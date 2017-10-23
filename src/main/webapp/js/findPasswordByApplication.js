$(function() {
    $("h3 input").on({
        blur: function() {
            var i = $("h3 input").index(this);
            var vals = $("h3 input").eq(i).val().replace(/\s+/g,"");
            var len = $("h3 input").eq(i).val().replace(/\s+/g,"").length;

            if (i == 0) {
                if (isNaN(vals)) {
                    $("#main .login .login-form #userNameIn").text("*账户名只能是数字").css("visibility", "visible");
                }
                if (len == 0) {
                    $("#main .login .login-form #userNameIn").text("*账户名不能为空").css("visibility", "visible");
                } else if (len != 11) {
                    $("#main .login .login-form #userNameIn").text("*有效长度在为11位").css("visibility", "visible");
                } else {
                	$("h3 input").eq(i).val(vals);
                }
            }
            if (i == 3) {
                if (len == 0) {
                    $("#main .login .login-form #telNumIn").text("*电话不能为空").css("visibility", "visible");
                }  else if (isNaN(vals)) {
                    $("#main .login .login-form #telNumIn").text("*电话只能是数字").css("visibility", "visible");
                }  else {
                	$("h3 input").eq(i).val(vals);
                }
            }

        },
        focus: function() {
            $("#main .login .login-form #userNameIn").css("visibility", "hidden");
            $("#main .login .login-form #telNumIn").css("visibility", "hidden");
        }
    })
    $("form").submit(function() {
        var nameval = $("h3 input").eq(0).val().replace(/\s+/g,"");
        var name = $("h3 input").eq(0).val().replace(/\s+/g,"").length;
        var password = $("h3 input").eq(1).val().replace(/\s+/g,"");

        if (name == 0 && password.length == 0) {
            $("#main .login .login-form #userNameIn").text("*账户名不能为空！").css("visibility", "visible");
            $("#main .login .login-form #telNumIn").text("*电话不能为空！").css("visibility", "visible");
            return false;
        } else if (name != 11) {
            $("#main .login .login-form #userNameIn").text("*有效长度在为11位！").css("visibility", "visible");
            return 
        } else if (isNaN(nameval)) {
            $("#main .login .login-form #userNameIn").text("*账户名只能是数字！").css("visibility", "visible");
            return false;
        } else if (isNaN(password)) {
            $("#main .login .login-form #telNumIn").text("*电话只能是数字！").css("visibility", "visible");
            return false;
        } else if (password.length==0){
            $("#main .login .login-form #telNumIn").text("*电话不能为空！").css("visibility", "visible");
            return false;
        }else {
        	$("h3 input").eq(0).val(nameval);
        	$("h3 input").eq(1).val(password);
            return true;
        }

    })

})