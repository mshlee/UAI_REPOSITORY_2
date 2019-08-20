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
		작성자 : ${boardDataVO.adminDataVO.ad_nick } <br>
		작성일 : ${boardDataVO.contentDataVO.b_postdate } <br>	
		내용 : <br>
		${boardDataVO.contentDataVO.b_content } <br>
		
		<c:forEach var="file" items="${boardDataVO.fileList }">
			<img src="${file.f_path }"> <br>
		</c:forEach>
		
		<
		
		

		
		<a href="./boardNoticePage">목록</a>
		<c:if test="${sessionData.ad_idx !=null && sessionData.ad_idx == boardDataVO.contentDataVO.ad_idx}"> <!-- 비회원일 경우 null.m_idx니까 오류...! -->
			<a href="./updateNoticeForm?b_idx=${boardDataVO.contentDataVO.b_idx }">수정</a>
			<a href="./deleteContentAction?b_idx=${boardDataVO.contentDataVO.b_idx }">삭제</a>
		</c:if>
	</div>



</body>
</html>