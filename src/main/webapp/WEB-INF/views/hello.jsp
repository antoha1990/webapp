<%@ page language="java" contentType="text/html; charset=utf8"
		 pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World - JSP tutorial</title>
</head>
<body>
	<%= "Hello World!" %>
</body>

<h3><spring:message code="label.contacts" /></h3>
<c:if test="${!empty contactList2}">
<table class="data">
	<tr>
		<th><spring:message code="label.firstname" /></th>
		<th><spring:message code="label.email" /></th>
		<th><spring:message code="label.telephone" /></th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach items="${contactList2}" var="contact">
		<tr>
			<td>${contact.lastname}, ${contact.firstname}</td>
			<td>${contact.email}</td>
			<td>${contact.telephone}</td>
			<td><a href="delete/${contact.id}"><spring:message code="label.delete" /></a></td>
		</tr>
	</c:forEach>
</table>
</c:if>



<form:form method="post" action="addhi" commandName="contact" >

	<table>
		<tr>
			<td><form:label path="firstname">
				<spring:message code="label.firstname" />
			</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
			<td><form:label path="lastname">
				<spring:message code="label.lastname" />
			</form:label></td>
			<td><form:input path="lastname" /></td>
		</tr>
		<tr>
			<td><form:label path="email">
				<spring:message code="label.email" />
			</form:label></td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><form:label path="telephone">
				<spring:message code="label.telephone" />
			</form:label></td>
			<td><form:input path="telephone" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
								   value="<spring:message code="label.addcontact"/>" /></td>
		</tr>
	</table>
</form:form>


</html>