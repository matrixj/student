package com.student.bean;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.student.repository.TeacherEnterHandle;

public class TeacherEnterBean {
	TeacherEnterHandle teacherEnter;
	public TeacherEnterBean(){
		teacherEnter = new TeacherEnterHandle();
	}
    public String[] AllTeacherName(){
    	return teacherEnter.SearchAllTeacher();
    }
    
    public String[]  Grade(){
    	return teacherEnter.GetAllGrade();
    }
    public String[]  Major(){
    	return teacherEnter.GetAllMajor();
    }
    public String[]  Class(){
    	return teacherEnter.GetAllClass();
    }
    public String[][] Student(String grade,String _class,String major){
    	return teacherEnter.SearchStudent(grade,_class, major);
    }
    public int Did(String grade,String _class,String major){
    	return teacherEnter.SearchDid(grade, _class, major);
    }
  
}
