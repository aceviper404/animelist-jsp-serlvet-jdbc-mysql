package com.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.DAO.RegisterDAO;
import com.todo.model.User;

@WebServlet("/register")
public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	RegisterDAO registerDAO;
	
	@Override
	public void init() throws ServletException {
		registerDAO = new RegisterDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("register.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//call registerDAO.addUser()
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User(firstName, lastName, username, password);
		RequestDispatcher dispatcher =null;
		
		try {
			int addedRow = registerDAO.addUser(user);
			dispatcher = req.getRequestDispatcher("register.jsp");
			
			if(addedRow == 1) {
				// show notification as registration successful 
				req.setAttribute("notification", "Registration Successful!");
			}
//			else if(addedRow == 0){
//				// show notification as registration failed
//				req.setAttribute("notification", "Username Already Exists");
//			}
//			else {
//				req.setAttribute("notification", "Registration Failed");
//			}
			dispatcher.forward(req, resp);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
}
