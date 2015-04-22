<%--
  Created by IntelliJ IDEA.
  User: 1002475
  Date: 15. 4. 22.
  Time: 오후 3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>지정된 고객을 찾을 수 없습니다</title>
</head>
<body>
<h1>지정된 고객을 찾을 수 없습니다</h1>
<c:url value="/customer" var="url"/>
<a href="${url}">목록 화면으로 돌아간다</a>
</body>
</html>