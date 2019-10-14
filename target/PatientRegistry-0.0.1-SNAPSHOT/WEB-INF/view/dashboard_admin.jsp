<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard - PatientRegistry</title>
<link href="<s:url value="static/css/style.css" />" rel="stylesheet" type="text/css">

</head>
<body background="<s:url value='/static/images/abc.jpeg'/>">
<table border="1" width="80%" align="center">
	<tr>
		<td height="80px">
		<!-- including site uniform head -->
		<jsp:include page="include/header.jsp"/>
		</td>
	</tr>
	<tr>
		<td height="25px">
		<jsp:include page="include/menu.jsp"></jsp:include>
		</td>
	</tr>
	
	<tr>
		<td height="350px" valign="top">
		<h1>Admin Dashboard</h1>
		TODO - html form
		</td>
	</tr>
		<tr>
		<td height="25px">
		<jsp:include page="include/footer.jsp"></jsp:include>
		</td>
	</tr>
</table>


</body>
</html>