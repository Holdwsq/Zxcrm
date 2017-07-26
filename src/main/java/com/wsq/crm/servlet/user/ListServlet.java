package com.wsq.crm.servlet.user;

import com.wsq.crm.model.User;
import com.wsq.crm.service.IUserService;
import com.wsq.crm.service.Impl.UserServiceImpl;
import com.wsq.crm.util.Pager;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2017/7/26.
 * 将普通的类继承HttpServlet，HttpServlet实现了我们Http协议
 * Override 其中的方法 如：doGet（）和 doPost（）方法
 */
@WebServlet("/user/list")
public class ListServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserServiceImpl();

    /**
     * 跳转到用户列表展示视图
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(1,"","",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        String keyword = req.getParameter("keyword");
        String searchField = req.getParameter("searchField");


        showPage(pageNo,keyword,searchField,req,resp);
    }
    private void showPage(int pageNo,String keyword,String searchField,HttpServletRequest req,HttpServletResponse resp)
            throws ServletException, IOException {
        int total = this.userService.total(keyword,searchField);
        Pager pager = new Pager(pageNo, total, 2, 4);
//      调用service获取用户列表
        List<User> userList = userService.list(pager,keyword,searchField);
        req.setAttribute("pager",pager);
        req.setAttribute("list",userList);
        req.setAttribute("keyword",keyword);
        req.setAttribute("searchField",searchField);

        req.getRequestDispatcher("/WEB-INF/view/user/list.jsp").forward(req,resp);
    }
}
