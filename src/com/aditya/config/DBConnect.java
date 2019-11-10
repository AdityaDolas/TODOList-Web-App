package com.aditya.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("org.postgresql.Driver");

			// postgres://zcazflfwugurmv:642eff7aa8bf44f5c06232bc10d29498b9913871abf055d5a6d4a3252bceb9be@ec2-184-73-169-163.compute-1.amazonaws.com:5432/dbp79kqc8onoie
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","root");
			//con = DriverManager.getConnection(
					//"jdbc:postgresql://ec2-184-73-169-163.compute-1.amazonaws.com:5432/dbp79kqc8onoie",
					//"zcazflfwugurmv", "642eff7aa8bf44f5c06232bc10d29498b9913871abf055d5a6d4a3252bceb9be");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Connecting to database ...");
		return con;

	}
}
