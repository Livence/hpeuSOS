<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
<meta name="description" content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
<title>我的消息</title> 
<link rel="icon" href="images/logo.ico" type="image/x-icon"/> 
<link rel="stylesheet" type="text/css" href="css/msg.css">
</head>
<body>
    <div id="top-left">
        <img src="images/logo.png">
    </div>
    <div id="top-right">
        <font><a href="toMain_redirection.do" id="genius">个人理财精灵</a></font>
        <p>
            欢迎您，尊敬的<b>&nbsp;&nbsp;${user.userName}</b> <span> &nbsp;&nbsp;<a
                href="toMain_redirection.do">首页</a>&nbsp;| &nbsp;&nbsp;<a
                href="topersonalCenter_redirection.do">个人中心</a>&nbsp;| &nbsp;&nbsp;<a
                href="toNews_redirection.do">消息</a>&nbsp;| &nbsp;&nbsp;<a
                href="toCancel_redirection.do">退出</a>
            </span>
        </p>
    </div>
    <div id="main">
        <div class="title">
            
        </div>
        <div class="content">
            <div class="content-top">
                <ul>
                    <li><a href=" "> 资金总计
                    </a></li>
            </div>
            
            <div class="myMsg">
                <div class="myMsgTop">
                    <div class="msgDelete">
                    	<a href="">
                    		<img src="images/reply.png">
                    	</a>                   	
                    </div>
                    <div class="msgReply">
                    	<a href="">
                    		<img src="images/delete.png">
                    	</a>
                    </div>
                </div>	
                <div class="myMsgCentent">
                	消息放在这里面~ 
                </div>
            </div>
        </div>
        
    </div>
    <div id="chart">
        <div class="chartTop">
        	<form action="#">
            <button>
                <img src="images/msgs.png">
            </button>    	    	
         	<input type="text" name="friendNum" id="myMsgs">
         	<!-- 点击图片获得input的value并提交到指定action -->
         	</form>  
        </div>
        <div class="chartMsg">
        	&nbsp;
        </div>
        <!-- 好友列表div -->
        <!-- 好友上限24个 -->
        <div class="myFriends">
            <a href="">
                18984240332
            </a>

        </div>
    	
    	<div class="chartBottom">
    		<hr>
    		<a class="friend" href="">
    			<img src="images/friend.png">
    		</a>
    		<a class="email" href="" >
    			<img src="images/email.png">
    		</a>	   		
    	</div>
    </div>
    <script src="plugins/jquery.js" type="text/javascript"></script>
    <script src="js/main.js" type="text/javascript"></script>
</body>
</html>