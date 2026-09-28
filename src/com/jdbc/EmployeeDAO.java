package com.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
    public void addEmployee(Employee employee) {
        
        String sql = """
                     INSERT INTO employees
                     (employee_name, email, salary, department, joining_date)
                     VALUES (?, ?, ?, ?, ?)
                     """;
                     
        try (Connection connection =
        		DBConnection.getConnection();
        		
             PreparedStatement ps =
            		 connection.prepareStatement(sql)) {
             
           
            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getEmail());
            ps.setDouble(3, employee.getSalary());
            ps.setString(4, employee.getDepartment());
            
            int rows = ps.executeUpdate(); 
         
            System.out.println(
            		rows + "employee inserted successfully."
            		);
            
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
    }


        public List<Employee> getAllEmployees() {
        	
        	List<Employee> employees =
        			new ArrayList<>();
        	
        	String sql =
        			"SELECT * FROM employees";
        	try (Connection connection =
        			DBConnection.getConnection();
        			
        			PreparedStatement ps =
        			connection.prepareStatement(sql);
        			
        			
        			ResultSet rs = 
        					ps.executeQuery()) {
        		
        		while (rs.next()) {
        			Employee employee = new Employee();
        			
        			employee.setEmployeeId(
        					rs.getInt("employee_id")
        					);
        			
        			employee.setEmployeeName(
        					rs.getString("employee_name")
        			);
        			
        			employee.setEmail(
        					rs.getString("email")
        			);
        			
        			employee.setSalary(
        					rs.getDouble("salary")
        			);
        			
        			employee.setDepartment(
        					rs.getString("department")
        			);
        			employee.setJoiningDate(
        					rs.getDate("joining_date")
        			);
        			employees.add(employee);
        		}
        		
        	} catch (Exception e) {
        		
        		e.printStackTrace();
        	}
        	
        	return employees;
        	
        }
        									
  

         public  void updateEmployee(
        		 int employeeId,
        		 double salary) {
        	 
        	 String sql = """
        	 		UPDATE  employees
        	 		SET salary = ?
        	 		""";
        	 
        	 try(Connection connection =
        			 DBConnection.getConnection();
        			 
        		PreparedStatement ps = 
        				connection.prepareStatement(sql)) {
        		 
        		 ps.setDouble(1, salary);
        		 ps.setInt(2,  employeeId);
        		 
        		 int rows = ps.executeUpdate();
        		 
        		 System.out.println(
        				 rows +"employee updated."
        		);
        		 
        	 } catch (Exception e) {
        		 
        		 e.printStackTrace();
        	 }
         }
         
         public static void main(int employeeId)  {
        	 
        	 String sql = """
        	 		DELETE FROM employees
        	 		WHERE employee_id = ?
        	 		""";
        	 
        	 try (Connection connection =
        			 DBConnection.getConnection();
        			 
        		  PreparedStatement ps =
        				  connection.prepareStatement(sql)) {
        					  
               ps.setInt(1, employeeId);
               
               int rows = ps.executeUpdate();
               
               System.out.println(rows + "employee deleted.");
               
        	 } catch (Exception e) {
        		 
        		 e.printStackTrace();
        		 
        	 }
         }
}