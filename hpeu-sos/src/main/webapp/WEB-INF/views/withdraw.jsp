<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
    <meta name="description" content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
	<title>账户提现</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
    <style type="text/css">
        *{
            margin: 0px;
        }
         #main{
           background:url(images/commonBackground.jpg) no-repeat;
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
		    <h2>账户提现</h2>
		    <hr>
		    <div class="login-form">
		    <form action="withdraw_genius">
		    <h3>提现卡号：
		    	<select name="cardId">
		     	    <c:forEach var="list" items="${cards}">
		    	        <option value="${list.id}">${list.cardNum}</option>
		    	    </c:forEach>
		        </select>
		    </h3>
		    <h3>提现金额:<input type="text" name="tradeBalance" placeholder="请输入提现金额">
		    </h3>
		    <h3>
		    <button id="register">提现</button>
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
</body>
</html>