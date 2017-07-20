package com.wsq.crm.servlet.user;

import com.wsq.crm.model.User;
import com.wsq.crm.service.IUserService;
import com.wsq.crm.service.Impl.UserServiceImpl;
import com.wsq.crm.util.SessionKey;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 2017/7/20.
 */
public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IUserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        servlet的主要功能就是参、调、存、转
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("username");
        String password = req.getParameter("password");
        userService = new UserServiceImpl();
        User user = userService.getByLogin(name,password);
        if(user ==null){
            req.setAttribute("errorMessage", "用户名或密码错误！");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else{
            HttpSession session = req.getSession();
            session.setAttribute(SessionKey.USER,user);
            session.setAttribute(SessionKey.USERNAME,user.getUsername());
            resp.sendRedirect(req.getContextPath()+"/admin.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
