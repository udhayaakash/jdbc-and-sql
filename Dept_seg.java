package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Dept_seg {

	protected static Connection Conn = null;
	protected static Statement Stmt = null;
	protected static ResultSet Rs = null;
	protected static Connection myConn = null;
	protected static Statement myStmt = null;
	protected static ResultSet myRs = null;
	public void department() throws SQLException
	{

		
		try {

			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dept", "student" , "student");
			Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename", "student" , "student");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			Stmt = Conn.createStatement();
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from student");
			
			// 4. Process the result set
			//input in = new input();
			int ro=0,fl=0;
			String i;
			int j=4;
			int k=0;
			int l=0;
			int m=0;
			while (myRs.next()) {
				String dep =myRs.getString("department");

				if(dep.equals("EEE")) {
					i = myRs.getString("id");
					++k;
			
					String s = "INSERT INTO eee " + "VALUES ('"+k+"','"+myRs.getString("Name")+"','EEE',null)";

		           Stmt.executeUpdate(s);
				}
				else if(dep.equals("ECE")){
					i = myRs.getString("id");
					++l;
					//INSERT NAME INTO CSE WHERE COLUMN = DFS AND id = NUM
			
					String s = "INSERT INTO ece " + "VALUES ('"+l+"','"+myRs.getString("Name")+"','ECE',null)";

		            Stmt.executeUpdate(s);
				}
				else if(dep.equals("CSE")) {
					i = myRs.getString("id");
					++m;
					String s = "INSERT INTO cse " + "VALUES ('"+m+"','"+myRs.getString("Name")+"','CSE',null)";
					Stmt.executeUpdate(s);
				}
				//System.out.println(myRs.getString("Name") + ", " +", ");
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
				//Rs.close();
				
			}
			
			if (myStmt != null) {
				myStmt.close();
				Stmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
				Conn.close();
			}
		}

	}
}
