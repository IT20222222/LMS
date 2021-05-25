<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Regular User</title>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String mOrder = request.getParameter("mOrder");
		String mWeight = request.getParameter("mWeight");
		String w = request.getParameter("w");
		String wd = request.getParameter("wd");
		String wdp = request.getParameter("wdp");
		String m = request.getParameter("m");
		String ods = request.getParameter("ods");
		String pad = request.getParameter("pad");
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
	%>
	
	
	<h1>Delete Regular user Account</h1>

	<form action ="delete" method ="post">
		<table>
		<tr>
		<td>User ID</td>
		<td><input type = "text" name = "id" value = "<%= id%>" readonly></td>
		</tr>
		<tr>
		<td>Maximum Order</td>
		<td><input type = "text" name = "mOrder" value ="<%= mOrder%>" readonly></td>
		</tr>
		<tr>
		<td>Maximum Weight</td>
		<td><input type = "text" name = "mWeight" value ="<%= mWeight%>" readonly></td>
		</tr>
		<tr>
		<td>Washing</td>
		<td><input type = "text" name = "w" value ="<%= w%>" readonly></td>
		</tr>
		<tr>
		<td>Wshing + Drying</td>
		<td><input type = "text" name = "wd" value ="<%= wd%>" readonly></td>
		</tr>
		<tr>
		<td>Washing + Drying + Pressing</td>
		<td><input type = "text" name = "wdp" value ="<%= wdp%>" readonly></td>
		</tr>
		<tr>
		<td>Mending</td>
		<td><input type = "text" name = "m" value ="<%= m%>" readonly></td>
		</tr>
		<tr>
		<td>Oneday Service</td>
		<td><input type = "text" name = "ods" value ="<%= ods%>" readonly></td>
		</tr>
		<tr>
		<td>Pickup and Delivery</td>
		<td><input type = "text" name = "pad" value ="<%=pad%>" readonly></td>
		</tr>
		<tr>
		<td>Username</td>
		<td><input type = "text" name = "uname" value ="<%= uname%>" readonly></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type = "password" name = "pword" value ="<%= pword%>" readonly></td>
		</tr>
		</table>
		<br>
		<input type="submit" name ="submit" value="Delete Account"><br>
		 
	</form>

</body>
</html>