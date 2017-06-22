<%--
  Created by IntelliJ IDEA.
  User: chenyinpo
  Date: 2017/6/20
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
  Dear <strong>${user}</strong>,welcome boarding.
  <a href="<c:url value="/logout"/> ">Logout</a>
  <br/><br/>
  <div>
      <label>View all information | this part is visible to Everyone</label>
  </div>
  <div>
      <sec:authorize access="hasRole('ADMIN')">
          <label>
              <a href="#">Edit this page</a> | this part is visible only to ADMIN
          </label>
      </sec:authorize>
      <div>
          <sec:authorize access="hasRole('ADMIN') and hasRole('DBA')">
              <label>
                  <a href="#">Start backup</a> | this part is visible only who is both admin and dba.
              </label>
          </sec:authorize>
      </div>


  </div>
</body>
</html>
