package com.aditya.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.dao.CartDao;
import com.aditya.dao.ProductDao;
import com.aditya.pojo.Cart;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDao cd = new CartDao();
	ProductDao pd = new ProductDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		String action = request.getParameter("action");
		if (action != null && action.equals("addToCart")) {

			int pid = Integer.parseInt(request.getParameter("pid"));

			boolean b = cd.addToCart(pid, username);

			if (b) {
				request.setAttribute("cartMsg", "Cart Added Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("HomePageDemo.jsp");
				rd.include(request, response);
			}
		} else if (action != null && action.equals("edit")) {

		} else if (action != null && action.equals("delete")) {
			System.out.println("delete");
			String pid = request.getParameter("pid");

			boolean b = pd.deleteProduct(pid);
			if (b) {
				response.sendRedirect("CartServlet");
			}

		} else if (request.getParameter("qty") != null) {
			String qty []= request.getParameterValues("qty");

			// String fake = request.getParameter("fake");
			// System.out.println("" + qty + "|bygrvtmhyjynjbvfrgbmk " + fake);
			session.setAttribute("qty", qty);
			// System.out.println("");
			String selectedQuantities = request.getParameter("updatedQuantities");
			String selectedQuantitiesArray[] = selectedQuantities.split(",");

			System.out.println("quantities => " + selectedQuantities);
			CartDao cd = new CartDao();

			List<Cart> orders = cd.getCartList(username);
			int i = 0, totalPrice = 0;
			double d = 0;
			ArrayList<Double> SubTotal = new ArrayList<>();
			
			for (Cart c : orders) {
				totalPrice += c.getPrice() * Integer.parseInt(selectedQuantitiesArray[i]);
				d = c.getPrice() * Integer.parseInt(selectedQuantitiesArray[i++]);
				System.out.println("order => " + d);
				SubTotal.add(d);
				
				System.out.println("prices:"+c.getPrice());
			}
			System.out.println("toalPrice ===> " + totalPrice);

			request.setAttribute("d", d);
			request.setAttribute("orders", orders);
			request.setAttribute("s", SubTotal);
			request.setAttribute("totalPrice", totalPrice);

			request.getRequestDispatcher("PlaceOrder.jsp").forward(request, response);
			// response.sendRedirect("PlaceOrder.jsp");
		} else {
			List<Cart> CartList = cd.getCartList(username);
			session.setAttribute("CartList", CartList);
			response.sendRedirect("CartList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession(); String username = (String)
		 * session.getAttribute(username);
		 * 
		 * double totalBill = 0; String qty[] = request.getParameterValues("qty");
		 * String price[] = request.getParameterValues("price"); String pname[] =
		 * request.getParameterValues("pname");
		 * 
		 * for (int i = 0; i < price.length; i++) { totalBill =
		 * totalBill+(Integer.parseInt(qty[i])*Double.parseDouble(price[i])); }
		 * 
		 * session.setAttribute("pname", pname); session.setAttribute("qty", qty);
		 * session.setAttribute("price", price); session.setAttribute("totalBill",
		 * totalBill);
		 * 
		 * Address b=ad.getAddressByEmail(username); if(b.getEmail()!=null &&
		 * b.getEmail().equals(username)) { session.setAttribute("a",b);
		 * response.sendRedirect("updateAddress.jsp"); }else {
		 * response.sendRedirect("addAddress.jsp"); } }
		 */

	}
}