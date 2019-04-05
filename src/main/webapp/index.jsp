<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
        <script src="${pageContext.request.contextPath}/assets/js/jquery-1.9.1.min.js"></script>
        <script>
            $(function () {
                $("#testJson").click(function () {
                    var url = this.href;
                    var args = {};
                    $.post(url, args, function (data) {
                        for(var i = 0; i < data.length; i++) {
                            var id = data[i].id;
                            var lastName = data[i].lastName;
                            alert("id=" + id + ", lastName=" + lastName);
                        }
                    })
                    return false;
                })
            })
        </script>
    </head>
<body>

<a href="/springmvc/testSimpleMappingExceptionResolver?i=2">Test SimpleMappingExceptionResolver</a>
<br><br>
<a href="/springmvc/testDefaultHandlerExceptionResolver">Test DefaultHandlerExceptionResolver</a>
<br><br>
<a href="/springmvc/testResponseStatusExceptionResolver?i=10">Test ResponseStatusExceptionResolver</a>
<br><br>
<a href="/springmvc/testExceptionHandlerExceptionResolver?i=10">Test ExceptionHandlerExceptionResolver</a>
<br><br>

<form action="/springmvc/testFileUpload" method="POST" enctype="multipart/form-data">
    File: <input type="file" name="file"/>
    Desc: <input type="text" name="desc"/>
    <input type="submit" value="fileUpload"/>
</form>

    <!--
		关于国际化:
		1. 在页面上能够根据浏览器语言设置的情况对文本(不是内容), 时间, 数值进行本地化处理
		2. 可以在 bean 中获取国际化资源文件 Locale 对应的消息
		3. 可以通过超链接切换 Locale, 而不再依赖于浏览器的语言设置情况

		解决:
		1. 使用 JSTL 的 fmt 标签
		2. 在 bean 中注入 ResourceBundleMessageSource 的示例, 使用其对应的 getMessage 方法即可
		3. 配置 LocalResolver 和 LocaleChangeInterceptor
	-->
    <a href="/springmvc/i18n">I18N PAGE</a>
<br><br>

<a href="/springmvc/testResponseEntity">Test ResponseEntity</a>
<br><br>
<form action="/springmvc/testHttpMessageConverter" method="POST" enctype="multipart/form-data">
    File: <input type="file" name="file"/>
    Desc: <input type="text" name="desc"/>
    <input type="submit" value="testResponseEntity"/>
</form>
<br><br>

<a href="/springmvc/testJson" id="testJson">test Json</a>
<br>
<a href="/emps">List All Employees</a>
<br>
<a href="/springmvc/testRedirect">testRedirect</a>
<br>

<a href="/springmvc/testView">testView</a>
<br>

<a href="/springmvc/testViewAndViewResolver">testViewAndViewResolver</a>
<br>

<form action="/springmvc/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1">
    username: <input type="text" name="username"><br>
    email: <input type="email" name="email"><br>
    age: <input type="text" name="age"><br>
    <input type="submit" value="testModelAttibute">
</form>
<a href="/springmvc/testSessionAttributes">testSessionAttributes</a>
<br>
<a href="/springmvc/testMap">testMap</a>
<br>

<a href="/springmvc/testModelAndView">testModelAndView</a>
<br>

<a href="/springmvc/testServletAPI">testServletAPI</a>
<br>

<form action="/springmvc/testPojo" method="post">
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    email: <input type="email" name="email"><br>
    age: <input type="text" name="age"><br>
    province: <input type="text" name="address.province"><br>
    city: <input type="text" name="address.city"><br>
    <input type="submit" value="submitPojo">
</form>
<br>

<a href="/springmvc/testCookieValue">testCookieValue</a>
<br>
<a href="/springmvc/testRequestHeader">testRequestHeader</a>
<br>
<a href="/springmvc/testRequestParam?username=google&age=18">testRequestParam</a>
<br>

<form action="/springmvc/testRestful/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="submitPut">
</form>

<br>
<form action="/springmvc/testRestful/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="submitDelete">
</form>
<br>

<form action="/springmvc/testRestful" method="post">
    <input type="submit" value="submitPost">
</form>
<br>

<a href="/springmvc/testRestful/1">testRestGet</a>
<br>

<a href="/springmvc/testPathVariable/1">testPathVariable</a>
<br>

<a href="/springmvc/testAntPath/x/abc">testAntPath</a>
<br>
<a href="/springmvc/testRequestMapping?username=spring&age=11">testParamsAndHeaders</a>

<h2>Hello World!</h2>
<a href="/hello">Hello Spring Mvc</a>

<br><br>
<a href="/springmvc/testRequestMapping">Hello Spring Test</a>


<br><br>
<a href="/springmvc/testMethod">Method Test</a>

<br><br>
<form action="/springmvc/testMethod" method="post">
    <input type="submit" value="submit">
</form>

</body>
</html>
