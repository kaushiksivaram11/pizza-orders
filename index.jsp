<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
	
	<title></title>
	</head>
	<body bgcolor="pink" style="background-image: url('pizza2.jpg');z-index:-1;">
	
		<center>
		<h1 style="font-size: 70px;color:blue;"><c:out value = "${'PIZZA CORNER ' }"/></h1><br>
		<img src="logo.jpg" style="float:left;position: relative;margin-top:-120px;">
		<br>
		<br>
		<br>
		<div style="font-size: 50px;color:yellow;">
		<c:out value = "${'LOGIN' }"/></div>
		
		<form action = "login" method="POST">
		<label style="font-size: 50px;color:blue;">Username: <input type = "text" name = "uname"> </label>
		<br />
		<label style="font-size: 50px;color:blue;">Password: <input type = "password" name = "pwd"> </label>
		<br / >
		</center>
		<br />
		<center><input type = "submit" value = "submit" style="font-size: 50px;color:blue;background-color: orange;"></center>
		</form>
		
	</body>
</html>