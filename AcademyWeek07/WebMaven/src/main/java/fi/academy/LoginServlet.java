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

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Boolean entry = true;

        if(req.getSession(false) != null) {

            HttpSession session = req.getSession(true);

            if("okay".equals(session.getAttribute("entry"))) {

                entry = true;
                RequestDispatcher rd = req.getRequestDispatcher("/cow");
                rd.forward(req, res);

            } else {
                entry = false;
            }
        }

        res.setContentType("text/html");
        try (PrintWriter out = res.getWriter()) {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login to CoW</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Here you can login to CoW (Countries of the World):</h1>");
            out.println("<h3></h3>");

            out.println("<form action='cow' method='post'><fieldset>");
            out.println("<legend>Please enter your username and password.</legend>");
            out.println("<label for='user' style='width: 100px'>Username</label>");
            out.println("<input type='text' id='user' name='user' placeholder='Enter username'>");
            out.println("<br>");
            out.println("<label for='pass' style='width: 100px'>Password</label>");
            out.println("<input type='password' id='pass' name='pass' placeholder='Enter password'>");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for='file' style='width: 100px'>Possible file to upload</label>");
            out.println("<input type='file' id='file' name='file'>");
            out.println("<br>");
            out.println("<br>");
            out.println("<input type='submit' value='Login to CoW'>");

            if (entry == false) {
                out.println("<p style='font-color: red; font-weight: bold;'> You were not authorised to enter the site! </p>");
            }

            out.println("</fieldset></form>");

            out.println("<p></p>");
            out.println("<p>Back to the <a href='index.jsp'>index</a></p>");

            out.println("</body>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
