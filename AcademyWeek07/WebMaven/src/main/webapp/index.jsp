<html>

<jsp:useBean id="Laskuri" class="fi.academy.Laskuri" scope="application"></jsp:useBean>

<% Laskuri.setLaskuri(Laskuri.getLaskuri() + 1); %>

<body>
<h2>Here there be a counter: <% out.print(Laskuri.getLaskuri()); %></h2>
<p></p>
<p style="font-weight: bold;"><a href="/login">Link</a> to a list of the countries of the world!</p>
<p style="font-weight: bold;"><a href="CoW.jsp">Link</a> to the list .jsp</p>
</body>
</html>
