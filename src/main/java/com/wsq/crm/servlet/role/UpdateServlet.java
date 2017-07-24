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
@WebServlet("/role/update")
public class UpdateServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IRoleService roleService = new RoleServiceImpl();

    /**
     * 跳转到修改角色的页面视图中
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int roleId = Integer.parseInt(req.getParameter("id"));
        Role role = this.roleService.get(roleId);
        req.setAttribute("role",role);
        req.getRequestDispatcher("/WEB-INF/view/role/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName = req.getParameter("roleName");
        String roleDesc = req.getParameter("roleDesc");
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        Role role = new Role();
        role.setRoleId(roleId);
        role.setRoleName(roleName);
        role.setRoleDesc(roleDesc);
//        获取到当去登陆的用户
        User u = (User)req.getSession().getAttribute(SessionKey.USER);
        role.setUpdater(u.getUserId());
        role.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));

//      调用service进行业务操作
        if (this.roleService.updateRole(role) > 0){
            resp.sendRedirect(req.getContextPath()+"/role/list");
        }else{
            req.setAttribute("errorMessage","更新失败，请查看日志！");
            req.setAttribute("role",role);
            req.getRequestDispatcher("/WEB-INF/view/role/add.jsp");
        }
    }
}
