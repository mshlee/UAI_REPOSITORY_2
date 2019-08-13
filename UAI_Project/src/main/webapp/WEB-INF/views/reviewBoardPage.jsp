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
				<a href="./loginForm">로그인해라</a>

			</c:otherwise>
		</c:choose>
		<table border="1">
			<tr>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
				<td>평점</td>
			</tr>
			<c:choose>
			<c:forEach var="boardData" items="${boardDataList }">
				
				<tr>
					<td>
					<a href="./readReviewContent?b_idx=${boardDataVO.contentDataVO.b_idx }">
					<c:when test="${boardDataVO.contentDataVO.b_type=1}">
						${boardDataVO.contentDataVO.b_title}
					</c:when></a>
					 </td>
					<td>
						<c:when test="${boardDataVO.contentDataVO.b_type=1}">
						${boardDataVO.memberDataVO.m_nick}
					</c:when>
						</td>
					<td><c:when test="${boardDataVO.contentDataVO.b_type=1}">
						${boardDataVO.contentDataVO.b_postdate}
					</c:when></td>
					<td><c:when test="${boardDataVO.contentDataVO.b_type=1}">
						</c:when></td>
					

				</tr>

			</c:forEach>
</c:choose>

		</table>
		<c:if test="${!empty sessionData }">
			<a href="./writeReviewContentForm">리뷰 작성</a>
		</c:if>

		<br>
		</div>
 


</body>
</html>