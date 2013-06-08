package com.student.bean.model;

public class Person {
	
	protected String name;	//姓名
	protected String password;	//用户密码
	
	public Person() {
		name = null;
		password = null;
	}
	

	/**
	 * 姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Person) {
			return name.equals(((Person) obj).getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
}
