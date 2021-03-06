<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
<meta name="description" content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
<title>账户充值</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/addcard.css">
</head>
<body>
    <div id="top-left">
        <img src="images/logo.png">
    </div>
    <div id="top-right">
        <font><a href="toMain_redirection.do" id="genius">个人理财精灵</a></font>
        <p><span> &nbsp;&nbsp;
	    	 <a href="toMain_redirection.do">首页</a>&nbsp;| &nbsp;&nbsp;
	    	 <a href="topersonalCenter_redirection.do">个人中心</a>&nbsp;| &nbsp;&nbsp;
	    	 <a href="toNews_redirection.do">消息</a>&nbsp;| &nbsp;&nbsp;
	    	 <a href="toCancel_redirection.do">退出</a>
            </span>
        </p>
    </div>
    <div id="main">
        <div class="loginFail">
            <b>${msg}</b>
        </div>
        <div class="login">
            <div class="msgShow">
                
            </div>
            <h2>账户充值</h2>
            <hr>
            <div class="login-form">
                <form action="rechange_genius.do" method="post">
                    <h3>支付方式：
		    	<select name="cardId">
		    	<c:forEach var="list" items="${cards}">
		    	    <option value="${list.id}">${list.cardNum}</option>
		    	</c:forEach>
		        </select>
		    </h3>
                    <h3>充值金额:<input type="text" name="tradeBalance" placeholder="请输入充值金额">
		    </h3>
                    <h3>
		    <button id="register">充值</button>
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
    <script src="js/common.js" type="text/javascript"></script>
</body>
</html>