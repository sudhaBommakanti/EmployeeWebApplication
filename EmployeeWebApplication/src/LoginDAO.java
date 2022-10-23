import java.sql.*;

public class LoginDAO {
	private static final String SELECT_EMPLOYEE_QUERY = "SELECT * FROM EMPLOYEES WHERE FirstName=? AND LastName=?";

	static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Library;integratedSecurity=true;TrustServerCertificate=true;";
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String userName = "";
	private static String password = "";

	public static boolean validate(String firstName, String lastName) {
		boolean status = false;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(URL, userName, password);

			PreparedStatement ps = con.prepareStatement(SELECT_EMPLOYEE_QUERY);
			ps.setString(1, firstName );
			ps.setString(2 , lastName);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
