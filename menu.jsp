<%@page import="product.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<html>
<head>
<title>상품정보관리</title>
</head>
<body bgcolor="#eeeeff">
<table align="left" cellspacing="0" cellpadding="0">
   	<tr height="25">
   		<td colspan="3">&nbsp;</td>
   	</tr>
   	<tr height="40"><td></td></tr>
   	<%
   		Product entity=(Product)session.getAttribute("logOK");
   		if(entity != null)
   		{
   	%>
   		<tr><td width="400" align="center"><a href="result.jsp" target="main">[HOME]</a> </td></tr>
   		<tr height="40"><td align="center"><a href="product/productInput.jsp" target="main">상품등록</a></td></tr>
   		<tr height="40"><td align="center"><a href="/product/list" target="main">상품전체조회</a></td></tr>
   		<tr height="40"><td align="center"><a href="/product/logout" target="main">로그아웃</a></td></tr>
	<%
		}else{
	%>
	
		<tr><td width="400" align="center"><a href="login.jsp" target="main">[HOME]</a> </td></tr>
   		<tr height="40"><td align="center"><a href="login.jsp" target="main">로그인</a></td></tr>
   		<%} %>

    <!--  구현 하시오.JSTL을 이용하시오 -->

        	
</table>
</body>
</html>
