<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
<meta name="description"
	content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
<title>银行卡管理</title>
<link rel="stylesheet" type="text/css" href="css/cardManage.css">
<style type="text/css">
* {
	margin: 0px;
}

#main {
	background: url(images/commonBackground.jpg) no-repeat;
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
		<div class="title"></div>
		<div class="content">
			<div class="content-top">
				<ul>
					<li><a href=" "> <span>资金总计</span>
					</a></li>
					<li><a href=" "> <span>资金记录</span>
					</a></li>
					<li><a href=" "> <span>资金统计</span>
					</a></li>
					<li><a href="toCardManage_redirection"> <span>银行卡管理</span>
					</a></li>
					<li><a href=" "> <span>安全中心</span>
					</a></li>
					<li><a href=" "> <span>关于我们</span>
					</a></li>
				</ul>
			</div>
			<div class="content-show">${msg}</div>

			<div class="content-center">
				<div class="center-right">
					<p id="rechange">
						<a href="toRechange_redirection">充值</a>
					</p>
					<p id="add">
						<a href="toAddCard_redirection">添加</a>
					</p>
				</div>
				<form name="refer" action="deleteCard_genius">				
					<table>
					    <c:forEach var="list" items="${cards}">
						<tr>
							<td><input type="hidden" name="cardId" value="${list.id}">
							${list.cardName}</td>
							<td>${list.cardNum}</td>
							<td><button>解绑</button></td>
						</tr>
						</c:forEach>
					</table>				
				</form>
			</div>
		</div>

	</div>

</body>
</html>