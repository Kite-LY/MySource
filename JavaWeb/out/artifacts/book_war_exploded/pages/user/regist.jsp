<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>

	<%--静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		//页面加载完成
		$(function () {
			//给用户名绑定上失去焦点事件
			$("#username").blur(function () {
				//获取输入的用户名
				var username = this.value;
				//发送ajax请求
				$.getJSON("<%=basePath%>/userServlet","action=ajaxExistsUsername&username=" + username,function (data) {
					if(data.existUserName){
						$("span.errorMsg").text("用户名已存在！")
					}else{
						$("span.errorMsg").text("用户名可用！")
					}
				});
			});
			
			
			
			//给验证码绑上单击事件
			$("#code_img").click(function ( ) {
				//重新给验证码附上地址(加上时间断点，让每次浏览器缓存的地址不一样，让图片可以进行刷新！)
				this.src = "${basePath}kaptcha.jpg?d="+ new Date();
			});
			
			
			//绑定按钮
			$("#sub_btn").click(function () {
				//获取输入内容
				var valName = $("#username").val();
				var testName = /^\w{5,12}$/;
				//使用yest方法进行验证(不合法的状况)
				if (!testName.test(valName)){
					$("span.errorMsg").text("用户名不合法")
					//阻止页面进行跳转
					return false
				}

				//密码的注册
				var valPassword = $("#password").val();
				var testPassWord = /^\w{5,12}$/;
				//使用yest方法进行验证(不合法的状况)
				if (!testPassWord.test(valPassword)){
					$("span.errorMsg").text("输入的密码不合法");

					//阻止页面进行跳转
					return false
				}

				//验证确认密码与密码是否相同
				var valPassword = $("#password").val();
				var valRep = $("#repwd").val();
				if(valPassword != valRep){
					$("span.errorMsg").text("确认密码与验证密码不相同");

					//不合法阻止页面跳转
					return false;
				}

				//验证邮箱内容
				var valEmail = $("#email").val();
				var testEmail = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if(!testEmail.test(valEmail)){
					$("span.errorMsg").text("输入的邮箱格式不对");

					//不合法阻止页面跳转
					return false;
				}

				//验证验证吗//验证码内容一般由数据库进行提供
				//trim()除去前后输入的空格
				var valCode = $.trim($("#code").val());


				if(valCode == null || valCode == ""){
					$("span.errorMsg").text("验证码为空！");

					return false;
				}



				//让跳转消息为空
				$("span.errorMsg").text("");
			});
		})
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
                                    <input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   value="${requestScope.username}"
										   autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   value="${requestScope.email}"
										   autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 130px;" name="code" id="code" />
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width:100px; height:30px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>