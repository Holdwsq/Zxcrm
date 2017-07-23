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
 * Created by admin on 2017/7/22.
 */
@WebServlet("/department/add")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
//   这里同样前期通过new 一个DepartmentService的bean，后期依旧采用、、就是我们的spring
//    来进行配置
    IDepartmentService departmentService = new DepartmentServiceImpl();

    /**
     * 我们请求方法为post中进行添加部门的业务逻辑
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String departmentName = request.getParameter("departmentName");
        String departmentDesc = request.getParameter("departmentDesc");

        Department d = new Department();
        d.setDepartmentName(departmentName);
        d.setDepartmentDesc(departmentDesc);
        User currentU = (User) request.getSession().getAttribute(SessionKey.USER);
        if (currentU!=null){
            d.setCreater(currentU.getUserId());
            d.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        }



        if (departmentService.addDepartment(d) > 0){
            response.sendRedirect(request.getContextPath()+"/department/list");
        }else{
            request.setAttribute("errorMessage","添加部门失败！请查看日志！");
            request.setAttribute("department",d);
            doGet(request,response);
        }
    }

    /**
     * 转到我们的添加视图 add.jsp的页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/view/department/add.jsp").forward(request,response);
    }
}
