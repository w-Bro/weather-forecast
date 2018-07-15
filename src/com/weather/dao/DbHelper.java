package com.weather.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class DbHelper {
	
	private String driverName;
	private String url;
	private String user;
	private String password;
	
	private Connection con = null;
	
	public DbHelper(String driverName,String url,String user,String password){
		this.driverName = driverName;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	/**
	 * 创建数据库对象
	 * @throws Exception
	 */
	public void createConnection() throws Exception{
		Class.forName(this.driverName);
		this.con = DriverManager.getConnection(this.url,this.user,this.password);
	}
	
	/**
	 * 关闭连接
	 * @throws Exception
	 */
	public void closeConnection() throws Exception {
		if(con==null) return;
		if(con.isClosed()) return;
		this.con.close();
	}
	
	/**
	 * 执行一条没有返回值的sql语句
	 * @param sql
	 * @param param
	 */
	public void execute(String sql,Map<String,Object> param) throws Exception {
		if(this.con==null || this.con.isClosed()){
			throw new Exception("请首先调用createConnection方法创建连接");
		}
		
		PreparedStatement psmt = this.con.prepareStatement(sql);
		
		if(param != null){
			int index = 1;
			for(String key:param.keySet()){
				Object value = param.get(key);
				//System.out.println(index+","+key+"="+value);
				
				psmt.setObject(index, value);

				index++;
			}
		}
		
		psmt.executeUpdate();
	}
	
	/**
	 * 执行一条有返回值的select语句
	 * @return 返回结果集
	 * @param sql sql语句
	 * @param param 哈希图，带入sql语句的参数
	 */
	public ResultSet query(String sql,Map<String,Object> param) throws Exception {
		if(this.con==null || this.con.isClosed()){
			throw new Exception("请首先调用createConnection方法创建连接");
		}
		
		PreparedStatement psmt = this.con.prepareStatement(sql);
		
		if(param != null){
			int index = 1;
			for(String key:param.keySet()){
				Object value = param.get(key);
				psmt.setObject(index, value);
				index++;
			}
		}
		
		ResultSet rs = psmt.executeQuery();
		
		return rs;
	}
	
	/**
	 * 创建一个表
	 */
	public void createTable(String sql,Map<String, Object> param) throws Exception{
		if(this.con==null || this.con.isClosed()){
			throw new Exception("请首先调用createConnection方法创建连接");
			}
		
		PreparedStatement psmt = this.con.prepareStatement(sql);
		if(param != null) {
			int index = 1;
			for(String key:param.keySet()) {
				Object value = param.get(key);
				psmt.setObject(index, value);
				index++;
			}
		}
		
		psmt.executeUpdate();
	}
}
