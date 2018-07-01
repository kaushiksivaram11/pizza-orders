<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<html>

<sql:setDataSource var="snap" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="1"/>

<c:set var="name" value="${param.q}"/>
<sql:query dataSource="${snap}" var="result">
SELECT * from verify where uname=?;
<sql:param value="${name}"/>
</sql:query>

<c:out value = "${name}"/>
exists !!! <br/>
</html>