package com.aditya.servlet;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
			int email = Integer.parseInt(request.getParameter("lid"));
			boolean b = td.deleteUser(email);
			if (b) {
				response.sendRedirect("ToDoListServlet");
			}
		} else if (action != null && action.equals("completeTask")) {

			// Inserting Data into Database

			// String taskId = request.getParameter("taskId");
			// System.out.println("taskId = " + taskId);

			String checked = request.getParameter("taskId");

			t.setChecked(checked);

			boolean b = td.addList(t);

			if (b) {
				response.sendRedirect("ToDoListServlet");
			} else {
				response.sendRedirect("CreateUser.jsp");
			}

		} else {

			List<ToDoList> tl = td.getListById(username);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String date = dtf.format(now);
			// System.out.println(date);
			// System.out.println(tl);
			session.setAttribute("toDoList", tl);
			session.setAttribute("dateTime", date);
			response.sendRedirect("ToDoListHomePage.jsp");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Inserting Data into Database
		String name = request.getParameter("insert");
		String email = (String) session.getAttribute("username");
		String date = (String) session.getAttribute("dateTime");

		t.setName(name);
		t.setEmail(email);
		t.setDate(date);

		boolean b = td.addList(t);

		if (b) {
			response.sendRedirect("ToDoListServlet");
		} else {
			response.sendRedirect("CreateUser.jsp");
		}

	}

}
