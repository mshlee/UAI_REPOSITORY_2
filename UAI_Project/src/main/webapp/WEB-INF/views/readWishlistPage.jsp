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
		#nowPage{
			border : 1px solid black;
			background-color: cyan;
			float : left;
		}
		a{
			text-decoration: none;
			color: black;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<c:forEach var="productData" items="${wishlistData }">
			<div id="wish">
				<a href="./readProductPage?p_idx=${productData.productVO.p_idx }">
					<div>${productData.productVO.p_name }</div>
					<div>${productData.productVO.p_nowPrice } 원</div>
					<div>${productData.productVO.p_teacher } </div>
					<div>${productData.productVO.p_location }</div>
				</a>
			</div>
		</c:forEach>
		<div id="pages">
			<c:if test="${pageVO.startOfPageGroup != 1}">
				<a href="readWishlistPage?changePage=previous&nowPage=${pageVO.nowPage }">이전</a>
			</c:if>
			<c:forEach var="i" begin="${pageVO.startOfPageGroup }" end="${pageVO.endOfPageGroup }" step="1">
				<c:choose>
					<c:when test="${i == pageVO.nowPage}">
						<div id="nowPage">${i }</div>
					</c:when>
					<c:otherwise>
						<div id="page"><a href="./readWishlistPage?nowPage=${i }">${i }</a></div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pageVO.endOfPageGroup != pageVO.maxPage}">
				<a href="readWishlistPage?changePage=next&nowPage=${pageVO.nowPage }">다음</a>
			</c:if>
		</div>
	</div>
</body>
</html>