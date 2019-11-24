package com.aditya.pojo;

public class ToDoList {
	private int Lid;
	private String Name;
	private String Email;
	private String Date;
	private String checked;

	public int getLid() {
		return Lid;
	}

	public void setLid(int lid) {
		Lid = lid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "ToDoList [Lid=" + Lid + ", Name=" + Name + ", Email=" + Email + ", Date=" + Date + ", checked="
				+ checked + "]";
	}

}