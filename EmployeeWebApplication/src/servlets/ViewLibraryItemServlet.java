package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.dao.LibraryItemsList;
import com.model.LibraryList;

/**
 * Servlet implementation class ViewCategoryServlet
 */
@WebServlet("/ViewLibraryItemServlet")
public class ViewLibraryItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SELECT_LIBRARY_NAMESQUERY = "SELECT DISTINCT Title, Author FROM LIBRARYITEM";

	static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Library;integratedSecurity=true;TrustServerCertificate=true;";
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String userName = "";
	private static String password = "";
	
	List<LibraryList> libraryItems;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewLibraryItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		libraryItems = new ArrayList<LibraryList>();
		
		LibraryList list;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
		
			Class.forName(driver);
			con = DriverManager.getConnection(URL, userName, password);

			ps = con.prepareStatement(SELECT_LIBRARY_NAMESQUERY);

			rs = ps.executeQuery();
			
			
			while (rs.next()) {
				// Just get the value of the column, and add it to the list
				list = new LibraryList();
				list.setTitle(rs.getString("Title"));
				list.setAuthor(rs.getString("Author"));
				libraryItems.add(list);
			}

			System.out.println(".............." + libraryItems.size());
			// See what's in Array...
			for (int i = 0; i < libraryItems.size(); i++) {
				System.out.println("LibraryData: " + libraryItems.get(i).getAuthor());
			}

			//RequestDispatcher rd = request.getRequestDispatcher("viewCategoryItem.html");
			request.setAttribute("LibraryItems", libraryItems);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/viewLibrary.jsp");
			
			rd.include(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
