<!DOCTYPE html>
<%@page import="com.aditya.pojo.ToDoList"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>To Do List</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Titillium+Web">

<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<%
		List<ToDoList> toDoList = (List<ToDoList>) session.getAttribute("toDoList");
	%>

	<div>
		<div>
			<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
				<a class="navbar-brand" href="#">ToDoList</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link" href="#">Home
								<span class="sr-only">(current)</span>
						</a></li>

					</ul>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
						<ul class="navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="#">Logout
									<span class="sr-only">(current)</span>
							</a></li>

						</ul>
					</form>


				</div>
			</nav>
		</div>
		<br></br> <br></br>


		<form action="ToDoListServlet" method="post">
			<div class="addList">
				<div class="container sticky-top">
					<div class="input-group mb-3">
						<div class="input-group">
							<input name="inpute" type="text" class="form-control"
								placeholder="Enter an activity">
							<div class="input-group-btn">
								<button class="btn btn-danger" type="submit" id="button-addon2">Add
									To List</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>


		<div class="table">
			<div class="container">
				<div class="table-wrapper-scroll-y my-custom-scrollbar">

					<table class="table table-borderless table-dark">
						<thead>
							<tr class="bg-warning">
								<th scope="col">Title</th>
								<th scope="col">Check</th>
								<th scope="col">Delete</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (ToDoList t : toDoList) {
							%>
							<tr class="bg-info">
								<td><%=t.getName()%></td>
								<td><div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input"
											id="defaultUnchecked"> <label
											class="custom-control-label" for="defaultUnchecked">Complete</label>
									</div></td>
								<td><a href="TodolistData?action=delete&lid="><button
											type="submit">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>

				</div>
			</div>
		</div>



		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>