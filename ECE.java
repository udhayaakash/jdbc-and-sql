package jdbcdemo;

public class ECE implements DEPT{
	int r=0,f=0,b=0;
	@Override
	public void allocate() {
		// TODO Auto-generated method stub
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
			myRs = myStmt.executeQuery("select * from ece");
			Rs = Stmt.executeQuery("select * from ece");
			//Allocating for ECE students
			while(myRs.next()) {
				
				
				if(scount>4) {
					scount=1;
					rcount++;
					System.out.println("room "+rcount);
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
				String room = c +""+fcount+"0"+rcount;
						//update users set num_points = ? where first_name = ?;
				String s = "update ece set "+"hostel = '"+room+"' where id = '"+id+"'";
				Stmt.executeUpdate(s);
						System.out.println(room);
				
				scount++;
				
			}
			
		}
	}
	int [] val() {
		CSE c = new CSE();
		int a[] = new int[3];
		r=c.ro;
		f=c.flo;
		b=c.blo;
		return a;
	}

}
