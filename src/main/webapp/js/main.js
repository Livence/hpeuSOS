$(function(){
            $("form").submit(function(){
            	var msg=$("#chart .chartTop input").eq(0).val().replace(/\s+/g,"").length;
                var msgval = $("#chart .chartTop input").eq(0).val().replace(/\s+/g,"");
                if(msg==0){
                    $("#chart .chartMsg").eq(0).text("*账号不能为空！").css("visibility","visible");
                    return false;
                }else if(isNaN(msgval)){
                    $("#chart .chartMsg").eq(0).text("*账户只能是数字").css("visibility","visible");
                    return false;
                }else{
                	$("#chart .chartTop input").eq(0).val(msg);
                	$("#chart .chartTop input").eq(0).val(msgval);
                	return true;
                }

            })
    
    })