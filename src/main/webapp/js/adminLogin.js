$(function(){
            $("h3 input").on({
                blur:function(){ 
                    var i = $("h3 input").index(this);
                    var vals = $("h3 input").eq(i).val().replace(/\s+/g,"");
                    var len = $("h3 input").eq(i).val().replace(/\s+/g,"").length;
                        if(i==0){
                            if(len==0){
                                $("h4").eq(0).text("*账户名称不能为空").css("visibility","visible");
                        }
                       }
                        if(i==1){
                           if(len==0){
                               $("h4").eq(1).text("*密码不能为空").css("visibility","visible");
                           }else if(len<6||len>20&&len!=0){
                               $("h4").eq(1).text("*有效长度在6~20之间").css("visibility","visible");
                           }else{
                        	   $("h3 input").eq(i).val(vals);
                           }
                       }
                  
              },focus:function(){var i = $("h3 input").index(this);
                     $("h4").eq(i).css("visibility","hidden")}
            })
            $("form").submit(function(){
                var nameval = $("h3 input").eq(0).val().replace(/\s+/g,"");
                var name=$("h3 input").eq(0).val().replace(/\s+/g,"").length;
                var password=$("h3 input").eq(1).val().replace(/\s+/g,"");

                if(name==0&&password.length==0){
                    $("h4").eq(0).text("*账号不能为空！").css("visibility","visible");
                    $("h4").eq(1).text("*密码不能为空！").css("visibility","visible");
                    return false;
                }else if(password.length<6||password.length>20){
                    $("h4").eq(1).text("*密码有效长度在6~20之间").css("visibility","visible");
                    return false;
                }else{
                	$("h3 input").eq(0).val(nameval);
                	$("h3 input").eq(1).val(password);
                    return true;
                }
            })
    })