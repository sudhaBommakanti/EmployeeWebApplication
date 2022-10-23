import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

public class RegisterEmployeeDAO {
	// SQL query
	private static final String REGISTER_EMPLOYEE_QUERY = "INSERT INTO EMPLOYEES (FirstName, LastName, Salary, IsCEO, IsManager, ManagerId) VALUES (?,?,?,?,?,?)";

	static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Library;integratedSecurity=true;TrustServerCertificate=true;";
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private static String userName = "";
	private static String password = "";
	
	@SuppressWarnings("unlikely-arg-type")
	public static boolean validate(String firstName, String lastName, String salary, String isCEO, String isManager, String managerId ) {
		boolean status = false;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(URL, userName, password);

			PreparedStatement ps = con.prepareStatement(REGISTER_EMPLOYEE_QUERY);
			
			int manId = Integer.parseInt(managerId);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			
			double d = Double.parseDouble(salary);  
			
			ps.setDouble(3, d );
		
			boolean isCeo = (isCEO.equals(true)) ? true: false;
			ps.setBoolean(4,  isCeo);
			
			boolean isMan = (isManager.equals(true)) ? true: false;
			ps.setBoolean(5,  isMan);
		
			ps.setInt(6, manId);
			
			System.out.println ("Row data: " +firstName + lastName + salary + isCEO + isManager + manId + "from form");
			
			// ps..setBigDecimal(2, new BigDecimal(799.88));
			// preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

			int row = ps.executeUpdate();
			// rows affected
			System.out.println(row); // 1

			//ResultSet rs = ps.executeQuery();
			
			status = true;
			//status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
