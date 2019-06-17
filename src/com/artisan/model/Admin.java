package com.artisan.model;

//系统管理员类

public class Admin{
	private int id;//管理员id
	private String name;//用户名
	private String password;//密码
	private String createDate;//创建时间
	
	//自动生成get、set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
