<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
	<h3>查询书籍</h3>
	<s:form action="searchbyname">
	请输入作者名字：
		<s:textfield name="name" />
		<s:submit value="提交" />
	</s:form>
</body>
</html>