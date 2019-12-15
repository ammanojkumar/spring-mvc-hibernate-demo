<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management Screen</title>
</head>
<body>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>


		<div align="center">
			<c:choose>
				<c:when test="${not empty errormessage}">
			Error while loading the page
		</c:when>
				<c:otherwise>
					<h1>Student List</h1>
					<table border="1">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Address</th>
							<th>Grade</th>
							<th>Action</th>
						</tr>

						<c:forEach var="student" items="${studentList}">
							<tr>
								<td>${student.stuId}</td>
								<td>${student.name}</td>
								<td>${student.email}</td>
								<td>${student.address}</td>
								<td>${student.grade}</td>
								<td><a href="edit?stuId=${student.stuId}">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete?stuId=${student.stuId}">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
					<h4>
						New Student Register <a href="add">here</a>
					</h4>
				</c:otherwise>
			</c:choose>
		</div>
	</c:if>
</body>
</html>