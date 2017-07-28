
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/26
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name = "viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
</head>
<body>
    <div class="box">
        <div class="actions">
            <form id="searchForm" action="<c:url value="/user/list"/>" method="post">
                <span>搜索内容：</span>
                <input type="text" name="keyword" value="${requestScope.keyword}" placeholder="请输入搜索关键词">
                &nbsp;&nbsp;&nbsp;
                <span>搜索字段：</span>
                <select name = "searchField">
                    <option value="username" ${requestScope.searchField == "username"?"selected":""}>用户名</option>
                    <option value="mobile" ${requestScope.searchField == "mobile" ? "selected":""}>手机号</option>
                    <option value="address" ${requestScope.searchField == "address" ? "selected":""}>地址</option>
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="hidden" name="pageNo" id="pageNo" value="1">
                <input type="submit" class="btn btn-default" value="搜索">
            </form>
            <div>
                <a class="btn btn-primary" href="<c:url value="/user/add"/>">添加用户</a>
            </div>
        </div>
        <table class="list">
            <tr>
                <th>序号</th>
                <th>用户名</th>
                <th>部门</th>
                <th>角色</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${ requestScope.list}" var="u">
                <tr>
                    <td>${u.userId}</td>
                    <td>
                        <a title="查看详情" href="#">
                            ${u.username}
                        </a>
                    </td>
                    <td>${ u.departmentId}</td>
                    <td>${ u.roleId}</td>
                    <td>${ u.mobile}</td>
                    <td>${ u.email}</td>
                    <td>${ u.updateTime}</td>
                    <td>
                        <a class="fa fa-pencil" title="编辑" href="#"></a>
                        &nbsp;&nbsp;
                        <a class="fa fa-remove" title="删除" href="javascript:confirmDelete(${u.userId})"></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="pager-info">
            <div>
                共有：${requestScope.pager.total}条记录，第${requestScope.pager.pageNo}条
            </div>
            <div>
                <ul class="pagination">
                    <li class = "paginate_button previous disabled">
                        <c:if test="${ requestScope.pager.pageNo > 1}">
                            <a href="javascript:goPage(${requestScope.pager.pageNo - 1})" title="上一页">上一页</a>
                        </c:if>
                        <c:if test="${ requestScope.pager.pageNo <= 1}">
                            <a href="#" title="上一页">上一页</a>
                        </c:if>
                    </li>
                    <c:forEach begin="${requestScope.pager.start}" end ="${requestScope.pager.end}" var="p">
                        <li class="paginate_button ${ p == requestScope.pager.pageNo ? "active":""}">
                            <a href="javascript:goPage(${p})">${p}</a>
                        </li>
                    </c:forEach>
                    <li class="paginate_button next disabled">
                        <c:if test="${requestScope.pager.pageNo < requestScope.pager.pageCount}">
                            <a title="下一页" href="javascript:goPage(${requestScope.pager.pageNo + 1})">下一页</a>
                        </c:if>
                        <c:if test="${requestScope.pager.pageNo >= requestScope.pager.pageCount}">
                            <a href="#" title="下一页">下一页</a>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </div>
<script src="<c:url value="/lib/jquery/jquery.js"/>"></script>
<script>
    function goPage(pageNo){
        $("#pageNo").val(pageNo);
        $("#searchForm").submit();
    }
    function confirmDelete(id){
        if (confirm("确定要删除么？")){
            location.href = "<c:url value="/user/remove"/>?id="+ id ;
        }

    }
</script>
</body>
</html>
