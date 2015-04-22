<%--
  Created by IntelliJ IDEA.
  User: 1002475
  Date: 15. 4. 21.
  Time: 오후 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>갱신완료</title>
</head>
<body>

  <h2>갱신완료</h2>

  <dl>
    <dt> name </dt>
    <dd><c:out value="${editCustomer.name}"></c:out></dd>
    <dt> phone </dt>
    <dd><c:out value="${editCustomer.phone}"></c:out></dd>
    <dt> email </dt>
    <dd><c:out value="${editCustomer.email}"></c:out></dd>
  </dl>

  <c:url var="url" value="/customer"/>
  <a href="${url}">뒤로</a>

</body>
</html>
