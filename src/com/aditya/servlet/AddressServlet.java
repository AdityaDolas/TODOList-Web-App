package com.aditya.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.dao.AddressDao;
import com.aditya.pojo.Address;

@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Address a = new Address();
	AddressDao ad = new AddressDao();

	public AddressServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Inserting Data into Database
		String name = (String) request.getParameter("name");
		String contact = request.getParameter("contact");
		String username = request.getParameter("username");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pinecode = request.getParameter("pinecode");

		a.setName(name);
		a.setContact(contact);
		a.setUsername(username);
		a.setCity(city);
		a.setState(state);
		a.setPincode(pinecode);

		boolean b = ad.addAddress(a);

		if (b) {
			response.sendRedirect("Bill.jsp");
		} else {
			response.sendRedirect("HomePageDemo.jsp");
		}

	}
}
