<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
	<table border="1">
		<s:iterator id="u" value="books">
			<tr>
				<td><a href="showdetail.action?isbn=<s:property value="#u.isbn" />">
					<s:property value="#u.title" /></a>
				</td>
				<td><a href="deletebook.action?isbn=<s:property value="#u.isbn" />">删除</a>
				</td>
				<td>
				<a href="update.action?isbn=<s:property value="#u.isbn" />">更新</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<br/>
	<a href="index.jsp">返回主页</a>
</body>
</html>