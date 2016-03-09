package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import compare.GoalsTemperatureComparison;

/**
 * Servlet implementation class CompareServer
 */
@WebServlet("/CompareServer")
public class CompareServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public GoalsTemperatureComparison gt;
	
    /**
     * Default constructor. 
     */
	public CompareServer() {
    	gt = new GoalsTemperatureComparison();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("application/json;charset=UTF-8");
        	Boolean pretty = Boolean.valueOf(request.getParameter("pretty"));
            JsonFormatter format = new JsonFormatter();

            response.getWriter().append((pretty ? format.format(gt.getData()) : gt.getData()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
