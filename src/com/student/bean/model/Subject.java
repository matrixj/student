package com.student.bean.model;

import java.util.List;

/**
 * 科目的实体类
 * @author 李亮灿
 *
 */
public class Subject {

	private int suid;		//科目id
	private String name;	//科目名字
	private List<Teacher> teachers;		//所教该科目的老师
	
	public Subject() {
		suid = 0;
		name = null;
		teachers = null;
	}

	/**
	 * 科目id
	 * @return
	 */
	public int getSuid() {
		return suid;
	}

	/**
	 * 科目id
	 * @param suid
	 */
	public void setSuid(int suid) {
		this.suid = suid;
	}

	/**
	 * 科目名字
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 科目名字
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 所教该科目的老师
	 * @return
	 */
	public List<Teacher> getTeachers() {
		return teachers;
	}

	/**
	 * 所教该科目的老师
	 * @param teachers
	 */
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Subject) {
			return suid == ((Subject) obj).suid;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return suid;
	}
	
}
