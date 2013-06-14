package com.student.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 表department的操作
 * @author 李亮灿
 *
 */
public class DepartmentMessageControler {

	private Connection connection;
	private ResultSet resultSet;
	
	public DepartmentMessageControler() {
		connection = DatabaseFactory.open();
		resultSet = null;
	}
	
	/**
	 * 获取所有的专业名称
	 * @return
	 */
	public List<String> getAllMajors() {
		try {
			Statement state = connection.createStatement();
			resultSet = state.executeQuery(
					"SELECT DISTINCT major FROM department;");
			List<String> majors = null;
			if(resultSet.first()) {
				majors = new ArrayList<String>();
				do {
					majors.add(resultSet.getString("major"));
				} while(resultSet.next());
			}
			state.close();
			resultSet.close();
			return majors;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据指定的科目和专业，查找指定老师所能够录入成绩的年级
	 * @param suid
	 * @param major
	 * @param tid
	 * @return
	 */
	public List<String> getAllowInputMarkGrade(
			String suid, String major, String tid) {
		try {
			Statement state = connection.createStatement();
			resultSet = state.executeQuery(
					"SELECT DISTINCT a.grade FROM department AS a " +
					"WHERE (a.grade, a.class) NOT IN " +
					"(SELECT b.grade, b.class FROM department AS b " +
					"WHERE b.did IN " +
					"(SELECT did FROM student WHERE no IN " +
					"(SELECT DISTINCT no FROM mark WHERE suid=" + suid + 
					" AND tid!=" + tid + "))) " +
					"AND a.major='" + major + "';");
			List<String> grades = null;
			if(resultSet.first()) {
				grades = new ArrayList<String>();
				do {
					grades.add(resultSet.getString("grade"));
				} while(resultSet.next());
			}
			state.close();
			resultSet.close();
			return grades;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据指定的科目和专业，查找指定老师所能够录入成绩的年级的班别
	 * @param suid
	 * @param major
	 * @param tid
	 * @param grade
	 * @return
	 */
	public List<String> getAllowInputMarkClass(
			String suid, String major, String tid, String grade) {
		try {
			Statement state = connection.createStatement();
			resultSet = state.executeQuery(
					"SELECT DISTINCT a.class FROM department AS a " +
					"WHERE (a.grade, a.class) NOT IN " +
					"(SELECT b.grade, b.class FROM department AS b " +
					"WHERE b.did IN " +
					"(SELECT did FROM student WHERE no IN " +
					"(SELECT DISTINCT no FROM mark WHERE suid=" + suid + 
					" AND tid!=" + tid + "))) " +
					"AND a.major='" + major + "' " +
					"AND a.grade='" + grade + "';");
			List<String> classes = null;
			if(resultSet.first()) {
				classes = new ArrayList<String>();
				do {
					classes.add(resultSet.getString("class"));
				} while(resultSet.next());
			}
			state.close();
			resultSet.close();
			return classes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean close() {
		return DatabaseFactory.close(connection);
	}
	
}
