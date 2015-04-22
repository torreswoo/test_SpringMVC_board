<%--
  Created by IntelliJ IDEA.
  User: 1002475
  Date: 15. 4. 21.
  Time: 오후 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>확인 화면</title>
</head>
<body>
<h1>확인 화면</h1>
<form method="post">
  <dl>
    <dt>이름</dt>
    <dd><c:out value="${editCustomer.name}"/></dd>
    <dt>주소</dt>
    <dd><c:out value="${editCustomer.address}"/></dd>
    <dt>이메일 주소</dt>
    <dd><c:out value="${editCustomer.emailAddress}"/></dd>
  </dl>
  <button type="submit" name="_event_confirmed">갱신</button>
  <button type="submit" name="_event_revise">재입력</button>
</form>
</body>
</html>