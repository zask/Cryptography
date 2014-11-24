<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>加密算法</title>
</head>
<body>
<h2>DES与SM4结合算法:</h2>
<h3>加密</h3>
<s:form action="encode">
	<s:textfield name="simple" key="明文(128位,32位十六进制)" value="13ac7b8923fd8c83e21a3182ab8c375c"/>
	<s:textfield name="key"    key="密钥(64位,16位十六进制)" value="ab2341a4eb23f891"/>
	<s:submit value="加密"/>
</s:form>


<h3>解密</h3>
<s:form action="decode">
	<s:textfield name="secret" key="密文(128位,32位十六进制)" value="6624652b2ad4675694dcf04c94790146"/>
	<s:textfield name="key"    key="密钥(64位,16位十六进制)" value="ab2341a4eb23f891"/>
	<s:submit value="解密"/>
</s:form>
</br>
----by Zas.K
</body>
</html>