$(function() {
    $("#main .content .content-center td input").on({
            blur: function() {
                var i = $("#main .content .content-center td input").index(this);
                var vals = $("#main .content .content-center td input").eq(i).val().replace(
                    /\s+/g, "");
                var len = $("#main .content .content-center td input").eq(i).val().replace(/\s+/g,
                    "").length;
                if (i == 0) {
                    if (len == 0) {
                        $("#main .content .content-center  td span").eq(0).text("*姓名不能为空").css(
                            "visibility", "visible");
                    }  else {
                        $("#main .content .content-center td input").eq(i).val(vals);
                    }
                }
                if (i == 1) {
                    if (len == 0) {
                        $("#main .content .content-center  td span").eq(1).text("*ID不能为空").css(
                            "visibility", "visible");
                    } else if (len != 18) {
                        $("#main .content .content-center  td span").eq(1).text("*有效长度为18位").css(
                            "visibility", "visible");
                    } else {
                        $("#main .content .content-center td input").eq(i).val(vals);
                    }
                }
                if (i == 2) {
                	if (isNaN(vals)) {
                        $("#main .content .content-center  td span").eq(2).text("*收入只能是数字").css(
                            "visibility", "visible");
                    }
                    if (len == 0) {
                        $("#main .content .content-center  td span").eq(2).text("*收入不能为空").css(
                            "visibility", "visible");
                    }  else {
                        $("#main .content .content-center td input").eq(i).val(vals);
                    }
                }
                if (i == 3) {
                    if (len == 0) {
                        $("#main .content .content-center  td span").eq(3).text("*地址不能为空").css(
                            "visibility", "visible");
                    }  else {
                        $("#main .content .content-center td input").eq(i).val(vals);
                    }
                }
                if (i == 4) {
                	if (isNaN(vals)) {
                        $("#main .content .content-center  td span").eq(4).text("*只能是数字").css(
                            "visibility", "visible");
                    }
                    if (len == 0) {
                        $("#main .content .content-center  td span").eq(4).text("*密码不能为空").css(
                            "visibility", "visible");
                    } else if (len != 6) {
                        $("#main .content .content-center  td span").eq(4).text("*有效长度为6位").css(
                            "visibility", "visible");
                    } else {
                        $("#main .content .content-center td input").eq(i).val(vals);
                    }
                }
            },
            focus: function() {
                var i = $("#main .content .content-center td input").index(this);
                $("#main .content .content-center  td span").eq(i).css("visibility", "hidden")
            }
        })
    $("form").submit(function() {
        var nameval = $("#main .content .content-center td input").eq(0).val().replace(/\s+/g, "");
        var name = $("#main .content .content-center td input").eq(0).val().replace(/\s+/g, "").length;
        var idNum = $("#main .content .content-center td input").eq(1).val().replace(/\s+/g, "");
        var income = $("#main .content .content-center td input").eq(2).val().replace(/\s+/g, "");
        var address = $("#main .content .content-center td input").eq(3).val().replace(/\s+/g, "");
        var payPwd = $("#main .content .content-center td input").eq(4).val().replace(/\s+/g, "");
        if (name == 0 && idNum.length == 0&&income.length==0&&address.length==0) {
            $("#main .content .content-center  td span").eq(0).text("*姓名不能为空").css("visibility", "visible");
            $("#main .content .content-center  td span").eq(1).text("*ID号码不能为空").css("visibility", "visible");
            $("#main .content .content-center  td span").eq(2).text("*收入不能为空").css("visibility", "visible");
            $("#main .content .content-center  td span").eq(3).text("*地址不能为空").css("visibility", "visible");
            return false;
        } else if (idNum.length!= 18) {
            $("#main .content .content-center  td span").eq(0).text("*ID长度为11位！").css("visibility", "visible");
            return false;
        } else if (!isNaN(name)) {
        	$("#main .content .content-center  td span").eq(0).text("*姓名不包含数字").css("visibility", "visible");
          
            return false;
        } else if (idNum.length!=18) {
           $("#main .content .content-center  td span").eq(1).text("*有效长度为18位").css("visibility", "visible");
            return false;
        } else if (address.length==0) {
            $("#main .content .content-center  td span").eq(3).text("*地址不能为空").css("visibility", "visible");
            return false;
        } else if (income.length==0) {
           $("#main .content .content-center  td span").eq(2).text("*收入不能为空").css("visibility", "visible");
            return false;
        } else if (isNaN(income)) {
            $("#main .content .content-center  td span").eq(2).text("*收入只能是数字").css("visibility", "visible");
            return false;
        } else if (payPwd.length==0) {
           $("#main .content .content-center  td span").eq(4).text("*密码不能为空").css("visibility", "visible");
            return false;
        } else if (isNaN(payPwd)) {
           $("#main .content .content-center  td span").eq(4).text("*只能是数字为空").css("visibility", "visible");
            return false;
        } else {
            $("#main .content .content-center td input").eq(0).val(nameval);
            $("#main .content .content-center td input").eq(1).val(idNum);
            $("#main .content .content-center td input").eq(2).val(income);
            $("#main .content .content-center td input").eq(3).val(address);
            $("#main .content .content-center td input").eq(4).val(payPwd);
            return true;
        }

    })

})