<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome ${userBean.email}</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/1.7.2.jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.7.custom.min.js"></script>
</head>
<body>

				
		<div>
		
	Welcome ${userBean.email}

	<form:form action="logout" commandName="userBean" >
		
				
				<input type="submit" id="logout" value="Logout " />
		
	</form:form>	
	</div>
	
	
	
	<div id="viewProfileDiv">

		<table border="1">
			<tr>
				<td colspan="2">My Profile
				</td>
			</tr>
			<tr>
				<td><form:form action="updateUser" commandName="userBean"  enctype="multipart/form-data" >
						<table>
							<tr>
								<td><form:label for="email" path="email">Email :</form:label></td>
								<td><form:input type="text" path="email" /></td>
							</tr>
							<tr>
								<td><form:label for="password" path="password">Password :</form:label></td>
								<td><form:input type="password" path="password" /></td>
							</tr>
							
							
							<tr>
							<td>
								<form:input type="hidden" path="profilePic" id="profilePic"/>
                     		 	<form:input type="hidden" path="id" />
                     	        <img id="browse" src="${userBean.profilePic}" 
		                      width="80" height="80" alt="User Image" title="Select Avatar" onclick="$('#fileField').click();"/>
		                      <input type="file" name="fileField" id="fileField"  accept="image/*" />
		                    </td>
                     	 	</tr>
                     	 
                     	 	<tr>
								<td><input type="submit" id="register" value="Update Profile" /></td>
							</tr>
						</table>
					</form:form>
				</td>
				
			</tr>
		</table>

	</div>
</body>

</html>