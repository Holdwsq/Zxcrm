package com.wsq.crm.servlet.department;

import com.wsq.crm.service.IDepartmentService;
import com.wsq.crm.service.Impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2017/7/23.
 */
@WebServlet("/department/remove")
public class removeServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    //前期通过new的方式配置，后期我们将采用spring的Ioc的进行装配
    private IDepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    /**
     * 这是删除部门的servlet控制器
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int departmentId = Integer.parseInt(req.getParameter("id"));
        //调用我们的service对部门进行删除操作
        if (departmentService.remove(departmentId)>0){
            resp.sendRedirect(req.getContextPath()+"/department/list");
        }else{
            req.setAttribute("errorMessage","删除部门失败！请查看日志");
            req.getRequestDispatcher("/WEB-INF/view/department/list.jsp").forward(req,resp);
        }
    }
}
