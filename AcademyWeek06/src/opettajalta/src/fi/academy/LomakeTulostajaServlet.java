package fi.academy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "LomakeTulostajaServlet", urlPatterns = {"/LomakeTulostajaServlet"})
public class LomakeTulostajaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("virhesivu.jsp");
        // Suoritetaan varsinainen uudelleenohjaus
        rd.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='fi'>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<title>HelloServlet</title>");
            out.println("<style>td{padding: 1pt 3pt;}</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>LomakeData</h1>");
            out.println("<h2>getParameterNames()-versio");
            out.println("<table border='1'>");
            out.println(tulostaRivit(request));
            out.println("</table>");
            out.println("<h2>getParameterMap()-versio");
            out.println("<table border='1'>");
            out.println(tulostaRivitv2(request));
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String tulostaRivit(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> nimet = request.getParameterNames();
        while(nimet.hasMoreElements()) {
            String parametrinNimi = nimet.nextElement();
            String parametrinArvo = request.getParameter(parametrinNimi);
            String rivi = String.format("<tr><td>%s</td><td>%s</td></tr>",
                    parametrinNimi, parametrinArvo);
            sb.append(rivi);
        }
        return sb.toString();
    }

    private String tulostaRivitv2(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Map<String, String[]> parametrit = request.getParameterMap();
        for(Map.Entry<String, String[]> param : parametrit.entrySet()) {
            String parametrinNimi = param.getKey();
            String [] arvot = param.getValue();
            sb.append("<tr><td>").append(parametrinNimi).append("</td><td>");
            sb.append(String.join("<br/>", Arrays.asList(arvot)));
            sb.append("</td></tr>");
        }
        return sb.toString();
    }
}
