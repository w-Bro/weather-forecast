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
	
	//用户key
	private static final String key = "你在和风天气申请的key";
	//实时天气预报查询地址
	private static final String NOW_WEATHER_URL = "https://free-api.heweather.com/s6/weather/now?";
	//逐小时天气查询地址
	private static final String HOURLY_WEATHER_URL = "https://free-api.heweather.com/s6/weather/hourly?";
	//三天天气预报
	private static final String DAILY_WEATHER_URL = "https://free-api.heweather.com/s6/weather/forecast?";
	//生活指数查询地址
	private static final String LIFE_STYLE_URL = "https://free-api.heweather.com/s6/weather/lifestyle?";
	
	//返回json字符串数据
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
            System.out.println("发送GET请求出现异常！" + e);  
            //e.printStackTrace();  
			System.out.println("发送GET请求出现异常！请检查网络！");
			return "error";
        }  
		return jsonStr;
	}
	
	//查询实时天气，返回Now_Weather对象
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
		//json字符串转换成now_Weather对象
		if(resultStr != null) {
			JSONObject jsonObject = JSONObject.fromObject(resultStr);
			now_Weather = (Now_Weather)JSONObject.toBean(jsonObject, Now_Weather.class);
		}
		
		//设置LocationAndUpdateTime
		now_Weather.setLocationAndUpdateTime(getLocationAndUpdateTime(jsonStr));
		
		jsonStr = getJsonStr(LIFE_STYLE_URL+parameters);
		regex = "\"txt\":\"(.*?)\"";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(jsonStr);
		while(matcher.find()) {
			now_Weather.setSuggestion(matcher.group(1));	
			break;	//只取今天的生活指数建议
		}
		return now_Weather;
	}
	
	//逐小时天气预报，返回List<Hourly_Weather>
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
			//json字符串转换成对象数组
			for(int i = 0; i < jsonArray.size(); i++) {
				JSONObject jObject = jsonArray.getJSONObject(i);
				Hourly_Weather hourly_Weather = (Hourly_Weather) JSONObject.toBean(jObject,Hourly_Weather.class);
				hourly_Weather.setLocationAndUpdateTime(getLocationAndUpdateTime(jsonStr));
				hourly_Weathers.add(hourly_Weather);
			}
		}
		return hourly_Weathers;
	}
	
	//查询三天天气预报，返回对象数组
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
		//json字符串转换成对象数组
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
		//匹配城市信息
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
		
		//将最后一个大括号替换为逗号,拼接上匹配的时间，成为完整json字符串
		resultStr = resultStr.substring(0, resultStr.length()-1)+",";
		
		//匹配更新时间
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
