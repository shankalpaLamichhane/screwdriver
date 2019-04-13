package com.screwdriver.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screwdriver.beans.UserAccount;
import com.screwdriver.dao.Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext()
							.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String errorString = null;
		UserAccount user = null;
		try {
			 user = Dao.findUser(email, password);
			 System.out.println("user is now "+user);
			 System.out.println("user == null" + (user==null));
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			errorString = e.getMessage();
			e.printStackTrace();
		}
		
		
		if(errorString != null || user == null) 
		{
			if(user == null)
				{
				errorString = " incorrect username or password";
				}
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}else 
		{
			response.sendRedirect(request.getContextPath()+"/index.html");
		}
	}

}
