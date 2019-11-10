package com.aditya.pojo;

public class Cart {

	private int cartId;
	private String pname;
	private String description;
	private double price;
	private int qty;
	private String email;
	private int pid;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String toString() {
		return "Cart [cartId=" + cartId + ", pname=" + pname + ", description=" + description + ", price=" + price
				+ ", qty=" + qty + ", email=" + email + ", pid=" + pid + "]";
	}

}
