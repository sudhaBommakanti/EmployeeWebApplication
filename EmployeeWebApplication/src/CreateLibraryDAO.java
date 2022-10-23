import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;  
import java.sql.Date; 

public class CreateLibraryDAO {
	private static final String INSERT_LIBRARYITEM_QUERY = "INSERT INTO LIBRARYITEM (CategoryId, Title, Author, Pages, RunTimeMinutes, isBorrowable, Borrower, BorrowDate, Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Library;integratedSecurity=true;TrustServerCertificate=true;";
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String userName = "";
	private static String password = "";

	public static boolean validate(String title, String author, String pages, String runTimeMinutes, String isBorrowable, String borrower, String borrowDate, String type) {
		boolean status = false;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(URL, userName, password);

			PreparedStatement ps = con.prepareStatement(INSERT_LIBRARYITEM_QUERY);
			
			int numpages = Integer.parseInt(pages);
			int runTime = Integer.parseInt(runTimeMinutes);
			boolean isBorrow = (isBorrowable.equals(true)) ? true: false;
			  
		    Date stringToDate = Date.valueOf(borrowDate); 
			
		    ps.setInt(1,  1);
			ps.setString(2, title);
			ps.setString(3, author);
			ps.setInt(4, numpages);
			ps.setInt(5, runTime);
			ps.setBoolean(6, isBorrow);
			ps.setString(7,  borrower);
			ps.setDate(8, stringToDate);
			ps.setString(9, type);
		
			int row = ps.executeUpdate();
			// rows affected
			System.out.println(row); // 1

			status = true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
