package com.student.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.student.bean.model.Mark;
import com.student.bean.model.Teacher;

/**
 * 操作教师信息数据库
 * @author Hunter
 *
 */
public class TeacherMessageControler {
	
	private Connection connection;	
	private PreparedStatement SearchStatment;	
	private PreparedStatement InsertStatment;	
	private PreparedStatement DeleteStatment;	
	private ResultSet resultSet;	
	
	public TeacherMessageControler(){
		try {
			connection = DatabaseFactory.open();
			SearchStatment = connection.prepareStatement("select * from Teacher where Tid like ? and Name like ? and Password like ?");	//��ѯ���
			InsertStatment = connection.prepareStatement("insert into teacher values(?,?,?)");	
			DeleteStatment = connection.prepareStatement("delete from teacher where Tid = ?");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 查找功能
	 */
	public Teacher[] SearchTeacher(String Tid,String Name,String Password){
		Teacher[] teachers;
		try {
			if(Password==null)Password = "%";
			if(Name==null)Name = "%";
			if(Tid==null)	SearchStatment.setString(1, "%");
			else SearchStatment.setInt(1, Integer.parseInt(Tid));
			SearchStatment.setString(2, Name);
			SearchStatment.setString(3, Password);
			resultSet = SearchStatment.executeQuery();
			SearchStatment.clearParameters();
			resultSet.last();
			teachers = new Teacher[resultSet.getRow()-1];
			resultSet.first();
			int i = 0;
			while(resultSet.next()){
			 Teacher tea = new Teacher();
			 tea.setTid(resultSet.getInt(1));
			 tea.setName(resultSet.getString(2));
			 tea.setPassword(resultSet.getString(3));
			 teachers[i] = tea;
			}
			return teachers;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 插入
	 */
	public Boolean InsertTeacher(String Tid,String Name,String Password){
		try {
			InsertStatment.setInt(1, Integer.parseInt(Tid));
			InsertStatment.setString(2, Name);
			InsertStatment.setString(3, Password);
			InsertStatment.executeQuery();
			InsertStatment.clearParameters();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除功能
	 */
	public Boolean DeleteTeacher(String Tid){
		try {
			DeleteStatment.setInt(1, Integer.parseInt(Tid));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 关闭数据库
	 */
	public boolean Close(){
		try {
			return DatabaseFactory.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
