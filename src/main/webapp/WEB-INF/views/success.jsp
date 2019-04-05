<%--
     解决sringMVC 转发到jsp时出现405错误：JSPs only permit GET POST or HEAD
     isErrorPage设置为true，默认为false
     isELIgnored="true|false" 表示是否在此JSP网页中执行或忽略EL表达式。如果为true时JSP Container将忽略EL表达式。
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" isELIgnored = "false" %>
<%-- 导入国际化标签 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h2>欢迎来到 Spring MVC</h2>
    time: ${requestScope.time}
    <br><br>

    names: ${requestScope.names}
    <br><br>

    request user: ${requestScope.user}
    <br><br>

    scope user: ${sessionScope.user}
    <br><br>

    request school: ${requestScope.school}
    <br><br>

    scope school: ${sessionScope.school}
    <br><br>

    <fmt:message key="i18n.username" ></fmt:message>
    <br><br>

    <fmt:message key="i18n.password"></fmt:message>
    <br><br>

</body>
</html>
