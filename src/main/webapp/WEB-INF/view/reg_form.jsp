<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login - PatientRegistry</title>
<%-- <link href="<s:url value="static/css/style.css" />" rel="stylesheet"
	type="text/css"> --%>

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
				<h3>User Registration</h3> 
				<c:if test="${err!=null}">
				<p class="error">
				${err}
				</p>
				</c:if>
			<s:url var="url_reg" value="/register"/>
				<f:form
					action="${url_reg}" modelAttribute="command">
					<table border="1">
					<tr>
						<td>Name</td>
						<td><f:input path="user.name"/></td>
					</tr>
										<tr>
						<td>Phone</td>
						<td><f:input path="user.phone"/></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><f:input path="user.email"/></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><f:textarea path="user.address"/></td>
					</tr>
					
						<tr>
							<td>Username</td>
							<td><f:input path="user.loginName" /></td>
					</tr>
						<tr>
							<td>Password</td>
							<td><f:password path="user.password" /></td>
					</tr>
						<tr>
							<td colspan="2" align="right"><button>Submit</button></td>

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