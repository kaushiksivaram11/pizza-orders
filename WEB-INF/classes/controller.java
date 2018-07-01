import cart.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Map;
import java.util.Map.Entry;
import Bean.*;
import java.util.Set;
import DAO.*;

public class controller extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            	response.setContentType("text/html");
            	PrintWriter out = response.getWriter();
            	 HttpSession ob = request.getSession();


               
	loginBean l=(loginBean) ob.getAttribute("email");
	if(l==null)
	System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLL");
	else
	System.out.println(l.getUserName());
	ob.setAttribute("email",l);


            	 cart c = (cart) ob.getAttribute("cart");
            	 if(c==null)
            	 {
            	 	c=new cart();
            	 	ob.setAttribute("cart",c);
            	 }
            	 dao d = new dao();
            	 String name=request.getParameter("fname");
            	 d.insert(c,name);
            	 ob.setAttribute("cart",c);
            	 int x=0;
                out.println("<html><head><style>th{padding:10px;font-weight:bold;font-size:20px;}td{padding:10px;font-weight:bold;font-size:15px;}a{text-decoration:none;color:white;}a:hover{text-decoration:none;color:white;}</style></head>");
                  out.println("<body><table style='border:solid 2px black'>");
                     out.println("<tr style='border:solid 2px black'><th>Name</th><th>Quantity</th><th>Cost</th><tr>");
            	 		for(Map.Entry m:c.cart_items.entrySet())
                     { 
                     out.println("<tr style='border:solid 2px black'>");

                     int y=d.calcost((String)m.getKey());
                     
   						out.println("<td>"+(String)m.getKey()+"<td>"+m.getValue()+"<td>"+(int)m.getValue()*y);  
   						x=x+(int)m.getValue()*y;
   						out.println("</tr>");
   						}
                     


   			out.println("<tr style='border:solid 2px black'><td colspan='2'>Total Bill Amount : </td><td> Rs."+x+"</td></tr>");
            out.println("</table><a href='final1.html'><button style='border:none;border-radius:15px;background-color:orange;font-size:20px;font-weight:bold;position:relative;left:140px;'>Place Order</button></a></body></html>");
   			}

        }