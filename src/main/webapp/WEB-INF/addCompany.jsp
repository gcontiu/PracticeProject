<%--
  Created by IntelliJ IDEA.
  User: anghel
  Date: 1/23/12
  Time: 2:23 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<title>Add Company</title>
<head>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
</head>


<body>

<form:form commandName="newCompany" method="POST" name="addCompany">
    <table>
        <tr><td><form:errors path="name" /></td><tr/>

        <tr><td><form:input path="name" /></td></tr>

        <tr><td><form:errors path="industry" /> </td><tr>

        <tr><td>
            <spring:bind path="newCompany.industry">
                <form:select path="industry">
                    <form:options items="${industries}" />
                </form:select>
            </spring:bind>
        </td></tr>

        <input type="submit" value="Add Company">
    </table>
</form:form>

<script type="text/javascript">

    function getCompanies() {
        $.ajax({

            url:'/list-companies.htm',
            type: "GET",

            success: function(data) {
                $("#companiesList").html(data)
            },

            error: function() {
                alert("nuuu, eroare la ajaaax!")
            }

        })
    }

</script>
<p/>
<a href="#" onclick="getCompanies()">List Companies</a>

<!-- Place to display companies after ajax request-->
<span id="companiesList"></span>

</body>
</html>