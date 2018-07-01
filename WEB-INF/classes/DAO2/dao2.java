package DAO2;

import cart.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.Set;



public class dao2
{
	public void insert(cart c,String name)
	{
		c.delete(name);
	}

	public int lspace(String x)
	{
		int y=x.length();
		for(int i=y-1;y>=0;--i)
			if(Character.isWhitespace(x.charAt(i)))
				return i;
			return 0;
	}

	public int calcost(String abc)
	{
try
{

 final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
               final String DB_URL="jdbc:mysql://localhost:3306/TEST";
               //  Database credentials
               final String USER = "root";
               final String PASS = "1";
               Connection  conn = null;
               Statement stmt = null;


               Class.forName("com.mysql.jdbc.Driver");
               // Open a connection
               conn = DriverManager.getConnection(DB_URL,USER,PASS);
               // Execute SQL query
               stmt = conn.createStatement();
               String sql;



					int l=lspace(abc);

                     String s1=abc.substring(l+1);
                     String s2=abc.substring(0,l);



                     sql="select cost from hotel where type='"+s1+"' and items = '"+s2+"'";
                     
                     System.out.println(sql);
                     ResultSet rs = stmt.executeQuery(sql);
                     if(rs.next())
                     {
                     return (rs.getInt(1));
                 	}
                 	else
                 		return 99;
                 }
                 catch(Exception se)
                 {
                 	se.printStackTrace();
                 }
                 return 0;
	}

}
