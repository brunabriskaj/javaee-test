package java_server_filters;

import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestHandler")
public class RequestHandler extends HttpServlet {

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<H2>Welcome User</H2>");
        out.println("</body>");
        out.println("</html>");
    }
}
