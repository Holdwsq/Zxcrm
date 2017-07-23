<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/22
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-COMPATIBLE" content="ie=edge">

    <title>部门添加</title>
    <link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <script src="<c:url value="/lib/jquery/jquery.js"/> "></script>
    <script>
        function submitForm() {
            alert(${empty param.id});
            if(${empty param.id}){
                alert(1);
                $("#form1").attr("action","<c:url value="/department/add"/>");
            }else {
                alert(2);
                $("#form1").attr("action","<c:url value="/department/update"/>");
            }
            $("#form1").attr("method","post").submit();
        }
    </script>
</head>
<body>
    <div class="box">
        <h3>
            <c:choose>
                <c:when test="${empty param.id}">
                    添加部门
                </c:when>
                <c:otherwise>
                    更新部门
                </c:otherwise>
            </c:choose>
        </h3>
        <form action="" id="form1" name="form1">
            <input type="hidden" name="departmentId" value="${requestScope.department.departmentId }">
            <table class="form-table">
                <tr>
                    <td>部门名称</td>
                    <td class="control">
                        <input type="text" name="departmentName" value="${requestScope.department.departmentName}"
                        value="" placeholder="请填写部门名称">
                    </td>
                </tr>
                <tr>
                    <td>部门描述</td>
                    <td class="control">
                        <textarea name="departmentDesc" placeholder="请填写部门描述">${requestScope.department.departmentDesc}</textarea>
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <p class="error-message">${requestScope.errorMessage}</p>
                <input class="btn btn-primary va-bottom" type="button" value="保存" onclick="submitForm()">&nbsp;&nbsp;
                <a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
            </div>
        </form>
    </div>
</body>
</html>
