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
	    		if(hs.add(rs.getString(3)))
	    		grade[index] =  rs.getString(3);
	    		index++;
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
	    		if(hs.add(rs.getString(2)))
	    		major[index] = rs.getString(2);
	    		index++;
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
	    		if(hs.add(rs.getString(4)))
	    		Class[index] = rs.getString(4);
	    		index++;
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
	  
}
