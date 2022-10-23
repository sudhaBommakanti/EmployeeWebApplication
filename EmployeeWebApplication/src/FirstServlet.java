import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
					  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String fn =request.getParameter("firstName");  
		    String ln =request.getParameter("lastName");  
		    
		    System.out.println("firstName: " + fn + " lastName: " + ln);
		          
		    if(LoginDAO.validate(fn, ln)){  
		        response.sendRedirect( "home.html");
            }  
		    else{  
		    	RequestDispatcher rd=request.getRequestDispatcher("employeeRegister.html");  
		        out.print("Sorry firstname or lastname has error or the employee is not registered");  
		        rd.include(request,response);  
		    }  
		          
		    out.close();  
		}  
		  
	

}
