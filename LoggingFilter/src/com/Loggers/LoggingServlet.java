package com.Loggers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.logging.Logger;


/**
 * Servlet implementation class LoggingServlet
 */
@WebServlet("/LoggingServlet")
public class LoggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static Logger log = Logger.getLogger(LoggingServlet.class.getName());
	  
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter writer = response.getWriter();
		  try {
		  log.info("invoked the LoggingServlet...");
		  writer.println("Check your web server console...");
		  writer.flush();
		  writer.close();
		  } finally {
		  writer.close();
		  }
		  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}







 




