package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.aditya.config.DBConnect;
import com.aditya.pojo.Order;

public class OrderDao {

	Connection con = DBConnect.getConnect();

	public boolean addOrder(Order o) {

		String sql = "Insert into PlaceOrder(TOTALBILL,ORDERSTATUS,ORDERDATE,EMAIL) values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, o.getTotalBill());
			ps.setString(2, o.getStatus());
			ps.setString(3, o.getOrderDate());
			ps.setString(4, o.getEmail());

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
