package com.screwdriver.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screwdriver.beans.Info;
import com.screwdriver.dao.Dao;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/info.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info = request.getParameter("info");
		String description = request.getParameter("description");
		Info information = new Info();
		information.setInfo(info);
		information.setDescription(description);
		int checkStatus = 0;
		String errorString = null;
		try {
			checkStatus= Dao.saveInfo(information);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			errorString = e.getMessage();
			e.printStackTrace();
		}
		if(checkStatus>0) 
		{
			response.sendRedirect("index.html");
		}else {
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/info.jsp");
			dispatcher.forward(request, response);
		}
	}

}
