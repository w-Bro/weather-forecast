package com.weather.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class CityDao extends BaseDao{
	
	/**
	 * ��ȡȫ��ʡ������
	 * @return ʡ�����Ƽ���
	 */
	public List<String> getProvinceName() {
		List<String> provinceNameList = new ArrayList<>();
		provinceNameList.add("��ѡ��ʡ��");
		
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
			System.out.println("���ݿ������쳣");
			JOptionPane.showMessageDialog(null, "���ݿ������쳣,���ȷ�������Զ��˳�");
			System.exit(0);
		}
		return provinceNameList;
	}
	
	/**
	 * ͨ��ʡ�����Ʋ�ѯ��ʡ���µĵؼ���
	 * @param provinceName	ʡ������
	 * @return	�ؼ������Ƽ���
	 */
	public List<String> getCityName(String provinceName){
		List<String> cityNameList = new ArrayList<>();
		cityNameList.add("��ѡ�����");
		
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
			System.out.println("���ݿ������쳣");
			JOptionPane.showMessageDialog(null, "���ݿ������쳣,���ȷ�������Զ��˳�");
			System.exit(0);
		}
		return cityNameList;
	}
	
	//����ʡ�����ƣ����ĸ�ֱϽ�м���۰���,sql��䲻ͬ��
	public boolean isSpecialCity(String provinceName) {
		switch (provinceName) {
			case "����":
				return true;
			case "�Ϻ�":
				return true;
			case "���":
				return true;
			case "����":
				return true;
			case "���":
				return true;
			case "����":
				return true;
			default:
				return false;
		}
	}

	/**
	 * ͨ��ʡ�ݺ͵ؼ��в�ѯ����
	 * @param provinceName	ʡ������
	 * @param cityName	�ؼ�������
	 * @return	�������Ƽ���
	 */
	public List<String> getAreaName(String provinceName, String cityName){
		List<String> areaNameList = new ArrayList<>();
		//areaNameList.add("��ѡ��");
		
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
			System.out.println("���ݿ������쳣");
			JOptionPane.showMessageDialog(null, "���ݿ������쳣,���ȷ�������Զ��˳�");
			System.exit(0);
		}
		
		return areaNameList;
	}
}


