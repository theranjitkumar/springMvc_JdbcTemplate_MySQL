<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> student list </title>
</head>
<body>

	<h3> Student List </h3> <a href="./addNewStudent">Add New Student</a>

	 <ul>
		<c:forEach var="listValue" items="${studentList}">
			<li>
			   ${listValue.id}-${listValue.name}-${listValue.city}
			---<a href="./updateStudent">update</a>
			---<a href="./deleteStudent?id=${listValue.id}">delete</a>
			 
			</li>
		</c:forEach>
	</ul> 

<%--     <div align="center">
        <h1>Add student form</h1>
         <form:form action="addStudent"  method="post" modelAttribute="student">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>city:</td>
                <td><form:input path="city" /></td>
            </tr>
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div> --%>


</body>
</html>