package Managing_Info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Application_Dynamic {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	//private static final String Url="jdbc:mysql://localhost:3306/security_info";
	private static final String Username="root";
	private static final String Password="Sanju@123";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		int choice;
		do {
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter your choice: ");
			DisplayMenu();
			choice=Integer.parseInt(scanner.next());
			switch(choice) {
			case 1:
				Create_Database();
				break;
			case 2:
				Drop_Database();
				break;
			case 3:
				Data_Insertion();
				break;
			case 4:
				Delete_by();
				break;
			case 5:
				Update_data();
				break;
			case 6:
				get_by();
				break;
			case 7:
				get_all();
				break;
			case 8:
				System.out.println("Thank You");
				choice=1;
				break;

			}

		}
		while(choice>0);
	}
	private static void get_all() {
		try {
			Scanner scanner=new Scanner(System.in);
			Class.forName(Driver);
			String Url="jdbc:mysql://localhost:3306/";
			System.out.println("Enter database name");
			conn=DriverManager.getConnection(Url+scanner.next(),Username,Password);
			System.out.println("Enter the table name: ");
			String table_name=scanner.next();
			String query="Select * from "+table_name;

			pmst=conn.prepareStatement(query);
			ResultSet result  =pmst.executeQuery();
			while(result.next()) {
				System.out.println("Id :"+result.getInt(1));
				System.out.println("Name :"+result.getString(2));
				System.out.println("Contact :"+result.getString(3));
			}

			pmst.close();
			conn.close();
		}
		catch(Exception e) {
		}

	}
	private static void Drop_Database() {
		try {
			Class.forName(Driver);
			String Url="jdbc:mysql://localhost:3306/";
			conn=DriverManager.getConnection(Url,Username,Password);
			Scanner scanner=new Scanner(System.in);
			System.out.print("Enter the database name: ");
			String database = scanner.nextLine();
			String query="Drop database "+database;
			pmst=conn.prepareStatement(query);
			int i =pmst.executeUpdate();
			if(i==0) {
				System.out.println("Database is dropped");
			}
			else {
				System.out.println("Database is not dropped");
			}
			pmst.close();
			conn.close();
		}
		catch(Exception e) {
		}

	}
	private static void get_by() {
		try {
			Scanner scanner=new Scanner(System.in);
			Class.forName(Driver);
			String Url="jdbc:mysql://localhost:3306/";
			System.out.println("Enter database name");
			conn=DriverManager.getConnection(Url+scanner.next(),Username,Password);
			System.out.println("Enter the table name: ");
			String table_name=scanner.next();
			System.out.println("Enter the column name" );
			String column_name=scanner.next();
			String query="Select * from "+table_name+" where "+column_name+"=?";
			pmst=conn.prepareStatement(query);
			System.out.println("Enter the condition");
			pmst.setInt(1, scanner.nextInt());

			ResultSet result  =pmst.executeQuery();
			while(result.next()) {
				System.out.println("Id :"+result.getInt(1));
				System.out.println("Name :"+result.getString(2));
				System.out.println("Contact :"+result.getString(3));
			}

			pmst.close();
			conn.close();
		}
		catch(Exception e) {
		}

	}
	private static void Update_data() {

		try {
			Scanner scanner=new Scanner(System.in);
			Class.forName(Driver);
			String Url="jdbc:mysql://localhost:3306/";
			System.out.println("Enter database name");
			conn=DriverManager.getConnection(Url+scanner.next(),Username,Password);
			System.out.println("Enter the table name: ");
			String table_name=scanner.next();
			String query="update "+table_name+" set Name=?,Contact=? where Id=?";
			pmst=conn.prepareStatement(query);
			System.out.print("Enter Name: ");
			pmst.setString(1,scanner.next());
			System.out.print("Enter Contact Info: ");
			pmst.setString(2,scanner.next());
			System.out.print("Enter id where to update: ");
			pmst.setString(3,scanner.next());
			int i =pmst.executeUpdate();
			if(i>0) {
				System.out.println("Update Successful");
			}
			else {
				System.out.println("Update unsuccessful");
			}
			pmst.close();
			conn.close();
		}
		catch(Exception e) {
		}


	}
	private static void Delete_by() {
		try {
			Scanner scanner=new Scanner(System.in);
			Class.forName(Driver);
			String Url="jdbc:mysql://localhost:3306/";
			System.out.println("Enter database name");
			conn=DriverManager.getConnection(Url+scanner.next(),Username,Password);
			System.out.println("Enter the table name: ");
			String table_name=scanner.next();
			System.out.println("Enter the column name" );
			String column_name=scanner.next();
			String query="Delete from "+table_name+" where "+column_name+"=?";
			pmst=conn.prepareStatement(query);
			System.out.println("Enter the condition");
			pmst.setInt(1, scanner.nextInt());

			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("Data is deleted");
			}
			else {
				System.out.println("Data is not deleted");

			}

			pmst.close();
			conn.close();
		}
		catch(Exception e) {
		}


	}
	private static void Data_Insertion() {
		try {
			Scanner scanner=new Scanner(System.in);
			Class.forName(Driver);
			String Url="jdbc:mysql://localhost:3306/";
			System.out.println("Enter database name");
			conn=DriverManager.getConnection(Url+scanner.next(),Username,Password);
			System.out.println("Enter the table name: ");
			String table_name=scanner.next();
			String query="insert into "+table_name+"(Id,Name,Contact) values(?,?,?)";
			pmst=conn.prepareStatement(query);
			System.out.println("Enter id: ");
			pmst.setString(1,scanner.next());
			System.out.println("Enter Name: ");
			pmst.setString(2,scanner.next());
			System.out.println("Enter Contact Info: ");
			pmst.setString(3,scanner.next());
			int i =pmst.executeUpdate();
			if(i>0) {
				System.out.println("Data is inserted");
			}
			else {
				System.out.println("Data is not inserted");
			}
			pmst.close();
			conn.close();
		}
		catch(Exception e) {
		}

	}
	private static void Create_Database() {
		try {
			Class.forName(Driver);
			String Url="jdbc:mysql://localhost:3306/";
			conn=DriverManager.getConnection(Url,Username,Password);
			Scanner scanner=new Scanner(System.in);
			System.out.print("Enter the database name: ");
			String database = scanner.nextLine();
			String query="Create database "+database;
			pmst=conn.prepareStatement(query);
			int i =pmst.executeUpdate();
			if(i>0) {
				System.out.println("Database is created");
			}
			else {
				System.out.println("Database is not created");
			}
			pmst.close();
			conn.close();
		}
		catch(Exception e) {
		}

	}
	private static void DisplayMenu() {
		System.out.println("\t1.Create Database");
		System.out.println("\t2.Drop Database");
		System.out.println("\t3.Data Insertion");
		System.out.println("\t4.Delete by id or email");
		System.out.println("\t5.Update Data");
		System.out.println("\t6.get by email");
		System.out.println("\t7.getall");
		System.out.println("\t8.Exit");

	}
}
