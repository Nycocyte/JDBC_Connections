
package Managing_Info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Database_Entry {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost:3306/security_info";
	private static final String Username="root";
	private static final String Password="Sanju@123";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		try {
			Scanner scanner=new Scanner(System.in);
			Class.forName(Driver);
			conn=DriverManager.getConnection( Url,Username,Password);
			//String query="drop table registration;";
			String query="insert into registration(Id,Name,Contact) values(?,?,?);";
			//String query="select *from security_info.registration;";
			pmst=conn.prepareStatement(query);
			System.out.print("Enter id: ");
			pmst.setString(1,scanner.nextLine());
			System.out.print("Enter Name: ");
			pmst.setString(2,scanner.nextLine());
			System.out.print("Enter Contact Info: ");
			pmst.setString(3,scanner.nextLine());
			int i=pmst.executeUpdate();
			
			/*while(i.next()) {
				
				System.out.print(i.getString(1)+"\t"); 
				System.out.print(i.getString(2)+"\t"); 
				System.out.print(i.getString(3)); 
			}*/
			/*if(i>0) {
				System.out.println("Data inserted");
			}
			else{
				System.out.println("Data not inserted");
			}*/
			pmst.close();
			conn.close();
			scanner.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
