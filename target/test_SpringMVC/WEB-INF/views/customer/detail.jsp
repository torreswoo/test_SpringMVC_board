<%--
  Created by IntelliJ IDEA.
  User: 1002475
  Date: 15. 4. 22.
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>고객 정보 화면</title>
</head>
<body>
<h1>고객 정보 화면</h1>
<dl>
  <dt>이름</dt>
  <dd><c:out value="${customer.name}"/></dd>
  <dt>주소</dt>
  <dd><c:out value="${customer.address}"/></dd>
  <dt>이메일 주소</dt>
  <dd><c:out value="${customer.emailAddress}"/></dd>
</dl>
<c:url value="/customer" var="url"/>
<a href="${url}">목록</a>
</body>
</html>