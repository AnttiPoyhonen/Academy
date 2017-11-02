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

@WebServlet(name = "IstuntoNimiServlet", urlPatterns = {"/IstuntoNimiServlet"})
public class IstuntoNimiServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession istunto = request.getSession(false);
        String nimi = "";
        if(istunto != null)
            nimi= (String) istunto.getAttribute("nimi");
        if (nimi == null)
            nimi = "";

        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='fi'>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<title>HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login</h1>");
            out.println("<form method=POST>");
            out.println("<p>Nimesi: <input name='nimi' value='" + nimi + "'></p>" );
            out.println("<p><input type='submit' value='Kirjaudu'></p>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession istunto = request.getSession(true);
        String nimi = request.getParameter("nimi");
        if (nimi == null)
            nimi = "Tuntematon";
        istunto.setAttribute("nimi", nimi);
//        RequestDispatcher rd = request.getRequestDispatcher("TervehdysServlet");
//        rd.forward(request, response);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Siirrytään..</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>");
        out.println("Olet nyt loggautunut, sivun pitäisi siirtyä:");
        out.println("<a href='TervehdysServlet'>");
        out.println("Tervehdyssivulle</a>");
        out.println("</h3>");
        out.println("</body>");
        out.println("</html>");
        // Suoritetaan uudelleenohjaus
        response.sendRedirect("TervehdysServlet");

    }

}
