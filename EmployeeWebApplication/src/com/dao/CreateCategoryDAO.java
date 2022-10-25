package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateCategoryDAO {
	private static final String INSERT_CATEGORY_QUERY = "INSERT INTO CATEGORY (CategoryName) VALUES (?)";

	static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Library;integratedSecurity=true;TrustServerCertificate=true;";
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String userName = "";
	private static String password = "";

	public static boolean validate(String categoryName) throws Exception {
		boolean status = false;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(URL, userName, password);

			PreparedStatement ps = con.prepareStatement(INSERT_CATEGORY_QUERY);
			
			//int catNum = Integer.parseInt(categoryID);
			//ps.setInt(1, catNum);
			ps.setString(1, categoryName);
			// ps..setBigDecimal(2, new BigDecimal(799.88));
			// preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

			int row = ps.executeUpdate();
			// rows affected
			System.out.println(row); // 1

			status = true;

		} catch (Exception e) {
			System.out.println(e);
			throw(e);
		}
		return status;
	}

}
