package com.aditya.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.dao.CartDao;
import com.aditya.dao.OrderDao;
import com.aditya.pojo.Order;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Order o = new Order();
	OrderDao od = new OrderDao();
	CartDao cd = new CartDao();

	public OrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		double totalBill = Double.parseDouble(request.getParameter("totalBill"));
		String email = (String) session.getAttribute("userName");
		String status = "In Process";
		String orderDate = new Date().toString();
		o.setEmail(email);
		o.setOrderDate(orderDate);
		o.setStatus(status);
		o.setTotalBill(totalBill);
		boolean b = od.addOrder(o);
		if (b) {

			boolean b2 = cd.deleteCartByEmail(email);
			if (b2) {
				response.sendRedirect("Bill.jsp");
			}
		}

	}
}
