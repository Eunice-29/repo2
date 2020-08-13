<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>

    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUser" method="post">
        <%--  增添隐藏框存放id属性      --%>
        <input name="id" value="${user.id}" type="hidden">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="username" value="${user.username}"  readonly="readonly" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别：</label>
             <c:if test="${user.gender == '男'}">
                 <input type="radio" name="gender" value="男"  checked />男
                 <input type="radio" name="gender" value="女"  />女
             </c:if>
            <c:if test="${user.gender == '女'}">
                <input type="radio" name="gender" value="男"   />男
                <input type="radio" name="gender" value="女" checked />女
            </c:if>

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" value="${user.age}" placeholder="请输入年龄" />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control"  id="address">
                <c:if test="${user.address == '魏国'}">
                    <option value="魏国" selected>魏国</option>
                    <option value="吴国">吴国</option>
                    <option value="蜀国">蜀国</option>
                </c:if>
                <c:if test="${user.address == '吴国'}">
                    <option value="魏国" >魏国</option>
                    <option value="吴国" selected>吴国</option>
                    <option value="蜀国">蜀国</option>
                </c:if>
                <c:if test="${user.address == '蜀国'}">
                    <option value="魏国" >魏国</option>
                    <option value="吴国">吴国</option>
                    <option value="蜀国" selected>蜀国</option>
                </c:if>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" id="qq" value="${user.qq}" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" id="email" value="${user.email}" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" onclick="javascript:history.back(-1)" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
