package fi.academy.istunnot;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;


@WebServlet(name = "TervehdysServlet", urlPatterns = {"/TervehdysServlet"})
public class TervehdysServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession istunto = request.getSession(false);
        String nimi = "Tuntematon";
        if (istunto != null)
            nimi= (String) istunto.getAttribute("nimi");
        if (nimi == null)
            nimi = "Tuntematon";

        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='fi'>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<title>HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tervehdys</h1>");
            out.println(String.format("<p>Terve '%s'!</p>", nimi));
            out.println("<p><a href='IstuntoNimiServlet'>Kirjaudu</a><br/><a href='LopetaIstuntoServlet'>Poistu</a>");
            out.println("</body>");
            out.println("</html>");
        }

    }

}
