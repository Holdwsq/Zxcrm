package com.wsq.crm.servlet.department;

import com.wsq.crm.model.Department;
import com.wsq.crm.service.IDepartmentService;
import com.wsq.crm.service.Impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by admin on 2017/7/23.
 */
@WebServlet("/department/list")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IDepartmentService departmentService = new DepartmentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    /**
     * 查询部门数据， 跳转到部门列表视图
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询部门数据
        List<Department> list = departmentService.listDepartment();
        request.setAttribute("list",list);
        //跳转到部门列表视图
        request.getRequestDispatcher("/WEB-INF/view/department/list.jsp").forward(request,response);
    }
}
