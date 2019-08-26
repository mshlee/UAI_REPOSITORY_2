<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<h1>글 수정하기</h1>
		<form action="./updateContentAction" method="post">
			제목 : <input type="text" name="c_title" value="${boardData.contentVO.c_title }"> <br>
			닉네임 : ${sessionData.m_nick } <br>
			내용 : <br>
			<textarea rows="20" cols="50" name="c_contents">${boardData.contentVO.c_contents }</textarea>
			<input type="hidden" value="${boardData.contentVO.c_idx }" name="c_idx">
			<input type="submit" value="수정완료">
		</form>
	</div>
</body>
</html>