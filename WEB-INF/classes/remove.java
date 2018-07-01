import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class remove extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            	System.out.println("HAI");
            	HttpSession session = request.getSession(false);
		if (session != null) {
    session.invalidate();
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }