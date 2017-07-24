<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/24
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>角色管理</title>

    <link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>"/>
</head>
<body>
    <div class="box">
        <h3>角色管理</h3>
        <div class="actions">
            <form id="searchForm" action="#" method="post">
            </form>
            <div>
                <a class="btn btn-primary" href="<c:url value="/role/add"/>">添加角色</a>
            </div>
        </div>
        <table class="list">
            <tr>
               <td>序号</td>
               <td>角色名</td>
               <td>角色描述</td>
               <td>更新时间</td>
               <td>操作</td>
            </tr>
            <c:forEach items="${requestScope.roleList}" var="r">
                <tr>
                    <td>${r.roleId}</td>
                    <td>${r.roleName}</td>
                    <td>${r.roleDesc}</td>
                    <td>${r.updateTime}</td>
                    <td>
                        <a class="fa fa-pencil" title="编辑" href="<c:url value="/role/update?id=${r.roleId}"/>"></a>
                        &nbsp;&nbsp;
                        <a class="fa fa-remove" title="删除" href="javascript:confirmDelete(${r.roleId})"></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script src="<c:url value="/lib/jquery/jquery.js"/>"></script>
    <script>
        function confirmDelete(id) {
            if (confirm("确定要删除么？")){
                location.href = '<c:url value="/role/remove"/>?id='+id;
            }
        }
        
    </script>
</body>
</html>
