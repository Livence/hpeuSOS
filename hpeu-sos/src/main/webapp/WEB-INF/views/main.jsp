<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="理财精灵，票据理财，投资理财，网上投资，网络理财。">
<meta name="description"
    content="理财精灵是一家国有绝对控股企业（100%国有资产）的互联网金融平台，是银行承兑汇票散户投资需求平台，由银行承担验票、保管、到期托收并结算的责任">
<title>理财精灵主页</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
* {
    margin: 0px;
}

#main {
    background: url(images/commonBackground.jpg) no-repeat;
}

#main .title {
    background: url(images/user-bg.png);
}
</style>
</head>
<body>
    <div id="top-left">
        <img src="images/logo.png">
    </div>
    <div id="top-right">
        <font>个人理财精灵</font>
        <p>
            欢迎您，尊敬的<b>&nbsp;&nbsp;${user.userName}</b> <span> &nbsp;&nbsp;<a
                href="toMain_redirection">首页</a>&nbsp;| &nbsp;&nbsp;<a
                href="toProblem_redirection">常见问题</a>&nbsp;| &nbsp;&nbsp;<a
                href="toNews_redirection">消息</a>&nbsp;| &nbsp;&nbsp;<a
                href="toCancel_redirection">退出</a>
            </span>
        </p>
    </div>
    <div id="main">
        <div class="title">
            <div class="user">
                <img src="images/userappear.png" class="appear"> <img
                    src="images/pic.png"> <b>您好，${user.userName}</b>
                <div class="title-right">
                    <table>
                        <tr>
                            <td valign="top"></td>
                        </tr>
                    </table>
                    <p>
                        资产总计：<br> ${user.userBalance}元
                    </p>
                </div>
            </div>
        </div>
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
                    <li><a href=" "> <span>马上借呗</span>
                    </a></li>
                </ul>
            </div>
            <div class="content-cal">
                <div class="cal-right">
                    <b><img src="images/cal.png"></b> <b><img
                        src="images/eye.png"></b>
                </div>
            </div>
            <div class="content-show">${msg}</div>
            <div class="content-center">
                <div class="balance">
                    <p>
                        总余额(元)：<br>${user.userBalance}
                    </p>
                    <div class="operation">
                        <a href="toRechange_redirection" id="rechange">充值</a> <a
                            href="toWithdraw_redirection" id="withdraw">提现</a>
                    </div>
                </div>
                <div class="profit">
                    <p>
                        累计收益(元)：<br> ${0.1}
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>