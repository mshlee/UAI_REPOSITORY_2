<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div id="wrapper">
      <c:choose>
         <c:when test="${!empty sessionData.m_idx }">
            ${sessionData.m_nick }님 환영합니다.
            <a href="./logoutAction">로그아웃</a>
            <br>

         </c:when>
            <c:when test="${!empty sessionData.ad_idx }">
            ${sessionData.ad_nick }님 환영합니다.
            <a href="./logoutAction">로그아웃</a>
               <br>
            </c:when>
   <c:otherwise>
            비회원님 환영합니다.
            <a href="./loginForm">로그인 페이지로</a><br>
            <a href="./mainPage">메인페이지로</a>
            <br>
         </c:otherwise>
      </c:choose>
      <table border="1">
         <tr>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>조회수</td>
         </tr>
  
         <c:forEach var="boardDataVO" items="${boardDataList }">
            
            <tr>
               <td>${boardDataVO.contentDataVO.b_title }
              </td>
               <td>${boardDataVO.memberDataVO.m_nick}</td>
               <td>${boardDataVO.contentDataVO.b_postdate}</td>
               <td>${boardDataVO.contentDataVO.b_count }</td>              
            </tr>
         </c:forEach>

      </table>
      <c:if test="${!empty sessionData }">
         <a href="./writeReviewForm">질문 작성</a>
      </c:if>

      <br>
      </div>

</body>
</html>