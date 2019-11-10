package com.aditya.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.dao.UserDao;
import com.aditya.pojo.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User u = new User();
	UserDao ud = new UserDao();

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String action = request.getParameter("action");

		if (action != null && action.equals("delete")) {
			String email = request.getParameter("email");

			boolean b = ud.deleteUser(email);
			if (b) {
				response.sendRedirect("UserServlet");
			}

		} else if (action != null && action.equals("edit")) {
			String email = request.getParameter("email");
			User user = ud.getUserByid(email);
			session.setAttribute("u", user);
			response.sendRedirect("UpdateUserList.jsp");
		} else {
			List<User> al = ud.getUserList();
			session.setAttribute("ulist", al);
			response.sendRedirect("Userlist.jsp");

		}

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
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("CreateUser.jsp");
		}

	}
}
