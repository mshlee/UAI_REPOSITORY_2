<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProductListPage</title>
	<style>
		#wrapper{
			border: 1px solid black;
		}
		#categories{
			border: 1px solid black;
		}
		#category{
			border: 1px solid black;
			float: left;
		}
		#select_location{
			border: 1px solid black;
		}
		#location{
			border: 1px solid black;
			float: left;
		}
		#product{
			border: 1px solid black;
			float: left;
		}
		#pages{
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
		<div id="categories">
			<div id="category_info">카테고리?</div>
			<div id="category">언어</div>
			<div id="category">IT/컴퓨터</div>
			<div id="category">미술</div>
			<div id="category">음악</div>
			<div id="category">스포츠</div>
			<div id="category">기타</div>
		</div>
		<div id="select_location">
			<div id="location_info">장소?</div>
			<c:forEach var="productData" items="${dataList }">
				<div id="location">장소 코드 들어갑니다</div>
			</c:forEach>
		</div> <br><br>
		<c:forEach var="productData" items="${productDataList }">
			<div id="product">
				<a href="./readProductPage?p_idx=${productData.p_idx }">
					<div>${productData.p_name}</div>
					<div>${productData.p_nowPrice } 원</div>
					<div>별점 | ${productData.p_teacher } | ${productData.p_location }</div>
				</a>
			</div>
		</c:forEach> <br><br><br><br>
		<div id="pages">
			<c:forEach var="i" begin="${pageVO.startOfPageGroup }" end="${pageVO.endOfPageGroup }" step="1">
				<div id="page"><a href="./productListPage?nowPage=${i }">${i }</a></div>
			</c:forEach>
		</div>
	</div>
</body>
</html>