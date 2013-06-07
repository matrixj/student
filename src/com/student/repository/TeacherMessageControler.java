package com.student.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsystem","root","a359712032");
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
	public boolean SearchTeacher(String Tid,String Name,String Password){
		try {
			if(Password==null)Password = "%";
			if(Name==null)Name = "%";
			if(Tid==null)	SearchStatment.setString(1, "%");
			else SearchStatment.setInt(1, Integer.parseInt(Tid));
			SearchStatment.setString(2, Name);
			SearchStatment.setString(3, Password);
			resultSet = SearchStatment.executeQuery();
			SearchStatment.clearParameters();
			/*
			while(resultSet.next()){
			 
				System.out.println(resultSet.getString(2));
			}
			*/
			if(resultSet.next())return true;
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
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
	public void Close(){
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
