package com.student.bean.model;

import java.util.List;

/**
 * 老师的实体类
 * @author 李亮灿
 *
 */
public class Teacher extends Person {

	private int tid;		//老师的id号
	private List<Subject> subjects;		//老师所教的科目
	
	public Teacher() {
		tid = 0;
		subjects = null;
	}

	/**
	 * 老师的id号
	 * @return
	 */
	public int getTid() {
		return tid;
	}

	/**
	 * 老师的id号
	 * @param tid
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}

	/**
	 * 老师所教的科目
	 * @return
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * 老师所教的科目
	 * @param subjects
	 */
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
}
