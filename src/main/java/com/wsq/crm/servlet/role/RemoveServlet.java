package com.wsq.crm.servlet.role;

import com.wsq.crm.service.IRoleService;
import com.wsq.crm.service.Impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2017/7/24.
 */
@WebServlet("/role/remove")
public class RemoveServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IRoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int roleId = Integer.parseInt(req.getParameter("id"));
        if (this.roleService.removeRole(roleId) > 0){
            resp.sendRedirect(req.getContextPath()+"/role/list");
        }else{
            req.setAttribute("errorMessage","删除失败，请查看日志");
            req.getRequestDispatcher("/WEB-INF/view/role/list.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
