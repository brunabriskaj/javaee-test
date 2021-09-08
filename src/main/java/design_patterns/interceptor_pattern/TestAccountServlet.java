package design_patterns.interceptor_pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestAccountServlet")
public class TestAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TestAccountServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello from TestAccountServlet");

        InitialContext initialContext;
        AccountService bean;

        String message = request.getParameter("printMessage");

        if (message != null) {
            // test using http://localhost:8080/test-1.0-SNAPSHOT/TestAccountServlet?printMessage=Hello%20From%20Bruna
            try {
                initialContext = new InitialContext();
                AccountService accountService = (AccountService)initialContext.lookup("java:global/test-1.0-SNAPSHOT/AccountService!design_patterns.interceptor_pattern.AccountService");
                accountService.printMessage(message);

            } catch (NamingException e) {

                e.printStackTrace();
            }
        }
    }
}