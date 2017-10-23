<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
<meta name="description" content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
<title>资金记录</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/fundRecord.css">
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
			<div class="user">
				<img src="images/userappear.png" class="appear"> <b>您好，${user.userName}</b>
				<div class="title-right">
					<table>
						<tr>
							<td valign="top"></td>
						</tr>
					</table>
					<p>
						资产总计： <br> ${user.userBalance}元
					</p>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="content-top">
				<ul>
					<li><a href="toMain_redirection.do">资金总计 </a></li>
					<li><a href="fundRecord_genius.do">资金记录 </a></li>
					<li><a href=" ">资金统计 </a></li>
					<li><a href="toCardManage_redirection.do">银行卡管理 </a></li>
					<li><a href=" ">安全中心 </a></li>
					<li><a href=" ">马上借呗 </a></li>
				</ul>
			</div>
			<div class="content-cal">
				<div class="cal-right">
					<b><img src="images/cal.png"></b> <b><img
						src="images/eye.png"></b>
				</div>
			</div>
			<div class="content-center">
				<div class="balance">
					<table>
						<tr>
							<td>交易时间:</td>
							<td>交易金额:</td>
						</tr>
						<c:forEach var="fundRecord" items="${fundRecords}">
							<tr>
								<td>${fundRecord.tradeDate}</td>
								<td>${fundRecord.tradeAccount}</td>
							</tr>
						</c:forEach>
					</table>
					<div class="page">
						<span>
                            <a href="fundRecord_genius.do?i=1">&nbsp;首页&nbsp;</a>
                        </span>   
                        <c:if test="${i>1}">
                            <span>
                               <a href="fundRecord_genius.do?i=${previous}">上一页</a>
                            </span>
                        </c:if>       
                        <c:forEach var="i" begin="1" end="${pages}">
                            <a href="fundRecord_genius.do?i=${i}">&nbsp;${i}&nbsp;</a>
                        </c:forEach>
                        <c:if test="${pages>i}">
                            <span>
                               <a href="fundRecord_genius.do?i=${next}">下一页</a>
                            </span>
                        </c:if>
                         <span>
                            <a href="fundRecord_genius.do?i=${pages}">&nbsp;尾页&nbsp;</a>
                        </span> 
					</div>
				</div>

			</div>
		</div>
	</div>
	<div id="chart">
		<div class="chartTop">
			<form action="#">
				<button>
					<img src="images/addFriend.png" id="addFriend">
				</button>
				<input type="text" name="friendNum">
				<!-- 点击图片获得input的value并提交到指定action -->
			</form>
		</div>
		<div class="chartMsg">${msg}</div>
		<!-- 好友列表div -->
		<!-- 好友上限24个 -->
		<div class="myFriends">
			<a href=""> 18984240332 </a>
		</div>
		<div class="chartBottom">
			<hr>
			<a class="friend" href=""> <img src="images/friend.png">
			</a> <a class="email" href=""> <img src="images/email.png">
			</a>
		</div>
	</div>
	<script src="plugins/jquery.js" type="text/javascript"></script>
	<script src="js/main.js" type="text/javascript"></script>
	
</body>
</html>