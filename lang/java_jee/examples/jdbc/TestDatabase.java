/*
	This program loads the database driver and checks the connection
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class TestDatabase {
	private String url;
	private String username;
	private String password;
	private Connection conn;
	TestDatabase(){
		url ="";
		username ="";
		password ="";
	}
	TestDatabase(String url,String userName,String password){
		this.url = url;
		this.username = userName;
		this.password = password;
	}
	public boolean getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			return true;
		} catch (ClassNotFoundException ex){
			System.out.println(ex.getMessage());
		} catch (SQLException ex){
			System.out.println(ex.getMessage());
		}
		return false;
	}
	public void displayDatabaseMetaData(){
		try {
			DatabaseMetaData metaData = conn.getMetaData() ;
			System.out.println("database name"+metaData.getDatabaseProductName());
			System.out.println("database version"+metaData.getDatabaseProductVersion());
			System.out.println("driver name"+metaData.getDriverName());
			System.out.println("driver version"+metaData.getDriverVersion());
			System.out.println("Max connections"+metaData.getMaxConnections());
			System.out.println("Schemas:");
			ResultSet rs = metaData.getSchemas();
			while(rs.next()){
				System.out.println(rs.getString(0));
			}
			System.out.println("String functions:"+metaData.getStringFunctions());
			System.out.println("databse url:"+metaData.getURL());

		} catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}

	public void doSelected(int choice){
		if(choice ==1) createEmployeeTable();
		else if(choice ==2) createOrderTable();
	}
	private void createEmployeeTable() {
		try {
			String qry = " create table Employee(emp_id varchar(10),"+
			             " emp_name varchar(20))";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(qry);
			System.out.println("Table created successfully");
		} catch(SQLException sqlExp){
			System.out.println("Exception while creating employee table:"+sqlExp.getMessage());
		}
	}

	private void createOrderTable(){
		try {
			String qry = " create table Orders(order_id varchar(10),"+
		                 " emp_id varchar(20))";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(qry);
			System.out.println("Table created successfully");
		} catch(SQLException sqlExp){
			System.out.println("Exception while creating employee table:"+sqlExp.getMessage());
		}
	}

	public static void main(String args[]){
		TestDatabase td = new TestDatabase("jdbc:mysql://localhost:3306/testdb","test","test");
		if(td.getConnection()) 	System.out.println("Database connection succesful");
		//JOptionPane.showMessageDialog(null,"Database connection successful");
		//td.displayDatabaseMetaData();
		int choice;
		do{
			choice = getChoice();
			if(choice!=0) td.doSelected(choice);
		} while(choice !=0);
		System.exit(0);
	}
	public static int getChoice(){
		String choice = JOptionPane.showInputDialog(null,
					"1) Create Employee \n"+
					"2) Create Order \n"+
					"0) Exit");
		return Integer.parseInt(choice);
	}


}
