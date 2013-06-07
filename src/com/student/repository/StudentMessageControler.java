package com.student.repository;

import java.sql.*;

/**
 * 操作学生信息数据库
 * @author Hunter
 */

public class StudentMessageControler {
		
	private Connection connection;		
	private PreparedStatement SearchStatment;	
	private PreparedStatement InsertStatment;	
	private PreparedStatement DeleteStatment;	
	private PreparedStatement UpdateStatment;	
	private PreparedStatement SearchMarkStatement;	
	private PreparedStatement InsertMarkStatement;	
	private ResultSet resultSet;	
	
	public StudentMessageControler(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsystem","root","a359712032");
			SearchStatment = connection.prepareStatement("select * from Student where No like ? and " +
														"Password like ? and Did like ? and Name like ? and Sex like ?");	
			InsertStatment = connection.prepareStatement("insert into Student values(?,?,?,?,?)");	
			DeleteStatment = connection.prepareStatement("delete from Student where No like ? and Did like ?");	
			UpdateStatment = connection.prepareStatement("");	
			SearchMarkStatement = connection.prepareStatement("selete * from Mark where No = ?");
			InsertMarkStatement = connection.prepareStatement("insert into Mark(No,Suid,Tid,Score) values(?,?,?,?)");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 查找功能
	 */
	public boolean SearchStudent(String No,String Password,String Did,String Name,String Sex){
		try {
			if(No==null)No = "%";
			if(Password==null)Password = "%";
			if(Name==null)Name = "%";
			SearchStatment.setString(1, No);
			SearchStatment.setString(2, Password);
			if(Did==null)	SearchStatment.setString(3, "%");
			else	SearchStatment.setInt(3, Integer.parseInt(Did));
			SearchStatment.setString(4, Name);
			if(Sex==null)	SearchStatment.setString(5, "%");
			else	SearchStatment.setByte(5, Byte.parseByte(Sex));
			resultSet = SearchStatment.executeQuery();
			SearchStatment.clearParameters();
			/*
			 * while(resultSet.next()){
				System.out.println(resultSet.getString(3));
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
	 * 插入功能
	 */
	public Boolean InsertStudent(String No,String Password,String Did,String Name,String Sex){
		try {
			InsertStatment.setString(1,No);
			InsertStatment.setString(4,Password);
			InsertStatment.setInt(2, Integer.parseInt(Did));
			InsertStatment.setString(3,Name);
			InsertStatment.setBoolean(5, Boolean.parseBoolean(Sex));
			InsertStatment.executeUpdate();
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
	private Boolean DeleteStudent(String No,String Did){
		try {
			DeleteStatment.setString(1, No);
			if(Did.equals("%"))	DeleteStatment.setString(2, Did);
			else	DeleteStatment.setInt(3, Integer.parseInt(Did));
			DeleteStatment.executeUpdate();
			DeleteStatment.clearParameters();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据学号删除学生信息
	 */
	public Boolean DeleteStudentByNo(String No){
		return DeleteStudent(No, "%");
	}
	/**
	 * 根据班级删除学生信息
	 */
	public Boolean DeleteStudentByDid(String Did){
		return DeleteStudent("%", Did);
	}	
	/**
	 * 删除全部学生
	 */
	public Boolean DeleteAllStudent(){
		return DeleteStudent("%","%");
	}
	
	/**
	 * 修改学生信息
	 */
	public void UpdateStudent(){
		
	}
	
	/**
	 * 查询学生个人成绩
	 */
	public void FindStudentMark(String Tid){
		try{
			SearchMarkStatement.setString(1, Tid);
			resultSet = SearchMarkStatement.executeQuery();
			SearchMarkStatement.clearParameters();
			while(resultSet.next()){
				System.out.println(resultSet.getDouble(5));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 插入学生个人成绩
	 */
	public Boolean InsertStudnetMark(String No,String Suid,String Tid,String Score){
		try {
			InsertMarkStatement.setString(1, No);
			InsertMarkStatement.setString(2, Suid);
			InsertMarkStatement.setString(3, Tid);
			InsertMarkStatement.setDouble(4, Double.parseDouble(Score));
			InsertMarkStatement.executeUpdate();
			InsertMarkStatement.clearParameters();
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
