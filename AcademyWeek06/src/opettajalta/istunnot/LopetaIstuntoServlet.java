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


@WebServlet(name = "LopetaIstuntoServlet", urlPatterns = {"/LopetaIstuntoServlet"})
public class LopetaIstuntoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession istunto = request.getSession(false);
        if (istunto != null)
            istunto.invalidate();
        RequestDispatcher rd = request.getRequestDispatcher("TervehdysServlet");
        rd.forward(request, response);
    }

}
