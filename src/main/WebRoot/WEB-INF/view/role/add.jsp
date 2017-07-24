<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/24
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>角色添加和修改</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
</head>

<body>
    <!-- 添加和修改放进一个jsp页面中 -->
    <div class = "box">
        <h3>
            <c:choose>
                <c:when test="${empty requestScope.role.roleId}">
                    添加角色
                </c:when>
                <c:otherwise>
                    修改角色
                </c:otherwise>
            </c:choose>
        </h3>
        <form action="" name="form1" id="form1">
            <input type="hidden" name="roleId" value="${requestScope.role.roleId}"/>
            <table class = "form-table">
                <tr>
                    <td>角色名称</td>
                    <td class="control">
                        <input type="text" name="roleName" value="${requestScope.role.roleName}"
                            value="" placeholder="请填写角色名称"/>
                    </td>
                </tr>
                <tr>
                    <td>角色描述</td>
                    <td class="control">
                        <textarea name="roleDesc" placeholder="请填写角色描述" >${requestScope.role.roleDesc}</textarea>
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <p class="error-message">${requestScope.errorMessage}</p>
                <input class="btn btn-primary va-bottom" type="button" value="保存" onclick = "submitForm()"/>
                &nbsp;&nbsp;
                <a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
            </div>
        </form>
    </div>
    <script src="<c:url value="/lib/jquery/jquery.js"/>"></script>
    <script>
        function submitForm() {
            if (${empty requestScope.role.roleId}){
                $("#form1").attr("action",'<c:url value="/role/add"/>');
            }else{
                $("#form1").attr("action",'<c:url value="/role/update"/>');
            }
            $("#form1").attr("method","post").submit();
        }
    </script>
</body>
</html>
