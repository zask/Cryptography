<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>解密结果</title>
</head>
<body>
<%
String secret = (String)session.getAttribute("secret");
String key = (String)session.getAttribute("key");
char simple[] = (char[])session.getAttribute("simple");
%>
<h2>您的解密输入:</h2></br>
密文:<%=secret %></br>
密钥:<%=key %></br>
<h2>解密结果:</h2></br>
明文:<%=simple %></br>
</br>
<a href="surface.jsp">返回主页</a>
</body>
</html>