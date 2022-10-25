
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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

/**
 * Servlet implementation class CreateLibraryServlet
 */
@WebServlet("/CreateLibraryServlet")
public class CreateLibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SELECT_CATEGORY_NAMESQUERY = "SELECT CategoryName FROM CATEGORY";
	static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Library;integratedSecurity=true;TrustServerCertificate=true;";
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String userName = "";
	private static String password = "";

	private static List<String> categoryList = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateLibraryServlet() {
		super();
		// TODO Auto-generated constructor stub
		List<String> categoryList = new ArrayList<>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter pw = null;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// set content type
			response.setContentType("text/html");
			// get Writer
			pw = response.getWriter();

			Class.forName(driver);
			con = DriverManager.getConnection(URL, userName, password);

			ps = con.prepareStatement(SELECT_CATEGORY_NAMESQUERY);

			rs = ps.executeQuery();
			// pw.println("<h1>View Category Details </h1>");
			// final List<String> categoryList = new ArrayList<>();
			while (rs.next()) {
				// Just get the value of the column, and add it to the list
				categoryList.add(rs.getString("CategoryName"));
				// pw.println("<h2> Category </h2>" + "Names: " + rs.getString("CategoryName") +
				// "<br>");
			}

			// RequestDispatcher rd = request.getRequestDispatcher("viewCategoryItem.html");
			request.setAttribute("categorynames", categoryList);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/viewCategory.jsp");

			rd.include(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String pages = request.getParameter("pages");

		String runTimeMinutes = request.getParameter("runTimeMinutes");

		String isBorrowable = request.getParameter("isBorrowable");

		String borrower = request.getParameter("borrower");

		String borrowDate = request.getParameter("borrowDate");

		String catName = request.getParameter("catName");

		String type = request.getParameter("types");

		try {
			if (CreateLibraryDAO.validate(title, author, pages, runTimeMinutes, isBorrowable, borrower, borrowDate,
					catName, type)) {

				String resData = " Library Item with " + " ' " + title + " ' " + " by" + " ' " + author + " ' "
						+ " created successfully on database";
				request.setAttribute("result", resData);

				System.out.println("request: " + request.getAttribute("result"));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/createLibrary.jsp");
				rd.include(request, response);
			} else {
				out.print("There is an error in creating data");
				RequestDispatcher rd = request.getRequestDispatcher("home.html");
				rd.include(request, response);
			}
		}

		catch (Exception e) {
			throw new ServletException(e);
		}
		out.close();
	}

}
