package com.aditya.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.dao.ToDoListDoa;
import com.aditya.dao.UserDao;

import com.aditya.pojo.ToDoList;
import com.aditya.pojo.User;

@WebServlet("/ToDoListServlet")
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ToDoList t = new ToDoList();
	ToDoListDoa td = new ToDoListDoa();

	public ToDoListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		String action = request.getParameter("action");
		if (action != null && action.equals("delete")) {
			String email = request.getParameter("email");
			boolean b = td.deleteUser(email);
			if (b) {
				response.sendRedirect("ToDoListServlet");
			}
		} else {
			List<ToDoList> tl = td.getList();
			 System.out.println(tl);
			session.setAttribute("toDoList", tl);
			response.sendRedirect("ToDoListHomePage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Inserting Data into Database
		String name = request.getParameter("inpute");

		t.setName(name);

		boolean b = td.addList(t);

		if (b) {
			response.sendRedirect("TodolistData");
		} else {
			response.sendRedirect("CreateUser.jsp");
		}

	}

}
