package com.wsq.crm.filter;

import com.wsq.crm.util.Global;
import com.wsq.crm.util.SessionKey;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 2017/7/23.
 */
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req!=null){
            HttpSession session = req.getSession();
            String username = (String) session.getAttribute(SessionKey.USERNAME);
            if(username==null){
                HttpServletResponse response = (HttpServletResponse)servletResponse;
//                response.sendRedirect(((HttpServletRequest) servletRequest).getContextPath()+"/index.jsp");
                response.sendRedirect(Global.getLoginURL(req));
                return;
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
