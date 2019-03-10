package com.Loggers;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

@WebServlet("/test")
public class TestLog4jServlet extends HttpServlet {
	
	 static private FileHandler fileTxt;
	    static private SimpleFormatter formatterTxt;

    static private FileHandler fileHTML;
    static private Formatter formatterHTML;

	static final Logger log = Logger.getLogger(TestLog4jServlet.class); 
			
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		 log.setLevel(Level.INFO);
	        fileTxt = new FileHandler("Logging.txt");
	        fileHTML = new FileHandler("Logging.html");
	        
	        
	        // create a TXT formatter
	        formatterTxt = new SimpleFormatter();
	        fileTxt.setFormatter(formatterTxt);
	        log.addHandler(fileTxt);

	        // create an HTML formatter
	        formatterHTML = new MyHtmlFormatter();
	        fileHTML.setFormatter(formatterHTML);
	        log.addHandler(fileHTML);

		

	}

}


/*	log.info("This is a logging statement from log4j");
log.info("new log generated");

String html = "<html><h2>Log4j has been initialized successfully!</h2></html>";
response.getWriter().println(html);

String xml = "<xml><h2>Log4j is generated!</h2></html>";
response.getWriter().println(xml);*/





