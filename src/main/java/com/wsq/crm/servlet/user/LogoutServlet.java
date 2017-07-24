package com.wsq.crm.servlet.user;

import com.wsq.crm.service.IUserService;
import com.wsq.crm.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2017/7/24.
 */
@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.userService.logout(req);
       resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
