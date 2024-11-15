package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public HomeController() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
		{
		
		String apellido = request.getParameter("apellido");
		response.addHeader("content-type", "text/html; charset=utf-8");
		
		PrintWriter escribidor = response.getWriter();
		
		escribidor.append("Querido "+apellido+": ");
		escribidor.append("<button>:)</button>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String apellido = request.getParameter("apellido");
		
		response.getWriter().append(apellido+" :(");
	}

}
