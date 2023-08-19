package com.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.DAO.ListDAO;
import com.todo.model.Anime;

@WebServlet("/")
public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ListDAO listDAO;
	
	@Override
	public void init() throws ServletException {
		listDAO = new ListDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch(action) {
		case "/list":
			showList(req, resp);
			break;
		case "/add":
			addToList(req, resp);
			break;
		case "/update":
			updateList(req, resp);
			break;
		case "/delete":
			delete(req,resp);
			break;
		default:
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}		
	}
	
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		listDAO.delete(id);
		System.out.println(req.getContextPath());
		resp.sendRedirect("list");
	}

	private void updateList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String[] names = req.getParameterValues("animeName");
		int result=0;
		if(names!=null) {
			for(String name:names) {
				//System.out.println(name);
				boolean watched = req.getParameter("watched_"+name)!=null;
				boolean watchLater = req.getParameter("watchLater_"+name)!=null;
				boolean completed = req.getParameter("completed_"+name)!=null;
				
				result = listDAO.update(name, watched, watchLater, completed);
			}
		}
		if(result ==1) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/list");
			req.setAttribute("NOTIFICATION", "SUCCESSFULLY UPDATED");
			resp.setIntHeader("Refresh", 2);
			dispatcher.forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/list");
		}
		
	}

	private void addToList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = listDAO.add(req.getParameter("animeName"), 
							Boolean.parseBoolean(req.getParameter("watched")), 
							Boolean.parseBoolean(req.getParameter("watchLater")),
							Boolean.parseBoolean(req.getParameter("completed")));
		
		if(result == 1) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/list");
			req.setAttribute("NOTIFICATION", "SUCCESSFULLY ADDED");
			//resp.setIntHeader("Refresh", 2);
			//System.out.println("addTOList() Refreshed");
			dispatcher.forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/list");
		}
		
	}

	private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Anime> animelist = listDAO.getList(); 
		//animelist.forEach((anime)->System.out.println(anime.getAnimeName()));
		req.setAttribute("animelist", animelist);
		RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
