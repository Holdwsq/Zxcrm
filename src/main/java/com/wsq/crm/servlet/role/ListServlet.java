package com.wsq.crm.servlet.role;

import com.wsq.crm.model.Role;
import com.wsq.crm.service.IRoleService;
import com.wsq.crm.service.Impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2017/7/24.
 */
@WebServlet("/role/list")
public class ListServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IRoleService roleService = new RoleServiceImpl();

    /**
     * 查询角色列表信息，跳转到列表页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> roleList = this.roleService.list();
        req.setAttribute("roleList",roleList);

        req.getRequestDispatcher("/WEB-INF/view/role/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
