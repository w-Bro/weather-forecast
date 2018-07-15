package com.weather.dao;

public class BaseDao {
	
	protected String driver_name = "com.mysql.jdbc.Driver";
	protected String db_url = "jdbc:mysql://localhost:3306/你的数据库名?useSSL=false";
	protected String db_user = "你的数据库用户名";
	protected String db_pwd = "你的数据库密码";
	
	public DbHelper createDbHelper(){
		try {
			DbHelper dbHelper = new DbHelper(driver_name,db_url,db_user,db_pwd);
			return dbHelper;
		} catch (Exception e) {
			System.out.println("数据库连接异常");
		}
		return null;
	}
}
