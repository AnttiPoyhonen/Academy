<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Error details</title>
</head>
<body>

<h1>There was an error, details below:</h1>

<h2><%

    out.print("Error with an input, ");
    out.println(exception.getMessage());

%></h2>

</body>
</html>