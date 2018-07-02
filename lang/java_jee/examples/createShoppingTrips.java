import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
public class createShoppingTrips
{
	String POPULATE_HISTORY_MASTER = "insert into pss_shopping_history_master(SHOPPINGTRIP_ID,SHOPPER_ID,SHOPPINGTRIP_STATE,"
					+ "ITEM_COUNT,TOTAL_PRICE) values (?,?,?,?,?)";
	String POPULATE_HISTORY_ITEM ="insert into pss_shopping_history_item(SHOPPINGTRIP_ID,SHOPPINGITEM_INDEX,BARCODE,ITEM_ID,"
					+ "SALE_PRICE,QUANTITY) values (?,?,?,?,?,?)";
	String DELETE_FROM_HISTORY_MASTER = "delete from pss_shopping_history_master where SHOPPINGTRIP_ID=?";
	String DELETE_FROM_HISTORY_ITEM = "delete from pss_shopping_history_item where SHOPPINGTRIP_ID=?";

	Connection con = null;

	public createShoppingTrips(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql:///pss","pss","pssadmin");
		}
		catch (Exception exp)
		{
			System.out.println("Exception while getting connection. Message:"+exp.getMessage());
			System.out.println("Exiting program..........");
			System.exit(2);
		}
	}

	public static void main(String args[]) {
		createShoppingTrips shoppingTrip = new createShoppingTrips();
		shoppingTrip.populateShopperTables(30501,40500);
		//shoppingTrip.cleanShoppingTables(10001,16000);
	}
	
	public void populateShopperTables(long startId,long endId) {
		System.out.println("Populating pss_shopping_history_master for shopping trip ids between "+startId+" and"+endId);
		try
		{
			PreparedStatement pstmt1 = con.prepareStatement(POPULATE_HISTORY_MASTER);
			PreparedStatement pstmt2 = con.prepareStatement(POPULATE_HISTORY_ITEM);
			for(long i=startId;i<=endId;i++){
				System.out.println("Shopper Id: "+i);
				// item 1
				pstmt2.setLong(1,i);
				pstmt2.setLong(2,0);
				pstmt2.setString(3,"037000936763");
				pstmt2.setString(4,"037000936763");
				pstmt2.setFloat(5,10);
				pstmt2.setLong(6,1);
				pstmt2.executeUpdate(); 
				// item 2
				pstmt2.setLong(1,i);
				pstmt2.setLong(2,1);
				pstmt2.setString(3,"073369060503");
				pstmt2.setString(4,"073369060503");
				pstmt2.setFloat(5,11);
				pstmt2.setLong(6,1);
				pstmt2.executeUpdate(); 

				pstmt1.setLong(1,i);
				pstmt1.setString(2,"460000001408");
				pstmt1.setString(3,"ENDED");
				pstmt1.setLong(4,2);
				pstmt1.setLong(5,21);
				pstmt1.executeUpdate(); 
			}
		}catch(Exception exp){
			System.out.println("Exception message populateHistoryMaster:"+exp.getMessage());
			exp.printStackTrace();
		}
		System.out.println("Done");
	}


	public void cleanShoppingTables(long startId,long endId){
		System.out.println("Deleting data from pss_shopping_history_master and pss_shopping_history_item for shoppers between "+startId+ " and "+endId);
		try
		{
			PreparedStatement pstmt1 = con.prepareStatement(DELETE_FROM_HISTORY_MASTER);
			PreparedStatement pstmt2 = con.prepareStatement(DELETE_FROM_HISTORY_ITEM);
			for(long i=startId;i<=endId;i++){
				pstmt1.setLong(1,i);
				pstmt1.executeUpdate();
				pstmt2.setLong(1,i);
				pstmt2.executeUpdate();
			}
		}
		catch (Exception exp)
		{
			System.out.println("cleanShoppingTables:Exception Message:"+exp.getMessage());
			exp.printStackTrace();
		}
		System.out.println("Done");
	}
}