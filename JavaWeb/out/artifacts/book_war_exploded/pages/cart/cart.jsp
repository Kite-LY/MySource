<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			//给删除按钮绑定单击事件
			$("a.deleteItem").click(function () {
				//提示信息
				return confirm("你确定要删除【"+ $(this).parent().parent().find("td:first").text() +"】?");
			});

			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车！");
			});

			//给输入框绑定change()事件:输入框中的值改变的时候，就回显示的提示信息
			$(".updateCount").change(function () {
				var count = this.value;
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr("bookId");
				if(confirm("你确定要修改【"+name+"】数量为"+count+"")){
					//发请求给服务器保存修改
					location.href="<%=basePath%>cartServlet?action=updateCount&count="+count+"&id="+id;
				}else{
					//defaultValue为dom对象中默认的value属性值
					this.value = this.defaultValue;
				}

			});

		});
	</script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--静态包含登录成功之后的菜单--%>
		<%@include file="/pages/common/login_sucess_menu.jsp" %>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<%-- 为空的情况下！ --%>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲！当前购物车为空！请去首页挑选</a></td>
				</tr>
			</c:if>

			<c:if test="${not empty sessionScope.cart.items}">
				<%-- 遍历cart中的信息--%>
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input bookId="${entry.value.id}"
								   class="updateCount" style="width: 60px"
								   type="text" value="${entry.value.count}"/>
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>



			
		</table>
		<%--购物车为空的时候，应该进行隐藏--%>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

	
	</div>
	

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>