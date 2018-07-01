
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<sql:setDataSource var="snap" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="1"/>
<html>
<c:set var="name" value="${param.fname}"/>
<sql:query dataSource="${snap}" var="result">
SELECT * from hotel where type = ?
<sql:param value="${name}"/>
</sql:query>

<c:forEach var="row" items = "${result.rows}">
<form>
<c:out value="${row.items}">
</c:out>


	<input type="hidden" name="name" value="${row.items}">
	<input type="button" onclick="f2('${row.items} ${name}')" value = "+">

</form>
<br>
</c:forEach>
</html>
