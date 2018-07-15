package com.weather.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class CityDao extends BaseDao{
	
	/**
	 * 获取全国省份名称
	 * @return 省份名称集合
	 */
	public List<String> getProvinceName() {
		List<String> provinceNameList = new ArrayList<>();
		provinceNameList.add("请选择省份");
		
		DbHelper dbHelper = this.createDbHelper();
		
		try {
			dbHelper.createConnection();
			
			String sql = "SELECT DISTINCT ProvinceChinese FROM city";
			
			ResultSet resultSet = dbHelper.query(sql, null);
			while (resultSet.next()) {
				provinceNameList.add(resultSet.getString(1));
			}
			
			dbHelper.closeConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接异常");
			JOptionPane.showMessageDialog(null, "数据库连接异常,点击确定程序将自动退出");
			System.exit(0);
		}
		return provinceNameList;
	}
	
	/**
	 * 通过省份名称查询该省份下的地级市
	 * @param provinceName	省份名称
	 * @return	地级市名称集合
	 */
	public List<String> getCityName(String provinceName){
		List<String> cityNameList = new ArrayList<>();
		cityNameList.add("请选择城市");
		
		DbHelper dbHelper = this.createDbHelper();
		
		try {
			dbHelper.createConnection();
			String sql;
			if(!isSpecialCity(provinceName)) {
				sql = "select CityChinese from city WHERE ProvinceChinese=? and SuperiorCityChinese = CityChinese";
			}
			else {
				sql = "select CityChinese from city WHERE ProvinceChinese=?";
			}
			
			Map<String, Object> param = new LinkedHashMap<String, Object>();
			param.put("ProvinceChinese", provinceName);
			
			ResultSet resultSet = dbHelper.query(sql, param);
			
			while (resultSet.next()) {
				cityNameList.add(resultSet.getString(1));
			}
//			if(cityNameList.size() == 0) {
//				sql = "select CityChinese from city WHERE ProvinceChinese=?";
//				resultSet = dbHelper.query(sql, param);
//				
//				while (resultSet.next()) {
//				cityNameList.add(resultSet.getString(1));
//				}
//			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接异常");
			JOptionPane.showMessageDialog(null, "数据库连接异常,点击确定程序将自动退出");
			System.exit(0);
		}
		return cityNameList;
	}
	
	//特殊省份名称（即四个直辖市及香港澳门,sql语句不同）
	public boolean isSpecialCity(String provinceName) {
		switch (provinceName) {
			case "北京":
				return true;
			case "上海":
				return true;
			case "天津":
				return true;
			case "重庆":
				return true;
			case "香港":
				return true;
			case "澳门":
				return true;
			default:
				return false;
		}
	}

	/**
	 * 通过省份和地级市查询地区
	 * @param provinceName	省份名称
	 * @param cityName	地级市名称
	 * @return	地区名称集合
	 */
	public List<String> getAreaName(String provinceName, String cityName){
		List<String> areaNameList = new ArrayList<>();
		//areaNameList.add("请选择");
		
		DbHelper dbHelper = this.createDbHelper();
		
		try {
			dbHelper.createConnection();
			
			String sql = "SELECT citychinese from city WHERE SuperiorCityChinese in (select CityChinese from city WHERE ProvinceChinese=? and SuperiorCityChinese = ?)";
			Map<String, Object> param = new LinkedHashMap<String, Object>();
			param.put("ProvinceChinese", provinceName);
			param.put("SuperiorCityChinese", cityName);
			
			ResultSet resultSet = dbHelper.query(sql, param);
			
			while (resultSet.next()) {
				areaNameList.add(resultSet.getString(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接异常");
			JOptionPane.showMessageDialog(null, "数据库连接异常,点击确定程序将自动退出");
			System.exit(0);
		}
		
		return areaNameList;
	}
}


