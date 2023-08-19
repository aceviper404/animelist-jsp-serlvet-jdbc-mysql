package com.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.DAO.LoginDAO;
import com.todo.model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	LoginDAO loginDAO;
	@Override
	public void init() throws ServletException {
		loginDAO = new LoginDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//authenticate username and password
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User(username, password);
		
		try {
			if(loginDAO.validate(user)) {
				// if user is validated, redirect to the main page
				RequestDispatcher dispatcher = req.getRequestDispatcher("/list");
				dispatcher.forward(req, resp);
				//System.out.println("User "+username+" Validated!!");
				
			}
			else {
				resp.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
