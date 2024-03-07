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


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		int status = 0;
		try {
			status = EmpDao.deleteEmp(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(status>0) {
		  response.sendRedirect("ViewServlet");
		}else {
			out.print("Something went Wrong");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}	
	}

