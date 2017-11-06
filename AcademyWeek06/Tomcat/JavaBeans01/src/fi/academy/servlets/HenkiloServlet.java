package fi.academy.servlets;

import fi.academy.beans.Henkilo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HenkiloServlet", urlPatterns = {"/HenkiloServlet"})
public class HenkiloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Henkilo henkilo = new Henkilo();
        String enimi = request.getParameter("enimi");
        if (enimi != null) {
            String snimi = request.getParameter("snimi");
            int ika = Integer.parseInt(request.getParameter("ika"));
            henkilo.setEtunimi(enimi);
            henkilo.setSukunimi(snimi);
            henkilo.setIka(ika);
        } else {
            henkilo.setEtunimi("Etunimi");
            henkilo.setSukunimi("Sukunimi");
            henkilo.setIka(0);
        }
        request.setAttribute("henkilo", henkilo);
        request.getRequestDispatcher("henkiloel.jsp").
                forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
