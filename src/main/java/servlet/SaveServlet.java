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


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int status =0;
		Employee emp = new Employee();
		emp.setName(request.getParameter("name"));
		emp.setPassword(request.getParameter("password"));
		emp.setEmail(request.getParameter("email"));
		emp.setCountry(request.getParameter("country"));
		
		try {
			status = EmpDao.saveEmployee(emp);
			if(status>0) {
				out.print("Employee Added Successfully!");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}else {
				out.print("Something Going Wrong!");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
