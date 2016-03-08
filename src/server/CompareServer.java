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

    /**
     * Default constructor. 
     */
    public CompareServer() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoalsTemperatureComparison gt = new GoalsTemperatureComparison();
		
		response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	Boolean pretty = Boolean.valueOf(request.getParameter("pretty"));
            JsonFormatter format = new JsonFormatter();
            
            if(pretty == true) {
            	out.println(format.format(gt.getData())); // 1. skillnad mellan 1 och 2?
            } else
        		response.getWriter().append(gt.getData()); // 2.            	
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
