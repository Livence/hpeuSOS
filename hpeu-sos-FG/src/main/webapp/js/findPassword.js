$(function() {
    $("h3 input").on({
        blur: function() {
            var i = $("h3 input").index(this);
            var vals = $("h3 input").eq(i).val();
            var len = $("h3 input").eq(i).val().length;

            if (i == 0) {
                if (isNaN(vals)) {
                    $("#main .login .login-form p").eq(0).text("*账户名只能是数字").css("visibility", "visible");
                }
                if (len == 0) {
                    $("#main .login .login-form p").eq(0).text("*账户名不能为空").css("visibility", "visible");
                } else if (len != 11) {
                    $("#main .login .login-form p").eq(0).text("*账户名有效长度在为11位").css("visibility", "visible");
                }
            }
            if (i == 1) {
                if (len == 0) {
                    $("#main .login .login-form p").eq(1).text("*身份证号不能为空").css("visibility", "visible");
                } else if (len != 18) {
                    $("#main .login .login-form p").eq(1).text("*身份证号有效长度为18位").css("visibility", "visible");
                } else if (isNaN(vals)) {
                    $("#main .login .login-form p").eq(1).text("*身份证号只能是数字").css("visibility", "visible");
                }
            }

        },
        focus: function() {
            var i = $("h3 input").index(this);
            $("#main .login .login-form p").eq(i).css("visibility", "hidden")
        }
    })
    $("form").submit(function() {
        var nameval = $("h3 input").eq(0).val();
        var name = $("h3 input").eq(0).val().length;
        var password = $("h3 input").eq(1).val();

        if (name == 0 && password.length == 0) {
            $("#main .login .login-form p").eq(0).text("*账户名不能为空！").css("visibility", "visible");
            $("#main .login .login-form p").eq(1).text("*身份证号不能为空！").css("visibility", "visible");
            return false;
        } else if (name != 11) {
            $("#main .login .login-form p").eq(0).text("*账户名有效长度在为11位！").css("visibility", "visible");
            return false;
        } else if (isNaN(nameval)) {
            $("#main .login .login-form p").eq(0).text("*账户名只能是数字").css("visibility", "visible");
            return false;
        } else if (isNaN(password)) {
            $("#main .login .login-form p").eq(1).text("*身份证号只能是数字").css("visibility", "visible");
            return false;
        } else if (password.length != 18) {
            $("#main .login .login-form p").eq(1).text("*身份证号有效长度为18位").css("visibility", "visible");
            return false;
        } else {
            return true;
        }

    })

})