<%--
  Created by IntelliJ IDEA.
  User: YJ-HDC
  Date: 2019/4/9
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/Demo02Action_findUser" method="post">
        <input type="text" name="username">
        <input type="submit" value="go">
        <s:fielderror fieldName="username"></s:fielderror>
    </form>

    <form action="/Demo04Action_findDate" method="post">
        <input type="text" name="birthday">
        <input type="submit" value="go">
    </form>

</body>
</html>
