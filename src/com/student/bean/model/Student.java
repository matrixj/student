package com.student.bean.model;

/**
 * 学生实体类
 * @author 李亮灿
 *
 */
public class Student extends Person {

	private String no;	//学号
	private String sex;		//性别
	private Department department;	//学生的班别
	
	public Student() {
		no = null;
		sex = null;
		department = null;
	}
	
	
	/**
	 * 学号
	 * @return
	 */
	public String getNo() {
		return no;
	}
	
	/**
	 * 学号
	 * @param no
	 */
	public void setNo(String no) {
		this.no = no;
	}
	
	/**
	 * 性别
	 * @return
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * 性别
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 学生的班别
	 * @return
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * 学生的班别
	 * @param department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
