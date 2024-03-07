package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.EmpDao;
import model.Employee;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			List<Employee> empList =  EmpDao.empList();
			
			out.print("<table border='1' width='100%'");
			out.print("<tr><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
			
			for(Employee emp:empList) {
				out.print("<tr><td>"+emp.getName()+"</td><td>"+emp.getPassword()+"</td><td>"+emp.getEmail()+"</td><td>"+emp.getCountry()+"</td><td><a href='EditServlet?id="+emp.getId()+"'>Edit</td><td><a href='DeleteServlet?id="+emp.getId()+"'>Delete</td>");
			}
			out.print("</table>");
			out.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
}
