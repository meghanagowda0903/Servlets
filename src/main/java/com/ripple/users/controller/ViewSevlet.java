package com.ripple.users.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

import com.ripple.users.dao.EmployeeDAO;
import com.ripple.users.dto.Emp;
//import com.ripple.users.util.EntityManagerFactoryUtil;

/**
 * Servlet implementation class ViewSevlet
 */
@WebServlet("/ViewSevlet")
public class ViewSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<a href='index.html'>Add Employee</a>");
	        out.println("<h1>Employees List</h1>");
	        
	        out.println("<table border='1' width='100%'>");
	        out.println("<tr><th>Id</th><th>Name</th><th>Dept</th><th>Update</th><th>Delete</th></tr>");

	        
	        EmployeeDAO employeeDAO=new EmployeeDAO();
	        List<Emp> employees = employeeDAO.getAllEmployees();

	       
	        for (Emp employee : employees) {
	            out.println("<tr>");
	            out.println("<td>" + employee.getId() + "</td>");
	            out.println("<td>" + employee.getName() + "</td>");
	            out.println("<td>" + employee.getDept() + "</td>");
	            out.println("<td><a href='UpdateServlet?id=" + employee.getId() + "'>update</a></td>");
	            out.println("<td><a href='DeleteServlet?id=" + employee.getId() + "'>delete</a></td>");
	            out.println("</tr>");
	        }
	        out.println("</table>");
	        out.close();
	    }
}
