package com.aditya.pojo;

public class ToDoList {
	private int Lid;
	private String Name;

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

	@Override
	public String toString() {
		return "ToDoList [Lid=" + Lid + ", Name=" + Name + "]";
	}

}
