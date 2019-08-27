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
	<div id="wrapper" align="center">
		제목 : ${boardDataVO.contentDataVO.b_title } <br>
		작성자 : ${boardDataVO.memberDataVO.m_id } <br>
		작성일자 : ${boardDataVO.contentDataVO.b_postdate } <br>	
		내용 : <br>
		${boardDataVO.contentDataVO.b_content } <br>
		
		<div id="replyBox">
			<form action = "writeReplyAction" method="post">
			Nick : ${sessionDataVO.m_nick }
			<input type="text" name="b_content" placeholder="댓글은 자신의 얼굴입니다">
			<input type="hidden" name="b_title" value="reply">
			<input type="hidden" name="b_isPost" value="0">
			<input type="hidden" name="b_pw" value="replyPW">
			<input type="hidden" name="b_type" value="2">
			<input type="hidden" name="b_referIdx" value="${boardDataVO.contentDataVO.b_idx }">
			
			<c:choose>
			<c:when test="${!empty sessionData.ad_idx }">
			<input type="hidden" name="m_idx" value="${sessionData.m_idx }">
			</c:when>
			<c:otherwise>
			<input type="hidden" name="m_idx" value="0">
			</c:otherwise>
			</c:choose>
			<input type="hidden" name="b_idx" value="${boardDataVO.contentDataVO.b_idx }">
			<input type="hidden" name="p_idx" value="${boardDataVO.contentDataVO.p_idx }">
			<c:choose><c:when test="${!empty sessionData.ad_idx }">
			<input type="hidden" name="ad_idx" value="${sessionData.ad_idx }">
			</c:when>
			<c:otherwise>
			<input type="hidden" name="ad_idx" value="0">
			</c:otherwise>
			</c:choose>
			
			<input type="submit" value="등록" name="submit">
			</form>
			
			<table>			
			<tr>
			<td>&nbsp; &nbsp; 닉네임 &nbsp; &nbsp; </td>
			<td>&nbsp; &nbsp; &nbsp; &nbsp;내용&nbsp; &nbsp; &nbsp; &nbsp;</td>
			<td>&nbsp; &nbsp; &nbsp; &nbsp;작성일&nbsp; &nbsp; &nbsp; &nbsp;</td>
			</tr>
			<!-- 댓글 리스트 -->
			<c:forEach var="boardData" items="${boardDataReplyList }">
			<tr>
			<c:choose>
				<c:when test="${boardData.contentDataVO.b_referIdx eq boardDataVO.contentDataVO.b_idx}">
					<c:choose>
					<c:when test="${boardData.contentDataVO.ad_idx != 0 }">
					<td>${boardData.adminDataVO.ad_nick }</td>
					</c:when>
					<c:otherwise><td>${boardData.memberDataVO.m_nick }<td></c:otherwise>
					</c:choose>
					<td>${boardData.contentDataVO.b_content }</td>
					<td>${boardData.contentDataVO.b_postdate}</td>
				</c:when>
			</c:choose>
			</tr>
			</c:forEach>
			

			</table>
			
		</div>
		
		<a href="./reviewBoardPage">목록</a>
		<c:if test="${sessionDataVO != null && sessionDataVO.m_idx == boardDataVO.contentDataVO.m_idx}"> <!-- 비회원일 경우 null.m_idx니까 오류...! -->
			<a href="./updateContentForm?b_idx=${boardDataVO.contentDataVO.b_idx }">수정</a>
			<a href="./deleteContentAction?b_idx=${boardDataVO.contentDataVO.b_idx }">삭제</a>
		</c:if>
	</div>
</body>
</html>