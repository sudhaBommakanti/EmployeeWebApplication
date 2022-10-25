import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.dao.LibraryList;

import java.sql.Date; 

public class CreateLibraryDAO {
	private static final String INSERT_LIBRARYITEM_QUERY = "INSERT INTO LIBRARYITEM (CategoryId, Title, Author, Pages, RunTimeMinutes, isBorrowable, Borrower, BorrowDate, Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Library;integratedSecurity=true;TrustServerCertificate=true;";
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String userName = "";
	private static String password = "";
	
	private static final String GET_CATEGORYID_FOR_CATEGORY_NAME_QUERY = "select categoryid from category where categoryName=?";
	
	private static final String UPDATE_LIBRARYITEM_QUERY = "INSERT INTO LIBRARYITEM (categoryId)" + 
			"SELECT categoryId from category c where c.categoryName = (Select categoryname from category where categoryId = c.categoryId)";
	
	public static boolean validate(String title, String author, String pages, String runTimeMinutes, String isBorrowable, String borrower, String borrowDate, String catName, String type) {
		boolean status = false;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(URL, userName, password);
			PreparedStatement psGet = con.prepareStatement(GET_CATEGORYID_FOR_CATEGORY_NAME_QUERY);
			
			psGet.setString(1, catName);
			
			rs = psGet.executeQuery();
			int catId = 0;
		
			while (rs.next()) {
				// Just get the value of the column, and add it to the list
				catId = rs.getInt("categoryId");
				
			}
			
			System.out.println("categoryID : " + catId);
		
			
			PreparedStatement psInsert = con.prepareStatement(INSERT_LIBRARYITEM_QUERY);
			
			int numpages = Integer.parseInt(pages);
			int runTime = Integer.parseInt(runTimeMinutes);
			boolean isBorrow = (isBorrowable.equals(true)) ? true: false;
			  
		    Date stringToDate = Date.valueOf(borrowDate); 
			
		    psInsert.setInt(1,  catId);
		    psInsert.setString(2, title);
		    psInsert.setString(3, author);
		    psInsert.setInt(4, numpages);
		    psInsert.setInt(5, runTime);
		    psInsert.setBoolean(6, isBorrow);
		    psInsert.setString(7,  borrower);
		    psInsert.setDate(8, stringToDate);
		    psInsert.setString(9, type);
		
			int row = psInsert.executeUpdate();
			// rows affected
			System.out.println(row); // 1

			status = true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
