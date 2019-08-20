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
		<form action="./readQnAContentPage" method="post">
			
			PW : <input type="password" name="b_pw"><br>
			<input type="hidden" value="${boardDataVO.contentDataVO.b_idx}" name="b_idx">
			<input type="hidden" value="${boardDataVO.contentDataVO.b_isHidden}" name="b_isHidden"> 	 		
			<input type="submit" value="확인"><br>	
		</form>
	
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
		<form action="./readQnAContentPage" method="post">
			
			PW : <input type="password" name="b_pw"><br>
			<input type="hidden" value="${boardDataVO.contentDataVO.b_idx}" name="b_idx">
			<input type="hidden" value="${boardDataVO.contentDataVO.b_isHidden}" name="b_isHidden"> 	 		
			<input type="submit" value="확인"><br>	
		</form>
	
	</div>

</body>
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
</html>