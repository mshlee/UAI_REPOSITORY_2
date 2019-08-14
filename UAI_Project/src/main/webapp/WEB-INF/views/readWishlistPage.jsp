<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>readWishlistPage</title>
	<style>
		#wish{
			border: 1px solid black;
		}
		#page{
			border: 1px solid black;
			float : left;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<c:forEach var="productData" items="${wishlistData }">
			<div id="wish">
				<div>${productData.productVO.p_name }</div>
				<div>${productData.productVO.p_nowPrice } 원</div>
				<div>${productData.productVO.p_teacher } </div>
				<div>${productData.productVO.p_location }</div>
			</div>
		</c:forEach>
		<div id="pages">
			<c:forEach var="i" begin="${pageVO.startOfPageGroup }" end="${pageVO.endOfPageGroup }" step="1">
				<div id="page"><a href="./readWishlistPage?nowPage=${i }">${i }</a></div>
			</c:forEach>
		</div>
	</div>
</body>
</html>