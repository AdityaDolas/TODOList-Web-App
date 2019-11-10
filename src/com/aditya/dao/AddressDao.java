package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.aditya.config.DBConnect;
import com.aditya.pojo.Address;

public class AddressDao {

	Connection con = DBConnect.getConnect();

	public boolean addAddress(Address a) {
		// Inserting Data into Database
		String sql = "insert into address (Name, Address, Username, City, State, Pinecode) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getName());
			ps.setString(2, a.getContact());
			ps.setString(3, a.getUsername());
			ps.setString(4, a.getCity());
			ps.setString(5, a.getState());
			ps.setString(6, a.getPincode());
			

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
