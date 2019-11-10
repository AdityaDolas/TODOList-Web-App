package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aditya.config.DBConnect;
import com.aditya.pojo.Cart;

public class CartDao {

	Connection con = DBConnect.getConnect();

	public boolean addToCart(int pid, String userName) {
		String sql = "insert into cart(pid,username) values(?,?)";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, userName);

			int i = ps.executeUpdate();

			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public List<Cart> getCartList(String email) {
		String sql = "select distinct  p.pid, Product_Name ,Product_Price, Product_Description from product p inner join cart c on p.pid =c.pid where userName=?";
		List<Cart> cl = new ArrayList<Cart>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setPid(rs.getInt(1));
				c.setPname(rs.getString(2));
				c.setPrice(rs.getDouble(3));
				c.setDescription(rs.getString(4));
				cl.add(c);
			}
			return cl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// DELETE Product From Cart
	public boolean deleteCartByEmail(String email) {
		String sql = "delete from cart where email=?";
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
