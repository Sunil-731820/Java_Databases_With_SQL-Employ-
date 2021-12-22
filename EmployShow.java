package infinite.jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployShow {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitepractice",
					 "root", "root");
			String cmd = "select *from Employ";
			PreparedStatement pst = conn.prepareStatement(cmd);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				System.out.println("_----------------------------------------");
				System.out.println("The Employ Number is " + res.getInt("Empno"));
				System.out.println("The Employ Name is  " + res.getString("name"));
				System.out.println("The Gender is " + res.getString("Gender"));
				System.out.println("The Department is " + res.getString("Dept"));
				System.out.println("The Designation is " + res.getString("Desig"));
				System.out.println("The Basic is " + res.getInt("Basic"));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
