package com.minashop.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SqlUtil {

	private static String driver=null;
	private static String url=null;
	private static String name=null;
	private static String pwd=null;
	
	static{
		try{
			//server.properties文件放在src目录下
			InputStream in=SqlUtil.class.getClassLoader().getResourceAsStream("server.properties");
			Properties prop=new Properties();
			prop.load(in);
	    	  driver=prop.getProperty("mysql.driver");
			  url=prop.getProperty("mysql.url");	
			 name=prop.getProperty("mysql.username");		
			 pwd=prop.getProperty("mysql.password");		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//连接数据库
	public static Connection getConnection(){
		Connection conn=null;
		try{	
			//加载驱动
			Class.forName(driver);
			conn=DriverManager.getConnection(url, name, pwd);
			
		}catch(Exception e){
			System.out.println("数据库连接错误");	
		}
		return conn;
	}
	
	//关闭连接
	public static void close(ResultSet rs,Statement stmt,Connection con){
		try{
			if(rs!=null)rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(stmt!=null)stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(con!=null)con.close();
		}catch(Exception e){
			e.printStackTrace();
			}
	}
	  
}
