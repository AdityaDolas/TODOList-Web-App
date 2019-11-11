package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.aditya.config.DBConnect;
import com.aditya.pojo.Cart;
import com.aditya.pojo.ToDoList;
import com.aditya.servlet.ToDoListServlet;

public class ToDoListDoa {

	Connection con = DBConnect.getConnect();

	// ADD List
	public boolean addList(ToDoList t) {

		// Inserting Data into Database
		String sql = "insert into List (Todolist) values(?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getName());

			int i = ps.executeUpdate();
			if (i > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getList(String email) {

		// Get Data from Database
		String sql = "insert into List (Todolist) values(?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ToDoList c = new ToDoList();
				c.setPid(rs.getInt(1));
				
			}
			return cl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
