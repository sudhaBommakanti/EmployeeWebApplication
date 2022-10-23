

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
							  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		    
		    String  catName =request.getParameter("categoryName");  
		          
		    if(CreateCategoryDAO.validate(catName)){  
		        response.sendRedirect( "home.html");
                System.out.println("Data created successfully  "+ catName);
		    }  
		    else{  
		        out.print("There is an error in creating data");  
		        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
		        rd.include(request,response);  
		    }  
		          
		    out.close();  
		}  
	}


