<%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2019/4/4
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>emps list</title>
    <!--
        SpringMVC 处理静态资源:
        1. 为什么会有这样的问题:
        优雅的 REST 风格的资源URL 不希望带 .html 或 .do 等后缀
        若将 DispatcherServlet 请求映射配置为 /,
        则 Spring MVC 将捕获 WEB 容器的所有请求, 包括静态资源的请求, SpringMVC 会将他们当成一个普通请求处理,
        因找不到对应处理器将导致错误。
        2. 解决: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler/>
    -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.9.1.min.js"></script>
    <script>
        $(function () {
            $(".delete").click(function () {
                var href = $(this).attr("href");
                $("form").attr("action", href).submit();
                return false;
            });
        });
    </script>
</head>
<body>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>

    <a href="/emp">Add An Employee</a>
    <c:if test="${empty requestScope.emps}">
        没有任何员工信息.
    </c:if>
    <c:if test="${!empty requestScope.emps}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tbody>
                <tr>
                    <td>ID</td>
                    <td>LastName</td>
                    <td>Email</td>
                    <td>Gender</td>
                    <td>DepartmentName</td>
                    <td>Edit</td>
                    <td>Delete</td>
                </tr>
            </tbody>
            <c:forEach items="${requestScope.emps}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.gender == 0 ? 'female' : 'male'}</td>
                    <td>${emp.department.departmentName}</td>
                    <td><a href="/emp/${emp.id}">Edit</a></td>
                    <td><a class="delete" href="/emp/${emp.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
