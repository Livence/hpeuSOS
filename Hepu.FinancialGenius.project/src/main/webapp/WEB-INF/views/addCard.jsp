<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
    <meta name="description" content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
	<title>银行卡添加</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
    <style type="text/css">
        *{
            margin: 0px;
        }
         #main{
           background:url(images/registerBackground.jpg) no-repeat;
        }
    </style>
</head>
<body>
    <div id="top-left">
		<img src="images/logo.png">
	</div>
	<div id="top-right">
	    <font>个人理财精灵</font>
	    <p><span>
          &nbsp;&nbsp;<a href="toMain_redirection">首页</a>&nbsp;|
          &nbsp;&nbsp;<a href="toProblem_redirection">常见问题</a>&nbsp;|
          &nbsp;&nbsp;<a href="toNews_redirection">消息</a>&nbsp;|
	      &nbsp;&nbsp;<a href="toCancel_redirection">退出</a>
	    </span></p>
	</div>
	<div id="main">
		<div class="loginFail">
			<b>${msg}</b>
		</div>	
		<div class="login"> 
		    <h2>银行卡添加</h2>
		    <hr>
		    <div class="login-form">
		    <form action="addCard_genius">
		    <h3>所属银行：
		    	<select name="cardName">
		     	    <option value="农业银行">农业银行</option>
		     	    <option value="工商银行">工商银行</option>
		     	    <option value="中国银行">中国银行</option>
		     	    <option value="交通银行">交通银行</option>
		     	    <option value="建设银行">建设银行</option>
		     	    <option value="邮政储蓄">邮政储蓄</option>
		        </select>
		    </h3>
		    <h3>银行卡号:<input type="text" name="cardNum" placeholder="请输入绑定的银行卡号">
		    </h3>
		    <h3>此卡密码:<input type="password" name="cardPwd" 
		    placeholder="请输入银行卡密码"></h3>
		    <h3>   
		    <button type="Reset">重置</button>
		    <button id="register">添加</button>
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
	
</body>
</html>