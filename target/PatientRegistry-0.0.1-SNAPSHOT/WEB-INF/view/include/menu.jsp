<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${sessionScope.userId == null}">
<a href="#">Home</a> | <a href="#">Login</a> | <a href="#">Register</a> | <a href="#">About</a> | <a href="#">Help</a> 
</c:if>

<c:if test="${sessionScope.userId! = null && sessionScope.role ==1}">
<%--Admin Logged in --%>
<a href="#">Home</a> | <a href="#">User List</a> | <a href="#">Logout</a> | <a href="#">About</a> | <a href="#">Help</a> 
</c:if>

<c:if test="${sessionScope.userId! = null && sessionScope.role ==2}">
<%--general user Logged in --%>
<a href="#">Home</a> | <a href="#">Add contact</a> | <a href="#">contact list</a> | <a href="#">Logout</a> 
</c:if>