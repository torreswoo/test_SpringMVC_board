<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>예외발생(디버그용)</title>
</head>
<body>
<h1>예외발생(디버그용)</h1>
<dl>
  <dt>예외 클래스</dt>
  <dd>${exception.class.name}</dd>
  <dt>메시지</dt>
  <dd>${exception.message}</dd>
</dl>

</body>
</html>