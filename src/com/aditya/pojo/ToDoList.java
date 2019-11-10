package com.aditya.pojo;

public class ToDoList {
	private int Lid;
	private String Name;
	private String Time;
	private String Date;

	public int getId() {
		return Lid;
	}

	public void setId(int id) {
		this.Lid = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

}
