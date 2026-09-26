package com.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SelectEmployee {
	public static void main(String[] args) {
		String sql="SELECT *FROM employees";
		try {
			Connection connection=DBConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("employee_id");
				String name=rs.getString("employee_name");
				String email=rs.getString("email");
				double salary=rs.getDouble("salary");
				String department=rs.getString("department");
				System.out.println(id+"|"+name+"|"+email+"|"+salary+"|"+department);
			}
			rs.close();
			ps.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}