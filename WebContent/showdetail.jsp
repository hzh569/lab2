<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
书籍信息:<br />
ISBN: <s:property value="book.isbn" /><br />
标题: <s:property value="book.title" /><br />
出版社: <s:property value="book.publisher" /><br />
出版日期: <s:property value="book.publishDate" /><br />
价格: <s:property value="book.price" /><br />
<br />
作者信息: <br />
姓名: <s:property value="book.author.name" /><br />
年龄: <s:property value="book.author.age" /><br />
国籍: <s:property value="book.author.country" /><br />
<br/>
<a href="deletebook.action?isbn=<s:property value="book.isbn" />">删除</a><br/>
<a href="update.action?isbn=<s:property value="book.isbn" />">更新</a><br/>
</body>
</html>