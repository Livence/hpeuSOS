<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
<meta name="description" content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
<title></title>
<link rel="icon" href="images/logo.ico" type="image/x-icon"/> 
<link rel="stylesheet" type="text/css" href="css/adminLogin.css">
</head>
<body>
	<div id="top-left">
		<img src="images/logo.png">
	</div>
	<div id="top-right">
		 <font>网站管理系统</font>
	</div>
	<div id="main">
		<div class="loginFail">
			<b>${msg}</b>
		</div>
		<div class="login">
			<h2>管理员登录</h2>
			<hr>
			<div class="login-form">
				<form action="adminLogin_admin.action">
					<h3>
						<img src="images/username.png"><input type="text"
							name="adminstorName" placeholder="请输入您的账号">
						<h4>&nbsp;</h4>	
					</h3>
					<h3>
						<img src="images/password.png"> <input type="password"
							name="adminstorPassword" placeholder="请输入您的密码">
						<h4>&nbsp;</h4>	
					</h3>
					<h3>
						<button id="signUp">登录</button>
						<button type="Reset" id="reset">重置</button>
					</h3>
				</form>
			</div>
		</div>
		<div class="main-right">
			<img src="images/Ad1.png">
		</div>
		<div class="bottom">
			<!-- <p>Copyright&copy;理财精灵版权所有</p> -->
		</div>
	</div>
    <script src="plugins/jquery.js" type="text/javascript"></script>
    <script src="js/adminLogin.js" type="text/javascript"></script>
</body>
</html>