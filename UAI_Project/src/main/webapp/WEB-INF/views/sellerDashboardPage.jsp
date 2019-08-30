<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>UAI-통계 관리</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
		  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
		  
        <!-- Bootstrap CSS -->
    	<link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		<!-- slider 설정 -->
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen">
        <!-- Include jQuery library and Flexslider script -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/flexslider/2.6.3/jquery.flexslider-min.js"></script>
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
		
		<!-- Link Swiper's CSS -->
  		<link rel="stylesheet" href="css/swiper.min.css">
		
        
        <!-- font 설정 -->
        <link rel="stylesheet" href="https://use.typekit.net/kcj1cyn.css">
        
        <!--효은언니가 설정해 둔것-->
        <link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
                
        <style>
         @import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
        @import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);
        @import url(//fonts.googleapis.com/earlyaccess/hanna.css);
        @import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);
          #wrapper{
            width: 1024px;
            margin: 0px auto;
          }
          #top-box{
            width: 1024px;
            height: 215px;
            float: left;
            margin-top: 10px;
            margin-bottom:-10px;
          }
                    #top-small-1{
                      width: 1024px;
                      height: 10px; 
                      float: left;
                    }
                    #top-menu{
                      width:300px;
                      height: 10px;
                      float: right;
                      font-family: lemongrass-caps, sans-serif;
                      font-weight: 200;
                      font-style: normal;
                    } 
                    #top-small-2{
                      width: 1024px;
                      height: 130px;
                      float: left;
                    }
                    #top-logo{
                      width: 130px;
                      height: 120px;
                      margin-left: 230px;
                    }
                    #top-small-3{
                      width: 1024px;
                      height: 60px;
                      float: left;
                    }
                    #top-mini-logo{
                      width: 25px;
                      height: 25px;
                      float: left;
                    }
                    #top-menu-bar{
                      width: 1024px;
                      margin-top: -8px;
                      margin-bottom: -8px;              
                      font-family: 'Nanum Gothic', sans-serif;
                      font-weight: 900;
                      font-style: normal;
                      font-size: 13pt;
                      float: left;
                    }
                    
                    
            #middle-box{
                width: 1024px;
                height: 800px;
                float: left;
                }
                        #middle-small-3{
                            width:900px;
                            height: 250px;
                            float: left;
                        }
                        #middle-slide{
                            width: 1000px;
                            height: 250px;
                            float: left;
                            margin-left: 13px;
                            margin-top:-10px;
                        }
                        #middle-small-1{
	                      width: 216px;
	                      height: 250px;
	                      float: left;
	                      font-family: lemongrass-caps, sans-serif;
	                    }
	                    #login-success-box{
	                    	float: left;
	                    	margin-top:9px;
	                    }
	                    #middle-empty1{
	                    	float: left;
	                    	width: 200px;
	                    	height: 45px;
	                    	font-family: lemongrass-script, sans-serif;
	                    	font-size: 10pt;
	                    	text-align: center;
	                    	margin-bottom:-35px;
	                    	font-weight: 300;
	                    	margin-left: 5px;
	                    	margin-top:10px;
	                    }
	                    #login-success-function{
	                      float: left;
	                      text-align: center;
	                      margin-left: 10px;
	                    }
	                    #logo-login-box-line2{
	                      width: 3px;
	                      height: 160px;
	                      float: right;
	                      margin-right: 15px;
	                    }
	                    #middle-login-box{
	                      width: 160px;
	                      height: 180px;
	                      float: left;
	                      border-radius: 5px;
	                      margin-left: 40px;
	                    }
	                    #logo-login-box-line{
	                      width: 3px;
	                      height: 160px;
	                      float: right;
	                      margin-top: 8px;
	                    }
	                    #sign-in{
	                      width: 140px;
	                      height: 80px;
	                      float: left;
	                      margin-top: 25px;
	                    }
	                    #logo-sign-in{
	                      width: 35px;
	                      height: 40px;
	                      float: left;
	                    }
	                    #sign-up{
	                      width: 140px;
	                      height: 80px;
	                      float: left;
	                      margin-top: 8px;
	                    }
	                    #logo-sign-up{
	                      width: 32px;
	                      height: 30px;
	                      float: left;
	                      margin-left: 3px;
	                    }
	                    .login-function{
	                      float: right;
	                      font-family: lemongrass-caps, sans-serif;
	                      font-weight: 400;
	                      font-style: normal; 
	                      font-size: 18pt;
	                      margin-right: 10px;
	                      margin-top: 3px;   
	                    }
																				                        #middle-small-2{
																				                            width: 795px;
																				                            height: 600px;
																				                            float: left;
																				                            margin-top: 5px;
																				                            font-size: 15pt;
																				                            
																				                        }
																				                        #notice-title{
																				                        	float: left;
																				                        	width: 795px;
																				                        	font-size: 18pt;
																				                        	font-weight: 300;
																				                        	background-color: darkgray;
																				                        	border-radius:5px;
																				                        	color: white;
																				                        	font-family: 'Jeju Gothic', sans-serif;
																				                        }
																				                        #search_box{
																				                        	float:left;
																				                        	font-family: 'Jeju Gothic', sans-serif;
																				                        	font-weight: 400;
																				                        }
																				                        #content_box{
																				                        	float:left;
																				                        	font-family: 'Jeju Gothic', sans-serif;
																				                        	font-size: 8pt;
																				                        
																				                        }
																				                  
																				                       
																										
               #bottom-box{
	            width: 1024px;
	            height: 170px;
	            background-color: darkgray;
	            color: white;
	            float: left;
				margin-top: 80px;	            
	          }
          
              #bottom-phrase{
                font-family: seasoned-hostess, sans-serif;
				font-weight: 400;
				font-style: normal;
				font-size: 15pt;
              	float: right;
              	margin-top:130px;
              	margin-right: 10px;
              }



        </style>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

	  
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
        
    </head>






    <body>
        <div id="wrapper">
           <div id="top-box">
            <div id="top-small-1">
              <div id="top-menu">
                <a style="color: black" href="./mainPage">Main Page</a> | 
                <a style="color: black" href="./logoutAction">LOGOUT</a> | 
                <a style="color: black" href="./boardNoticePage">NOTICE</a> | 
                <a style="color: black" href="./myPage">MY PAGE</a>    
                
              </div>
              </div>
              <div id="top-small-2">
                <div id="top-logo">
                  <a href="./mainPage"><img id="top-logo" src="./img/logo.png"></a>
                </div>
              </div>
              <div id="top-small-3">
                <nav class="navbar navbar-expand navbar-light bg-light sticky-top">
                  <a class="navbar-brand"><img id="top-mini-logo" src="./img/topMiniLogo.png"></a>
                    <ul class="navbar-nav" id="top-menu-bar">
                      <li class="nav-item"><a class="nav-link" href="./sellerIndex.do">Main page</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageProduct.do">상품 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageOrder.do">주문 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageMember.do">회원 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageReview.do">리뷰 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageQnA.do">Q & A 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManagePaycheck.do">지급 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerDashboard">통계 관리</a></li>
		  </ul>
                </nav>
              </div>
            </div><!--top-box div-->
        
        <div id="middle-box">
                <div id="middle-small-1">
                        <c:choose>
		                      <c:when test="${!empty sessionData.ad_idx }">
		                        <div id="middle-empty1">Learn Something Worthy!</div>
		                        <div id="login-success-box">
		                           <h4>Welcome,</h4> <h6>${sessionData.ad_nick}</h6>
		                           <br>
		                           <div id="login-success-function">
		                           <a href="./logoutAction"><button class="btn btn-light">Logout</button></a>
		                           <a href="./sellerIndex.do"><button class="btn btn-info">Settings</button></a>
		                           <br>
		                           </div>

		                        
		                        </div>
		                        <img src="./img/loginBoxLine.png" id="logo-login-box-line2">
		                      </c:when>
		                      
		                      <c:otherwise>
		                         <div class="well" id="middle-login-box">
		                        <img src="./img/loginBoxLine.png" id="logo-login-box-line">
		                        <div id="sign-in">
		                          <img src="./img/signIn.png" id="logo-sign-in"> 
		                          <a class="login-function" style="color: black" href="./loginForm">Sign In</a>
		                        </div>
		                        <div id="sign-up">
		                          <img src="./img/signUp.png" id="logo-sign-up">
		                          <a class="login-function" style="color: black" href="#">Sign Up</a>
		                        </div>
		                      </div>
		                        <!-- Your ID was not found in our Data. Please try it again. <br>
		                        <a href="./loginForm">go back to Login Page</a> <br><br> -->
		                      </c:otherwise>      
                    	</c:choose>
	
                </div><!--middle-small-box-1-->

      
				
                <div id="middle-small-2">
                	<div id="notice-title">
                		▶ 통계 관리
                	</div>
                    <br>
                    <br>
                    <br>

		<div id="content_box" style="overflow: auto;">
					<!--Divs that will hold each control and chart-->
			
			<label>1. 주문관련 통계</label><br>
			<div id="curve_chart1" style="width: 500px; height: 300px; float: left; padding: 10px;"></div>
			<div id="curve_chart2" style="width: 500px; height: 300px; float: right; padding: 10px;"></div>
			<br>
			<label>2. 상품관련 통계</label><br>
			<div id="pie_chart" style="width: 500px; height: 300px; padding: 10px;" ></div>
			
			
		
			</div> <!-- content_box -->
                    
                </div><!--middle-small-box-2-->
              
        </div><!--middle box-->
        
        
        <div id="bottom-box">
        
          	<div id="bottom-phrase">Help | Feedback | Privacy | Terms | ⓒUAI Project Company</div>
        
        
        
        </div><!-- bottom box div -->
        
       </div><!-- wrapper -->
	<!-- Optional JavaScript -->
     <!-- jQuery first, then Popper.js, then Bootstrap JS -->
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>