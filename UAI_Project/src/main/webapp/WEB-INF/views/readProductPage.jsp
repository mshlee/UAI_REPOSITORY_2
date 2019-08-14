<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
	</style>
</head>
<body>
	<div id="wrapper">
		<div id="product_detail">
			<div id="picture"></div>
			<div id="brief_explain">
				<div id="lecture_name">${productData.productVO.p_name}</div>
				<div id="lecture_star">별점</div>
				<div id="lecture_detail">
					<div id="details">${productData.productVO.p_location}</div>
					<div id="details">${productData.productVO.p_lectureTime}(${productData.productVO.p_lectureDay})</div>
					<div id="details">${productData.productVO.p_maxStudent} 명</div>
					<div id="details">${productData.productVO.p_nowPrice} 원</div>
				</div>
			</div> <br>
			<div id="detailed_explain">
				<div>
					선생님 정보 <br>
					${productData.productVO.p_teacherInfo}
				</div>
				<div>
					커리큘럼 <br>
					${productData.productVO.p_lectureInfo}
				</div>
				<div>
					기타 사항 <br>
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
			<div id="wish"><a href="./wishProductPage?p_idx=${productData.productVO.p_idx}">찜하기</a></div>
		</div>
	</div>
</body>
</html>