$(function() {
    $("h3 input").on({
        blur: function() {
            var i = $("h3 input").index(this);
            var vals = $("h3 input").eq(i).val().replace(/\s+/g,"");
            var len = $("h3 input").eq(i).val().replace(/\s+/g,"").length;

            if (i == 0) {
                if (isNaN(vals)) {
                    $("#main .login .login-form p").eq(0).text("*银行卡号只能是数字").css("visibility", "visible");
                }
                if (len == 0) {
                    $("#main .login .login-form p").eq(0).text("*银行卡号不能为空").css("visibility", "visible");
                } else if (len != 19) {
                    $("#main .login .login-form p").eq(0).text("*有效长度在为19位").css("visibility", "visible");
                } else{
                	$("h3 input").eq(i).val(vals);
                }
            }
            if (i == 1) {
                if (len == 0) {
                    $("#main .login .login-form p").eq(1).text("*密码不能为空").css("visibility", "visible");
                } else if (len != 6) {
                    $("#main .login .login-form p").eq(1).text("*有效长度为6位").css("visibility", "visible");
                } else if (isNaN(vals)) {
                    $("#main .login .login-form p").eq(1).text("*密码只能是数字").css("visibility", "visible");
                } else{
                	$("h3 input").eq(i).val(vals);
                }
            }

        },
        focus: function() {
            var i = $("h3 input").index(this);
            $("#main .login .login-form p").eq(i).css("visibility", "hidden")
        }
    })
    $("form").submit(function() {
        var nameval = $("h3 input").eq(0).val().replace(/\s+/g,"");
        var name = $("h3 input").eq(0).val().replace(/\s+/g,"").length;
        var password = $("h3 input").eq(1).val().replace(/\s+/g,"");

        if (name == 0 && password.length == 0) {
            $("#main .login .login-form p").eq(0).text("*银行卡号不能为空！").css("visibility", "visible");
            $("#main .login .login-form p").eq(1).text("*密码不能为空！").css("visibility", "visible");
            return false;
        } else if (name != 19) {
            $("#main .login .login-form p").eq(0).text("*卡号有效长度在为19位！").css("visibility", "visible");
            return false;
        } else if (isNaN(nameval)) {
            $("#main .login .login-form p").eq(0).text("*银行卡号只能是数字").css("visibility", "visible");
            return false;
        } else if (isNaN(password)) {
            $("#main .login .login-form p").eq(1).text("*密码只能是数字").css("visibility", "visible");
            return false;
        } else if (password.length != 6) {
            $("#main .login .login-form p").eq(1).text("*有效长度为6位").css("visibility", "visible");
            return false;
        } else {
        	$("h3 input").eq(0).val(nameval);
        	$("h3 input").eq(1).val(password);
            return true;
        }

    })

})