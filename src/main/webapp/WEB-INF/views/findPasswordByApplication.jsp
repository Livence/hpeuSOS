<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
<meta name="description" content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
<title>提交申请找回密码</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon"/> 
<link rel="stylesheet" type="text/css" href="css/findPasswordByApplication.css">
</head>
<body>
    <div id="top-left">
		<img src="images/logo.png">
	</div>
	<div id="top-right">
	    <font><a href="index.jsp" id="genius">个人理财精灵</a></font>
	    <h4>填写越详细找回密码的成功率越高哦</h4>
	     <div id="forgetId">
	        <a href="index.jsp">用户登陆界面</a>
	    </div>	
	</div>
	<div id="main">
		<div class="loginFail">		
			<b>${msg}</b>
		</div>	
		<div class="login"> 
		    <h2>填写申请</h2>
		    <hr>
		    <div class="login-form">
		    <b id="userNameIn">&nbsp;</b>
		    <b id="telNumIn">&nbsp;</b>
		    <form action="#">
		    <h3>用户账户:<input type="text" name="userName" placeholder="请输入注册的账户名">
		    </h3>
		    <h3>常住地址:<input type="text" name="address" 
		    placeholder="请输入您个人信息的常住地址"></h3>
		    <h3>个人职业:<input type="text" name="profession" 
		    placeholder="请输入您个人信息的个人职业"></h3>
		    <h3>联系方式:<input type="text" name="telNum" 
		    placeholder="请输入联系电话以便能联系到您"></h3>
		    <h3>申诉补充:&nbsp;&nbsp;<textarea rows="3" cols="26" type="text" name="">
		    </textarea>
            </h3>
		    <h3>
		    <button id="register">提交</button>
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
        	<p>Copyright&copy;理财精灵版权所有</p>
        </div>
	</div>	
	<script src="plugins/jquery.js" type="text/javascript"></script>
    <script src="js/findPasswordByApplication.js" type="text/javascript"></script>
</body>
</html>