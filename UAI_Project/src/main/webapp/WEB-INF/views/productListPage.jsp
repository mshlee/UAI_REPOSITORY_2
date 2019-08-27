<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ProductListPage</title>
<script src="http://code.jquery.com/jquery-1.9.0rc1.js"></script> 
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
      a{
         text-decoration: none;
         color: black;
      }
   </style>
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
</head>
<body>
   <div id="wrapper">
      <div id="categories">
         <div id="category_info">카테고리</div>
         <div id="category"><a href="./productListPage">전체 수업</a></div>
         <div id="category"><a href="./productListPage?p_type=0&p_location=${p_location}&searchWord=${searchWord}">언어</a></div>
         <div id="category"><a href="./productListPage?p_type=1&p_location=${p_location}&searchWord=${searchWord}">IT/컴퓨터</a></div>
         <div id="category"><a href="./productListPage?p_type=2&p_location=${p_location}&searchWord=${searchWord}">미술</a></div>
         <div id="category"><a href="./productListPage?p_type=3&p_location=${p_location}&searchWord=${searchWord}">음악</a></div>
         <div id="category"><a href="./productListPage?p_type=4&p_location=${p_location}&searchWord=${searchWord}">스포츠</a></div>
         <div id="category"><a href="./productListPage?p_type=5&p_location=${p_location}&searchWord=${searchWord}">기타</a></div>
      </div> <br><br>
      <div id="search" >
         <form name="frmSearch" action="./productListPage?p_type=${p_type}&p_location=${location}" >
            <input name="searchWord" class="main_input" type="text" onKeyUp="keywordSearch()"> 
            <input type="submit" value="검색" >
         </form>
      </div>
      <div id="suggest">
           <div id="suggestList"></div>
         </div>
      <div id="locations">
         <div id="location_info">장소를 선택해 주세요</div>
         <c:forEach var="location" items="${locationList}">
            <div id=location><a href="productListPage?p_type=${p_type}&p_location=${location}&searchWord=${searchWord}">${location }</a></div>
         </c:forEach>
      </div> <br><br>
      <div> 총 ${listCount} 건의 강의가 있습니다. </div>
      <c:forEach var="productData" items="${productDataList }">
         <div id="product">
            <a href="./readProductPage?p_idx=${productData.productVO.p_idx }">
               <div><img src="${productData.thumbnail}"></div>
               <div>${productData.productVO.p_name}</div>
               <div>${productData.productVO.p_nowPrice } 원</div>
               <div>${productData.productVO.p_starRate} 점 / 5 점 | ${productData.productVO.p_teacher } | ${productData.productVO.p_location }</div>
            </a>
         </div>
      </c:forEach> <br><br><br><br> <br>
      <div id="pages">
         <c:if test="${pageVO.startOfPageGroup != 1}">
            <a href="productListPage?changePage=previous&nowPage=${pageVO.nowPage }&p_type=${p_type}&p_location=${p_location}&searchWord=${searchWord}">이전</a>
         </c:if>
         <div>
            <c:forEach var="i" begin="${pageVO.startOfPageGroup }" end="${pageVO.endOfPageGroup }" step="1">
               <c:choose>
                  <c:when test="${i == pageVO.nowPage}">
                     <div id="nowPage">${i } </div>
                  </c:when>
                  <c:otherwise>
                     <div id="page"><a href="./productListPage?nowPage=${i }&p_type=${p_type}&p_location=${p_location}&searchWord=${searchWord}">${i } </a></div>
                  </c:otherwise>
               </c:choose>
            </c:forEach>
         </div>
         <c:if test="${pageVO.endOfPageGroup != pageVO.maxPage}">
            <a href="productListPage?changePage=next&nowPage=${pageVO.nowPage }&p_type=${p_type}&p_location=${p_location}&searchWord=${searchWord}">다음</a>
         </c:if>
      </div>
   </div>
</body>
</html>