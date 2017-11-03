package fi.academy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Annotation to ensure the URL with this Servlet is accessed w/
@WebServlet(name = "LaskinServlet", urlPatterns = {"/LaskinServlet"})
public class LaskinServlet extends HttpServlet {
    // Servlet extending the javax.servlet.http.HttpServlet class

    // main methods, doPost (forms, files) and doGet (page requests etc visible)
    // always using HttpServletRequest and HttpServletResponse classes to read/write data
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // info the other party (browser) that the content to send will be text or html
        // defining content type to ensure browser uses the proper resource to display/open
        res.setContentType("text/html");

        // read the parameters / variables from data and PARSE STRINGS
        // req.getParameter("name") for single value parameters
        // req.getParameterValues("name") for checkbox & multiple selects to get String[]
        // req.getParameterNames() gives a Collection of all data single value parameter fields/names
        // req.getParameterMap() gives a Map of all (w/ multiple value) data parameter names as key and values as String[]

        int nr1 = Integer.parseInt(req.getParameter("first"));
        int nr2 = Integer.parseInt(req.getParameter("second"));

        int output = nr1 + nr2;

        // init PrintWriter w/ response.getWriter for writing out HTML to the page
        try (PrintWriter out = res.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='fi'>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");

            out.println("<title>Calculator results</title>");

            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Here are the results of the Calculator:</h1>");

            out.println("<form><fieldset>");

            out.println("<legend>Result</legend>");

            out.println("<p>Sum of the values " + nr1 + " and " + nr2 + ":</p>");
            out.println("<p>" + output + "</p>");

            out.println("</form></fieldset>");

            out.println("<a href='Laskin.jsp'>Back to calculator</a>");

            out.println("</body>");
            out.println("</html>");
        }

        //out.close() would close the PrintWriter if needed (try w/ resources! => not needed)

    }

    /*
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    } */

}
