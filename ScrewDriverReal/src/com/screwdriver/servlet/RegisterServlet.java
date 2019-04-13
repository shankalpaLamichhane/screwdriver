package com.screwdriver.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screwdriver.beans.UserAccount;
import com.screwdriver.conn.MySQLConnUtils;
import com.screwdriver.dao.Dao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = (String) request.getParameter("name");		
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		int number = Integer.parseInt((String) request.getParameter("number"));
		String location = (String) request.getParameter("location");
		
		UserAccount user = new UserAccount();
		user.setName(name);
		user.setEmail(email);
		user.setNumber(number);
		user.setPassword(password);
		user.setLocation(location);
		
		String errorString = null;
		int checkStatus=0;
		try {
			checkStatus = Dao.save(user);
			if(checkStatus == 0) 
			{
				errorString = "Error encountered";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			errorString = e.getMessage();
			e.printStackTrace();
		}
		
		request.setAttribute("user",user);
		request.setAttribute("errorString", errorString);
		
		if(checkStatus>0) 
		{
			response.sendRedirect("index.html");
		}else 
		{
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/register.jsp");
			dispatcher.forward(request, response);
		}
	}

}
