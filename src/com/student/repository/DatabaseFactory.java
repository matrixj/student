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
			Class.forName(CommonData.Database.DBDriver);
			Connection connection = 
					DriverManager.getConnection(
							CommonData.Database.DBConnStr, 
							CommonData.Database.user, 
							CommonData.Database.password);
			return connection;
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
