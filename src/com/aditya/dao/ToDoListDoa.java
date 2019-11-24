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
		String sql = "insert into List (Todolist,Email,Date,checked) values(?,?,?,'incomplete')";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getEmail());
			ps.setString(3, t.getDate());
			//ps.setString(4, t.getChecked());

			int i = ps.executeUpdate();
			if (i > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Inserting Check-box into Database
	public boolean addCheckBox(ToDoList t) {
		String sql = "update list set checked='complete' where lid=?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(4, t.getChecked());

			int i = ps.executeUpdate();
			if (i > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Get data from database
	public List<ToDoList> getListById(String username) {
		String sql = "select * from list where email=?";

		List<ToDoList> tl = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ToDoList t = new ToDoList();
				t.setLid(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setDate(rs.getString(4));
				tl.add(t);

			}
			return tl;
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println();

		}
		return null;
	}

	// get data by id
	public User getUserByid(String username) {
		String sql = "select * from users where Email=?";
		User u = new User();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setPid(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setContact(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));

			}

		} catch (Exception e) {

		}
		return u;

	}

	// DELETE LIST
	public boolean deleteUser(int Lid) {
		String sql = "delete from list where Lid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Lid);
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
