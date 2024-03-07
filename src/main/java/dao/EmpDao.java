package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import util.EmployeeUtil;

public class EmpDao {
	
	public static int saveEmployee(Employee emp) throws SQLException {
		int status=0;
		Connection conn= null;
		
		try {
			conn= EmployeeUtil.createConnection();
			PreparedStatement pst = conn.prepareStatement("insert into emp(name,password, email,country) values (?,?,?,?)");
			pst.setString(1, emp.getName());
			pst.setString(2, emp.getPassword());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getCountry());
			status = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return status;
	}
	
	public static int updateEmp(Employee emp) throws SQLException {
		Connection conn=null;
		int status =0;
		try {
			conn= EmployeeUtil.createConnection();
			PreparedStatement pst = conn.prepareStatement("update emp set name =?, password=?, email=?, country=?  where id=?");
			pst.setString(1, emp.getName());
			pst.setString(2, emp.getPassword());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getCountry());
			pst.setInt(5, emp.getId());
			status = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return status;
	}
	
	public static int deleteEmp(int id) throws SQLException {
		Connection conn=null;
		int status =0;
		try {
			conn= EmployeeUtil.createConnection();
			PreparedStatement pst = conn.prepareStatement("delete from emp where id=?");
			pst.setInt(1, id);
			status= pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return status;
	}
	public static Employee getEmpById(int id) throws SQLException {
		Employee emp = new Employee();
		Connection conn = null;
		try {
			conn= EmployeeUtil.createConnection();
			PreparedStatement pst = conn.prepareStatement("select * from emp where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				emp.setId(Integer.parseInt(rs.getString("id")));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setEmail(rs.getString("email"));
				emp.setCountry(rs.getString("country"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return emp;
	}
	
	public static List<Employee> empList() throws SQLException{
		List<Employee> empllist=new ArrayList<Employee>();
		Connection conn= null;
		try {
			conn = EmployeeUtil.createConnection();
			PreparedStatement pst = conn.prepareStatement("select * from emp");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(Integer.parseInt(rs.getString("id")));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setEmail(rs.getString("email"));
				emp.setCountry(rs.getString("country"));
				empllist.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return empllist;
	}
	

}
