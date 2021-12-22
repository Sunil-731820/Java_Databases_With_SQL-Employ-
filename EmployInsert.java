package infinite.jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployInsert {
	public static void main(String[] args) throws SQLException {
		int Empno,Basic;
		String name, Gender,Dept,Desig;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employ number here\n ");
		Empno = sc.nextInt();
		System.out.println("Enter the Name Here\n");
		name = sc.next();
		System.out.println("Enter the Gender Here\n");
		Gender = sc.next();
		System.out.println("Enter the Department here \n");
		Dept = sc.next();
		System.out.println("Enter the Designation here\n ");
		Desig = sc.next();
		System.out.println("Enter the Basic Here \n");
		Basic = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitepractice",
					"root","root");
			String cmd ="Insert into Employ(Empno,name,Gender,Dept,Desig,Basic)values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setInt(1, Empno);
			pst.setString(2, name);
			pst.setString(3, Gender);
			pst.setString(4, Dept);
			pst.setString(5, Desig);
			pst.setInt(6,Basic);
			pst.executeUpdate();
			System.out.println("the records are added successfully ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
