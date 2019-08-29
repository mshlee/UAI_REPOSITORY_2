<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Board Notice Page</title>
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

      <style>
	      #pages{
		         float: left;
		         text-align: center;
		         margin-left: 400px;
		      }
		      #page{
		         text-align: center;
		         float : left;
		      }
	            #nowPage{
		         float : left;
		         text-align: center;
		         
		      }
	      }
	 </style>
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
                        font-family: seasoned-hostess, sans-serif;
                        font-weight: 900;
                        font-style: normal;
                        font-size: 15pt;
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
																				                            font-size: 13pt;
																				                            
																				                        }
																				                        #notice-title{
																				                        	float: left;
																				                        	width: 795px;
																				                        	font-size: 24pt;
																				                        	font-weight: 550;
																				                        	background-color: darkgray;
																				                        	border-radius:5px;
																				                        	color: white;
																				                        	font-family: seasoned-hostess, sans-serif;
																				                        }
																				                        #notice-view{
																				                        	float: left; 
																				                        	font-family: 'Noto Sans KR', sans-serif;
																				                        	width: 750px;
																										    height: 35px;
																										    margin-left:20px;
																										    margin-top: 10px;
																										    margin-bottom: 15px;
																										    font-size: 13pt;
																			                        	}
																			                        	#notice-table-box{
																				                            width: 100%;
																				                            height: 545px;
																				                            float: left;
																				                            border-radius:10px;
																				                            background-color: aliceblue; 
																				                            margin-top:-20px;
																				                        }
																				                        .dot-line{
																				                        	border:none;
																				                        	border: 1px dashed darkgray;
																				                        	margin-top: 32px;
																				                        	margin-bottom: -4px;
																				                        }
																				                        #notice-view-top{
																				                        	float: left;
																				                        	width: 750px;
																				                        	height: 35px;
																				                        	color: darkgray;
																				                        }
																				                        #go-to-list{
																				                        	float: right;
																				                        	
																				                        }
																				                        #notice-content{
																				                        	float: left;
																				                        	margin-left: 30px;
																				                        	width: 735px;
																				                        	height: 400px;
																				                        	font-size: 16pt;
																				                        	margin-bottom: 10px;
																				                        	
																				                        }
																				                        #logo-writer{
																				                        	float:left;
																				                        	width: 30px;
																				                        	height: 30px;
																				                        	margin-right: -10px;
																				                        }
																				                        #writer{
																				                        	float: left;
																				                        	width: 750px;
																				                        	margin-top: 10px;
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
        <!-- Swiper styles -->
        <style>
            .swiper-container {
                width: 100%;
                height: 100%;
                margin-left: auto;
                margin-right: auto;
            }
            .swiper-slide {
                text-align: center;
                font-size: 18px;
                background: #fff;
                /* Center slide text vertically */
                display: -webkit-box;
                display: -ms-flexbox;
                display: -webkit-flex;
                display: flex;
                -webkit-box-pack: center;
                -ms-flex-pack: center;
                -webkit-justify-content: center;
                justify-content: center;
                -webkit-box-align: center;
                -ms-flex-align: center;
                -webkit-align-items: center;
                align-items: center;
            }
        </style>
    </head>






    <body>
        <div class="container-fluid" id="wrapper">
            <div id="top-box">
                <div id="top-small-1">
                    <div id="top-menu">
	                    <a style="color: black" href="./mainPage">HOME</a> | 
	                	<a style="color: black" href="./loginForm">LOGIN</a> | 
	                	<a style="color: black" href="./noticeBoardPage">NOTICE</a> | 
	                	<a style="color: black" href="./myPage">MYPAGE</a>            
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
							<li class="nav-item"><a class="nav-link" href="./boardNoticePage">Notice</a></li>
                            <li class="nav-item"><a class="nav-link" href="./productListPage">Lecture</a></li>
	                        <li class="nav-item"><a class="nav-link" href="./boardReviewPage">Review</a></li>
	                        <li class="nav-item"><a class="nav-link" href="./boardQnAPage">Q & A</a></li>
                        </ul>
                    </nav>
                    </div>
                </div><!--top-box div-->
        
        <div id="middle-box">

            <div id="middle-small-3">
                <!-- Swiper -->
                <div class="swiper-container" id="middle-slide">
                    <div class="swiper-wrapper">
                  <div class="swiper-slide"><img src="./img/middleSlide0.png"></div>
                  <div class="swiper-slide"><img src="./img/middleSlide1.png"></div>
                  <div class="swiper-slide"><img src="./img/middleSlide2.png"></div>
                  <div class="swiper-slide"><img src="./img/middleSlide3.png"></div>
                    </div> 
                    <!-- Add Pagination --> 
                    <div class="swiper-pagination"></div> 
                    <!-- Add Arrows -->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </div>
                
                <!-- Swiper JS --> 
                <script src="js/swiper.min.js"></script>
                
                <!-- Initialize Swiper -->
                <script>
                    var swiper = new Swiper('.swiper-container', {
                    spaceBetween: 30,
                    loop: true,
                    centeredSlides: true,
                    autoplay: {
                        delay: 3500, //autoplay 시간
                        disableOnInteraction: false,
                    },
                    pagination: {
                        el: '.swiper-pagination',
                        clickable: true
                    },
                    navigation: {
                        nextEl: '.swiper-button-next',
                        prevEl: '.swiper-button-prev',
                    },
                    });
                </script>
                </div><!--middle-small-box-3-->
            

                <div id="middle-small-1">
                        <c:choose>
                            <c:when test="${!empty sessionData.m_idx }">
                              <div id="middle-empty1">Learn Something Worthy!</div>
                              <div id="login-success-box">
                                  <h4>Welcome,</h4> <h6>${sessionData.m_nick }</h6>
                                  <br>
                                  <div id="login-success-function">
                                  <a style="color: black" href="./logoutAction"><button class="btn btn-light">Logout</button></a>
                                  <a href="./mainPage"><button class="btn btn-secondary">◀  Main</button></a>
                                  <br>
                                  </div>
                              </div>
                              <img src="./img/loginBoxLine.png" id="logo-login-box-line2">
                            </c:when>
                            
                            <c:when test="${!empty sessionData.ad_idx }">
                             <div id="middle-empty1">Learn Something Worthy!</div>
                              <div id="login-success-box">
                                  <h4>Welcome,</h4> <h6>${sessionData.ad_nick }</h6>
                                  <br>
                                  <div id="login-success-function">
                                  <a style="color: black" href="./logoutAction"><button class="btn btn-light">Logout</button></a>
                                  <a href="./mainPage"><button class="btn btn-secondary">◀  Main</button></a>
                                  <br>
                                  </div>
                              </div>
                              <img src="./img/loginBoxLine.png" id="logo-login-box-line2">
							<br>
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
                                  <a class="login-function" style="color: black" href="./joinMemberForm">Sign Up</a>
                                </div>
                              </div>
                              <!-- Your ID was not found in our Data. Please try it again. <br>
                              <a href="./loginForm">go back to Login Page</a> <br><br> -->
                            </c:otherwise>		
                          </c:choose>
                    </div><!--middle-small-box-1-->
      
				
                <div id="middle-small-2">
                	<div id="notice-title">
                	▶   NOTICE
                	</div>
                    <br>
                    <br>
                    <br>
                    <div id="notice-table-box"  >
                    <div id="notice-view">
                    	<div id="notice-view-top">
				        	&nbsp;&nbsp; ${boardDataVO.contentDataVO.b_title } &nbsp;&nbsp; | &nbsp;&nbsp; ${boardDataVO.contentDataVO.b_postdate } <br>
				        </div>
						<hr class="dot-line">
						<div id="writer">
							&nbsp;&nbsp;<img src="./img/signUp.png" id="logo-writer"> ${boardDataVO.adminDataVO.ad_nick }<br>
						</div>
						<div id="notice-content" style="overflow:auto;" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${boardDataVO.contentDataVO.b_content } <br>
						</div>
						
						<div id="go-to-list">
							<c:if test="${sessionData.ad_idx !=null && sessionData.ad_idx == boardDataVO.contentDataVO.ad_idx}"> <!-- 비회원일 경우 null.m_idx니까 오류...! -->
								<a style="color: black" href="./deleteContentAction?b_idx=${boardDataVO.contentDataVO.b_idx }"><button class="btn btn-secondary">삭제</button></a>
								<a style="color: black" href="./updateNoticeForm?b_idx=${boardDataVO.contentDataVO.b_idx }"><button class="btn btn-primary">수정</button></a>
							</c:if>
							<a style="color: black" href="./boardNoticePage"><button class="btn btn-info">목록</button></a>
				       </div>
						
							      
					</div><!-- notice-view --> 
							       
                    </div>
                    	
                    
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