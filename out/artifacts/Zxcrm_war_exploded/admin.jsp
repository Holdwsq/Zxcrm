<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/21
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.wsq.crm.util.SessionKey"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>客户关系管理主页</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="<c:url value="/css/admin.css"/>">
    <link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>">
    <%--font-awesome 专门为bootstrap创造的字体和图标 的库--%>
</head>
<body>
    <div class="header">
        <h1><a href="#">智游客户关系管理系统</a></h1>
        <div class="nav">
            <a target="pageBox" href="#">工作台</a>
            <a target="pageBox" href="#">报表</a>
            <a target="pageBox" href="#">客户信息</a>
            <a target="pageBox" href="#">员工信息</a>
            <a target="pageBox" href="#">公告信息</a>
            <a target="pageBox" href="#">发件箱</a>
        </div>
        <div class="user">
            <a href="#">${sessionScope[SessionKey.USERNAME]}</a>
            <a href="#">退出</a>
        </div>
    </div>
    <div class="main">
        <ul class="left-side">
            <li class="menu-title">
                <a href="#">
                    <i class="fa fa-users"></i>&nbsp;&nbsp;客户管理
                </a>
            </li>
            <li class="sub-menu">
                <ul>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;客户信息
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;客户分配
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;客户关怀
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;客户分类
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;客户状态
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;客户来源
                        </a>
                    </li>
                </ul>
            </li>
            <li class="menu-title">
                <a href="#">
                    <i class="fa fa-file-text"></i>&nbsp;&nbsp;内部信息
                </a>
            </li>
            <li class="sub-menu">
                <ul>
                    <li>
                       <a target="pageBox" href="#">
                           <i class="fa fa-circle"></i>&nbsp;&nbsp;通知公告
                       </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle"></i>&nbsp;&nbsp;员工信息
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle"></i>&nbsp;&nbsp;部门信息
                        </a>
                    </li>
                </ul>
            </li>
            <li class="menu-title">
                <a href="#">
                    <i class="fa fa-envelope"></i>&nbsp;&nbsp;站内邮件
                </a>
            </li>
            <li class="sub-menu">
                <ul>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;写邮件
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;收件箱
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;发件箱
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;草稿箱
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;垃圾箱
                        </a>
                    </li>
                </ul>
            </li>
            <li class="menu-title active">
                <a target="pageBox" href="#">
                    <i class="fa fa-sitemap"></i>&nbsp;&nbsp;管理员
                </a>
            </li>
            <li class="sub-menu">
                <ul class="menu">
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;公告管理
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="<c:url value="/department/list"/> ">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;部门管理
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;角色管理
                        </a>
                    </li>
                    <li>
                        <a target="pageBox" href="#">
                            <i class="fa fa-circle-thin"></i>&nbsp;&nbsp;用户管理
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <%--中间主页面显示 Iframe 的name 为pageBox--%>
        <div class="right-side">
            <iframe name="pageBox" src=""></iframe>
            <div class="footer">
                智游教育 ©2017 河南智游臻龙教育科技有限公司
            </div>
        </div>
    </div>
<script src="<c:url value="/lib/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/js/admin.js"/> "></script>
</body>
</html>
