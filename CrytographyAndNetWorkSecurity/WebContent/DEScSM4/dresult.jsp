<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���ܽ��</title>
</head>
<body>
<%
String secret = (String)session.getAttribute("secret");
String key = (String)session.getAttribute("key");
char simple[] = (char[])session.getAttribute("simple");
%>
<h2>���Ľ�������:</h2></br>
����:<%=secret %></br>
��Կ:<%=key %></br>
<h2>���ܽ��:</h2></br>
����:<%=simple %></br>
</br>
<a href="surface.jsp">������ҳ</a>
</body>
</html>