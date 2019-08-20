<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<STYLE>
      #pages{
         border: 1px solid blue;
      }
      #page{
         border: 1px solid bule;
         float : left;
      }
            #nowPage{
         border : 1px solid black;
         background-color: cyan;
         float : left;
      }
</STYLE>
<script>
function SirenFunction(title_box){
     if(document.getElementById("SirenDiv").style.display=="block"){ 
    	 document.getElementById("SirenDiv").style.display == "none"; }
      else{ 
    	  document.getElementById("SirenDiv").style.display == "block"; }
}
</script>



    

</head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<c:choose>
			<c:when test="${!empty sessionData.m_idx }">
				${sessionData.m_nick }님 환영합니다.
				<a href="./logoutAction">로그아웃</a>
				<a href="./mainPage">메인페이지로</a>
				<br>

			</c:when>
			<c:when test="${!empty sessionData.ad_idx }">
				${sessionData.ad_nick }님 환영합니다.
				<a href="./logoutAction">로그아웃</a>
				<a href="./mainPage">메인페이지로</a>
					<br>
				</c:when>
			<c:otherwise>
				비회원님 환영합니다.
				<a href="./loginForm">로그인 페이지로</a><br>
				<a href="./mainPage">메인페이지로</a>
			</c:otherwise>
		</c:choose>
		
		<table border="1">
			<tr>
				<th>문의</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>글타입</th>
			</tr>
			
				<c:forEach var="boardDataVO" items="${boardDataList }">
				<tr>
					<th><c:choose>
					<c:when test="${boardDataVO.contentDataVO.b_qCategory eq'0'} ">
					상품문의</c:when>
					<c:otherwise>
					결제문의
					</c:otherwise>
					</c:choose>
					</th>
					 <th><c:choose>
               <c:when test="${boardDataVO.contentDataVO.b_isHidden eq'0' }">
               <a href="./readQnAPage?b_idx=${boardDataVO.contentDataVO.b_idx }">
                  (공개글)${boardDataVO.contentDataVO.b_title}</a>
                  </c:when>
                  <c:otherwise>
       				 		<!-- <a href="#" onclick="document.getElementById('PW_box').style.display = 'block'; return false();"> -->
       				 		(비밀글)${boardDataVO.contentDataVO.b_title}
       				 		<form action="./readQnAPage" method="post" id="PW_box" style="display:block">
                  				<input type="hidden" name="b_title" value="${boardDataVO.contentDataVO.b_title }">
                  				<input type="hidden" name="b_idx" value="${boardDataVO.contentDataVO.b_idx }">
                  				PW : <input type="password" name="b_pw">
                  				<input type="submit" value="비밀번호확인">
                  			</form>
                  </c:otherwise>
                  </c:choose></th>
                  
					<th>${boardDataVO.memberDataVO.m_nick }</th>
					<th>${boardDataVO.contentDataVO.b_postdate}</th>
					<th><c:choose> 
               			<c:when test="${boardDataVO.contentDataVO.b_isHidden eq'0' }">
            			공개글
            		</c:when>
					<c:otherwise>비밀글</c:otherwise></c:choose></th>
					</c:forEach>
				
		</table>
		<br>
		<c:if test="${!empty sessionData }">
			<a href="./writeQnAForm">질문 작성</a>
		</c:if>
		<div id="search">
		<form action="./boardQnAPage" method="get">
		<input type="hidden" name="b_type" value="2" >
		검색대상 : <select name="searchTarget">
			<option value="b_title" selected>제목</option>
			<option value="b_content">내용</option>
			<option value="m_nick">작성자</option>
			
		</select>
			검색어 : <input type="text" name="searchWord">
			<input type="submit" value="serach">
			
		</form>
		</div>

		<br>
		      <div id="pages">
         <c:if test="${pageVO.startOfPageGroup != 1}">
            <a href="boardQnAPage?changePage=previous&nowPage=${pageVO.nowPage }">이전</a>
         </c:if>
         <c:forEach var="i" begin="${pageVO.startOfPageGroup }" end="${pageVO.endOfPageGroup }" step="1">
            <c:choose>
               <c:when test="${i == pageVO.nowPage}">
                  <div id="nowPage">${i }</div>
               </c:when>
               <c:otherwise>
                  <div id="page"><a href="./boardQnAPage?nowPage=${i }">${i }</a></div>
               </c:otherwise>
            </c:choose>
         </c:forEach>
         <c:if test="${pageVO.endOfPageGroup != pageVO.maxPage}">
            <a href="boardQnAPage?changePage=next&nowPage=${pageVO.nowPage }">다음</a>
         </c:if>
      </div>
		</div>


</body>
</html>