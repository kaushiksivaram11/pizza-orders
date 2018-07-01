<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<sql:setDataSource var="snap" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="1"/>
<html>
<body>
	<c:set var="name" value="${param.fname}"/>
	<h3 style="text-align: center;font-size: 30px;"><u><c:out value="${param.fname}"/></u></h3>
	<br />
	<sql:query dataSource="${snap}" var="result">
	SELECT * from hotel where type = ?
	<sql:param value="${name}"/>
	</sql:query>
	<c:forEach var="row" items = "${result.rows}">
		<form>
			<table>
				<tr>
					<td>&nbsp&nbsp&nbsp</td>
					<td><c:out value="${row.items}"></c:out></td>
					<td><input type="hidden" name="name" value="${row.items}"></td>
					<td><input type="button" onclick="f2('${row.items} ${name}')" value = "+" style="position:absolute;left: 200px;background-color:white;color: black;"></td>
					<td><input type="button" onclick="f3('${row.items} ${name}')" value = "-" style="position:absolute;left: 250px;background-color:white;color: black;width: 25px;"></td>
				</tr>
			</table>
		</form>
		<br>
	</c:forEach>
</body>
</html>
<!--DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<p>hi</p>
</body>
</html-->