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
            <br>
         </c:otherwise>
      </c:choose>
      
      <table border="1">
         <tr>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
         </tr>
            <c:forEach var="boardDataVO" items="${boardDataList }">
               <tr>
               <td><a href="./readNoticeContentPage?b_idx=${boardDataVO.contentDataVO.b_idx }">
                     ${boardDataVO.contentDataVO.b_title}</a></td>
               <td>${boardDataVO.adminDataVO.ad_nick}</td>
               <td>${boardDataVO.contentDataVO.b_postdate}</td>
               </tr>
            </c:forEach>
         </table>   
      <c:if test="${!empty sessionData.ad_idx }">
      <a href="./writeContentForm">글쓰기</a>
      </c:if>

      <div id="search">
      <form action="./noticeBoardPage" method="get">
      <input type="hidden" name="b_type" value="0" >
      검색대상 : <select name="searchTarget">
         <option value="b_title" selected>제목</option>
         <option value="b_content">내용</option>
         <option value="ad_nick">작성자</option>
         
      </select>
         검색어 : <input type="text" name="searchWord">
         <input type="submit" value="serach">
         
      </form>
      </div>
   </div><!-- last wrapper -->

</body>
</html>