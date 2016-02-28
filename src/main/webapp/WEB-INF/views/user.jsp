<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>User Page</title>
</head>
<body>
	<h1>Add a User</h1>
	<form:form action="user/add" commandName="user">
		<table>
			<c:if test="${!empty user.userName}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8" disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="userName">
						<spring:message text="User Name" />
					</form:label></td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty user.userName}">
						<input type="submit" value="<spring:message text="Edit User"/>" />
					</c:if> <c:if test="${empty user.userName}">
						<input type="submit" value="<spring:message text="Add User"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Users List</h3>
	<table>
		<tr>
			<th width="80">User ID</th>
			<th width="120">User Name</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<%-- <c:if test="${!empty findUsers}"> --%>
		<c:forEach items="${findUsers}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.userName}</td>
				<td><a href="<c:url value='/edit/${user.id}' />">Edit</a></td>
				<td><a href="<c:url value='/remove/${user.id}' />">Delete</a></td>
			</tr>
		</c:forEach>
		<%-- </c:if> --%>
	</table>
</body>
</html>
