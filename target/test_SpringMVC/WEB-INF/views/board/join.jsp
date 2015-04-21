<%--
  Created by IntelliJ IDEA.
  User: 1002475
  Date: 15. 4. 20.
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
    <title></title>
</head>
<body>
    <h1> write !</h1>
    <h2> 회원정보 받기 </h2>

  <div>

    <form method="post" action="register.jsp">
      <div>
        name : <input type="text" name="name" size="20"></br>
        userid : <input type="text" name="userid" size="20"></br>
        pwd : <input type="text" name="pwd" size="20"></br>
        email : <input type="text" name="email" size="20"></br>
        phone : <input type="text" name="phone" size="20"></br>
      </div>

      <input type="submit" value="전송">
      <input type="reset" value="취소">
    </form>

  </div>

</body>
</html>
