<%--
  Created by IntelliJ IDEA.
  User: 1002475
  Date: 15. 4. 21.
  Time: 오전 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>
    <title>고객 목록 화면</title>
</head>
<body>
    <h2>고객 목록 화면</h2>

    <table border="1">
      <tr>
        <td>ID</td>
        <td>name</td>
        <td>pwd</td>
        <td>email</td>
        <td>phone</td>
      </tr>

      <c:forEach items="${customers}" var="customer">
        <tr>
          <td><c:out value="${customer.id}"></c:out></td>
          <td><c:out value="${customer.name}"></c:out></td>
          <td><c:out value="${customer.pwd}"></c:out></td>
          <td><c:out value="${customer.email}"></c:out></td>
          <td><c:out value="${customer.phone}"></c:out></td>
        </tr>
      </c:forEach>
    </table>


</body>
</html>
