package com.wsq.crm.servlet.role;

import com.wsq.crm.model.Role;
import com.wsq.crm.model.User;
import com.wsq.crm.service.IRoleService;
import com.wsq.crm.service.Impl.RoleServiceImpl;
import com.wsq.crm.util.SessionKey;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by admin on 2017/7/24.
 */
@WebServlet("/role/add")
public class AddServlet extends HttpServlet{
    private static final long serialVersinUID = 1L;
    private IRoleService roleService = new RoleServiceImpl();

    /**
     * 转到添加角色的视图
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/role/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName = req.getParameter("roleName");
        String roleDesc = req.getParameter("roleDesc");
        Role role = new Role();
        role.setRoleName(roleName);
        role.setRoleDesc(roleDesc);
        //这里需要强换为User类型，因为原本存的是Object类型的
        User u = (User) req.getSession().getAttribute(SessionKey.USER);
        role.setCreater(u.getUserId());
        role.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));

        if (this.roleService.add(role) > 0){
            resp.sendRedirect(req.getContextPath()+"/role/list");
        }else{
            req.setAttribute("errorMessage","添加失败，请查看日志！");
            req.setAttribute("role",role);
            req.getRequestDispatcher("/WEB-INF/view/role/add.jsp").forward(req,resp);
        }

    }
}
