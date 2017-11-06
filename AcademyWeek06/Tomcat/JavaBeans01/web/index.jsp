<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="henkilo" class="fi.academy.beans.Henkilo" scope="session">
</jsp:useBean>

<%
    String enimi = request.getParameter("enimi");
    if (enimi == null
            &&
            (henkilo.getEtunimi() == null || henkilo.getEtunimi().isEmpty())
            ) {
        henkilo.setEtunimi("Etunimi");
        henkilo.setSukunimi("Sukunimi");
        henkilo.setIka(0);
    } else if (enimi != null) {
        String snimi = request.getParameter("snimi");
        int ika = Integer.valueOf(request.getParameter("ika"));
        henkilo.asetaKaikki(enimi, snimi, ika);
    }
%>

<html>

<head>
    <title>Henkilön tiedot</title>
    <style>
        td {width: 30px}
    </style>
</head>

<body>

<form method="post" style="min-width: 140px; width: 20%">
    <fieldset>

        <legend>Henkilön tiedot, Java Bean / JSP</legend>

        <table>

            <tr>
                <td><label for="enimi">Etunimi: </label></td>
                <td><input type="text" name="enimi" id="enimi" value="<% out.print(henkilo.getEtunimi()); %>"></td>
            </tr>

            <tr>
                <td><label for="snimi">Sukunimi: </label></td>
                <td><input type="text" name="snimi" id="snimi" value="<% out.print(henkilo.getSukunimi()); %>"></td>
            </tr>

            <tr>
                <td><label for="ika">Ikä: </label></td>
                <td><input type="text" name="ika" id="ika" value="<% out.print(henkilo.getIka()); %>"></td>
            </tr>
            <tr><td><input type="submit" value="Tallenna"></td></tr>

        </table>
    </fieldset>
</form>

<p><a href="HenkiloServlet">Form with a Servlet base and EL</a></p>
</body>

</html>