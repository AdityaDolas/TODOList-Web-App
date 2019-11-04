package com.toDoApp.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toDoApp.pojo.UserPojo;
import com.toDoAppDao.UserDao;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserPojo u = new UserPojo();
	UserDao ud = new UserDao();

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Inserting Data into Database
		String name = request.getParameter("uname");
		String contact = request.getParameter("contact");
		String email = request.getParameter("Email");
		String pass = request.getParameter("pass");

		u.setName(name);
		u.setContact(contact);
		u.setEmail(email);
		u.setPassword(pass);

		boolean b = ud.addUser(u);

		if (b) {
			response.sendRedirect("LoginPage.jsp");
		} else {
			response.sendRedirect("CreateUser.jsp");
		}

	}
}
