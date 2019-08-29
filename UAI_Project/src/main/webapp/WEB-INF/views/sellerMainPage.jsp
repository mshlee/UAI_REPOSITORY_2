<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>UAI-관리자 메인 페이지</title>
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
                      height: 300px;
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
                                                                                                    
                                                                              table {
                                                                               width: 300px;
                                                                               height: 100px;
                                                                               border-top: 1px solid #444444;
                                                                               border-collapse: collapse;
                                                                               font-family: 'Nanum Gothic', sans-serif;
                                                                               margin-left: 12px;
                                                                               font-size: 12pt;
                                                                               float:left;
                                                                               margin-left: 50px;
                                                                           }
                                                                            th, td {
                                                                               border-bottom: 1px solid #444444;
                                                                               padding: 3px;
                                                                               text-align: center;
                                                                               font-family: 'Nanum Gothic', sans-serif;
                                                                           }
                                                                            th {
                                                                               font-family: 'Nanum Gothic', sans-serif;
                                                                             }
                                                                            td {
                                                                               font-family: 'Nanum Gothic', sans-serif;
                                                                             }
                                                                             
                                                                           .white-table{
                                                                              width: 300px;
                                                                               height: 100px;
                                                                               border-top: 1px solid #444444;
                                                                               border-collapse: collapse;
                                                                               font-family: 'Nanum Gothic', sans-serif;
                                                                               margin-left: 12px;
                                                                               font-size: 12pt;
                                                                               float:left;
                                                                               margin-left: 50px;
                                                                           }
                                                                           .white-th, .white-td {
                                                                               border-bottom: 1px solid #444444;
                                                                               padding: 3px;
                                                                               text-align: center;
                                                                               font-family: 'Nanum Gothic', sans-serif;
                                                                           }
                                                                            .white-th {
                                                                               background-color: #bbdefb;
                                                                               font-family: 'Nanum Gothic', sans-serif;
                                                                             }
                                                                            .white-td {
                                                                               background-color: #e3f2fd;
                                                                               font-family: 'Nanum Gothic', sans-serif;
                                                                             }
                                                                            .middle-title{
                                                                               float:left;
                                                                               text-align: left;
                                                                               padding: 8px;
                                                                               margin-left: 15px;
                                                                              font-family: 'Jeju Gothic', sans-serif;
                                                                            }
                                                                             
                                                                                                    #recent-order{
                                                                                                        width: 390px;
                                                                                                        height: 245px;
                                                                                                        float: left;
                                                                                                        background-color: white;
                                                                                                        border-radius:10px;
                                                                                                        text-align:center;
                                                                                                    }
                                                                                                    #recent-lecture{
                                                                                                        width: 390px;
                                                                                                        height: 245px;
                                                                                                        float: left;
                                                                                                        border-radius:10px;
                                                                                                        background-color: aliceblue; 
                                                                                                        text-align:center;
                                                                                                    }
                                                                                                    #recent-QnA{
                                                                                                        width: 390px;
                                                                                                        height: 245px;
                                                                                                        float: left;
                                                                                                        border-radius:10px;
                                                                                                        background-color: aliceblue; 
                                                                                                        text-align:center;
                                                                                                    }
                                                                                                    #recent-review{
                                                                                                        width: 390px;
                                                                                                        height: 245px;
                                                                                                        float: left;
                                                                                                        border-radius:10px;
                                                                                                        background-color: white;
                                                                                                        text-align:center;
                                                                                                    }
                                                                                                    #more{
                                                                                                       float:right;
                                                                                                       margin-right: 20px;
                                                                                                       margin-top: 5px;
                                                                                                       font-family: 'Jeju Gothic', sans-serif;
                                                                                                       font-size: 10pt;
                                                                                                    }
                    


</head>
<body>
    <div id="wrapper">
        <div id="upper_bar"><a href="">쇼핑몰메인</a><a href="">로그아웃</a></div><br>
        <img src="" type="button">
        <div id="header"><a href="./sellerIndex">메인</a> | <a href="./sellerManageProduct">강의 관리</a> | <a href="./sellerManageOrder">주문 관리</a> | <a href="./sellerManageMember">회원관리</a> |  
            <a href="./sellerManageReview">리뷰 관리</a> | <a href="./sellerManageQnA">QnA 관리</a> | <a href="./sellerManagePaycheck">지급 관리</a>
        </div>
        <div id="left_box">
            <div id="admin_menu">

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

    </head>

    <body>
        <div id="wrapper">

          <div id="top-box">
            <div id="top-small-1">
              <div id="top-menu">
                <a style="color: black" href="./mainPage">Main Page</a> | 
                <a style="color: black" href="./logoutAction">LOGOUT</a> | 
                <a style="color: black" href="#">NOTICE</a> | 
                <a style="color: black" href="./myPage">AD PAGE</a>    
                
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
                      <li class="nav-item"><a class="nav-link" href="./sellerIndex">Main page</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageProduct">상품 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageOrder">주문 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageMember">회원 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageReview">리뷰 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManageQnA">Q & A 관리</a></li>
                      <li class="nav-item"><a class="nav-link" href="./sellerManagePayceck">지급 관리</a></li>
                    </ul>
                </nav>
              </div>
            </div><!--top-box div-->
          
            <div id="middle-box">
            
              <div id="middle-small-3">
                 <!-- Swiper -->
              <div class="swiper-container" id="middle-slide">
                <div class="swiper-wrapper">
                  <div class="swiper-slide"><img src="./img/middleSlide4.png"></div>
                  <div class="swiper-slide"><img src="./img/middleSlide4.png"></div>
                  <div class="swiper-slide"><img src="./img/middleSlide4.png"></div>
                  <div class="swiper-slide"><img src="./img/middleSlide4.png"></div>
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
                      <c:when test="${!empty sessionData }">
                        <div id="middle-empty1">Learn Something Worthy!</div>
                        <div id="login-success-box">
                           <h4>Welcome,</h4> <h6>${sessionData.ad_nick}</h6>
                           <br>
                           <div id="login-success-function">
                           <a href="./logoutAction"><button class="btn btn-light">Logout</button></a>
                           <a href="./sellerManageAdmin"><button class="btn btn-info">Settings</button></a>
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
                          <a class="login-function" style="color: black" href="#">AD Sign Up</a>
                        </div>
                      </div>
                        <!-- Your ID was not found in our Data. Please try it again. <br>
                        <a href="./loginForm">go back to Login Page</a> <br><br> -->
                      </c:otherwise>      
                    </c:choose>
              </div><!--middle-small-box-1-->

              <div id="middle-small-2">
                    <div id="recent-order">
                       <div class="middle-title" id="recent-order-title">
                       최근 주문
                       </div>
                       <table class="white-table">
                     <thead>
                       <tr>
                         <th>주문번호</th><th>주문금액</th><th>결제방법</th><th>주문날짜</th>
                       </tr>
                     </thead>
                     <tbody>
                    <c:forEach var="orderListForMain" items="${orderListForMain }" begin="1" end="4" step="1">
                     	<tr>
                         <td>${orderListForMain.o_idx }</td>
                         <td>${orderListForMain.o_id }</td>
                         <td>${orderListForMain.o_o_paymentMethod }</td>
                         <td>${orderListForMain.o_date }</td>
                       </tr>
                       </c:forEach>
                     </tbody>
                   </table>
                  <a href="./sellerManageOrder"><button class="btn btn-link" id="more">더 보기</button></a>                   
                      </div><!-- recent-order -->
                    
                    
                    <div id="recent-lecture">
                       <div class="middle-title" id="recent-lecture-title">
                       최근 상품
                       </div>
                       <table >
                     <thead>
                       <tr>
                        <th>강의번호</th><th>강의명</th><th>강의가격</th><th>등록날짜</th>
                       </tr>
                     </thead>
                     <tbody>
                    <c:forEach var="productListForMain" items="${productListForMain }" begin="1" end="4" step="1">
                     	<tr>
                         <td>${productListForMain.p_idx }</td>
                         <td><a href="./readProductPage?p_idx=${productListForMain.p_idx}">${productListForMain.p_name }</a></td>
                         <td>${productListForMain.p_originalPrice }</td>
                         <td>${productListForMain.p_postdate }</td>
                       </tr>
                       </c:forEach>
                     </tbody>
                   </table>
                   <a href="./sellerManageProduct"><button class="btn btn-link" id="more">더 보기</button></a>
                    </div><!-- recent-lecture -->
                    
                    <br>
                    <div id="recent-QnA">
                       <div class="middle-title" id="recent-QnA-title">
                       최근 QnA
                       </div>
                       <table class="white-table">
                     <thead>
                       <tr>
                         <th>글번호</th><th>제목</th><th>질문유형</th><th>작성날짜</th>
                       </tr>
                     </thead>
                     <tbody>
                    <c:forEach var="qnaListForMain" items="${qnaListForMain }" begin="1" end="4" step="1">
                     	<tr>
                         <td>${qnaListForMain.b_referIdx }</td>
                         <td><a href="./readQnAPageByAdmin?b_idx=${qnaListForMain.b_idx }">${qnaListForMain.b_title }</a></td>
                         <td>${qnaListForMain.b_qCategory }</td>
                         <td>${qnaListForMain.b_postdate }</td>
                       </tr>
                       </c:forEach>
                     </tbody>
                   </table>
                   <a href="./sellerManageQnA"><button class="btn btn-link" id="more">더 보기</button></a>
                    </div><!-- recent QnA -->
                    
                    <div  id="recent-review">
                       <div class="middle-title" id="recent-review-title">
                       최근 리뷰
                       </div>
                       <table>
                     <thead>
                       <tr>
                         <th>글번호</th><th>제목</th><th>별점</th><th>작성날짜</th>
                       </tr>
                     </thead>
                     <tbody>
                     <c:forEach var="reviewListForMain" items="${reviewListForMain }" begin="1" end="4" step="1">
                     	<tr>
                         <td>${reviewListForMain.b_referIdx }</td>
                         <td><a href="./readReviewPage?b_idx=${reviewListForMain.b_idx }">${reviewListForMain.b_title }</a></td>
                         <td>${reviewListForMain.b_starrate }</td>
                         <td>${reviewListForMain.b_postdate }</td>
                       </tr>
                       </c:forEach>
                     </tbody>
                   </table>
                   <a href="./sellerManageReview"><button class="btn btn-link" id="more">더 보기</button></a>
                    </div><!-- recent-review -->
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