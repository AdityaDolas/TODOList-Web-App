package com.aditya.pojo;

public class User {
	private int pid;
	private String Name;
	private String Contact;
	private String Email;
	private String Password;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "User [pid=" + pid + ", Name=" + Name + ", Contact=" + Contact + ", Email=" + Email + ", Password="
				+ Password + "]";
	}
	
	
	
		
	}
	