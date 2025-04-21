package Managing_Info;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main_Database {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost:3306/Security_";
	private static final String Username= "root";
	private static final String Password="Sanju@123";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args){
		try {
			Scanner scanner=new Scanner(System.in);
			Class.forName(Driver);
			conn=DriverManager.getConnection(Url,Username,Password);
			System.out.println("Connection Established successfully");
			System.out.println("Enter the database name");
			String database_name=scanner.nextLine();
			String query="drop database "+database_name;
			pmst=conn.prepareStatement(query);
			int i=pmst.executeUpdate();
			if(i==0) {
				System.out.println("Database is dropped");
			}
			else {
				System.out.println("Database  dropping is failed");
			}
			scanner.close();
			pmst.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
