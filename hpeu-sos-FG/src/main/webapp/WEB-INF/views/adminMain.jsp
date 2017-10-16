<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon"/> 
<link rel="stylesheet" type="text/css" href="css/adminMain.css">
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
        <font><a href="#" id="genius">后台系统管理</a></font>
        <p><span>
          &nbsp;&nbsp;<a href="">消息中心</a>&nbsp;|
          &nbsp;&nbsp;<a href="">安全退出</a>
        </span></p>
    </div>
    <div id="main">
        <div class="title"></div>
        <div class="content">
            <div class="content-top">
                <ul>
                    <li>&nbsp;&nbsp;&nbsp;&nbsp;<a href="toAdminMain_adminredirection"> 首页
                    </a></li>
                    <li><a href="toAdminUserShow_adminredirection"> 用户查询
                    </a></li>
                    <li><a href=" "> 用户管理
                    </a></li>
                    <li><a href=" "> 消息推送
                    </a></li>
                    <li><a href=" "> 资产分析
                    </a></li>
                </ul>
            </div>
            <div class="content-center">
              
            </div>
        </div>
    </div>
</body>

</html>