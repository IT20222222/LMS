<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegularUser Account</title>
</head>
<body>

	<table>
	<c:forEach var="ru" items="${ruDetails}">
	
	<c:set var="id" value="${ru.id}"/>
	<c:set var="mOrder" value="${ru.mOrder}"/>
	<c:set var="mWeight" value="${ru.mWeight}"/>
	<c:set var="w" value="${ru.w}"/>
	<c:set var="wd" value="${ru.wd}"/>
	<c:set var="wdp" value="${ru.wdp}"/>
	<c:set var="m" value="${ru.m}"/>
	<c:set var="ods" value="${ru.ods}"/>
	<c:set var="pad" value="${ru.pad}"/>
	<c:set var="uname" value="${ru.uname}"/>
	<c:set var="pword" value="${ru.pword}"/>
	
	<tr>
		<td>User ID</td>
		<td>${ru.id}</td>
		
	</tr>
	<tr>
		<td>Maximum Orders</td>
		<td>${ru.mOrder}</td>
		
	</tr>
	<tr>
		<td>Maximum Weight</td>	
		<td>${ru.mWeight}</td>
		
	</tr>
	<tr>
		<td>Washing</td>	
		<td>${ru.w}</td>
		
	</tr>
	<tr>
		<td>Washing + Drying</td>
		<td>${ru.wd}</td>
		
	</tr>
	<tr>	
		<td>Washing + Drying + Pessing</td>
		<td>${ru.wdp}</td>
		
	</tr>
	<tr>
		<td>Mending</td>	
		<td>${ru.m}</td>
		
	</tr>
	<tr>	
		<td>Oneday Service</td>
		<td>${ru.ods}</td>
		
	</tr>
	<tr>
		<td>Pick and Delivery</td>	
		<td>${ru.pad}</td>
		
	</tr>
	<tr>
		<td>Username</td>
		<td>${ru.uname}</td>
	</tr>
	<tr>	
		<td>Password</td>
		<td>${ru.pword}</td>
		
	</tr>	
		
	</c:forEach>
	</table>
	
	<c:url value = "UpdateRegUser.jsp" var = "reguserupdate">
		<c:param name = "id" value = "${id}"/>
		<c:param name = "mOrder" value = "${mOrder}"/>
		<c:param name = "mWeight" value = "${mWeight}"/>
		<c:param name = "w" value = "${w}"/>
		<c:param name = "wd" value = "${wd}"/>
		<c:param name = "wdp" value = "${wdp}"/>
		<c:param name = "m" value = "${m}"/>
		<c:param name = "ods" value = "${ods}"/>
		<c:param name = "pad" value = "${pad}"/>
		<c:param name = "uname" value = "${uname}"/>
		<c:param name = "pword" value = "${pword}"/>
	</c:url>
	
	<a href = "${reguserupdate}">
	<input type = "button" name = "update" value = "Update">
	</a>
	
	<br>
	<c:url value = "DeleteRegUser.jsp" var = "reguserdelete">
		<c:param name = "id" value = "${id}"/>
		<c:param name = "mOrder" value = "${mOrder}"/>
		<c:param name = "mWeight" value = "${mWeight}"/>
		<c:param name = "w" value = "${w}"/>
		<c:param name = "wd" value = "${wd}"/>
		<c:param name = "wdp" value = "${wdp}"/>
		<c:param name = "m" value = "${m}"/>
		<c:param name = "ods" value = "${ods}"/>
		<c:param name = "pad" value = "${pad}"/>
		<c:param name = "uname" value = "${uname}"/>
		<c:param name = "pword" value = "${pword}"/>
	</c:url>
	<a href = "${reguserdelete}">
	<input type ="button" name="delete" value="delete account">
	</a>
	
	
	
	
	
	
	
	
	
	
</body>
</html>