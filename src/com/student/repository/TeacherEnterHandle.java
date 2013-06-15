package com.student.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class TeacherEnterHandle {
	private Connection conn=null;
	public TeacherEnterHandle(){
		conn=DatabaseFactory.open();
	}
	/**
	 * return ALLteacherName
	 */
	public String[] SearchAllTeacher(){
		int index=0;
		String[] teacherName=new String[50];
		StringBuilder sb = new StringBuilder();
		try{
		 Statement  state = conn.createStatement();
		 ResultSet rs = state.executeQuery("select * from Teacher");
		 while(rs.next()){
			 teacherName[index] = rs.getString(2);
			 index++;
		 }
		}catch(Exception e){
			e.printStackTrace();
		}
		return teacherName;
	}
	/**
	 * return AllDepartment
	 */
	public ResultSet SearchDepartMent(){
		ResultSet rs=null;
		try{
		 Statement  state = conn.createStatement();
		 rs = state.executeQuery("select * from department");
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * return allgrade
	 */
	 public String[]  GetAllGrade(){
	    	ResultSet rs = SearchDepartMent();
	    	String[] grade = new String[50];
	    	HashSet<String> hs = new HashSet<String>();
	    	int index=0;
	    	try{
	    	while( rs.next()){
	    		if(hs.add(rs.getString(3))){
	    		grade[index] =  rs.getString(3);
	    		index++;
	    		}
	    	}
	    	
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    	return grade;
	    }
	 
	 //
	 public String[]  GetAllMajor(){
		 ResultSet rs = SearchDepartMent();
	    	String[] major = new String[50];
	    	HashSet<String> hs = new HashSet<String>();
	    	int index=0;
	    	try{
	    	while(rs.next()){
	    		if(hs.add(rs.getString(2))){
	    		major[index] = rs.getString(2);
	    		index++;
	    		}
	    	}
	    
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return major;
	    }
	 //
	    public String[]  GetAllClass(){
	    	ResultSet rs = SearchDepartMent();
	    	String[] Class = new String[50];
	    	HashSet<String> hs = new HashSet<String>();
	    	int index=0;
	    	try{
	    	while(rs.next()){
	    		if(hs.add(rs.getString(4))){
	    		Class[index] = rs.getString(4);
	    		index++;
	    		}
	    	}
	    
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return Class;
	    }
	    //判断所选班级是否存在
	    public boolean isExist(String grade,String _class,String major){
	    	try{
	    		
	    		PreparedStatement  state = conn.prepareStatement("select * from department where Major=? and Grade=? and Class=?");
	    	       state.setString(1, major);
	    	       state.setString(2, grade);
	    	       state.setString(3, _class);
	    	      ResultSet rs = state.executeQuery();
	    	       if(rs.next()){
	    	    	   return true;
	    	       }
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return false;
	    }
	    //判断学生是否存在
	    public boolean isExist_student(String no){
	    	try{
	    		PreparedStatement  state = conn.prepareStatement("select * from student where No=?");
	    	       state.setString(1, no);
	    	
	    	      ResultSet rs = state.executeQuery();
	    	       if(rs.next()){
	    	    	   return true;
	    	       }
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return false;
	    }
	    //判断教师是否存在
	    public boolean isExist_teacher(String name){
	    	try{
	    		PreparedStatement  state = conn.prepareStatement("select * from teacher where name=?");
	    	       state.setString(1, name);
	    	
	    	      ResultSet rs = state.executeQuery();
	    	       if(rs.next()){
	    	    	   return true;
	    	       }
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return false;
	    }
	    //判断科目是否存在
	    public boolean isExist_subject(String name){
	    	try{
	    		PreparedStatement  state = conn.prepareStatement("select * from subject where Name=?");
	    	       state.setString(1, name);
	    	
	    	      ResultSet rs = state.executeQuery();
	    	       if(rs.next()){
	    	    	   return true;
	    	       }
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return false;
	    }
	    /*
	     * 获取对应department的Did*
	     * param1  class,grade,major
	     *return int Did
	     */
	    public int SearchDid(String grade,String _class,String major){
	    	try{
	    		PreparedStatement  state = conn.prepareStatement("select * from department where Major=? and Grade=? and Class=?");
	    	       state.setString(1, major);
	    	       state.setString(2, grade);
	    	       state.setString(3, _class);
	    	      ResultSet rs = state.executeQuery();
	    	      if(rs.next())
	    	    	  return rs.getInt(1);
	    	      
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	  	  return 0;
	    }
	    
	    /*
	     * 获取对应Did下学生名单*
	     * param1 int Did
	     *return String[][][]
	     */
	    public String[][] SearchStudent(String grade,String _class,String major){
	    	String[][] msg = new String[50][4];
	    	int i= 0;
	    	int Did = SearchDid( grade,_class,major);
	    	try{
	    	PreparedStatement  state = conn.prepareStatement("select * from student where Did = ?");
	    	 state.setInt(1, Did);
	    	 ResultSet rs = state.executeQuery();
	    	 while(rs.next()){
	    		 msg[i][0] = rs.getString(1);//No
	    		 msg[i][1] = rs.getString(3);//name
	    		 msg[i][2] = rs.getString(4);//sex
	    		 msg[i][3] = rs.getString(5);//pw

	    		 i++;
	    	 }
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return msg;
	    }
	    /*
	     * UPdate student*
	     * param    all
	     *return String[][][]
	     */
	    public void UpdateStudent(String No,int Did,String Sex,String Name,String Password){
	    	try{
	    		PreparedStatement  state = conn.prepareStatement("update student set Did=?,Name=?,Sex=?,Password=? where No=?");
	    		state.setInt(1, Did);
	    		state.setString(2, Name);
	    		state.setString(3, Sex);
	    		state.setString(4, Password);
	    		state.setString(5, No);
	    	    state.executeUpdate();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    /*
	     * insert new student*
	     * param    all
	     */
	    public void InsertStudent(String No,int Did,String Sex,String Name,String Password){
	    	try{
	    		PreparedStatement  state = conn.prepareStatement("insert into student values (?,?,?,?,?)");
	    		state.setString(1, No);
	    		state.setInt(2, Did);
	    		state.setString(3, Name);
	    		state.setString(4, Sex);
	    		state.setString(5, Password);
	    	    state.executeUpdate();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    /*
	     * insert new student*
	     * param    all
	     */
	    public void InsertTeacher_subject(String name,int subjectid){
	    	try{
                  int teacherid = 0;
	    		PreparedStatement state = conn.prepareStatement("select * from teacher where Name = ?");
		    	 state.setString(1, name);
		    	 ResultSet rs = state.executeQuery();
		    	 if(rs.next())
		    		 teacherid= rs.getInt(1); 
	    		  state = conn.prepareStatement("insert into teacher_subject values (?,?)");
	    		state.setInt(1, subjectid);
	    		state.setInt(2, teacherid);
	    	    state.executeUpdate();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    /*
	     * insert new class*
	     * param    all
	     */
	    public void InsertClass(String major,String _class,String grade){
	    	try{
	    		PreparedStatement  state = conn.prepareStatement("insert into department(Major,Grade,Class) values (?,?,?)");
	    		
	    		state.setString(1, major);
	    		state.setString(2, grade);
	    		state.setString(3,  _class);
	    	    state.executeUpdate();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    /*
	     * insert new subject*
	     * param    all
	     */
	    public int InsertSubject(String subject){
	    	try{
	    		PreparedStatement  state = conn.prepareStatement("insert into subject(Name) values (?)");
	    		
	    		state.setString(1, subject);
	    	
	    	    state.executeUpdate();
	    	     state = conn.prepareStatement("select * from subject where Name = ?");
		    	 state.setString(1, subject);
		    	 ResultSet rs = state.executeQuery();
		    	 if(rs.next())
	    	    	  return rs.getInt(1);
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return 0;
	    }
	    /*
	     * insert new class*
	     * param    all
	     */
	    public void DelStudent(String no){
	    	try{
	    		PreparedStatement  state = conn.prepareStatement("delete from student where No = ?");
	    	    state.setString(1, no);
	    	    state.executeUpdate();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    }
}
