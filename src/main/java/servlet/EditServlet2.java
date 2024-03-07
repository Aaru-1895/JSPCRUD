package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import model.Employee;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Employee emp = new Employee();
		emp.setId(Integer.parseInt(request.getParameter("id")));
		emp.setName(request.getParameter("name"));
		emp.setPassword(request.getParameter("password"));
		emp.setEmail(request.getParameter("email"));
		emp.setCountry(request.getParameter("country"));
		
		int status =0;
		try {
			status = EmpDao.updateEmp(emp);
			if(status>0) {
				response.sendRedirect("ViewServlet");
			}else{
				out.println("Sorry! unable to update record");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
