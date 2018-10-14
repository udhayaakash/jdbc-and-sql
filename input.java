package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class input {
	boolean num(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
	
	protected static int nof, nor, block;
	
	public void getInput() {
		String s="";
		System.out.println("Welcome admin");
		System.out.println("Please enter the number of floors");
		Scanner in=new Scanner(System.in);
		s=in.next();
		if(num(s))
		this.nof= Integer.parseInt(s);
		else {
			System.out.println("ENTER IN INTEGER FORMAT");
			this.nof = in.nextInt();
		}
			
		System.out.println("Please enter the number of blocks");
		s=in.next();
		if(num(s))
		this.block= Integer.parseInt(s);
		else {
			System.out.println("ENTER IN INTEGER FORMAT AGAIN");
			this.block=in.nextInt();
		}
		 
		System.out.println("Please enter the number of rooms in a block");
		s=in.next();
		if(num(s))
		this.nor= Integer.parseInt(s);
		else {
			System.out.println("ENTER IN INTEGER FORMAT AGAIN");
			this.nor=in.nextInt();
		}
	}
	
	public void Search(String name, String dept) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		Boolean b = false;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename", "student" , "student");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			if(dept.equals("ECE")||dept.equals("ece"))
			myRs = myStmt.executeQuery("select * from ec");
			else if(dept.equals("CSE")||dept.equals("cse"))
				myRs = myStmt.executeQuery("select * from cs");
			else if(dept.equals("EEE")||dept.equals("e"))
				myRs = myStmt.executeQuery("select * from e");
				
			while(myRs.next()) {
				String n=myRs.getString("Name");
				if(n.equals(name)) {
					System.out.println("ID="+myRs.getString("id")+",\nNAME: "+ n + ",\nDEPT: " +myRs.getString("department")+",\nROOM: "+myRs.getString("room"));
					b = true;
				}
			}
			// 4. Process the result set
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
		if(b==false) {
			System.out.println("Student not found!! Make sure you enter correct details");
		}
	}
}
