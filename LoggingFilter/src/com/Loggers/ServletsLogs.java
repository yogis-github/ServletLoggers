package com.Loggers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

/**
 * Servlet implementation class example
 */
@WebServlet("/ServletsLogs")
public class ServletsLogs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilterConfig filterConfigObj = null;

	public void init(FilterConfig filterConfigObj) {
		this.filterConfigObj = filterConfigObj;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		{

			String remoteAddress = request.getRemoteAddr();
			String uri = ((HttpServletRequest) request).getRequestURI();
			String protocol = request.getProtocol();
			chain.doFilter(request, response);

			filterConfigObj.getServletContext().log("Logging Filter Servlet called");
			filterConfigObj.getServletContext().log("********************************");
			filterConfigObj.getServletContext().log("User Logged ! " + " User IP: " + remoteAddress + " Resource File: "
					+ uri + " Protocol: " + protocol);
		}

	}

	public void destroy() {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
