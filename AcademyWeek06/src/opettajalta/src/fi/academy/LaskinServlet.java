package fi.academy;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LaskinServlet", urlPatterns = {"/LaskinServlet"})
public class LaskinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int luku1=0, luku2=0, tulos=0;
        char op='?';
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='fi'>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<title>HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Laskin</h1>");
            try {
                String luku = request.getParameter("eka");
                if(luku != null) {
                    luku1 = Integer.parseInt(luku);
                }
                luku = request.getParameter("toka");
                if(luku != null) {
                    luku2 = Integer.parseInt(luku);
                }
                luku = request.getParameter("operaatio");
                if(luku != null&&luku.length()>=1) {
                    op = luku.charAt(0);
                    if(op == '+') tulos = luku1+luku2;
                    if(op == '-') tulos = luku1-luku2;
                    if(op == '*') tulos = luku1*luku2;
                    if(op == '/') tulos = luku1/luku2;
                }
            } catch (NumberFormatException e) {
                out.println("<p>Ongelma numeroiden kanssa, tarkempana</p>");
            }
            out.println("<form method='POST'>");
            out.println("<p>Luku1: <input name='eka' value='"+luku1+"'></p>");
            out.println("<p>Luku2: <input name='toka' value='"+luku2+"'></p>");
            out.println("<p><select name='operaatio'>");
            out.println("<option value='+'"+(op=='+'? " selected":"")+">+</option>");
            out.println("<option value='-'"+(op=='-'? " selected":"")+">-</option>");
            out.println("<option value='*'"+(op=='*'? " selected":"")+">*</option>");
            out.println("<option value='/'"+(op=='/'? " selected":"")+">/</option>");
            out.println("</select></p>");
            out.println("<input type='submit' value='Laske'>");
            out.println("</form><hr/>");
            out.println(String.format("<p>Lasku: %d %s %d = %d</p>", luku1, ""+op, luku2, tulos) );
            out.println("</body>");
            out.println("</html>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}