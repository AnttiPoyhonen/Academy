<%--
  JSP comments
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Calculator form w/ Servlet</title>
</head>

<body>

    <h2>Calculator in a form, using a servlet</h2>

    <form action="LaskinServlet" method="post">
        <fieldset>

            <legend>Calc</legend>

            <label for="first">First nr: </label>
            <input type="text" id="first" name="first" placeholder="input a number">

            <label for="second">First nr: </label>
            <input type="text" id="second" name="second" placeholder="input a number">

            <input type="submit" value="Laske">

        </fieldset>
    </form>

</body>

</html>
