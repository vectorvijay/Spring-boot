package com.webservices.restfulWebServices.users;
//
//import java.util.Date;

public class User {
	private int id;
	private String name;
	private int age;
	
	
	public User(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public User(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public User() {
		
	}
	
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
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age = age;
	}
	

}
