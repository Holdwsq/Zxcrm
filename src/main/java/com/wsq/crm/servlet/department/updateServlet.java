package com.wsq.crm.servlet.department;

import com.wsq.crm.model.Department;
import com.wsq.crm.model.User;
import com.wsq.crm.service.IDepartmentService;
import com.wsq.crm.service.Impl.DepartmentServiceImpl;
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
 * Created by admin on 2017/7/23.
 */
@WebServlet("/department/update")
public class updateServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IDepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Department department = this.departmentService.get(id);

        req.setAttribute("department",department);
        req.getRequestDispatcher("/WEB-INF/view/department/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("departmentId"));
        String departmentName = req.getParameter("departmentName");
        String departmentDesc = req.getParameter("departmentDesc");

        Department d = new Department();
        d.setDepartmentId(id);
        d.setDepartmentName(departmentName);
        d.setDepartmentDesc(departmentDesc);

        User u = (User) req.getSession().getAttribute(SessionKey.USER);
        d.setUpdater(u.getUserId());
        d.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));

        if (this.departmentService.update(d)>0){
            resp.sendRedirect(req.getContextPath()+"/department/list");
        }else{
            req.setAttribute("errorMessage", "更新数据失败，请查看日志！");
            req.setAttribute("department", d);
            req.getRequestDispatcher("/WEB-INF/view/department/add.jsp").forward(req,resp);
        }
    }
}
