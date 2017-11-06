<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="Laskinvirhe.jsp" %>

<html>

<head>
  <title>Calculator form as JSP</title>
</head>

<body>

<h2>Calculator in a form, as a JSP</h2>

<form method="post">
  <fieldset>

    <legend>Calc</legend>

    <label for="first">First nr: </label>
    <br>
    <input type="text" id="first" name="first" placeholder="input a number" autofocus>
    <br>

    <label for="second">Second nr: </label>
    <br>
    <input type="text" id="second" name="second" placeholder="input a number">
    <br><br>

    <label for="type">Type of calculation ( + , - , * , div ): </label>
    <br>
    <input type="text" id="type" name="type" placeholder="input type of calculation">
    <br><br>

    <input type="submit" value="Laske">
    <br>

    <p>Tulos: <%@ include file="Laskintulos.jsp" %></p>

  </fieldset>
</form>

</body>

</html>