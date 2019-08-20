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
      #nowPage{
         border : 1px solid black;
         background-color: cyan;
         float : left;
      }
   </style>
</head>
<body>
   <div id="wrapper">
      <div id="categories">
         <div id="category_info">카테고리?</div>
         <div id="category"><a href="./readProductPage?category=0">언어</a></div>
         <div id="category"><a href="./readProductPage?category=1">IT/컴퓨터</a></div>
         <div id="category"><a href="./readProductPage?category=2">미술</a></div>
         <div id="category"><a href="./readProductPage?category=3">음악</a></div>
         <div id="category"><a href="./readProductPage?category=4">스포츠</a></div>
         <div id="category"><a href="./readProductPage?category=5">기타</a></div>
      </div>
      <div id="select_location">
         <div id="location_info">장소?</div>
         <c:forEach var="productData" items="${ProductdataList }">
            <div id="location">장소 코드 들어갑니다</div>
         </c:forEach>
      </div>
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
         <c:if test="${pageVO.startOfPageGroup != 1}">
            <a href="productListPage?changePage=previous&nowPage=${pageVO.nowPage }">이전</a>
         </c:if>
         <c:forEach var="i" begin="${pageVO.startOfPageGroup }" end="${pageVO.endOfPageGroup }" step="1">
            <c:choose>
               <c:when test="${i == pageVO.nowPage}">
                  <div id="nowPage">${i }</div>
               </c:when>
               <c:otherwise>
                  <div id="page"><a href="./productListPage?nowPage=${i }">${i }</a></div>
               </c:otherwise>
            </c:choose>
         </c:forEach>
         <c:if test="${pageVO.endOfPageGroup != pageVO.maxPage}">
            <a href="productListPage?changePage=next&nowPage=${pageVO.nowPage }">다음</a>
         </c:if>
      </div>
   </div>
</body>
</html>