<!--
* NAME		: productView.jsp
* DESC		: 상품정보보기 페이지
* VER		: 1.0
-->

<%@page import="product.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   errorPage="error.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품정보수정</title></head>

<body>

<center>
<h1>상품정보수정</h1>

<%
	int num = Integer.parseInt(request.getParameter("num"));
	String writer = request.getParameter("writer");
	String name = request.getParameter("name");
%>
<form action="/product/update?num=<%=num %>" method="post" name="update">
  <table border=1>
	<tr > 
		<td width=103 align="center" height=40>번호</td>
        <td width=400><%=num %></td>
      </tr>
      <tr> 
		<td width="103" align="center" height=40>등록자</td>
        <td><%=writer%></td>
      </tr>
      <tr>
		<td align="center" height=40>상품명</td>
		<td><%=name%></td>
      </tr>
      <tr>
		<td colspan=2 align="center" height=100>
			<textarea name=content rows=10 cols=70></textarea>
		</td>
      </tr>
  </table>
  
  <input type="submit" name="update" value="수 정">
  </form>
</center>

</body>
</html>		
