package com.student.bean.model;

/**
 * 班级信息的实体类
 * @author 李亮灿
 *
 */
public class Department {
	
	private int did;		//班级的id
	private String major;	//专业
	private String grade;	//年级
	private String cls;	//班别
	
	public Department() {
		did = 0;
		major = null;
		grade = null;
		cls = null;
	}
	
	/**
	 * 班级的id
	 * @return
	 */
	public int getDid() {
		return did;
	}
	
	/**
	 * 班级的id
	 * @param did
	 */
	public void setDid(int did) {
		this.did = did;
	}
	
	/**
	 * 专业
	 * @return
	 */
	public String getMajor() {
		return major;
	}
	
	/**
	 * 专业
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * 年级
	 * @return
	 */
	public String getGrade() {
		return grade;
	}
	
	/**
	 * 年级
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/**
	 * 班别
	 * @return
	 */
	public String getCls() {
		return cls;
	}
	
	/**
	 * 班别
	 * @param cls
	 */
	public void setCls(String cls) {
		this.cls = cls;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Department) {
			return did == ((Department) obj).did;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return did;
	}
	
}
