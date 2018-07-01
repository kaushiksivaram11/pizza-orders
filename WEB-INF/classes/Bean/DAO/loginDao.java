/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.DAO;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import Bean.loginBean;

public class loginDao 
{
    public int userAuthentication(loginBean l)
    {
       // JDBC driver name and database URL
       final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
       final String DB_URL="jdbc:mysql://localhost:3306/TEST";
       //  Database credentials
       final String USER = "root";
       final String PASS = "1";
       Connection  conn = null;
       Statement stmt = null;
       String uname = l.getUserName();
       String upasswd = l.getPassword();
       try{
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");
         // Open a connection
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         // Execute SQL query
          stmt = conn.createStatement();
         String sql;
         sql = "SELECT * FROM verify where uname= '"+uname+"' and password = '"+upasswd+"'";
         ResultSet rs = stmt.executeQuery(sql);
         // Extract data from result set
         if(rs.next())
         {
              return 1;         
        }
	else
	{
		sql = "SELECT * FROM verify where uname= '"+uname+"'";
		rs = stmt.executeQuery(sql);
		if(rs.next())
         {
              return 2;         
        }
	}
       }
       catch(SQLException se)
       {
         //Handle errors for JDBC
          se.printStackTrace();
       }
       catch(Exception e)
       {
         //Handle errors for Class.forName
         e.printStackTrace();
       }         
       return 3;
    }
}


