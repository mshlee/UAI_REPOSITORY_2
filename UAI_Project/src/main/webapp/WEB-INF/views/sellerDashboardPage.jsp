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

<!--Load the AJAX API-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
	
<script type="text/javascript">
	// Load the Visualization API and the controls package.
	// Packages for all the other charts you need will be loaded
	// automatically by the system.
	google.charts.load('current', {
		'packages' : [ 'corechart', 'controls' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawDashboard);

	// Callback that creates and populates a data table,
	// instantiates a dashboard, a range slider and a pie chart,
	// passes in the data and draws it.
	function drawDashboard() {

		var dashboard = new google.visualization.Dashboard(document
				.getElementById('dashboard_div'));

		// Create our data table.
		var data = google.visualization.arrayToDataTable([ [ '날짜', '총 주문금액' ],
				[ '2019-08-28', 1000000 ], [ '2019-08-29', 1500000 ],
				[ '2019-08-30', 1000000 ], [ '2019-09-01', 800000 ] ]);

		var options = {
			title : '일별 주문금액 추이',
			curveType : 'function',
			legend : {
				position : 'bottom'
			}
		};

		var programmaticSlider = new google.visualization.ControlWrapper({
			'controlType' : 'DateRangeFilter',
			'containerId' : 'programmatic_control_div',
			'options' : {
				'filterColumnLabel' : '날짜 조정',
				'ui' : {
					'labelStacking' : 'vertical'
				}
			}
		});

		var chart = new google.visualization.LineChart(document
				.getElementById('curve_chart'));

		dashboard.bind(programmaticSlider, chart);

		chart.draw(data, options);
	}
	
	//JSON 객체 받아오기 테스트
	var paramOne =<c:out value="${dashVO}"/>
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


			<!--Divs that will hold each control and chart-->
			<div id="dashboard_div">
				<div id="programmatic_control_div"></div>
				<div id="curve_chart"></div>
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