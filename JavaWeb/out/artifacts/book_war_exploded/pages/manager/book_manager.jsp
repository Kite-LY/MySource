<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%--静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%></head>
	<script type="text/javascript">
		$(function () {
			//给删除的a标签绑定单击事件，确定是否要进行删除
			$("a.deleteClass").click(function () {
				/**
				 * confirm:是确认提示框函数
				 * 参数是它的提示内容
				 * 它有两个按钮，一个确认，一个取消
				 * 确认：true     取消：false
				 * （注意：如果return false 表示阻止默认行为，则为a标签不提交请求）
				 */
				//在事件的function()函数中，有一个this对象，这个this对象就是正在响应的dom对象
				//$(this).parent().parent().find("td:first").text():首先将dom对象转换为JQuery对象，再通过a标签的父元素为td，再找父元素tr，再查找tr的第一个td元素中的文本内容就可以获取book.name属性
				return confirm("您确定要删除《"+$(this).parent().parent().find("td:first").text()+"》图书吗？")
			});

		});

	</script>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<%--
				通过forEach遍历request域中的数据
				requestScope域中对应的key标签books
				var="book" 表示遍历的对象都是book对象
			--%>
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="bookServlet?action=getBook&id=${book.id}">修改</a></td>
					<%--创建class 绑定单击事件--%>
					<td><a class="deleteClass" href="bookServlet?action=delete&id=${book.id}">删除</a></td>
				</tr>
			</c:forEach>



			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>
		</table>

		<%--静态包含分页条--%>
		<%@include file="/pages/common/page_nav.jsp"%>


	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>