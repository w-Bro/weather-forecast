package com.weather.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.weather.model.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeatherUtil {
	
	//�û�key
	private static final String key = "���ںͷ����������key";
	//ʵʱ����Ԥ����ѯ��ַ
	private static final String NOW_WEATHER_URL = "https://free-api.heweather.com/s6/weather/now?";
	//��Сʱ������ѯ��ַ
	private static final String HOURLY_WEATHER_URL = "https://free-api.heweather.com/s6/weather/hourly?";
	//��������Ԥ��
	private static final String DAILY_WEATHER_URL = "https://free-api.heweather.com/s6/weather/forecast?";
	//����ָ����ѯ��ַ
	private static final String LIFE_STYLE_URL = "https://free-api.heweather.com/s6/weather/lifestyle?";
	
	//����json�ַ�������
	public static String getJsonStr(String url){
		String jsonStr = "";
		try{
		URL realUrl = new URL(url);
		URLConnection connection = realUrl.openConnection();
		connection.connect();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
		
		String line;
		while((line = reader.readLine()) != null){
			jsonStr += line;
		}
		System.out.println(jsonStr);
		reader.close();
		}catch (Exception e) {  
            System.out.println("����GET��������쳣��" + e);  
            //e.printStackTrace();  
			System.out.println("����GET��������쳣���������磡");
			return "error";
        }  
		return jsonStr;
	}
	
	//��ѯʵʱ����������Now_Weather����
	public static Now_Weather getNowWeather(String location) {
		Now_Weather now_Weather = null;
		StringBuilder parameters = new StringBuilder();
		try {
			parameters.append("location="+URLEncoder.encode(location, "UTF-8").toString()+"&key="+key);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String jsonStr = getJsonStr(NOW_WEATHER_URL+parameters);
		
		String regex = "\\{\"cloud\":.*?\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(jsonStr);
		
		String resultStr = null;
		while(matcher.find()) {
			resultStr = matcher.group(0);
		}
		//System.out.println(resultStr);
		//json�ַ���ת����now_Weather����
		if(resultStr != null) {
			JSONObject jsonObject = JSONObject.fromObject(resultStr);
			now_Weather = (Now_Weather)JSONObject.toBean(jsonObject, Now_Weather.class);
		}
		
		//����LocationAndUpdateTime
		now_Weather.setLocationAndUpdateTime(getLocationAndUpdateTime(jsonStr));
		
		jsonStr = getJsonStr(LIFE_STYLE_URL+parameters);
		regex = "\"txt\":\"(.*?)\"";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(jsonStr);
		while(matcher.find()) {
			now_Weather.setSuggestion(matcher.group(1));	
			break;	//ֻȡ���������ָ������
		}
		return now_Weather;
	}
	
	//��Сʱ����Ԥ��������List<Hourly_Weather>
	public static List<Hourly_Weather> getHourlyWeathers(String location){
		List<Hourly_Weather> hourly_Weathers = new ArrayList<>();
		StringBuilder parameters = new StringBuilder();
		try {
			parameters.append("location="+URLEncoder.encode(location, "UTF-8").toString()+"&key="+key);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String jsonStr = getJsonStr( HOURLY_WEATHER_URL + parameters);
		String regex = "\\[\\{\"cloud.*?\\]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(jsonStr);
		
		String resultStr = null;
		while(matcher.find()) {
			resultStr = matcher.group(0);
		}
		
		if(resultStr != null) {
			//System.out.println(resultStr);
			JSONArray jsonArray = JSONArray.fromObject(resultStr);
			//json�ַ���ת���ɶ�������
			for(int i = 0; i < jsonArray.size(); i++) {
				JSONObject jObject = jsonArray.getJSONObject(i);
				Hourly_Weather hourly_Weather = (Hourly_Weather) JSONObject.toBean(jObject,Hourly_Weather.class);
				hourly_Weather.setLocationAndUpdateTime(getLocationAndUpdateTime(jsonStr));
				hourly_Weathers.add(hourly_Weather);
			}
		}
		return hourly_Weathers;
	}
	
	//��ѯ��������Ԥ�������ض�������
	public static List<Daily_Weather> getDailyWeathers(String location) {
		List<Daily_Weather> daily_Weathers = new ArrayList<>();
		
		StringBuilder parameters = new StringBuilder();
		try {
			parameters.append("location="+URLEncoder.encode(location, "UTF-8").toString()+"&key="+key);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String jsonStr = getJsonStr(DAILY_WEATHER_URL + parameters);
		String regex = "\\[\\{\"cond_code_d.*?\\]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(jsonStr);
		
		String resultStr = "";
		while(matcher.find()) {
			resultStr = matcher.group(0);
		}
		//System.out.println(resultStr3);
		//json�ַ���ת���ɶ�������
		if(resultStr != null) {
			JSONArray jsonArray = JSONArray.fromObject(resultStr);
			for(int i = 0; i < jsonArray.size(); i++) {
				JSONObject jObject = jsonArray.getJSONObject(i);
				Daily_Weather daily_Weather = (Daily_Weather)JSONObject.toBean(jObject,Daily_Weather.class);
				daily_Weather.setLocationAndUpdateTime(getLocationAndUpdateTime(jsonStr));
				daily_Weathers.add(daily_Weather);
			}
		}
		return daily_Weathers;
	}
	
	public static LocationAndUpdateTime getLocationAndUpdateTime(String jsonStr) {
		LocationAndUpdateTime locationAndUpdateTime = null;
		//ƥ�������Ϣ
		String regex = "\\{\"cid\".*?\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(jsonStr);
		
		String resultStr = "";
		while(matcher.find()) {
			resultStr = matcher.group(0);
		}
		
		if(resultStr.equals("")) {
			return null;
		}
		
		//�����һ���������滻Ϊ����,ƴ����ƥ���ʱ�䣬��Ϊ����json�ַ���
		resultStr = resultStr.substring(0, resultStr.length()-1)+",";
		
		//ƥ�����ʱ��
		regex = "\"loc\".*?\\}";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(jsonStr);
		while(matcher.find()) {
			resultStr += matcher.group(0);
		}
		
		JSONObject jsonObject = JSONObject.fromObject(resultStr);
		locationAndUpdateTime = (LocationAndUpdateTime)JSONObject.toBean(jsonObject, LocationAndUpdateTime.class);
		return locationAndUpdateTime;
	}
}
