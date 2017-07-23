<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/22
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta http-equiv="X-UA-COMPATIBLE" content="ie=edge">
    <link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/> ">
</head>
<body>
    <div class="box">
        <h3>部门管理</h3>
        <div class="actions">
                <form id="searchForm" action="#" method="post">
                </form>
            <div>
                <a class="btn btn-primary" href="<c:url value="/department/add"/> ">添加部门</a>
            </div>
        </div>
        <table class="list">
            <tr>
                <td>序号</td>
                <td>部门号</td>
                <td>部门描述</td>
                <td>更新时间</td>
                <td>操作</td>
            </tr>
            <c:forEach var="d" items="${requestScope.list}">
                <tr>
                    <td>${d.departmentId}</td>
                    <td>${d.departmentName}</td>
                    <td>${d.departmentDesc}</td>
                    <td>${d.updateTime}</td>
                    <td>
                        <a class="fa fa-pencil" title="编辑" href="<c:url value="/department/update?id=${d.departmentId}"/> "></a>
                        &nbsp;&nbsp;
                        <a class="fa fa-remove" title="删除" href="javascript:confirmDelete(${d.departmentId})"></a>
                    </td>
                </tr>
            </c:forEach>
            </table>
    </div>
    <script src="<c:url value="/lib/jquery/jquery.js"/>"></script>
    <script>
        function goPage(pageNo) {
            $('#pageNo').val(pageNo);
            $('#searchForm').submit();
        }
        function confirmDelete(id){
            if(confirm("确定要删除么？")){
                location.href = '<c:url value="/department/remove?id="/>'+id;
            }
        }

    </script>
</body>
</html>
