<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>
<body>
<form:form action="displayUserInfo" modelAttribute="user">
Name: <form:input path="name"/><br><br>
Age: <form:input path="age"/><br><br>
Favorite Movies: <br>
<form:checkbox path="movies" name="like" value="Avengers"/>Avengers<br>
<form:checkbox path="movies" name="like" value="Black Panther"/>Black Panther<br>
<form:checkbox path="movies" name="like" value="Captain Marvel"/>Captain Marvel<br>
<form:checkbox path="movies" name="like" value="war"/>war<br>
          <br>
<input type="submit" value="submit">
</form:form>


</body>
</html>