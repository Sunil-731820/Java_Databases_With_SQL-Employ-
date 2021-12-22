package infinite.jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearch {
	public static void main(String[] args) throws SQLException {
		int Empno ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employ Number here for Searching\n ");
		Empno = sc.nextInt();
		try {
//			first Step 1 is : Register with the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
//			second Step 2 is : Getting the Connections Here
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitepractice",
					"root","root");
//			Third Step is 3: Query Statement 
			String cmd = "select *from Employ where Empno=?";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setInt(1, Empno);
//			Fourth Step is 4: Query Exceution 
			ResultSet res = pst.executeQuery();
			System.out.println("********* After performing the searching operation the Records are **********");
			if(res.next()) {
				System.out.println("The Employ Name  is \n" + res.getString("name"));
				System.out.println("The Gender is after Searching is \n" + res.getString("Gender"));
				System.out.println("The Department is \n " + res.getString("Dept"));
				System.out.println("The Designation is \n" + res.getString("Desig"));
				System.out.println("The Basic is \n" + res.getInt("Basic"));
				System.out.println("-------------------------------------------------------------------");
			}
			else {
				System.out.println("The Records Does not Exist in DataBase .....");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
