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
 * Servlet implementation class UpdateServlet2
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType ("text/html");
        PrintWriter out=response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String dept=request.getParameter("dept");
        Emp employee=new Emp();
        employee.setId(id);
        employee.setName(name);
        employee.setDept(dept);
        EmployeeDAO employeeDAO=new EmployeeDAO();
        Emp updateEmployee=employeeDAO.updateEmployee(employee);
        if(updateEmployee!=null) {
        	 out.println("<html><body>");
             out.println("<h1>Record Updated Successfully!</h1>");
             out.println("<a href='ViewSevlet'>View Employee</a> <br>");
             out.println("<a href='index.html'>Add Employee</a>");
             out.println("</body></html>");
        }
        else {
        	out.println("<html><body>");
            out.println("<h1>Unable to Save Record</h1>");
            out.println("</body></html>");
        }
        out.close();
        
        
        
	 }

}
