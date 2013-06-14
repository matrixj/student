package com.student.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.bean.model.Subject;
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
			SearchStatment = connection.prepareStatement("select * from Teacher where Tid like ? and Name like ? and Password like ?");	
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
			//else SearchStatment.setString(1, Tid);
			SearchStatment.setString(2, Name);
			SearchStatment.setString(3, Password);
			resultSet = SearchStatment.executeQuery();
			SearchStatment.clearParameters();
			resultSet.last();
			if(resultSet.getRow()>0){
				teachers = new Teacher[resultSet.getRow()];
				resultSet.first();
				int i = 0;
				do{
					Teacher tea = new Teacher();
					tea.setTid(resultSet.getInt(1));
					tea.setName(resultSet.getString(2));
					tea.setPassword(resultSet.getString(3));
					teachers[i++] = tea;
				}while(resultSet.next());
				return teachers;
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("yes");
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
	 * 根据老师的id获取该老师所教的课程
	 * @param tid
	 * @return
	 */
	public List<Subject> getTeacherSubject(String tid) {
		try {
			Statement state = connection.createStatement();
			resultSet = state.executeQuery(
					"SELECT * FROM subject WHERE Suid IN " +
					"(SELECT Suid FROM teacher_subject WHERE Tid=" + tid + ");");
			List<Subject> subs = null;
			if(resultSet.first()) {
				subs = new ArrayList<Subject>();
				do {
					Subject sub = new Subject();
					sub.setSuid(resultSet.getInt("Suid"));
					sub.setName(resultSet.getString("Name"));
					subs.add(sub);
				} while(resultSet.next());
			}
			resultSet.close();
			state.close();
			return subs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
