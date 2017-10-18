<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人资料修改</title>
    <link rel="icon" href="images/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="css/personalData.css">
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
                    <li><a href="fundRecord_genius">资金记录
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
                <form name="refer" action="personalData_personal">
                        <p id="p">
                            <button>修改</button>
                        </p>                   
                    <table cellspacing="0">
                        <tr>
                            <td>
                                账户昵称：
                            </td>
                            <td>
                            	<input type="text" name="user.nickname">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                常用地址：
                            </td>
                            <td>
                                <input type="text" name="user.address">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
                            </td>
                            <td>
                                男<input type="radio" name="user.sex" class="radio" value="男">&nbsp;&nbsp;
		    		            女<input type="radio" name="user.sex" class="radio" value="女">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                个性签名：
                            </td>
                            <td id="sign">
                                <textarea name="user.sign"  rows="3" cols="22"></textarea>。
                            </td>
                        </tr>
                        <tr>
                            <td>
                                从事职业：
                            </td>
                            <td>
                                <select name="user.profession">
                                	<option value="程序猿">程序猿</option>
                                	<option value="教师">教师</option>
                                	<option value="医生">医生</option>
                                	<option value="工程师">工程师</option>
                                	<option value="美工师">美工师</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>