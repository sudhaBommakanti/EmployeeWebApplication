package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterEmployeeDAO;

/**
 * Servlet implementation class RegisterEmployeeServlet
 */
@WebServlet("/RegisterEmployeeServlet")
public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterEmployeeServlet() {
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
	    
	    boolean isCeo = false;
	    boolean isMan = false;
	    
	          
	    String fn = request.getParameter("firstName");  
	    String ln = request.getParameter("lastName");  
	    
	    String salary = request.getParameter("salary");
	    
	    String isCEO = request.getParameter("isCEO");
	    String isManager = request.getParameter("isManager");
	    String managerId = request.getParameter("managerId");
	    
	    System.out.println("Table : " + "firstName: " + fn + " lastName: " + ln + " salary: " + salary + " ISCEO: " +  isCEO+ " isManager: " + isManager + " manager id: " +  managerId + "-- data");
	    
	     
	    if(RegisterEmployeeDAO.validate(fn, ln, salary, isCEO, isManager, managerId)){  
	        response.sendRedirect( "home.html");
            System.out.println(" selected action is  "+ fn + ln + salary + isCEO + isManager + managerId);
	    }  
	    else{  
	    	//RequestDispatcher rd=request.getRequestDispatcher("employeeRegister.html");  
	        out.print("Cannot register");  
	        //rd.include(request,response);  
	    }  
	          
	    out.close();  
	}  
}


