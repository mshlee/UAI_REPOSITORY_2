<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.9.0rc1.js"></script>   
<script>
	var empty_heart = "./img/zzim_blanked.jpg"
    var filled_heart = "./img/zzim_colored.jpg"
    	function click_wish(p_idx){
        	var src = $('#zzim').attr("src");
            if(src == empty_heart){
                //ajax처리
                $.ajax({
                    type : "post",
                    async : false,
                    url : "./addWishlist", 
                    data : { p_idx : p_idx }, //전달할 키&값
                    success : function (){ //전달 성공 시
                        $('#zzim').attr("src",filled_heart);
                        alert("위시리스트에 담겼습니다");
                    },
                    error : function (){
                        alert("에러 발생");
                    },
                    complete : function (){
                        //alert("위시리스트에 담겼습니다");
                    }
                });
            }else{
                //ajax처리
                $.ajax({
                    type : "post",
                    async : false,
                    url : "./removeWishlist", 
                    data : { p_idx : p_idx }, //전달할 키&값
                    success : function (data, textStatus){ //전달 성공 시
                        $('#zzim').attr("src",empty_heart);
                        alert("위시리스트에서 삭제되었습니다");
                    },
                    error : function (data, textStatus){
                        alert("에러 발생");
                    },
                    complete : function (data, textStatus){
                        //alert("위시리스트에서 삭제되었습니다");
                    }
                });
            } 
    }
</script>
<meta charset="UTF-8">
<title>readProductPage</title>
	<style>
		#wrapper{
			border: 1px solid black;
		}		
		#product_detail{
			border: 1px solid black;
		}
		#picture{
			border: 1px solid black;
		}
		#brief_explain{
			border: 1px solid black;
		}
		#details{
			border: 1px solid black;
			float: left;
		}
		#detailed_explain{
			border: 1px solid black;
		}
		#reviews{
			border: 1px solid black;
		}
		#right_box{
			border: 1px solid black;
			float: left;
		}	
		#box_info{
			border: 1px solid black;
		}	
		a{
			text-decoration: none;
			color: black;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<div id="product_detail">
			<div id="picture"></div>
			<div id="brief_explain">
				<div id="lecture_name">${productData.productVO.p_name}</div>
				<div id="lecture_star">${productData.productVO.p_starRate } 점 / 5 점 (${starCount }건)</div>
				<div id="lecture_buyCount"> 총 ${productData.productVO.p_totalSaleCount } 명이 강의를 수강하였습니다 </div>
				<div id="lecture_detail">
					<div id="details">${productData.productVO.p_location}</div>
					<div id="details">${productData.productVO.p_lectureTime}(${productData.productVO.p_lectureDay})</div>
					<div id="details">${productData.productVO.p_maxStudent} 명</div>
					<div id="details">${productData.productVO.p_nowPrice} 원</div>
				</div>
			</div> <br>
			<div id="detailed_explain">
				<div>
					<h3>선생님 정보</h3> <br>
					${productData.productVO.p_teacherInfo}
				</div>
				<div>
					<h3>커리큘럼</h3> <br>
					${productData.productVO.p_lectureInfo}
				</div>
				<div>
					<h3>기타 사항</h3> <br>
					${productData.productVO.p_otherInfo}
				</div>
			</div>
			<div id="reviews">
				리뷰
			</div>
		</div>
		<div id="right_box">
			<div id="box_info">
				<table>
					<tr><td>위치</td><td>	${productData.productVO.p_location}</td></tr>
					<tr><td>기간</td><td>	${productData.productVO.p_startDate} - ${productData.productVO.p_lastDate}</td></tr>
					<tr><td>요일</td><td>	${productData.productVO.p_lectureDay}</td></tr>
					<tr><td>시간</td><td>	${productData.productVO.p_lectureTime}</td></tr>
					<tr><td>가격</td><td>	${productData.productVO.p_nowPrice} 원</td></tr>
				</table>
			</div>
			<div id="buy"><a href="./buyProductPage?p_idx=${productData.productVO.p_idx}" >강의 신청하기</a></div>
			<div id="wish" onclick="click_wish(${productData.productVO.p_idx});">
				<c:choose>
					<c:when test="${IsWished eq false }">
						<img id="zzim" src="./img/zzim_blanked.jpg">
					</c:when>
					<c:otherwise>
						<img id="zzim" src="./img/zzim_colored.jpg">
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>