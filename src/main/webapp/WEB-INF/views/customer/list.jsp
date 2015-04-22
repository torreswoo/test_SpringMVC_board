<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>고객 목록 화면</title>
</head>
<body>

<h1>고객 목록 화면</h1>



<c:if test="${editedCustomer != null}">
  아래 고객이 갱신되었습니다.
  <dl>
    <dt>이름</dt>
    <dd><c:out value="${editedCustomer.name}"/></dd>
    <dt>주소</dt>
    <dd><c:out value="${editedCustomer.address}"/></dd>
    <dt>이메일 주소</dt>
    <dd><c:out value="${editedCustomer.emailAddress}"/></dd>
  </dl>
</c:if>


<table border="1">
  <tr>
    <th>ID</th>
    <th>이름</th>
    <th>주소</th>
    <th>이메일 주소</th>
    <td></td>
  </tr>
  <c:forEach items="${customers}" var="customer">
    <tr>
      <td><c:out value="${customer.id}"/></td>
      <td><c:out value="${customer.name}"/></td>
      <td><c:out value="${customer.address}"/></td>
      <td><c:out value="${customer.emailAddress}"/></td>
      <td>
        <c:url value="/customer/${customer.id}" var="url"/>
        <a href="${url}">상세</a>
        <c:url value="/customer/${customer.id}/edit" var="url"/>
        <a href="${url}">편집</a>
      </td>
    </tr>
  </c:forEach>
</table>


</body>
</html>
