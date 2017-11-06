package fi.academy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DBAccessServlet", urlPatterns = {"/cow"})
public class CoWServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        if(req.getSession(false) != null) {

            if(authorised(req, req.getSession())) {

                RequestDispatcher rd = req.getRequestDispatcher("CoW.jsp");
                rd.forward(req, res);

            } else {

                req.getSession().setAttribute("entry", "not");
                RequestDispatcher rd = req.getRequestDispatcher("/login");
                rd.forward(req, res);

            }
        }

        res.setContentType("text/html");

        try (PrintWriter out = res.getWriter()) {
            out.println("<html>");

            out.println("<head>");
            out.println("<title>CoW - Countries of the World</title>");
            out.println("</head>");

            out.println("<body>");
            out.println("<h1>Countries of the World:</h1>");

            out.println("<p>Here there be a list</p>");

            out.println("<p>Back to the <a href='index.jsp'>index</a></p>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/login");
        rd.forward(req, res);

    }

    private boolean authorised(HttpServletRequest req, HttpSession session) {

        if ("Antti".equals(req.getParameter("user")) && "secret".equals(req.getParameter("pass"))) {
            session.setAttribute("entry", "okay");
            return true;
        }
        else return false;

    }

}
