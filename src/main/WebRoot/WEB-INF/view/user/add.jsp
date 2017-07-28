<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/27
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>用户管理</title>
    <meta charset = "UTF-8">
    <meta name="viewport" content = "width=device-width,initial-scale=1.0">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>"/>
</head>
<body>
    <div class="box">
        <h3>添加用户</h3>

        <form action="<c:url value="/user/add"/>" method="post">
            <table class=" form-table">
                <tr>
                    <td>用户名</td>
                    <td class="control">
                        <input type="text" name="username" value="${requestScope.user.username}"
                        placeholder="请填写用户名"/>
                    </td>
                    <td>密码</td>
                    <td class="control">
                        <input type="password" placeholder="请输入密码" name="password" value="123456"/>
                    </td>
                </tr>
                <tr>
                    <td>部门</td>
                    <td class="control">
                        <select name="departmentId">
                            <c:forEach items="${requestScope.departments}" var="d">
                                <option ${d.departmentId == user.departmentId ? "selected":""} value="${d.departmentId}">
                                    ${d.departmentName}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>角色</td>
                    <td class="control">
                        <select name="roleId">
                            <c:forEach items="${requestScope.roles }" var="r">
                                <option ${r.roleId == user.roleId?"selcted":""} value="${r.roleId}">
                                    ${r.roleName}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td class="control">
                        <input type="radio" name="sex" id="male" value="true" ${use.sex == true?"checked":""}><label for="male">男</label>
                        <input type="radio" name="sex" id="female" value="false" ${user.sex == false?"checked":""}><label for="female"></label>
                    </td>
                    <td>手机号</td>
                    <td class="control">
                        <input name="mobile" type="text" value="${requestScope.user.mobile}" placeholder="请填写手机号">
                    </td>
                </tr>
                <tr>
                    <td>地址</td>
                    <td class="control">
                        <input type="text" name="address" class="p100" value="${requestScope.user.address}" placeholder="请填写地址">
                    </td>
                    <td>出生日期</td>
                    <td class = "control">
                        <input type="datetime" name="birthdate" value="${requestScope.user.birthdate}" placeholder="请填写出生日期">
                    </td>
                </tr>
                <tr>
                    <td>固定电话</td>
                    <td class="control">
                        <input type="text" name="tel" value="${requestScope.user.tel}" placeholder="请填写固定电话">
                    </td>
                    <td>身份证号</td>
                    <td class="control">
                        <input type="text" name="idNum" value="${requestScope.user.idNum}" class="p80" placeholder="请填写身份证号">
                    </td>
                </tr>
                <tr>
                    <td>电子邮箱</td>
                    <td class="control">
                        <input type="text" name="email" value="${requestScope.user.email}" placeholder="请填写电子邮箱">
                    </td>
                    <td>QQ号</td>
                    <td class="control">
                        <input type="text" name="qq" value="${requestScope.user.qq}" placeholder="请填写QQ号">
                    </td>
                </tr>
                <tr>
                    <td>爱好</td>
                    <td class="control">
                        <input type="text" name="hobby" value="${requestScope.user.hobby}" placeholder="请填写爱好">
                    </td>
                    <td>学历</td>
                    <td class="control">
                        <select name="education">
                            <c:forTokens items="小学,初中,高中,专科,本科,硕士,博士"
                                         delims="," var="op" varStatus="s">
                                <option value="${ s.count}">
                                    ${op}
                                </option>
                            </c:forTokens>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>工资卡号</td>
                    <td class="control">
                        <input type="text" name="cardNum" value="${requestScope.user.cardNum}" placeholder="请填写工资卡号">
                    </td>
                    <td>民族</td>
                    <td class="control">
                        <input type="text" name="nation" value="${requestScope.user.nation}" placeholder="请填写民族">
                    </td>
                </tr>
                <tr>
                    <td>婚姻状况</td>
                    <td class="control">
                        <select name="marry">
                            <c:forTokens items="已婚,未婚,离异" delims="," var="op" varStatus="s">
                                <option value="${ s.index }"> ${op}</option>
                            </c:forTokens>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>备注</td>
                    <td colspan="3" class="control">
                        <textarea class="p100" style="height: 150px;" name="remark" placeholder="请填写备注"></textarea>
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <span><p style="color: #ff333b;">${requestScope.errorMessage}</p></span>
                <input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
                <a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
            </div>
        </form>
    </div>
</body>
</html>
