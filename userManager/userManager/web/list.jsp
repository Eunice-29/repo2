<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(param) {
            if (confirm("你确定删除吗？")){
               location.href="${pageContext.request.contextPath}/deleteUser?id="+param;
            }
        }
        // 删除选中
        function deleteUsers(){
            let flag = false;
            let ids = $("input[name='uid']");
            for (let i = 0; i < ids.length; i++) {
                if (ids[i].checked) {
                    flag = true;
                }
            }
            if (flag){
                if (confirm("你确定删除这些记录吗？")){
                    $("#userForm").submit();
                }
            }
        }

        $(function () {
                //全选
                $("#checkAll").click(function () {
                    var ids = $("input[name='uid']")
                    for (let i = 0; i < ids.length; i++) {
                        ids[i].checked = this.checked;
                    }
                })
        })

    </script>
</head>
<body>
<div class="container">
    <h1 style="text-align: center">用户信息列表</h1>
    <div class="row" style="margin-bottom: 30px">
        <div class="col-lg-9" >
            <form class="form-inline" method="post" action="${pageContext.request.contextPath}/pageList?pageNum=1&rows=5">
                <div class="form-group">
                    <label for="username">姓名</label>
                    <input type="text" class="form-control" id="username"  name="username" value="${condition.username[0]}" placeholder="姓名">
                </div>
                <div class="form-group">
                    <label for="address">籍贯</label>
                    <input type="text" class="form-control" id="address" name="address" value="${condition.address[0]}" placeholder="籍贯">
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" id="email"  name="email" value="${condition.email[0]}" placeholder="jane.doe@example.com">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
        </div>
        <div class="col-lg-3">
            <a style="float: right" class="btn btn-primary" href="javascript:deleteUsers()">删除选中</a>
            <a style="float: right;margin-right: 20px" class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        </div>
    </div>
    <div class="row">
        <form method="post" id="userForm" action="${pageContext.request.contextPath}/deleteUsers">
            <table border="1" class="table table-bordered table-hover">
                <tr class="success">
                    <th><input type="checkbox" id="checkAll" /></th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>籍贯</th>
                    <th>QQ</th>
                    <th>邮箱</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="user" varStatus="vs">
                <tr>
                    <td><input type="checkbox"  name="uid" value="${user.id}"/></td>
                    <td>${vs.index+1}</td>
                    <td>${user.username}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findOne?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a></td>
                </tr>
                </c:forEach>
            </table>
        </form>
    </div>
    <div class="row" >
        <nav aria-label="Page navigation">
            <ul class="pagination">
<%--                上一页开始   --%>
                <c:if test="${pageInfo.pageNum == 1}">
                    <li class="disabled">
                </c:if>
                 <c:if test="${pageInfo.pageNum != 1}">
                        <li>
                 </c:if>
                        <a href="${pageContext.request.contextPath}/pageList?pageNum=${pageInfo.pageNum-1}&rows=5&username=${condition.username[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>

<%--          上一页结束       --%>
                <c:forEach begin="1" end="${pageInfo.totalPage}" step="1" var="i">
                    <c:if test="${pageInfo.pageNum == i}">
                        <li class="active">
                    </c:if>
                    <c:if test="${pageInfo.pageNum != i}">
                        <li>
                    </c:if>
                            <a href="${pageContext.request.contextPath}/pageList?pageNum=${i}&rows=5&username=${condition.username[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                        </li>
                </c:forEach>

<%--    下一页开始     --%>
               <c:if test="${pageInfo.pageNum == pageInfo.totalPage}">
                    <li class="disabled">
               </c:if>
                 <c:if test="${pageInfo.pageNum != pageInfo.totalPage}">
                        <li>
                 </c:if>
                        <a href="${pageContext.request.contextPath}/pageList?pageNum=${pageInfo.pageNum+1}&rows=5&username=${condition.username[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
<%--    下一页结束   --%>
                <li style="margin-left: 20px">
                    <h3 style="display: inline" >共${pageInfo.totalNum}条记录,共${pageInfo.totalPage}页</h3>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
