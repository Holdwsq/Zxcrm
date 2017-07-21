<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/20
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录-客户关系管理系统</title>
    <meta charset = "UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%--个常用的针对移动网页优化过的页面的 viewport meta 标签--%>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
    <div id="login">
        <img src="<c:url value="/images/logo.png"/>"/>
        <p>智游客户关系管理系统</p>
        <form action="<c:url value="/user/login"/>" method = "post">
            <div>
                <input type="text" id="username" name="username" value="" placeholder="请输入用户名">
            </div>
            <div>
                <input type="password" id="password" name="password" value="" placeholder="请输入密码"/>
            </div>
            <div>
                <p class="error-message">${requestScope.errorMessage}</p>
                <input type="submit" value="登录"/>
            </div>
        </form>
    </div>
</body>
</html>
