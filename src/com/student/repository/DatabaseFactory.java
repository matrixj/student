package com.student.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.student.CommonData;

public class DatabaseFactory {
	
	/**
	 * 打开数据库
	 * @return	打开失败返回null 
	 */
	public static Connection open() {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			   String url="jdbc:mysql://localhost:3306/studentmanager?useUnicode=true&characterEncoding=gb2312";
			   Connection con=DriverManager.getConnection(url,"root","linyaohua");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 关闭数据库
	 * @param connection	
	 * @return	关闭是否成功
	 */
	public static boolean close(Connection connection) {
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
