<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenyinpo
  Date: 2017/6/20
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>DBA</title>
</head>
<body>
Dear <strong>${user}</strong>,welcome to dba page.
<a href="<c:url value="/logout"/>">logout</a>
</body>
</html>
