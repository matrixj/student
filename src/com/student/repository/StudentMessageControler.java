package com.student.repository;

import java.sql.*;

/**
 * 用于操作存储学生和成绩信息的数据库
 * @author Hunter
 */

public class StudentMessageControler {
		
	private Connection connection;		//用于连接数据库
	private PreparedStatement SearchStatment;	//查找预处理语句
	private PreparedStatement InsertStatment;	//插入预处理数据
	private PreparedStatement DeleteStatment;	//删除预处理语句
	private PreparedStatement UpdateStatment;	//修改预处理语句
	private PreparedStatement SearchMarkStatement;	//查询个人成绩
	private PreparedStatement InsertMarkStatement;	//录入个人成绩
	private ResultSet resultSet;	//数据集
	
	public StudentMessageControler(){		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsystem","root","a359712032");
			SearchStatment = connection.prepareStatement("select * from Student where No like ? and " +
														"Password like ? and Did like ? and Name like ? and Sex like ?");	//查询语句
			InsertStatment = connection.prepareStatement("insert into Student values(?,?,?,?,?)");	//插入语句
			DeleteStatment = connection.prepareStatement("delete from Student where No like ? and Did like ?");	//删除语句
			UpdateStatment = connection.prepareStatement("");	//修改语句
			SearchMarkStatement = connection.prepareStatement("selete * from Mark where No = ?");
			InsertMarkStatement = connection.prepareStatement("insert into Mark(No,Suid,Tid,Score) values(?,?,?,?)");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询指定学生信息
	 */
	public void SearchStudent(String No,String Password,String Did,String Name,String Sex){
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
			while(resultSet.next()){
				System.out.println(resultSet.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}			
	}
	
	/**
	 * 插入学生信息到数据库
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
	 * 从数据库删除指定学生信息
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
	 * 根据学号删除学生
	 */
	public Boolean DeleteStudentByNo(String No){
		return DeleteStudent(No, "%");
	}
	/**
	 * 根据班级删除学生
	 */
	public Boolean DeleteStudentByDid(String Did){
		return DeleteStudent("%", Did);
	}	
	/**
	 * 从数据库删除所有学生信息
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
	 * 查询个人成绩
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
	 * 插入个人成绩
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
	 * 关闭数据库连接
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
