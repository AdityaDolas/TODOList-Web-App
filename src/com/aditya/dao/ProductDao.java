package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aditya.config.DBConnect;
import com.aditya.pojo.Product;

public class ProductDao {

	Connection con = DBConnect.getConnect();

	public boolean addProduct(Product p) {

		// Inserting Data into Database
		String sql = "insert into product(Product_Name,Product_Price,Product_Quantity,Category,Product_Category,Product_Description) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, p.getPName());
			ps.setString(2, p.getPPrice());
			ps.setString(3, p.getPQuantity());
			ps.setString(4, p.getCategory());
			ps.setString(5, p.getPCategory());
			ps.setString(6, p.getPDescript());

			int i = ps.executeUpdate();
			if (i > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// GET PRODUCT LIST
	public List<Product> getProductList() {
		String sql = "select * from product";
		List<Product> al = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt(1));
				p.setPName(rs.getString(2));
				p.setPPrice(rs.getString(3));
				p.setPQuantity(rs.getString(4));
				p.setCategory(rs.getString(5));
				p.setPCategory(rs.getString(6));
				p.setPDescript(rs.getString(7));
				al.add(p);

			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	// GET PRODUCT BY ID
	public Product getProductByid(int pid) {
		String sql = "select * from product where pid=?";
		Product p = new Product();
		try {
			PreparedStatement pd = con.prepareStatement(sql);
			pd.setInt(1, pid);
			ResultSet rs = pd.executeQuery();
			while (rs.next()) {
				p.setPid(rs.getInt(1));
				p.setPName(rs.getString(2));
				p.setPPrice(rs.getString(3));
				p.setPQuantity(rs.getString(4));
				p.setPCategory(rs.getString(5));
				p.setPDescript(rs.getString(6));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

	// UPDATE USER
	public boolean UpdateProduct(Product p) {
		String sql = "update product set name=?, contact=?, password=? where email=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getPName());
			ps.setString(3, p.getPPrice());
			ps.setString(4, p.getPQuantity());
			ps.setString(5, p.getPCategory());
			ps.setString(6, p.getPDescript());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

	// DELETE Product
	public boolean deleteProduct(String pid) {
		String sql = "delete from product where pid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pid);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	// Search Product
	public List<Product> getProductByname(String search) {
		System.out.println("arvind ye dekh 2 bar print ho raha he===>" + search);
		/*
		 * String sql = "select * from product where Product_Name like '%"+search+"%'";
		 */
		String sql = "select * from product where Product_Name like '%" + search + "%'";
		List<Product> al = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt(1));
				p.setPName(rs.getString(2));
				p.setPPrice(rs.getString(3));
				p.setPQuantity(rs.getString(4));
				p.setPCategory(rs.getString(5));
				p.setPDescript(rs.getString(6));
				al.add(p);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	// Search Product Men, Women, Kids
	public List<Product> getProductByCategory(String men) {
		System.out.println("arvind ye dekh 2 bar print ho raha he===>" + men);
		String sql = "select * from product where Category=?";
		List<Product> al = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, men);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt(1));
				p.setPName(rs.getString(2));
				p.setPPrice(rs.getString(3));
				p.setPQuantity(rs.getString(4));
				p.setPCategory(rs.getString(5));
				p.setPDescript(rs.getString(6));
				al.add(p);
			}
			System.out.println("Length===>" + al.size());
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}