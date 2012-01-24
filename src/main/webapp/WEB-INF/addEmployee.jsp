<%--
  Created by IntelliJ IDEA.
  User: anghel
  Date: 1/23/12
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <form:form commandName="employee" method="POST">

        <form:errors path="name" /><br/>
        Name: <form:input path="name" /><br/>

        <form:errors path="company" /><br/>
        <spring:bind path="employee.company">
            Company: <form:select path="company">
                <form:options items="${companies}" itemLabel="name" itemValue="id"/>
            </form:select>
        </spring:bind>

        <input type="submit" value="Add Employee" />
    </form:form>

</body>
</html>
