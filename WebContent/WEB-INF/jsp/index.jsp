<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	welcome index :- ${userdetails.email}
	
	<br><br><br><br>
	
	<form:form method="POST" action="/brp/signup" modelAttribute="userdetails" id="form1" >
		<div>
				<form:label for="email" path="email" >email :</form:label>
				<form:input type="text" path="email" value="" name="email" id="email" />
				
				<form:label for="password" path="password" >password :</form:label>
				<form:input type="password" path="password" value="" name="password" id="password" />
				
				<input type="submit" id="submit" value="Sign " />
		</div>
	</form:form>
</body>
</html>