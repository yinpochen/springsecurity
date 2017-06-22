<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: chenyinpo
  Date: 2017/6/20
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div>
        <div>
            <c:url var="loginUrl" value="/login"></c:url>
            <form action="${loginUrl}" method="post">
                <c:if test="${param.error != null}">
                    <div>
                        <p>Invalid username and password</p>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div>
                        <p> You have bean logged out successfully.</p>
                    </div>
                </c:if>
                <div>
                   username
                    <input type="text" id="username" name="ssoid" placeholder="Enter username" required>
                </div>
                <div>
                    password
                    <input type="password" id="password" name="password" placeholder="Enter password" required>
                </div>
                <div >
                    <div class="checkbox">
                        <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div>
                    <input type="submit" value="log in">
                </div>
            </form>

        </div>
    </div>
</body>
</html>
