package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.aditya.config.DBConnect;
import com.aditya.pojo.ToDoList;
import com.aditya.servlet.ToDoListServlet;

public class ToDoListDoa {
	
	Connection con = DBConnect.getConnect();
	
	// ADD List
	public boolean addList(ToDoList t) {

		// Inserting Data into Database
		String sql = "insert into List (Name, Time, Date) values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getTime());
			ps.setString(3, t.getDate());

			int i = ps.executeUpdate();
			if (i > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	}
