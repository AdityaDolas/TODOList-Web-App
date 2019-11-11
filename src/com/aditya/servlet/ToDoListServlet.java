package com.aditya.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.dao.ToDoListDoa;
import com.aditya.dao.UserDao;
import com.aditya.pojo.ToDoList;
import com.aditya.pojo.User;

@WebServlet("/ToDoList")
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ToDoList t = new ToDoList();
	ToDoListDoa td = new ToDoListDoa();
	User u = new User();
	UserDao ud = new UserDao();

	public ToDoListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Inserting Data into Database
		String name = request.getParameter("inpute");
		String time = request.getParameter("inpute");
		String date = request.getParameter("inpute");

		u.setName(name);
		u.setName(time);
		u.setName(date);

		boolean b = td.addList(t);

		if (b) {
			response.sendRedirect("ToDoListHomePage.jsp");
		} else {
			response.sendRedirect("CreateUser.jsp");
		}

	}

}
