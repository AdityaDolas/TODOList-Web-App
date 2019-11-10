package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aditya.config.DBConnect;
import com.aditya.pojo.User;

public class UserDao {

	Connection con = DBConnect.getConnect();

	/*
	 * public static void main(String[] args) { User u = new User();
	 * u.setName("aa"); u.setEmail("ll"); u.setContact("22"); u.setPassword("1");
	 * System.out.println(new UserDao().addUser(u)); }
	 */

	// ADD User
	public boolean addUser(User u) {

		// Inserting Data into Database
		String sql = "insert into users (Name, Contact, Email, Password) values(?,?,?,?)";
		try {
			System.out.println("my mehod" + u);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getContact());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());

			int i = ps.executeUpdate();
			if (i > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// GET USER LIST
	public List<User> getUserList() {
		String sql = "select * from user";
		List<User> al = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setPid(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setContact(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				al.add(u);

			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	// GET USER BY ID
	public User getUserByid(String email) {
		String sql = "select * from user where email=?";
		User u = new User();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
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

	// UPDATE USER
	public boolean updateuser(User u) {
		String sql = "update user set name=?, contact=?, password=? where email=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getPid());
			ps.setString(2, u.getName());
			ps.setString(3, u.getContact());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getEmail());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// DELETE USER
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

	// LOGIN
	public User getLogin(String uname, String password) {

		String sql = "SELECT Email, Password, Name, Contact FROM users WHERE Email=? and Password=?";
		User u = new User();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setEmail(rs.getString("Email"));
				u.setPassword(rs.getString("Password"));
				u.setName(rs.getString("Name"));
				u.setContact(rs.getString("Contact"));

			}
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}