package com.toDoAppDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.toDoApp.Config.DBConnect;
import com.toDoApp.pojo.UserPojo;


public class UserDao {

	Connection con = DBConnect.getConnect();

	/*
	 * public static void main(String[] args) { UserPojo u = new UserPojo();
	 * u.setName("aa"); u.setEmail("ll"); u.setContact("22"); u.setPassword("1");
	 * System.out.println(new UserPojoDao().addUserPojo(u)); }
	 */

	// ADD UserPojo
	public boolean addUser(UserPojo u) {

		// Inserting Data into Database
		String sql = "insert into Users (Name, Contact, Email, Password) values(?,?,?,?)";
		try {
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

	// GET UserPojo LIST
	public List<UserPojo> getUserPojoList() {
		String sql = "select * from Users";
		List<UserPojo> al = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserPojo u = new UserPojo();
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


	// LOGIN
	public UserPojo getLogin(String uname, String password) {

		String sql = "SELECT Email, Password, Name, Contact FROM Users WHERE Email=? and Password=?";
		UserPojo u = new UserPojo();
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
