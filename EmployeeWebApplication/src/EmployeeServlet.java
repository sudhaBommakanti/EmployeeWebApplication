
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
   // SQL query
   private static final String SELECT_EMPLOYEE_QUERY = 
         "SELECT * FROM EMPLOYEES WHERE EmployeeID = ?";
   static final String QUERY = "SELECT EmployeeId, FirstName, LastName FROM EMPLOYEES";
   
   static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Library;integratedSecurity=true;TrustServerCertificate=true;";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	//private String driver = "com.mysql.cj.jdbc.Driver";
	private String userName = "";
	private String password = "";

   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse res) 
         throws ServletException, IOException {

      // variables
      PrintWriter pw = null;
      int empno = 0;
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      boolean flag = false;

      // set content type
      res.setContentType("text/html");
      // get Writer
      pw = res.getWriter();

      // get form data
      empno = Integer.parseInt(req.getParameter("employeeId"));
      
      System.out.println("empNo: " + empno);
      
      try {
         // register JDBC driver
    	  System.out.println("driver: " + driver);
         Class.forName(driver);
         // create JDBC connection
         con = DriverManager.getConnection(URL, userName, password);
         // compile SQL query and store it in
         // PreparedStatement object
         if (con != null)
            ps = con.prepareStatement(SELECT_EMPLOYEE_QUERY);
         // set input value to query parameter
         if (ps != null)
            ps.setInt(1, empno);
         // execute the query
         if (ps != null)
            rs = ps.executeQuery();

         // process the result
         if (rs != null) {
            while (rs.next()) {
               // display result
               flag = true;
               pw.println("<h1>Employee Details </h1>" 
                    + "First Name: " + rs.getString("FIRSTNAME") + "<br>" 
                   + "Last Name: " + rs.getString("LASTNAME") + "<br>" 
                    + "Salary: " + rs.getBigDecimal("SALARY") + "<br>");
            }
         }

         // Student not found
         if (!flag) {
            pw.println("<h1>Employee not found</h1>");
         }

      } catch (SQLException se) {
         se.printStackTrace();
         pw.println("Error Occured");
      } catch (Exception e) {
         e.printStackTrace();
         pw.println("Unknown Exception Occured");
      } finally {
         // close JDBC connection
         try {
            if (rs != null)
               rs.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }
         try {
            if (ps != null)
               ps.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }
         try {
            if (con != null)
               con.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }

         // Link to home
         pw.println("<h3><a href='index.html'>Home</a></h3>");
         // close stream
         pw.close();
      }
   }

   @Override
   public void doPost(HttpServletRequest req, HttpServletResponse res) 
         throws ServletException, IOException {
      doGet(req, res);
   }
}
