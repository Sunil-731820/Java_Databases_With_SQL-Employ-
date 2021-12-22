package infinite.jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployUpdate {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		int Empno,Basic;
		String name , Gender,Dept,Desig;
		System.out.println("Enter the Emp number for updation of the records ..\n");
		Empno = sc.nextInt();
		System.out.println("Enter the name for updation \n");
		name = sc.next();
		System.out.println("Enter the Gender (MALE or FEMALE) here for updation\n ");
		Gender = sc.next().toUpperCase();
		System.out.println("Enter the department for updation \n");
		Dept = sc.next();
		System.out.println("Enter the Designation for updation\n");
		Desig = sc.next();
		System.out.println("Enter the Basic Here \n");
		Basic = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitepractice",
					"root","root");
			String update1 = "update Employ set name=? ,Gender=?,Dept=?,Desig=?,Basic=?" +
					"where Empno=?";
			PreparedStatement pst = conn.prepareStatement(update1);
			pst.setString(1, name);
			pst.setString(2, Gender);
			pst.setString(3, Dept);
			pst.setString(4, Desig);
			pst.setInt(5, Basic);
			pst.setInt(6, Empno);
			pst.executeUpdate();
			System.out.println("the Records are updated SuccessFully ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	    }

   }
}
