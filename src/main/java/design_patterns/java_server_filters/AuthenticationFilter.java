package design_patterns.java_server_filters;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter(filterName = "authentication")
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        UserAgent userAgent = UserAgent.parseUserAgentString(httpServletRequest.getHeader("User-Agent"));
        if (userAgent.getBrowser().getName().equals("Chrome 9")) {
            this.context.log("We are in Chrome");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>You are not authorized to enter</font>");
        } else {
            chain.doFilter(request, response);
        }

        // or you can add different logic here: allow access to the servlet if the user is admin

       /** if(httpServletRequest.getSession().getAttribute("USER_TYPE").equals("ADMIN")) {
            // allow to get access to the servlet
            chain.doFilter(httpServletRequest, response);
        } else {
            // redirect to a specific location
            ((HttpServletResponse) response).sendRedirect("/admin-login.html");
        }*/
    }

    public void destroy() {
        //we can close resources here
    }
}
