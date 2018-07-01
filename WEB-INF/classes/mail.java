import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import Bean.*;
import cart.*;
import Mail.*;
import DAO.*;

public class mail extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		HttpSession ob = request.getSession();


               
			loginBean l=(loginBean) ob.getAttribute("email");

			 cart c = (cart) ob.getAttribute("cart");
			 dao d = new dao();
			 int x=0;
			 String str;
			 str="item                        quantity                      cost\n";
			 for(Map.Entry m:c.cart_items.entrySet())
			 {
			 	int y=d.calcost((String)m.getKey());
			 	x=x+(int)m.getValue()*y;
			 str=str+(String)m.getKey()+"           "+m.getValue()+"                     "+(int)m.getValue()*y+"\n";
			}
				str=str+"Total Cost :                                         "+x+"\n";
            	SendMailSSL s = new SendMailSSL();
            	s.sendmail(l,str);
            }
        }