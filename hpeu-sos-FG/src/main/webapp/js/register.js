$(function(){
            $("h3 input").on({
                blur:function(){ 
                    var i = $("h3 input").index(this);
                    var vals = $("h3 input").eq(i).val();
                    var len = $("h3 input").eq(i).val().length;                   
                        if(i==0){
                        	if(isNaN(vals)){
                                 $("p").eq(0).text("*账户名称只能是数字").css("visibility","visible");
                            }
                            if(len==0){
                                $("p").eq(0).text("*账户名称不能为空").css("visibility","visible");
                        }else if(len!=11){
                               $("p").eq(0).text("*有效长度在为11位").css("visibility","visible");
                        }
                       }
                        if(i==1){
                           if(len==0){
                               $("p").eq(1).text("*密码不能为空").css("visibility","visible");
                           }else if(len<6||len>20&&len!=0){
                               $("p").eq(1).text("*有效长度在6~20之间").css("visibility","visible");
                           }
                       }
                        if(i==2){
                           var a =$("h3 input").eq(1).val(),b=$("h3 input").eq(2).val();
                           if(len==0){
                               $("p").eq(2).text("*重复密码不能为空").css("visibility","visible")    ;
                           }else if(a!=b){
                               $("p").eq(2).text("*两次输入密码不一致").css("visibility","visible");
                           }else{
                               $("p").eq(2).css("visibility","hidden");
                           }
                       }
              },focus:function(){var i = $("h3 input").index(this);
                     $("p").eq(i).css("visibility","hidden")}
            })
            $("form").submit(function(){
                var nameval = $("h3 input").eq(0).val();
                var name=$("h3 input").eq(0).val().length;
                var password=$("h3 input").eq(1).val();

                if(name==0&&password.length==0){
                    $("p").eq(0).text("*账号不能为空！").css("visibility","visible");
                    $("p").eq(1).text("*密码不能为空！").css("visibility","visible");
                    return false;
                }else if(name!=11){
                    $("p").eq(0).text("*账号长度为11位！").css("visibility","visible");
                    return false;
                }else if(isNaN(nameval)){
                    $("p").eq(0).text("*账户名称只能是数字").css("visibility","visible");
                    return false;
                }else if(password.length<6||password.length>20){
                    $("p").eq(1).text("*密码有效长度在6~20之间").css("visibility","visible");
                    return false;
                }else if(password!=repassword){
                    $("p").eq(2).text("*两次输入密码不一致！").css("visibility","visible");
                    return false;
                }else{
                    return true;
                }

            })
            
})