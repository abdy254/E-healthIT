<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>


<s:url var="url_logout" value="/logout"/>
<s:url var="url_login" value="/index"/>


<c:if test="${sessionScope.userId == null}">
<%-- User is not yet logged in : Guest Menu --%>
<s:url var="url_reg_form" value="/reg_form"/>

<a href="#">Home</a> | <a href="${url_login}">Login</a> | <a href="${url_reg_form}">Register1</a> | <a href="#">About</a> | <a href="${url_logout}">logout</a> 
</c:if>

<c:if test="${sessionScope.userId != null && sessionScope.role ==1}">
<!-- Admin Is Logged in -->
<s:url var="url_reg_form" value="/reg_form"/>

<a href="#">Home</a> | <a href="#">User List</a> | <a href="${url_logout}">Logout</a> | <a href="#">About</a> | <a href="${url_reg_form}">Register2</a> | <a href="#">Help</a> 
</c:if>

<c:if test="${sessionScope.userId != null && sessionScope.role ==2}">
<%--general user is Logged in --%>
<s:url var="url_reg_form" value="/reg_form"/>
<s:url var="url_user_home" value="/user/dashboard"/>
<s:url var="url_contact_form" value="/user/contact_form"/>



<a href="#">Home</a> | <a href="${url_contact_form}">Add contact</a> | <a href="#">contact list</a> | <a href="${url_reg_form}">Register3</a> |<a href="${url_logout}">Logout</a> 
</c:if>