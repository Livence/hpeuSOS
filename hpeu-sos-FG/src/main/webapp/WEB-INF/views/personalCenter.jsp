<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>个人资料查看</title>
    <link rel="icon" href="images/logo.ico" type="image/x-icon"/> 
    <link rel="stylesheet" type="text/css" href="css/personalCenter.css">
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
        <font><a href="toMain_redirection" id="genius">个人理财精灵</a></font>
        <p><span>
          &nbsp;&nbsp;<a href="toMain_redirection">首页</a>&nbsp;|
          &nbsp;&nbsp;<a href="topersonalCenter_redirection">个人中心</a>&nbsp;|
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
                <div class="center-right">
                    <p id="p">
                        <a href="topersonalData_redirection">个人资料修改</a>
                    </p>
                </div>
                <form name="refer" action="deleteCard_genius">
                    <table cellspacing="0">
                        <c:forEach var="list" items="${cards}">
                            <tr>
                                <td>
                                    账户昵称：
                                </td>
                                <td>
                                    
                                </td>
                            </tr>
                            <tr>    
                                <td>
                                    账户昵称：
                                </td>
                                <td>
                                   无花果的忧伤 
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
                                </td> 
                                <td>
                                    男
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    个性签名：
                                </td>
                                <td id="sign">
                                    韶华白首，不过转瞬。唯天道永恒，往返不复。
                                </td>
                            </tr>
                             <tr>    
                                <td>
                                    从事职业：
                                </td>
                                <td>
                                    程序猿
                                </td>
                            </tr>
                            <tr>    
                                <td>
                                    信誉积分：
                                </td>
                                <td>
                                    333
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>

</html>