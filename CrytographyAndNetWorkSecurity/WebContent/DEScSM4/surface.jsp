<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�����㷨</title>
</head>
<body>
<h2>DES��SM4����㷨:</h2>
<h3>����</h3>
<s:form action="encode">
	<s:textfield name="simple" key="����(128λ,32λʮ������)" value="13ac7b8923fd8c83e21a3182ab8c375c"/>
	<s:textfield name="key"    key="��Կ(64λ,16λʮ������)" value="ab2341a4eb23f891"/>
	<s:submit value="����"/>
</s:form>


<h3>����</h3>
<s:form action="decode">
	<s:textfield name="secret" key="����(128λ,32λʮ������)" value="6624652b2ad4675694dcf04c94790146"/>
	<s:textfield name="key"    key="��Կ(64λ,16λʮ������)" value="ab2341a4eb23f891"/>
	<s:submit value="����"/>
</s:form>
</br>
----by Zas.K
</body>
</html>