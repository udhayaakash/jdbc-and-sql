package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.io.*;
public class Hostel_allocate {
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	private static int flo=0, ro=0, blo=0;
	public Hostel_allocate() {
		
	}
	public Hostel_allocate(int f, int r, int b){
		flo=f;
		ro=r;
		blo=b;
	}
	public void allocate() throws SQLException {
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename", "student" , "student");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			Statement Stmt = myConn.createStatement();
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from cs");
			Statement st = myConn.createStatement();
			ResultSet r = st.executeQuery("select * from cs");
			ResultSet Rs = Stmt.executeQuery("select * from cs");
			int rcount=1, fcount=1, bcount=1, scount=1 ;
			System.out.println(ro+" "+flo+" "+blo);
			char c ='A';
			//Allocating for CSE students
			System.out.println("Allocating room for CSE students");
			int i=10;
			String room="A101";
			while(myRs.next()) {
					
				
				if(scount>4) {
					scount=1;
					rcount++;
					System.out.println("room "+room);
					if(rcount>ro) {
						rcount=1;
						bcount++;
						c++;
						
					
						
					if(bcount>blo) {
						bcount=1;
						fcount++;
						c='A';
						if(fcount>flo) {
							System.out.println("Student capacity exceeded");
							break;
						}
					}
					}
					
				}
				String id = myRs.getString("id");
				room = c +""+fcount+"0"+rcount;
						//update users set num_points = ? where first_name = ?;
				String s = "update cs set "+"room = '"+room+"' where id = '"+id+"'";
				Stmt.executeUpdate(s);
						//System.out.println(room);
				String source = "Name: "+myRs.getString("Name")+" Dept: "+myRs.getString("department")+" Room no: "+myRs.getString("room");		
				
				scount++;
				
			}
			scount=1;
			if(rcount<ro-1)
			rcount++;
			else {
				if(bcount<blo-1) {
					bcount++;
					c++;
				}
				else {
					if(fcount<flo-1) {
						fcount++;
					}
					else {
						System.out.println("Student capacity exceeded");
					}
				}
			}
			if(fcount<flo) {
				myRs = myStmt.executeQuery("select * from ec");
				Rs = Stmt.executeQuery("select * from ec");
				//Allocating for ECE students
				System.out.println("Allocating room for ECE students");
				while(myRs.next()) {
					
					
					if(scount>4) {
						scount=1;
						rcount++;
						System.out.println("room "+room);
						if(rcount>ro) {
							rcount=1;
							bcount++;
							c++;
							
						
						if(bcount>blo) {
							bcount=1;
							fcount++;
							c='A';
							if(fcount>flo) {
								System.out.println("Student capacity exceeded");
								break;
							}
						}
						}
						
					}
					String id = myRs.getString("id");
					room = c +""+fcount+"0"+rcount;
							//update users set num_points = ? where first_name = ?;
					String s = "update ec set "+"room = '"+room+"' where id = '"+id+"'";
					Stmt.executeUpdate(s);
					//System.out.println(room);
					String source = "Name: "+myRs.getString("Name")+" Dept: "+myRs.getString("department")+" Room no: "+myRs.getString("room");		
							
					scount++;
					
				}
				
			}
			scount=1;
			if(rcount<ro-1)
			rcount++;
			else {
				if(bcount<blo-1) {
					bcount++;
					c++;
				}
				else {
					if(fcount<flo-1) {
						fcount++;
					}
					else {
						System.out.println("Student capacity exceeded");
					}
				}
			}
			if(fcount<flo) {
				myRs = myStmt.executeQuery("select * from e");
				Rs = Stmt.executeQuery("select * from e");
				//Alloacating rooms for EEE
				System.out.println("Allocating room for EEE students");
				while(myRs.next()) {
					
					
					if(scount>4) {
						scount=1;
						rcount++;
						System.out.println("room "+room);
						if(rcount>ro) {
							rcount=1;
							bcount++;
							c++;
							
						
						if(bcount>blo) {
							bcount=1;
							fcount++;
							c='A';
							if(fcount>flo) {
								System.out.println("Student capacity exceeded");
								break;
							}
						}
						}
						
					}
					String id = myRs.getString("id");
					room = c +""+fcount+"0"+rcount;
							//update users set num_points = ? where first_name = ?;
					String s = "update e set "+"room = '"+room+"' where id = '"+id+"'";
					Stmt.executeUpdate(s);
					//System.out.println(room);
					String source = "Name: "+myRs.getString("Name")+" Dept: "+myRs.getString("department")+" Room no: "+myRs.getString("room");		

					scount++;
					
				}
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
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
	}


}
