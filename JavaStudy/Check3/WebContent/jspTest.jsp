<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div>
<%@ include file="header.jsp"%>
</div>

<!-- name、idの入力エリアを作成しなさい -->
<div class = "center">
<form action="#" method="post">
<table>
  <tr>
    <td>name</td>
    <td><input type="text" name="name"></td>
  </tr>
  <tr>
    <td>pass</td>
    <td><input type="password" name="pass"></td>
  </tr>
  </table>
  </form>
</div>

<div>
<%@ include file="footer.jsp"%>
</div>

</body>
</html>