<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
<meta name="description" content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
<title>理财精灵注册</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon"/> 
<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
    <div id="top-left">
		<img src="images/logo.png">
	</div>
	<div id="top-right">
	    <font>个人理财精灵</font>
	    <h5>
          &nbsp;&nbsp;<a href="index.jsp">用户登陆界面</a>&nbsp;|
          &nbsp;&nbsp;<a href="#">关于我们</a>&nbsp;
	    </h5>
	</div>
	<div id="main">
		<div class="loginFail">
			<b>${msg}</b>
		</div>	
		<div class="login"> 
		    <h2>帐户注册</h2>
		    <hr>
		    <div class="login-form">
		    <form action="register_skip.action">
		    <h3>注册账户:<input type="text" name="user.userName" placeholder="请输入注册手机号" id="select">
		    	<p>&nbsp;</p>
		    </h3>
		    <h3>注册密码:<input type="password" name="user.password" 
		    placeholder="请输入注册密码">
                <p>&nbsp;</p>
		    </h3>
		    <h3>重复密码:<input type="password" name="repassword" 
		    placeholder="请再次输入密码">
                <p>&nbsp;</p>
		    </h3>
		    <h3>
		    <button id="register">注册</button>
		    <button type="Reset">重置</button>
		    </h3>
		    </form>
		    </div>	    
		</div>
        <div class="main-right">
        	<img src="images/Ad2.png">
        </div>
        <div class="main-left">
        	<img src="images/Ad3.png">
        </div>
        <div class="bottom">
        	<!-- <p>Copyright&copy;理财精灵版权所有</p> -->
        </div>
	</div>	
	<script src="plugins/jquery.js" type="text/javascript"></script>
    <script src="js/register.js" type="text/javascript"></script>
</body>
</html>