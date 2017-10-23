$(function() {
	$("h3 input").on({
        focus: function() {
            var i = $("h3 input").index(this);
            $("#main .msgShow").eq(0).css("visibility", "hidden")
        }
    })
    $("form").submit(function() {
        var nameval = $("h3 input").eq(0).val().replace(/\s+/g,"");
        var name = $("h3 input").eq(0).val().replace(/\s+/g,"").length;
        if (name == 0 ) {
            $("#main .msgShow").text("*金额不能为空！").css("visibility", "visible");
            return false;
        } else if (name > 5) {
             $("#main .msgShow").text("*金额上限100000！").css("visibility", "visible");
            return false;
        } else if (isNaN(nameval)) {
             $("#main .msgShow").text("*金额只能是数字").css("visibility", "visible");
            return false;
        } else {
        	nameval = $("h3 input").eq(0).val(nameval);
            return true;
        }

    })

})