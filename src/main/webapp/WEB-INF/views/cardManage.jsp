<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
<meta name="description" content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
<title>银行卡管理</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon"/> 
<link rel="stylesheet" type="text/css" href="css/cardManage.css">
</head>
<body>
    <div id="top-left">
        <img src="images/logo.png">
    </div>
    <div id="top-right">
        <font><a href="toMain_redirection.do" id="genius">个人理财精灵</a></font>
        <p><span>
          &nbsp;&nbsp;<a href="toMain_redirection.do">首页</a>&nbsp;|
          &nbsp;&nbsp;<a href="toProblem_redirection.do">常见问题</a>&nbsp;|
          &nbsp;&nbsp;<a href="toNews_redirection.do">消息</a>&nbsp;|
	      &nbsp;&nbsp;<a href="toCancel_redirection.do">退出</a>
	    </span></p>
    </div>
    <div id="main">
        <div class="title"></div>
        <div class="content">
            <div class="content-top">
                <ul>
                    <li><a href=" "> 资金总计
					</a></li>
                    <li><a href="fundRecord_genius.do"> 资金记录
					</a></li>
                    <li><a href=" "> 资金统计
					</a></li>
                    <li><a href="toAddCard_redirection.do"> 银行卡管理
					</a></li>
                    <li><a href=" "> 安全中心
					</a></li>
                    <li><a href=" "> 关于我们
					</a></li>
                </ul>
            </div>
            <div class="content-show">${msg}</div>
            <div class="content-center">
                <div class="center-right">
                    <p id="rechange">
                        <a href="toRechange_redirection.do">充值</a>
                    </p>
                    <p id="add">
                        <a href="toAddCard_redirection.do">添加</a>
                    </p>
                </div>
                    <table>
                         <c:forEach var="list" items="${cards}">
                        <tr>
                            <td><input type="hidden" name="cardId" value="${list.id}">
                            ${list.cardName}</td>
                            <td>${list.cardNum}</td>
                            <td><a href="deleteCard_genius.do?cardId=${list.id}">解绑</a></td>
                        </tr>
                        </c:forEach>
                    </table>
            </div>
        </div>
    </div>
</body>
</html>