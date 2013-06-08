package com.student.bean.model;

/**
 * 成绩的实体类
 * @author 李亮灿
 *
 */
public class Mark {

	private int mid;		//成绩id
	private double score;	//得分
	private Subject subject;	//哪个科目的成绩
	private Student student;	//哪个学生的成绩
	private Teacher teacher;	//该成绩科目的任课老师
	
	public Mark() {
		mid = 0;
		score = -1;
		subject = null;
		student = null;
	}

	/**
	 * 成绩id
	 * @return
	 */
	public int getMid() {
		return mid;
	}

	/**
	 * 成绩id
	 * @param mid
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}

	/**
	 * 得分
	 * @return
	 */
	public double getScore() {
		return score;
	}

	/**
	 * 得分
	 * @param score
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * 哪个科目的得分
	 * @return
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * 哪个科目的得分
	 * @param subject
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * 哪个学生的成绩
	 * @return
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * 哪个学生的成绩
	 * @param student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	/**
	 * 该成绩科目的任课老师
	 * @return
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * 该成绩科目的任课老师
	 * @param teacher
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Mark) {
			return mid == ((Mark) obj).mid;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return mid;
	}
	
}
