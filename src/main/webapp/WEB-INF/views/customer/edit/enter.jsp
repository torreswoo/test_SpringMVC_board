<%--
  Created by IntelliJ IDEA.
  User: 1002475
  Date: 15. 4. 21.
  Time: 오후 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>입력화면</title>
</head>
<body>
  <h1>입력화면</h1>

  <%-- model의 어트리뷰트로지정한 곳으로 --%>
  <form:form modelAttribute="editCustomer">
    <dl>
      <dt> name </dt>
      <dd>
        <form:input path="name"></form:input>
        <form:errors path="name"></form:errors>
      </dd>

      <dt> address </dt>
      <dd>
        <form:input path="address"></form:input>
        <form:errors path="address"></form:errors>
      </dd>

      <dt> email </dt>
      <dd>
        <form:input path="emailAddress"></form:input>
        <form:errors path="emailAddress"></form:errors>
        <form:errors path="ngEmail"></form:errors>
      </dd>
    </dl>

    <%--_event_proceed이벤트 드리븐방식--%>
    <button type="submit" name="_event_proceed">다음</button>
  </form:form>


</body>
</html>
