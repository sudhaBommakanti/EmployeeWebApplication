package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CreateCategoryDAO;

/**
 * Servlet implementation class CreateCategoryServlet
 */
@WebServlet("/CreateCategoryServlet")
public class CreateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String catName = request.getParameter("categoryName");

		try {
			if (CreateCategoryDAO.validate(catName)) {

				String resData = " Category " + " ' " + catName + " ' " + " created successfully on database";
				request.setAttribute("result", resData);
				System.out.println("request: " + request.getAttribute("result"));
				// out.print("Data created successfully "+ catName);
				// response.sendRedirect("/WEB-INF/viewCategory.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/createCategory.jsp");
				rd.include(request, response);
				// response.sendRedirect( "home.html");

			} else {
				String resData = "There is an error in creating data";
				// String check = e.getMessage();
				response.sendRedirect("createCategoryItem.html?param1=" + resData);
				System.out.println("check value: " + resData);
				// RequestDispatcher rd = request.getRequestDispatcher("home.html");
				// rd.include(request, response);
			}
		} catch (Exception e) {
			String excepData = "Category name " + " ' " + catName + " ' " + " already exists";
			// String check = e.getMessage();
			response.sendRedirect("createCategoryItem.html?param1=" + excepData);
			System.out.println("check value: " + excepData);
			// response.sendRedirect(e.getMessage());
			// throw new ServletException(e);

		}

		out.close();
	}
}
