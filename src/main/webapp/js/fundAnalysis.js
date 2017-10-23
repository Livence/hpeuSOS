var pieData = [
				{   
					value: 1,
					color:"#F38630",
					lable:"wwww",
				},
				
		     	{
					value : 3,
					color : "#69D2E9"
				},
			];

var myPie = new Chart(document.getElementById("canvas1").getContext("2d")).Pie(pieData);


var lineChartData = {
			labels : ["Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec"],
			datasets : [
				{
					fillColor : "rgba(151,187,205,0.1)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					data : [7000.0,5000.0,800.0,6000.0,10000.0,3000.0,8000.0,4500.0,521.0,2000.0,9000.0,6000.0]
				}
			]
			
		}

	var myLine = new Chart(document.getElementById("canvas2").getContext("2d")).Line(lineChartData);
	var myLine = new Chart(document.getElementById("canvas2").getContext("2d")).Line(lineChartData,{ 
                          
            
            tooltipCornerRadius: 0, // 小提示的圆角     
            bezierCurveTension: 0,  // 折线的曲线过渡，0是直线，默认0.4是曲线
            bezierCurve: false,     // 关闭曲线功能
            scaleOverride :false ,  //是否用硬编码重写y轴网格线
            scaleSteps : 15,        //y轴刻度的个数
            scaleStepWidth : 1000,  //y轴每个刻度的宽度
            scaleStartValue : 0,    //y轴的起始值
            pointDot : true,        //是否显示点
            pointDotRadius : 3,     //点的半径
            pointDotStrokeWidth : 1,//点的线宽
            datasetStrokeWidth : 1, //数据线的线宽
            animation : true,       //是否有动画效果
            animationSteps : 60     //动画的步数 
	});
	