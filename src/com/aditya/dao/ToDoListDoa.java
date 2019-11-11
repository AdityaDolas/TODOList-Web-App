package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aditya.config.DBConnect;
import com.aditya.pojo.ToDoList;
import com.aditya.pojo.User;
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
		String sql = "select * from list";
		List<ToDoList> tl = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ToDoList t = new ToDoList();
				t.setName(rs.getString(1));
				tl.add(t);

			}
			return tl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tl;
	}
	
	// DELETE LIST
		public boolean deleteUser(String email) {
			String sql = "delete from user where email=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, email);
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
