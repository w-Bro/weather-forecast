package com.weather.dao;

public class BaseDao {
	
	protected String driver_name = "com.mysql.jdbc.Driver";
	protected String db_url = "jdbc:mysql://localhost:3306/������ݿ���?useSSL=false";
	protected String db_user = "������ݿ��û���";
	protected String db_pwd = "������ݿ�����";
	
	public DbHelper createDbHelper(){
		try {
			DbHelper dbHelper = new DbHelper(driver_name,db_url,db_user,db_pwd);
			return dbHelper;
		} catch (Exception e) {
			System.out.println("���ݿ������쳣");
		}
		return null;
	}
}
