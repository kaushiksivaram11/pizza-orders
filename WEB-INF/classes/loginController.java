
import Bean.*;
import Bean.DAO.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class loginController extends HttpServlet
{
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
  {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String uname=request.getParameter("uname");
      String upasswd=request.getParameter("pwd");
      loginBean l=new loginBean();      
      l.setUserName(uname);
      l.setPassword(upasswd);
      int flag=0;
      loginDao ld=new loginDao();
      flag=ld.userAuthentication(l);    
      if(flag==1)
      {
         HttpSession ob = request.getSession();
         ob.setAttribute("email",l);
         if(l==null)
          System.out.println("HAI@#$$");
         loginBean l2=(loginBean) ob.getAttribute("email");
         if(l2==null)
          System.out.println("HAI@");
        else
          System.out.println(l2.getUserName());
             request.getRequestDispatcher("index3.html").forward(request, response);
           }
      else if(flag==2)
             request.getRequestDispatcher("failure.jsp").forward(request, response);    
	else
	 request.getRequestDispatcher("failure2.jsp").forward(request, response);
   }
} 
