<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Henkilön tiedot</title>
    <style>
        td {width: 30px}
    </style>
</head>

<body>

<form action="HenkiloServlet" method="post" style="min-width: 140px; width: 20%">
    <fieldset>

        <legend>Henkilön tiedot, EL JSTL / JSP Servlet</legend>

        <table>

            <tr>
                <td>Etunimi</td>
                <td>${henkilo.etunimi}</td>
            </tr>

            <tr>
                <td>Sukunimi</td>
                <td>${henkilo.sukunimi}</td>
            </tr>

            <tr>
                <td>Ikä</td>
                <td>${henkilo.ika}</td>
            </tr>

            <tr><td><p></p></td></tr>

            <tr>
                <td><label for="enimi">Etunimi: </label></td>
                <td><input type="text" name="enimi" id="enimi" value="${henkilo.etunimi}"></td>
            </tr>

            <tr>
                <td><label for="snimi">Sukunimi: </label></td>
                <td><input type="text" name="snimi" id="snimi" value="${henkilo.sukunimi}"></td>
            </tr>

            <tr>
                <td><label for="ika">Ikä: </label></td>
                <td><input type="text" name="ika" id="ika" value="${henkilo.ika}"></td>
            </tr>
            <tr><td><input type="submit" value="Tallenna"></td></tr>

        </table>
    </fieldset>
</form>

<p><a href="index.jsp">Back to the form as JSP w/ Bean</a></p>

</body>

</html>