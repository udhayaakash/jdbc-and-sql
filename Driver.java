package jdbcdemo;
import java.io.*;
import java.sql.*;
import java.util.*;
public class Driver extends input {
	protected static int t;
	public static void main(String[] args) throws SQLException ,IOException {
		
		
        Dept_seg ob = new Dept_seg();
        //ob.department();
        input i = new input();
        i.getInput();
        Hostel_allocate cs = new Hostel_allocate(nof,nor,block); 
        cs.allocate();
        System.out.println("Enter 1 if you want to search, anyother number to terminate");
        Scanner in=new Scanner(System.in);
        t= in.nextInt();
        while(t==1) {
        	if(t==1) {
            	
            	System.out.println("Enter the name and department");
            	String name= in.next();
            	String dept = in.next();
            	i.Search(name, dept);
        
        }
        	 System.out.println("\nEnter 1 if you want to search, anyother number to terminate");
        	 String r= in.next();
             if(r.charAt(0)=='1')
            	 t=Integer.parseInt(r);
             else
            	 t=0;
        }
        System.out.println("Operation terminated");
		
	}

}



