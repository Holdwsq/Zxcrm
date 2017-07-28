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
 * Created by admin on 2017/7/27.
 */
@WebServlet("/user/remove")
public class RemoveServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (userService.remove(id) > 0){
            resp.sendRedirect(req.getContextPath()+"/user/list");
        }else{
            req.setAttribute("errorMessage","删除失败,请查看日志！");
            req.getRequestDispatcher("/WEB-INF/view/user/list.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
