package com.student.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.bean.model.*;
 
class sqlConn{
	String url;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement[] dePstmt = new PreparedStatement[4];
	PreparedStatement[]   subPstmt = new PreparedStatement[4];
	public sqlConn() throws Exception
	{ 
		conn = DatabaseFactory.open(); 
		stmt = conn.createStatement(); 
		//initSelectStm();
	}
	private void initSelectStm() throws Exception
	{
		String[] departmentSql = new String[4];
		String[] subjectSql = new String[2];
		departmentSql[0] = "select * from department where Did=?";
		departmentSql[1] = "select * from department where Major=?";
		departmentSql[2] = "select * from department where Grade=?";
		departmentSql[3] = "select * from department where Class=?";
		
		subjectSql[0] = "select * from subject where Suid=?";
		subjectSql[1] = "select * from subject where Name=?";
		for (int i = 0; i < 4; i++) {
			dePstmt[i] = conn.prepareStatement(departmentSql[i]);
		}
		
		for (int i = 0; i < 2; i++) {
			subPstmt[i] = conn.prepareStatement(subjectSql[i]);
		}
	}
	
	//其中key为Department的一个字段名，value为要查询字段的值
	public ArrayList getDepartment(String key, String value) throws Exception
	{	initSelectStm();
		int flag = 0;
		if (key == "Did") {
			dePstmt[0].setString(1, value);
			flag = 0;
		}
		else if (key == "Major") {
			dePstmt[1].setString(1, value);
			flag = 1;
		}
		else if (key == "Grade") {
			dePstmt[2].setString(1, value);
			flag = 2;
		}
		else if (key == "Class") {
			dePstmt[3].setString(1, value);
			flag = 3;
		}
		
		ResultSet rs = dePstmt[flag].executeQuery();
		ArrayList depList=new ArrayList();		
		while(rs.next()) 
		{ 
			System.out.println("你的第一个字段内容为："+rs.getString("Did")); 
			System.out.println("你的第二个字段内容为："+rs.getString("Major")); 
			System.out.println("你的第三个字段内容为："+rs.getString("Grade")); 
			System.out.println("你的第四个字段内容为："+rs.getString("Class")); 
			Department dp = new Department();
			
			dp.setDid(((Number) rs.getObject(1)).intValue());
			dp.setMajor(rs.getString("Major"));
			dp.setGrade(rs.getString("Grade"));
			dp.setCls(rs.getString("Class"));	
			depList.add(dp);
		} 
		//int size=depList.size();
	//	Department[] dpArray = (Department[])depList.toArray(new Department[size]);
		return depList;
	}
	
	public Subject[] getSubject(String key, String value) throws Exception
	{	
		initSelectStm();
		int flag;
		if (key == "Suid") {
			subPstmt[0].setString(1, value);
			flag = 0;
		}
		else if (key == "Name") {
			subPstmt[1].setString(1, value);
			flag = 1;
		}
		
		ResultSet rs = subPstmt[0].executeQuery();
		List subList=new ArrayList();		
		while(rs.next()) 
		{ 
			System.out.println("你的第一个字段内容为："+rs.getString("Suid")); 
			System.out.println("你的第二个字段内容为："+rs.getString("Name"));  
			Subject sb = new Subject();
			
			sb.setSuid(((Number) rs.getObject(1)).intValue());
			sb.setName(rs.getString("Name"));

			subList.add(sb);
		} 
		int size=subList.size();
		Subject[] sbArray = (Subject[])subList.toArray(new Subject[size]);
		return sbArray;
	}
	
	private void initInsertStm() throws Exception
	{
		String[] departmentSql =new String[4];
		String[] subjectSql = new String[2];
		departmentSql[0] = "insert into department(Did, Major, Grade, Class) value(?, ?, ?, ?)";
		
		dePstmt[0] = conn.prepareStatement(departmentSql[0]);
		
		subjectSql[0] = "insert into subject(Suid, Name) value(?, ?)";
		
		subPstmt[0] = conn.prepareStatement(subjectSql[0]);
	}
	
	public int setDepartment(Department dp) throws Exception
	{
		initInsertStm();
		if (getDepartment("Did", Integer.toString(dp.getDid())).size() > 0) 
			return 0;
		dePstmt[0].setString(1, Integer.toString(dp.getDid()));
		dePstmt[0].setString(2, dp.getMajor());
		dePstmt[0].setString(3, dp.getGrade());
		dePstmt[0].setString(4, dp.getCls());
		return  dePstmt[0].executeUpdate();
	}
	
	public int  setSubject(Subject  sb) throws Exception
	{
		initInsertStm();
		subPstmt[0].setString(1, Integer.toString(sb.getSuid()));
		subPstmt[0].setString(2, sb.getName());
		
		return subPstmt[0].executeUpdate();
	}
	
	private void initUpdate() throws Exception
	{
		String[] departmentSql = new String[4];
		String[] subjectSql = new String[2];
		departmentSql[0] = "update Department SET Did=?, Major=?, Grade=?, Class=? where Did=?";
		dePstmt[0] = conn.prepareStatement(departmentSql[0]);
		//未完成，暂不需要
	}
}