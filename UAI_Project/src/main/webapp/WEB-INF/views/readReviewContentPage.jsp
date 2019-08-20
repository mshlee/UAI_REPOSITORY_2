<<<<<<< HEAD
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
      제목 : ${boardDataVO.contentDataVO.b_title } <br>
      작성자 : ${boardDataVO.memberDataVO.m_nick } <br>
      작성일자 : ${boardDataVO.contentDataVO.b_postdate } <br>   
      내용 : <br>
      ${boardDataVO.contentDataVO.b_content } <br>
      
      <c:forEach var="file" items="${boardDataVO.fileList }">
         <img src="${file.f_path }"> <br>
      </c:forEach>
      
      <a href="./reviewBoardPage">목록</a>
      <c:if test="${sessionData != null && sessionData.m_idx == boardDataVO.contentDataVO.m_idx}"> <!-- 비회원일 경우 null.m_idx니까 오류...! -->
         <a href="./updateContentForm?b_idx=${boardDataVO.contentDataVO.b_idx }">수정</a>
         <a href="./deleteContentAction?b_idx=${boardDataVO.contentDataVO.b_idx }">삭제</a>
      </c:if>
   </div>
</body>
=======
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
      제목 : ${boardDataVO.contentDataVO.b_title } <br>
      작성자 : ${boardDataVO.memberDataVO.m_nick } <br>
      작성일자 : ${boardDataVO.contentDataVO.b_postdate } <br>   
      내용 : <br>
      ${boardDataVO.contentDataVO.b_content } <br>
      
      <c:forEach var="file" items="${boardDataVO.fileList }">
         <img src="${file.f_path }"> <br>
      </c:forEach>
      
      <a href="./reviewBoardPage">목록</a>
      <c:if test="${sessionData != null && sessionData.m_idx == boardDataVO.contentDataVO.m_idx}"> <!-- 비회원일 경우 null.m_idx니까 오류...! -->
         <a href="./updateContentForm?b_idx=${boardDataVO.contentDataVO.b_idx }">수정</a>
         <a href="./deleteContentAction?b_idx=${boardDataVO.contentDataVO.b_idx }">삭제</a>
      </c:if>
   </div>
</body>
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
</html>