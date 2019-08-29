<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="member_info">
			<!-- ${sessionData.m_nick } --> 유동연 님 강의 신청 전 다시 한 번 강의 정보를 확인해 주세요
		</div>
		<div id="product_info">
			<div id="detail">${productData.productVO.p_name}</div>
			<div id="detail">${productData.productVO.p_location}</div>
			<div id="detail">${productData.productVO.p_startDate} - ${productData.productVO.p_lastDate}</div>
			<div id="detail">${productData.productVO.p_lectureDay}</div>
			<div id="detail">${productData.productVO.p_lectureTime}</div>
		</div>
		<div id="buy_info">
			<div id="price">${productData.productVO.p_nowPrice} 원</div>
			<form action="./buyProductAction" method="post">
				<label><input type="radio" name="o_paymentMethod" value="0">무통장</label>
				<label><input type="radio" name="o_paymentMethod" value="1" checked>카드</label>
				<input type="hidden" name="o_totalPrice" value="${productData.productVO.p_nowPrice}">
				<input type="hidden" name="p_idx" value="${productData.productVO.p_idx }">
				<input type="submit" value="구매">
			</form>
		</div>
	</div>
</body>
</html>