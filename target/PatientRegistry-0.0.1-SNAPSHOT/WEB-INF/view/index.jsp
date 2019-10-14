<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login - PatientRegistry</title>
<link href="<s:url value="static/css/style.css" />" rel="stylesheet"
	type="text/css">

</head>
<body background="<s:url value='/static/images/abc.jpeg'/>">
	<table border="1">
		<tr>
			<td height="80px">
				<!-- including site uniform head --> <jsp:include
					page="include/header.jsp" />
		</td>
	</tr>
		<tr>
			<td height="25px"><jsp:include page="include/menu.jsp"></jsp:include>
		</td>
		<td>


	</tr>

		<tr>
			<td height="350px" valign="top">
				<h3>User Login</h3> 
		
				<f:form
					action="login" modelAttribute="command">
					<table border="1">
						<tr>
							<td>Username</td>
							<td><f:input path="loginName" /></td>
					</tr>
						<tr>
							<td>Password</td>
							<td><f:password path="password" /></td>
					</tr>
						<tr>
							<td colspan="2" align="right"><button>Login</button> <a
								href="!#">New User Registration</a></td>

					</tr>

					</table>
				</f:form>

		</td>
	</tr>
		<tr>
			<td height="25px"><jsp:include page="include/footer.jsp"></jsp:include>
		</td>
	</tr>
</table>


</body>
</html>