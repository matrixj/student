package com.student.repository;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 课程表subject的操作
 * @author 李亮灿
 *
 */
public class SubjectMessageControler {

	private Connection connection;
	private ResultSet resultSet;
	
	public SubjectMessageControler() {
		connection = DatabaseFactory.open();
		resultSet = null;
	}
	
	
	public boolean close() {
		return DatabaseFactory.close(connection);
	}
	
}
