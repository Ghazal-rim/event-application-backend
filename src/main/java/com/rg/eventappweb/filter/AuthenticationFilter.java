package com.rg.eventappweb.filter;

import com.rg.eventappweb.models.UserDetails;
import com.rg.eventappweb.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    private final static String URL_PATTERN = "/events";
    @Autowired
    private final UserDetailsService userDetailsService;

    public AuthenticationFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (matchUrlPattern(request)) {
            UserDetails userDetails = getUserDetails(request);
            if (isAutenticated(userDetails)) {
                filterChain.doFilter(servletRequest, servletResponse);

            } else {
                response.setStatus(403);
            }
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private UserDetails getUserDetails(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        String email = authorization.substring(0, authorization.lastIndexOf(":"));
        String password = authorization.substring(authorization.lastIndexOf(":") + 1, authorization.length());
        return new UserDetails(email, password);
    }

    private boolean isAutenticated(UserDetails userDetails) {
        return userDetailsService.isAutenticated(userDetails);
    }


    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private boolean matchUrlPattern(HttpServletRequest request) {
        return request.getRequestURI().startsWith(URL_PATTERN);
    }
}
