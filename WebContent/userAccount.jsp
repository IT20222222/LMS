<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="user" items="$(ruDetails)">
		${user.idru}
		${user.maxo}
		${user.maxw}
		${user.wash}
		${user.washdry}
		${user.washdrypress}
		${user.mending}
		${user.onedayservice}
		${user.pandd}
		${user.uname}
		${user.pword}
	</c:forEach>c:foreach>

</body>
</html>