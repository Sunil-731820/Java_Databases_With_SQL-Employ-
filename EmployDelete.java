package infinite.jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployDelete {
	public static void main(String[] args) throws SQLException {
		int Empno ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employ Number Here  ");
		Empno = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitepractice",
					"root","root");
			String delete1 = "Delete from Employ where Empno=?";
			PreparedStatement pst = conn.prepareStatement(delete1);
			pst.setInt(1, Empno);
			pst.executeUpdate();
			System.out.println("The records are deleted successfully from the table ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
