package com.wsq.crm.servlet.user;

import com.wsq.crm.model.Department;
import com.wsq.crm.model.Role;
import com.wsq.crm.model.User;
import com.wsq.crm.service.IDepartmentService;
import com.wsq.crm.service.IRoleService;
import com.wsq.crm.service.IUserService;
import com.wsq.crm.service.Impl.DepartmentServiceImpl;
import com.wsq.crm.service.Impl.RoleServiceImpl;
import com.wsq.crm.service.Impl.UserServiceImpl;
import com.wsq.crm.util.RequestToBeanUtil;
import com.wsq.crm.util.SessionKey;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by admin on 2017/7/27.
 */
@WebServlet("/user/add")
public class AddServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserServiceImpl();
    private IDepartmentService departmentService = new DepartmentServiceImpl();
    private IRoleService roleService = new RoleServiceImpl();
    /**
     * 转到添加用户的视图
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*   //getParameter获取对应name的String类型
        String userId = req.getParameter("id");
        int id = Integer.parseInt(userId);
        //调用service返回对应的用户
        User user = userService.get(id);
        req.setAttribute("user",user);*/
        //user的部门和角色 属于字典 应该从数据库中获取
        List<Department> departments = departmentService.listDepartment();
        List<Role> roles = roleService.list();
        req.setAttribute("departments",departments);
        req.setAttribute("roles",roles);
        req.getRequestDispatcher("/WEB-INF/view/user/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //由于参数太多，偷个懒，写一个工具类实现 对对象的封装
        try {
            User user = (User) RequestToBeanUtil.turn(req,User.class);
            User u = (User) req.getSession().getAttribute(SessionKey.USER);


            user.setCreater(u.getUserId());
            user.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));

            if (userService.add(user) > 0){
                resp.sendRedirect(req.getContextPath()+"/user/list");
            }else{
                req.setAttribute("errorMessage","增加用户失败，请查看日志！");
                req.setAttribute("user",user);
                req.getRequestDispatcher("/WEB-INF/view/user/add.jsp").forward(req,resp);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
