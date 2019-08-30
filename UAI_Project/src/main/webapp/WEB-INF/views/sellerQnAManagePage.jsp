<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>UAI-QnA 관리</title>
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
																				                        	width: 800px;
																				                        	height: 500px;
																				                        	float:left;
																				                        	font-family: 'Jeju Gothic', sans-serif;
																				                        	font-size: 10pt;
																				                        	overflow: auto;
																				                        
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

<script type="text/javascript">

function delchk(){
    return confirm("정말 삭제하시겠습니까?");
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
                		▶ QnA 관리
                	</div>
                    <br>
                    <br>
                    <br>
                	<div id="search_box">
                            <form action="./sellerManageQnA" method="get">
            <table>
            <tr class="table-primary">
            <th>작성일</th>
                <th><input type="date" name="startDate">~<input type="date" name="endDate"></th></tr>
               
            <tr class="table-secondary">
            <th>질문유형</th>
               <th><input type="radio" name="radioboxValue" value="0">강의문의 |
               <input type="radio" name="radioboxValue" value="1">결제문의</th>
                    </tr>
            
            <tr class="table-primary">
                <th>키워드</th>
                <th><select name="keyword">
              		<option></option>
              		<option value="B_REFERIDX">글번호</option>
              		<option value="B_TITLE">글제목</option>
              		<option value="P_IDX">강의번호</option>
              		<option value="P_NAME">강의명</option>
                    <option value="M_IDX">회원번호</option>
                    <option value="M_ID">아이디</option>
                </select><input type="text" name="value"></th>
            </tr>
            <tr class="table-secondary">
                <th>
                <button type="submit" style="float: right">검색</button></th>
            </tr>
            </table>
                </form>
        </div><br>
		<div id="content_box">
		<form action="./sellerDeleteQnAsByIdx" name="list" method="post" onsubmit="return confirm('정말 삭제하시겠습니까?')">
			<table class="table-responsive table-hover">
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">no.</th>
						<th scope="col">글번호</th>
						<th scope="col">강의번호</th>
						<th scope="col">강의명</th>
						<th scope="col">회원번호</th>
						<th scope="col">아이디</th>
						<th scope="col">닉네임</th>
						<th scope="col">회원명</th>
						<th scope="col">질문유형</th>
						<th scope="col">글제목</th>
						<th scope="col">조회수</th>
						<th scope="col">작성일</th>
						<th scope="col">답변작성</th>
						<th scope="col">문의글 삭제</th>
					</tr>
				</thead>

				<tbody>
				
						<!--lhe: forEach문으로 반복해서 리스트 가져오기-->
						<c:forEach var="qnaDataList" items="${qnaDataList }">
						<tr>
							<th scope="row"><input type="checkbox" name="idx[]" value="${qnaDataList.contentDataVO.b_referIdx}"></th>
							<th scope="row">  </th>
							<th scope="row">${qnaDataList.contentDataVO.b_referIdx }</th>
							<th scope="row">${qnaDataList.contentDataVO.p_idx }</th>
							<th scope="row">${qnaDataList.productDataVO.p_name }</th>
							<th scope="row">${qnaDataList.contentDataVO.m_idx }</th>
							<th scope="row">${qnaDataList.memberDataVO.m_id }</th>
							<th scope="row">${qnaDataList.memberDataVO.m_nick }</th>	
							<th scope="row">${qnaDataList.memberDataVO.m_name}</th>						
							<c:choose>
							<c:when test="${qnaDataList.contentDataVO.b_qCategory==0}">
							<th scope="row">강의문의</th>
							</c:when>
							<c:when test="${qnaDataList.contentDataVO.b_qCategory==1}">
							<th scope="row">결제문의</th>
							</c:when>
							</c:choose>
							
							<th scope="row">${qnaDataList.contentDataVO.b_title}</th>
							<th scope="row">${qnaDataList.contentDataVO.b_count}</th>
							<th scope="row">${qnaDataList.contentDataVO.b_postdate}</th>
							
							<th scope="row"><a href="./readQnAPageByAdmin?b_idx=${qnaDataList.contentDataVO.b_idx}">답변작성</a></th>
							<th scope="row"><a href="./sellerDeleteQnAByIdx?b_referIdx=${qnaDataList.contentDataVO.b_referIdx}" onclick="return delchk()">삭제</a></th>
						</tr>
						</c:forEach>
				</tbody>
			</table>
			<button type="submit" style="float: right">삭제</button>
			</form>
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