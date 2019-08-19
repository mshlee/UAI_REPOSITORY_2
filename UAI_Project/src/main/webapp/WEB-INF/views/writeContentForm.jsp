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
		<form action="./writeContentAction" method="post" enctype="multipart/form-data">
			제목 : <input type="text" name="b_title"> <br><br>
			닉네임 : ${sessionData.ad_nick } <br><br>
			내용 : <textarea rows="20" cols="50" name="b_content"></textarea> <br><br>
			<input type="hidden" value="${sessionData.ad_idx}"  name="ad_idx">
			<input type="hidden" value="none_pw" name="b_pw">
			<br>
			<input type="file" name="files" multiple> <br>
			<input type="submit" value="글쓰기">
		</form>
	</div>
</body>
</html>