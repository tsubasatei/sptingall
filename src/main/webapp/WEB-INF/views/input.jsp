<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2019/4/4
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>emps list</title>
</head>
<body>

    <form action="springmvc/testConversionEmployeeConverter" method="post">
        Employee:<input type="text" name="employee">
        <input type="submit" value="submit">
    </form>

    <br><br>

    <!--
		1. WHY 使用 form 标签呢 ?
		可以更快速的开发出表单页面, 而且可以更方便的进行表单值的回显
		2. 注意:
		可以通过 modelAttribute 属性指定绑定的模型属性,
		若没有指定该属性，则默认从 request 域对象中读取 command 的表单 bean
		如果该属性值也不存在，则会发生错误。
	-->
    <form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
        <form:errors path="*"></form:errors><br>
        <!-- path 属性对应 html 表单标签的 name 属性值 -->
        <c:if test="${emp.id == null}">
            lastName: <form:input path="lastName"/>
            <form:errors path="lastName"></form:errors>
        </c:if>
        <c:if test="${emp.id != null}">
            <form:hidden path="id"></form:hidden>
            <input type="hidden" name="_method" value="PUT">

            <%-- 对于 _method 不能使用 form:hidden 标签, 因为 modelAttribute 对应的 bean 中没有 _method 这个属性 --%>
            <%--
                <form:hidden path="_method" value="PUT"/>
            --%>

        </c:if>
        <br>
        email: <form:input path="email"/>
        <form:errors path="email"></form:errors>
        <br>
        <%
            Map<String, String> gender = new HashMap<>();
            gender.put("0", "female");
            gender.put("1", "male");
            request.setAttribute("genders", gender);
        %>
        gender: <br><form:radiobuttons path="gender" items="${genders}" delimiter="<br>"/><br>

        <!--
        1. 数据类型转换
        2. 数据类型格式化
        3. 数据校验.
        1). 如何校验 ? 注解 ?
        ①. 使用 JSR 303 验证标准
        ②. 加入 hibernate validator 验证框架的 jar 包
        ③. 在 SpringMVC 配置文件中添加 <mvc:annotation-driven />
        ④. 需要在 bean 的属性上添加对应的注解
        ⑤. 在目标方法 bean 类型的前面添加 @Valid 注解
        2). 验证出错转向到哪一个页面 ?
        注意: 需校验的 Bean 对象和其绑定结果对象或错误对象时成对出现的，它们之间不允许声明其他的入参
        3). 错误消息 ? 如何显示, 如何把错误消息进行国际化
        -->
        birth: <form:input path="birth"></form:input>
        <form:errors path="birth"></form:errors>
        <br>
        salary: <form:input path="salary"></form:input>
        <form:errors path="salary"></form:errors>
        <br>
        departmentName: <form:select path="department.id" items="${depts}" itemValue="id" itemLabel="departmentName"/><br>
        <input type="submit" value="save">
    </form:form>
</body>
</html>
