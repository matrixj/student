package com.student.repository;

import java.sql.*;

/**
 * ���ڲ����洢ѧ��ͳɼ���Ϣ����ݿ�
 * @author Hunter
 */

public class StudentMessageControler {
		
	private Connection connection;		//����������ݿ�
	private PreparedStatement SearchStatment;	//����Ԥ�������
	private PreparedStatement InsertStatment;	//����Ԥ�������
	private PreparedStatement DeleteStatment;	//ɾ��Ԥ�������
	private PreparedStatement UpdateStatment;	//�޸�Ԥ�������
	private PreparedStatement SearchMarkStatement;	//��ѯ���˳ɼ�
	private PreparedStatement InsertMarkStatement;	//¼����˳ɼ�
	private ResultSet resultSet;	//��ݼ�
	
	public StudentMessageControler(){		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsystem","root","a359712032");
			SearchStatment = connection.prepareStatement("select * from Student where No like ? and " +
														"Password like ? and Did like ? and Name like ? and Sex like ?");	//��ѯ���
			InsertStatment = connection.prepareStatement("insert into Student values(?,?,?,?,?)");	//�������
			DeleteStatment = connection.prepareStatement("delete from Student where No like ? and Did like ?");	//ɾ�����
			UpdateStatment = connection.prepareStatement("");	//�޸����
			SearchMarkStatement = connection.prepareStatement("selete * from Mark where No = ?");
			InsertMarkStatement = connection.prepareStatement("insert into Mark(No,Suid,Tid,Score) values(?,?,?,?)");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ѯָ��ѧ����Ϣ
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
	 * ����ѧ����Ϣ����ݿ�
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
	 * ����ݿ�ɾ��ָ��ѧ����Ϣ
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
	 * ���ѧ��ɾ��ѧ��
	 */
	public Boolean DeleteStudentByNo(String No){
		return DeleteStudent(No, "%");
	}
	/**
	 * ��ݰ༶ɾ��ѧ��
	 */
	public Boolean DeleteStudentByDid(String Did){
		return DeleteStudent("%", Did);
	}	
	/**
	 * ����ݿ�ɾ������ѧ����Ϣ
	 */
	public Boolean DeleteAllStudent(){
		return DeleteStudent("%","%");
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 */
	public void UpdateStudent(){
		
	}
	
	/**
	 * ��ѯ���˳ɼ�
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
	 * ������˳ɼ�
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
	 * �ر���ݿ�����
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
