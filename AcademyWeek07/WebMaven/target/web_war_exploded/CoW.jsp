<%--
Author: Antti Pöyhönen
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>

<head>
    <title>Countries of the World</title>
</head>

<body>

    <p>Back to the <a href='index.jsp'>index</a></p>

    <h1>Countries of the World:</h1>

    <p>

        <sql:query dataSource = "world" var = "result">
            <%--select code, name, population, headofstate from country order by population desc;--%>
        select * from country;
        </sql:query>

        <table border = "1" width = "100%">
            <tr>
                <th>Country Code</th>
                <th>Country Name</th>
                <th>Country Population</th>
                <th>Country Head of State</th>
            </tr>

            <c:forEach var = "row" items = "${result.rows}">

                <tr>
                    <td>${row.code}</td>
                    <td>${row.name}</td>
                    <td>${row.population}</td>
                    <td>${row.headofstate}</td>
                </tr>

            </c:forEach>

        </table>

    </p>

</body>

</html>
