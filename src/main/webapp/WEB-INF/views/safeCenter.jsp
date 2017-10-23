<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>安全中心</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/safeCenter.css">   
</head>
<body>
    <div id="top-left">
        <img src="images/logo.png">
    </div>
    <div id="top-right">
        <font><a href="toMain_redirection" id="genius">个人理财精灵</a></font>
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
                    <li><a href=" ">资金总计
                    </a></li>
                    <li><a href=" ">资金记录
                    </a></li>
                    <li><a href=" ">资金统计
                    </a></li>
                    <li><a href="toAddCard_redirection">银行卡管理
                    </a></li>
                    <li><a href=" ">安全中心
                    </a></li>
                    <li><a href=" ">关于我们
                    </a></li>
                </ul>
            </div>
            <div class="content-show">${msg}</div>
            <div class="content-center">
                <form name="refer" action="#">
                        <p id="p">
                            <button>修改</button>
                        </p>                   
                    <table cellspacing="0">
                        <tr>
                            <td>
                                真实姓名：
                            </td>
                            <td>
                            	<input type="text" name="name" placeholder="请填写您的真实姓名">
                            	<span>&nbsp;</span>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                身份证号：
                            </td>
                            <td>
                                <input type="text" name="IDNum" placeholder="请填写您的身份证号码">
                                <span>&nbsp;</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                               月均收入：
                            </td>
                            <td>
                                <input type="text" name="income" placeholder="请填写您的月均收入">
                                <span>&nbsp;</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                常住地址：
                            </td>
                            <td id="sign">
                               <input type="text" name="address" placeholder="请填写您的常住地址">
                               <span>&nbsp;</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                支付密码：
                            </td>
                            <td>
                            	<input type="password" name="payWord" placeholder="请设置六位数字支付密码">
                            	<span>&nbsp;</span>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script src="plugins/jquery.js" type="text/javascript"></script>
    <script src="js/safeCenter.js" type="text/javascript"></script>
</body>
</html>