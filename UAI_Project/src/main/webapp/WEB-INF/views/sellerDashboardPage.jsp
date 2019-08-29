<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UAI-통계 관리</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script type="text/javascript">


</script>

	  
<script type="text/javascript">	   
	  
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawSumChart);

      function drawSumChart() {
        var data = google.visualization.arrayToDataTable([
          ['날짜', '총 주문액'],
          ['2019-08-28',  100000],
          ['2018-08-29',  200000],
          ['2018-08-30',  100000],
          ['2018-09-01',  200000]
        ]
        		
        );

        var options = {
          title: '일별 주문액 통계(원)',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart1'));

        chart.draw(data, options);
      }
      
      
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawAvgChart);
      
      function drawAvgChart() {
          var data = google.visualization.arrayToDataTable([
            ['날짜', '건당 평균 주문액'],
            ['2019-08-28',  1000],
            ['2018-08-29',  5000],
            ['2018-08-30',  8000],
            ['2018-09-01',  4000]
          ]);

          var options = {
            title: '일별 주문 건당 평균 주문액 통계(원)',
            curveType: 'function',
            legend: { position: 'bottom' }
          };

          var chart = new google.visualization.LineChart(document.getElementById('curve_chart2'));

          chart.draw(data, options);
        }
      
      
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawCountChart);
       

      function drawCountChart() {

        var data = google.visualization.arrayToDataTable([
          ['강의 이름', '수강건수'],
          ['강의1',     10],
          ['강의2',      9],
          ['강의3',  8]
        ]);

        var options = {
          title: 'TOP 3 강의 (수강건수 기준)',
       	  pieHole: 0.4,
       	
        };

        var chart = new google.visualization.PieChart(document.getElementById('pie_chart'));

        chart.draw(data, options);
      }
      
      
      

    </script>

 

<style>
#wrapper {
	width: 1366px;
	height: 900px;
	border: solid black 0.3px;
	margin: 50px auto;
}

#upper_bar {
	float: right;
}

#header {
	width: 1166px;
	height: 100px;
	border: solid black 0.3px;
	float: right;
	padding: 10px;
}

#left_box {
	width: 200px;
	height: 500px;
	float: left;
	border: solid black 0.3px;
}

#admin_menu {
	width: 180px;
	height: 100px;
	margin: 5px auto;
	border: solid black 0.3px;
}

#content_box {
	overflow: auto;
	width: 1100px;
	height: 750px;
	margin: 5px auto;
	border: solid black 0.3px;
	float: right;
}
</style>


</head>
<body>
	<div id="wrapper">
		<div id="upper_bar">
			<a href="">쇼핑몰 메인</a><a href="">로그아웃</a>
		</div>

		<br> <img src="" type="button">
		<div id="header">
			<a href="./sellerIndex">메인</a> | <a href="./sellerManageProduct">강의
				관리</a> | <a href="./sellerManageOrder">주문 관리</a> | <a
				href="./sellerManageMember">회원 관리</a> | <a
				href="./sellerManageReview">리뷰 관리</a> | <a href="./sellerManageQnA">QnA
				관리</a> | <a href="./sellerManagePaycheck">지급 관리</a> | <a
				href="./sellerDashboard">통계 관리</a>
		</div>
		<div id="left_box">
			<div id="admin_menu">
				<c:choose>
					<c:when test="${!empty sessionData }">
				환영합니다.<br>${sessionData.ad_nick }<br>
						<a href="./logoutAction"><button>로그아웃</button></a>
						<br>
						<a href="./sellerManageAdmin"><button>관리자계정설정</button></a>
					</c:when>
					<c:otherwise>
						<a href="./loginForm">관리자 로그인</a>
					</c:otherwise>
				</c:choose>
			</div>
			<br>

		</div>
		<div id="content_box">
		
		<search>
		<c:forEach items="${result }" var="result">
		<result>
		<c:out value="${result.s_dailySum }"/>
		<c:out value="${result.s_date }"/>
		</result>
		</c:forEach>
		</search>


			<!--Divs that will hold each control and chart-->
			<div id="dashWrapper">
			<label>1. 주문관련 통계</label><br>
			<div id="order_wrapper">
					<div id="curve_chart1" style="width: 500px; height: 300px; float: left; padding: 10px;"></div>
			<div id="curve_chart2" style="width: 500px; height: 300px; float: right; padding: 10px;"></div>
			</div><br>
			<label>2. 상품관련 통계</label><br>
			<div id="pie_chart" style="width: 500px; height: 300px; padding: 10px;" ></div>
			
			
		</div>




		</div>
	</div>
	<br>




	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
</body>
</html>