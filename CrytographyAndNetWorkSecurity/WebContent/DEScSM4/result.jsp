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
String simple = (String)session.getAttribute("simple");
String key = (String)session.getAttribute("key");
char[] secret = (char[])session.getAttribute("secret");
%>
<h2>���ļ�������:</h2></br>
����:<%=simple %></br>
��Կ:<%=key %> </br>
<h2>���ܽ��:</h2></br>
����:<%=secret %></br>
</br>
<a href="surface.jsp">������ҳ</a>
</body>
</html>