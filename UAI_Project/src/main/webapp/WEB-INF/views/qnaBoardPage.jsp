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
         </c:otherwise>
      </c:choose>
      <table border="1">
         <tr>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>비밀글</td>
         </tr>
            <tr>
            <c:forEach var="boardDataVO" items="${boardDataList }">
               <td><c:choose>
               <c:when test="${boardDataVO.contentDataVO.b_isHidden}=0 ">
               <a href="./readQnAContentPage?b_idx=${boardDataVO.contentDataVO.b_idx }">
                  ${boardDataVO.contentDataVO.b_title}</a>
                  </c:when>
                  <c:when test="${boardDataVO.contentDataVO.b_isHidden}=1">
            <a href="./confirmPasswordPage">비밀글입니다</a>
                  </c:when>
                </c:choose>
               <td>${boardDataVO.memberDataVO.m_nick}</td>
               <td>${boardDataVO.contentDataVO.b_postdate}</td>
               <td></td>
               </c:forEach>
               </tr>


      </table>
      <c:if test="${!empty sessionData }">
         <a href="./writeContentForm">질문 작성</a>
      </c:if>

      <br>
      </div>

</body>
</html>