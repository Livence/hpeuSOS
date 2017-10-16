<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon"/> 
<link rel="stylesheet" type="text/css" href="css/adminUseShwo.css">
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
                    <li>&nbsp;&nbsp;&nbsp;&nbsp;<a href=" toAdminMain_adminredirection"> 首页
                    </a></li>
                    <li><a href="toAdminUserShow_adminredirection">用户查询
                    </a></li>
                    <li><a href=" ">用户管理
                    </a></li>
                    <li><a href=" ">消息推送
                    </a></li>
                    <li><a href=" ">资产分析
                    </a></li>
                </ul>
            </div>
            <div class="content-show">${msg}</div>

            <div class="content-center">
                <table cellspacing="0">
                    <tr>
                        <td>
                            用户id
                        </td>
                        <td>
                            用户名称
                        </td>
                        <td>
                            用户余额
                        </td>
                        <td>
                            用户职业
                        </td>
                        <td>
                            用户积分
                        </td>
                    </tr>
                    <c:forEach var="${allUsers}" items="allUser">
                    <tr>
                        <td>
                            ${allUser.id}
                        </td>
                        <td>
                            ${allUser.userName }
                        </td>
                        <td>
                            ${allUser.IDNumber }
                        </td>
                        <td>
                            ${allUser.profession }
                        </td>
                        <td>
                            ${allUser.sex }
                        </td>
                         <td>
                            ${allUser.address }
                        </td>
                         <td>
                            ${allUser.income }
                        </td>
                        <td>
                            ${allUser.userBalance }
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