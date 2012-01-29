<%--
  Created by IntelliJ IDEA.
  User: anghel
  Date: 1/23/12
  Time: 2:23 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<title>Add Company</title>
<head>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
</head>


<body>

<form:form commandName="newCompany" method="POST" name="addCompany">
    <form:errors path="name" /><br/>
    <form:input path="name" />
    <input type="submit" value="Add Company">
</form:form>

<script type="text/javascript">

    function getCompanies() {
        $.ajax({

            url:'/list-companies.htm',
            type: "GET",

            success: function(data) {
                alert(data);
                $("#companiesList").html(data)
            },

            error: function() {
                alert("nuuu")
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