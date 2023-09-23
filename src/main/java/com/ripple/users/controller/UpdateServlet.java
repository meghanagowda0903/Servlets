package com.ripple.users.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.ripple.users.dao.EmployeeDAO;
import com.ripple.users.dto.Emp;


/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {  
	 	
		   response.setContentType("text/html");
	       PrintWriter out = response.getWriter();
	       out.println("<h1>Update Employee</h1>");  
	       int id = Integer.parseInt(request.getParameter("id"));
       
	        EmployeeDAO employeeDAO = new EmployeeDAO();
	        Emp employee=employeeDAO.getEmployeeById(id);
        
	        out.print("<form action='UpdateServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+employee.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+employee.getName()+"'/></td></tr>");  
	        out.print("<tr><td>Dept:</td><td><input type='text' name='dept' value='"+employee.getDept()+"'/> </td></tr>");  
	        
	        out.print("<tr><td colspan='2'><input type='submit' value='Update '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();
	    }
	}







