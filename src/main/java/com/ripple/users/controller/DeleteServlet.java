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
//import com.ripple.users.util.EntityManagerFactoryUtil;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		EmployeeDAO employeeDAO=new EmployeeDAO();

        Emp employee = employeeDAO.getEmployeeById(id);
        
        response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	             if (employee != null) {
	                
	                 employeeDAO.deleteEmployee(id);
	                 out.println("<html><body>");
	                 out.println("<p>Record deleted Successfully</p>");
	                 out.println("<a href='ViewSevlet'>View Employee</a>");
	                 out.println("</body></html>");
	             } else {
	            	 out.println("<html><body>");
	            	 out.println("Sorry Unable to delete the record!!");
	            	 out.println("</body></html>");
	             }
	             out.close();
	}
	              
	                
	}


