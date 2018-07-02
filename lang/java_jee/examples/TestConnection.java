import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection
{
	public static void main(String args[]) {
		Connection con = null;
		String FIND_USER =" SELECT * FROM users WHERE name=?";
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();	
			con = DriverManager.getConnection("jdbc:mysql:///user","user","useradmin");
			if(con==null){
				System.out.println("Connection is null");
			} else {
				System.out.println("Connection is not null");
			}
			ResultSet rset;
			PreparedStatement stmt = con.prepareStatement(FIND_USER);
			//stmt.setString(1,"sss");
			rset= stmt.executeQuery();
			if(rset==null)
				System.out.println("Result set is null");
			rset.first();
			System.out.println(rset.getRow());

			System.out.println(rset.getString("name"));
			System.out.println(rset.getString("contactnumber"));
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}
}