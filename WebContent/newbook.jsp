<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
	<h3>新增书籍</h3>
	<s:form action="newbook">
		<s:textfield label="ISBN" name="isbn" />
		<s:textfield label="标题" name="title" />
		<s:textfield label="作者姓名" name="authorName" />
		<s:textfield label="作者年龄" name="authorAge" />
		<s:textfield label="作者国籍" name="authorCountry" />
		<s:textfield label="出版社" name="publisher" />
		<s:textfield label="出版日期" name="publishDate" />
		<s:textfield label="价格" name="price" />
		<s:submit value="提交" />
	</s:form>
</body>
</html>