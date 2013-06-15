package com.student.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.student.bean.model.Department;
import com.student.bean.model.Mark;
import com.student.bean.model.Student;
import com.student.bean.model.Subject;
import com.student.bean.model.Teacher;

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
			connection = DatabaseFactory.open();
			SearchStatment = connection.prepareStatement("select * from Student where No like ? and " +
														"Password like ? and Did like ? and Name like ? and Sex like ?");	
			InsertStatment = connection.prepareStatement("insert into Student values(?,?,?,?,?)");	
			DeleteStatment = connection.prepareStatement("delete from Student where No like ? and Did like ?");	
			UpdateStatment = connection.prepareStatement("update Student set password = ? where No = ? ");	
			SearchMarkStatement = connection.prepareStatement("select * from Mark where No = ?");
			InsertMarkStatement = connection.prepareStatement("insert into Mark(No,Suid,Tid,Score) values(?,?,?,?)");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 查找功能
	 */
	public Student[] SearchStudent(String No,String Password,String Did,String Name,String Sex){
		Student[] students;
		try {
			if(No==null)No = "%";
			if(Password==null)Password = "%";
			if(Name==null)Name = "%";
			if(Sex==null)Sex = "%";
			SearchStatment.setString(1, No);
			SearchStatment.setString(2, Password);
			if(Did==null)	SearchStatment.setString(3, "%");
			else	SearchStatment.setInt(3, Integer.parseInt(Did));
			SearchStatment.setString(4, Name);
			SearchStatment.setString(5, "%");
			resultSet = SearchStatment.executeQuery();
			SearchStatment.clearParameters();
			resultSet.last();
			if(resultSet.getRow()>0){
				students = new Student[resultSet.getRow()];
				resultSet.first();
				int i = 0;
				do{
					Student stu = new Student();
					stu.setNo(resultSet.getString(1));
					Department de = new Department();
					de.setDid(resultSet.getInt(2));
					stu.setDepartment(de);	//此department只有did，其他属性为空
					stu.setName(resultSet.getString(3));
					stu.setSex(resultSet.getString(4));
					stu.setPassword(resultSet.getString(5));
					students[i++] = stu;
				}while(resultSet.next());
				return students;
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
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
	public boolean UpdateStudent(String No,String Password){
		try{
			UpdateStatment.setString(1, Password);
			UpdateStatment.setString(2, No);
			UpdateStatment.executeUpdate();
			UpdateStatment.clearParameters();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 查询学生个人成绩
	 */
	public Mark[] FindStudentMark(String No){
		Mark[] marks;
		try{
			SearchMarkStatement.setString(1, No);
			resultSet = SearchMarkStatement.executeQuery();
			SearchMarkStatement.clearParameters();
			resultSet.last();
			if(resultSet.getRow()>0)
			{
				marks = new Mark[resultSet.getRow()];
				resultSet.first();
				int i = 0;
				do{
					Mark m = new Mark();
					m.setMid(resultSet.getInt(1));
					Student stu = new Student();
					stu.setNo(resultSet.getString(2));
					m.setStudent(stu);
					Subject sub = new Subject();
					sub.setSuid(resultSet.getInt(3));
					m.setSubject(sub);
					TeacherMessageControler tmc = new TeacherMessageControler();
					Teacher[] tea = tmc.SearchTeacher(Integer.toString(resultSet.getInt(4)), null, null);
					m.setTeacher(tea[0]);
					m.setScore(resultSet.getBigDecimal(5).doubleValue());
					marks[i++] = m;
				}while(resultSet.next());
				return marks;
			}
			return null;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
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
	 * 插入学生成绩
	 * @param marks	key为学生学号， value为学生成绩
	 * @param suid
	 * @param tid
	 * @return
	 */
	public boolean insertStudentsMarks(
			Map<String, String> marks, String suid, String tid) {
		try {
			connection.setAutoCommit(false);
			for(Map.Entry<String, String> tmp : marks.entrySet()) {
				if(!InsertStudnetMark(tmp.getKey(), suid, tid, tmp.getValue())) {
					throw new SQLException();
				}
			}
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	
	/**
	 * 查找指定班别的所有学生
	 * @param major
	 * @param grade
	 * @param cls
	 * @return
	 */
	public List<Student> findStudentByClass(
			String major, String grade, String cls) {
		try {
			Statement state = connection.createStatement();
			resultSet = state.executeQuery(
					"SELECT no, name, sex FROM student WHERE did=" +
					"(SELECT did FROM department WHERE " +
					"major='" + major + "' " +
					"AND grade='" + grade + "' " +
					"AND class='" + cls + "')");
			List<Student> students = null;
			if(resultSet.first()) {
				students = new ArrayList<Student>();
				do {
					Student student = new Student();
					student.setNo(resultSet.getString("no"));
					student.setName(resultSet.getString("name"));
					student.setSex(resultSet.getString("sex"));
					students.add(student);
				} while(resultSet.next());
			}
			state.close();
			resultSet.close();
			return students;
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
