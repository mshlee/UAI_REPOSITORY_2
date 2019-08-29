<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Product List Page</title>
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
            height: 1150px;
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
																											                      width: 800px;
																											                      height: 900px;
																											                      float: left;
																											                    }
																											                   
																																                   
																											                    #categories{
																											                      width: 100%;
																											                      height: 30px;
																											                      font-family: 'Jeju Gothic', sans-serif;
																											                      font-wieght: 900;
																											                      font-style: normal;
																											                      font-size: 13pt;
																											                      float: left;
																											                      margin-top: 5px;
																											                    }
																											                    #category{
																											                      width: 450px;
																											                      height: 30px;
																											                      float: left;
																											                    }
																											                    #empty-box{
																											                    	float: left;
																											                    	width: 60px;	
																											                    }
																											                    #search-box{
																											                    	width: 56px;
																											                    	height: 30px;
																											                    	margin-top: -2px;
																											                    	text-align: center;
																											                    	float: right;
																											                    }
																											                    #locations{
																											                    	float: left;
																											                    	width: 800px;
																											                    	height: 100px;
																											                    	background-color: aliceblue;
																											                    	margin-top: 15px;
																											                    	font-family: 'Nanum Gothic', sans-serif;
																										                    	}
																										                    	.menu a{cursor:pointer;}
																																.menu .hide{display:none;}


																										                    	#location-logo{
																										                    		float: left;
																										                    		width: 35px;
																										                    		height: 35px;
																										                    		margin-left: 5px;
																										                    		
																										                    	}
																										                    	#location_info{
																										                    		float: left;
																										                    		font-size: 15pt;
																										                    		margin-top: 5px;
																										                    		font-weight: 700;
																										                    		
																										                    	}
																											                    #location{
																											                    	float: left;
																											                    	font-family: 'Nanum Gothic', sans-serif;
																											                    	font-size: 13pt;
																											                    	width: 700px;
																											                    	height: 80px;
																											                    	margin-left: 28px;
																											                    	margin-top: 3px;
																											                    	
																											                    }
																											                    #count-info{
																											                    	float: left;
																											                    	font-family: 'Nanum Gothic', sans-serif;
																											                    	font-size: 13pt;
																											                    	margin-top: 8px;
																											                    	weight: 800px;
																											                    	height: 50px;
																											                    	font-weight: 700;
																											                    	margin-left:8px;
																											                    }
																											                    #count-info-letter{
																											                    	float: left;
																											                    	margin-top: 5px;
																											                    }
																											                    #product{
																											                    	float: left; 
																											                    	width: 800px;
																											                    	height: 630px;;
																											                    	margin-left: 10px;
																											                    	margin-top: 5px;
																											                    }
																											                    
																											                    #orderBy{
																												                     float: right;
																												                     margin-left: 570px;
																												                     
																											                    }
																											                    
																											                    #product-data{
																											                    	float: left;
																											                    	width: 240px;
																											                    	height: 300px;
																											                    	border-radius: 10px;
																											                    	background-color: #E5E5EA;
																											                    	margin-left: 10px;
																											                    	margin-bottom: 10px;
																											                    }
																											                    
																											                    #pages{
																											                    	float: left;
																											                    	text-align: center;
																											                    	font-size: 12pt;
																											                    	font-family: 'Nanum Gothic', sans-serif;
																											                    	font-weight: 500;
																											                    	width: 800px;
																											                    	height: 20px;
																											                    	color: black;
																											                    }
																											                    
																											                   


          #bottom-box{
            width: 1024px;
            height: 170px;
            background-color: darkgray;
            color: white;
            float: left;
            
          }
             #catchphrase{
                font-family: seasoned-hostess, sans-serif;
                font-weight: 300;
                font-style: normal;
                float: left;
                font-size: 30pt;
                margin-left: 30px;
                color: black;
                margin-top: 10px;
                
              }
              
              #bottom-phrase{
                font-family: seasoned-hostess, sans-serif;
            font-weight: 400;
            font-style: normal;
            font-size: 15pt;
                 float: right;
                 margin-top:50px;
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
        
        <!-- 동연이가 추가한 기능 -->
        
        <script src="http://code.jquery.com/jquery-1.9.0rc1.js"></script> 
        <script type="text/javascript">
			   var loopSearch=true;
			   function keywordSearch(){
			      if(loopSearch==false)
			         return;
			       var value=document.frmSearch.searchWord.value;
			         $.ajax({
			            type : "get",
			            async : true,
			            url : "./autosearchWord",
			            data : {keyword : value},
			            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			            success : function(data) {
			               var jsonInfo = JSON.parse(data);
			                displayResult(jsonInfo);
			            },
			            error : function(data, textStatus) {
			               alert("에러가 발생했습니다."+data);
			            },
			            complete : function(data, textStatus) {
			               //alert("작업을완료 했습니다");
			               
			            }
			         });   
			   }
			   
			   function displayResult(jsonInfo){
			      var count = jsonInfo.keyword.length;
			      if(count > 0) {
			          var html = '';
			          for(var i in jsonInfo.keyword){
			            html += "<a href=\"javascript:select('"+jsonInfo.keyword[i]+"')\">"+jsonInfo.keyword[i]+"</a><br/>";
			          }
			          var listView = document.getElementById("suggestList");
			          listView.innerHTML = html;
			          show('suggest');
			      }else{
			          hide('suggest');
			      }
			   }
			   
			   function show(elementId) {
			       var element = document.getElementById(elementId);
			       if(element) {
			        element.style.display = 'block';
			       }
			      }
			   
			   function hide(elementId){
			      var element = document.getElementById(elementId);
			      if(element){
			        element.style.display = 'none';
			      }
			   }
				
		</script>
        
        <!-- location script -->
        <script>
	    // html dom 이 다 로딩된 후 실행된다.
		    $(document).ready(function(){
		        // memu 클래스 바로 하위에 있는 a 태그를 클릭했을때
		        $(".menu>a").click(function(){
		            // 현재 클릭한 태그가 a 이기 때문에
		            // a 옆의 태그중 ul 태그에 hide 클래스 태그를 넣던지 빼던지 한다.
		            $(this).next("ul").toggleClass("hide");
		        });
		    });
		</script>
		
		<script>
		    // html dom 이 다 로딩된 후 실행된다.
		    $(document).ready(function(){
		        // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
		        $(".menu>a").click(function(){
		            var submenu = $(this).next("ul");
		 
		            // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
		            if( submenu.is(":visible") ){
		                submenu.slideUp();
		            }else{
		                submenu.slideDown();
		            }
		        });
		    });
		</script>


    </head>

    <body>
        <div class="container-fluid" id="wrapper">

          <div id="top-box">
            <div id="top-small-1">
              <div id="top-menu">
                <a style="color: black" href="./mainPage">HOME</a> | 
                <a style="color: black" href="./loginForm">LOGIN</a> | 
                <a style="color: black" href="./boardNoticePage">NOTICE</a> | 
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
                           <a href="./logoutAction"><button class="btn btn-light">Logout</button></a>
                           <a href="./myPage"><button class="btn btn-info">My Page</button></a>
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
                           <a href="./logoutAction"><button class="btn btn-light">Logout</button></a>
                            <a href="./sellerIndex.do"><button class="btn btn-secondary">Settings</button></a>
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
                          <a class="login-function" style="color: black" href="./joinMemberForm">Sign Up</a>
                        </div>
                      </div>
                        <!-- Your ID was not found in our Data. Please try it again. <br>
                        <a href="./loginForm">go back to Login Page</a> <br><br> -->
                      </c:otherwise>      
                    </c:choose>
                    
                    

              </div><!--middle-small-box-1-->

              <div id="middle-small-2">
              		<div id="categories">
		           		<nav class="navbar navbar-expand navbar-dark bg-secondary sticky-top">
		                    <ul class="navbar-nav" id="category">
		                      <li class="nav-item"><a class="nav-link" href="./productListPage">전체 수업</a></li>
		                      <li class="nav-item"><a class="nav-link" href="./productListPage?p_type=0&p_location=&searchWord=&order=">언어</a></li>
		                      <li class="nav-item"><a class="nav-link" href="./productListPage?p_type=1&p_location=&searchWord=&order=">IT/컴퓨터</a></li>
		                      <li class="nav-item"><a class="nav-link" href="./productListPage?p_type=2&p_location=&searchWord=&order=">미술</a></li>
		                      <li class="nav-item"><a class="nav-link" href="./productListPage?p_type=3&p_location=&searchWord=&order=">음악</a></li>
		                      <li class="nav-item"><a class="nav-link" href="./productListPage?p_type=4&p_location=&searchWord=&order=">스포츠</a></li>
		                      <li class="nav-item"><a class="nav-link" href="./productListPage?p_type=5&p_location=&searchWord=&order=">기타</a></li>
		                    </ul>
		                    <div id="empty-box"></div>
		                    <form class="form-inline" name="frmSearch" action="./productListPage?p_type=${p_type}&p_location=${location}" >
		                    	
		                    	<input name="searchWord" class="main_input" type="text" onKeyUp="keywordSearch()" placeholder="Search">
		                    	<br>
		                    	<button class="btn btn-xs btn-light" type="submit" id=search-box >검색</button>
		                    </form>
		                </nav>
			      </div>
	            <div id="suggest">
           			<div id="suggestList"></div>
         		</div>
			      <br>
			      <br>
			      <div id="locations">


					 <ul>
				        <li class="menu">
				            <a><img id="location-logo" src="./img/location-logo.png">
			         			&nbsp;&nbsp;장소를 선택해 주세요</a>
				            <ul class="hide">
						         <c:forEach var="location" items="${locationList}">
						            &nbsp; <a href="productListPage?p_type=${p_type}&p_location=${location}&searchWord=${searchWord}&order=${order}">${location}</a> &nbsp; | 
						         </c:forEach>
				            </ul>
				        </li>
					</ul>

			      
			         
			         <br>
			        
			      </div> <br><br>
      			  
      			  <div id="count-info">  
      			  
      			  <div id="count-info-letter"> ${listCount}건의 강의</div> 
			      
			      <div id="orderBy">
			         <div>정렬 </div>
			         <select name="selectBox" id="selectBox" onChange="location.href=this.value">
			             <c:if test="${order eq null || order == ''}">
			               <option value="./productListPage?order=latest" selected>최신순</option>
			               <option value="./productListPage?order=lowPrice">낮은 가격순</option>
			               <option value="./productListPage?order=highPrice">높은 가격순</option>
			               <option value="./productListPage?order=highSaleCount">구매순</option>
			               <option value="./productListPage?order=highStarRate">별점순</option>
			            </c:if>         
			            <c:if test="${order == 'latest'}">
			               <option value="./productListPage?order=latest" selected>최신순</option>
			               <option value="./productListPage?order=lowPrice">낮은 가격순</option>
			               <option value="./productListPage?order=highPrice">높은 가격순</option>
			               <option value="./productListPage?order=highSaleCount">구매순</option>
			               <option value="./productListPage?order=highStarRate">별점순</option>
			            </c:if>
			            <c:if test="${order == 'lowPrice'}">
			               <option value="./productListPage?order=latest">최신순</option>
			               <option value="./productListPage?order=lowPrice" selected>낮은 가격순</option>
			               <option value="./productListPage?order=highPrice">높은 가격순</option>
			               <option value="./productListPage?order=highSaleCount">구매순</option>
			               <option value="./productListPage?order=highStarRate">별점순</option>
			            </c:if>
			            <c:if test="${order == 'highPrice'}">
			               <option value="./productListPage?order=latest">최신순</option>
			               <option value="./productListPage?order=lowPrice">낮은 가격순</option>
			               <option value="./productListPage?order=highPrice" selected>높은 가격순</option>
			               <option value="./productListPage?order=highSaleCount">구매순</option>
			               <option value="./productListPage?order=highStarRate">별점순</option>
			            </c:if>
			            <c:if test="${order == 'highSaleCount'}">
			               <option value="./productListPage?order=latest">최신순</option>
			               <option value="./productListPage?order=lowPrice">낮은 가격순</option>
			               <option value="./productListPage?order=highPrice">높은 가격순</option>
			               <option value="./productListPage?order=highSaleCount" selected>구매순</option>
			               <option value="./productListPage?order=highStarRate">별점순</option>
			            </c:if>
			            <c:if test="${order == 'highStarRate'}">
			               <option value="./productListPage?order=latest">최신순</option>
			               <option value="./productListPage?order=lowPrice">낮은 가격순</option>
			               <option value="./productListPage?order=highPrice">높은 가격순</option>
			               <option value="./productListPage?order=highSaleCount">구매순</option>
			               <option value="./productListPage?order=highStarRate" selected>별점순</option>
			            </c:if>
			         </select>
			      </div>   
								     
				 </div>
				 <br>
			      <div id="product">
				      <c:forEach var="productData" items="${productDataList }">
				      		<div id="product-data">
					            <a href="./readProductPage?p_idx=${productData.productVO.p_idx }">
					              <img src="${productData.thumbnail}" class="img-rounded" id="product-img" style="width:100px; height:100px">
				                  ${productData.productVO.p_name}<br>
					              ${productData.productVO.p_nowPrice}원
					              ${productData.productVO.p_starRate} 점 / 5 점 | ${productData.productVO.p_teacher } | ${productData.productVO.p_location }
					            </a>
				            </div>
				      </c:forEach> 
			      </div>
			      <br>
			      
			      <div id="pages">
			         <c:if test="${pageVO.startOfPageGroup != 1}">
			            <a href="productListPage?changePage=previous&nowPage=${pageVO.nowPage }&p_type=${p_type}&p_location=${p_location}&searchWord=${searchWord}&order=${order}">이전</a>
			         </c:if>
			         
			         <div>
			            <c:forEach var="i" begin="${pageVO.startOfPageGroup }" end="${pageVO.endOfPageGroup }" step="1">
			               <c:choose>
			                  <c:when test="${i == pageVO.nowPage}">
			                     <div id="nowPage">${i } </div>
			                  </c:when>
			                  <c:otherwise>
			                     <div id="page"><a href="./productListPage?nowPage=${i }&p_type=${p_type}&p_location=${p_location}&searchWord=${searchWord}&order=${order}">${i } </a></div>
			                  </c:otherwise>
			               </c:choose>
			            </c:forEach>
			         </div>
			         
			         <c:if test="${pageVO.endOfPageGroup != pageVO.maxPage}">
			            <a href="./productListPage?changePage=next&nowPage=${pageVO.nowPage }&p_type=${p_type}&p_location=${p_location}&searchWord=${searchWord}&order=${order}">다음</a>
			         </c:if>
			      </div>
              </div><!--middle-small-box-2-->
              
              
          </div><!--middle box div-->
          
          
          <div id="bottom-box">
             
             <div id="catchphrase">
                UAI Project: Let us learn Something Worthy!          
             </div>
             <br>
             <br>
             <div id="bottom-phrase">Help | Feedback | Privacy | Terms | ⓒUAI Project Company</div>
          </div><!--bottom box div-->
       </div> <!--wrapper div-->
    
       <!-- Optional JavaScript -->
       <!-- jQuery first, then Popper.js, then Bootstrap JS -->
       <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>