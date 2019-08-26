<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UAI-관리자 계정 관리 메인</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<style>
#wrapper{
    width: 1366px;
    height: 900px;
    border: solid black 0.3px;
    margin: 50px auto;
}
#upper_bar{
    float:right;
}
#main_box{
    width: 1024px;
    margin: 200px auto;
}
#content_box{
    width: 500px;
    height: 400px;
    border: solid black 0.3px;
}
</style>


</head>
<body>
    <div id="wrapper">
        <div id="upper_bar"><a href="./mainPage">쇼핑몰메인</a> <a href="./logoutAction">로그아웃</a></div><br>
        <div id="main_box">
        ${sessionData.ad_nick }님, 어떤 작업을 수행하시겠습니까?<br>
            <div id="content_box" style="float: left;">
            <a href="./sellerNewAdmin">새 관리자 계정 생성</a></div>
            <div id="content_box" style="float: right">
            
            <a href="./sellerAdminEdit?ad_idx=${sessionData.ad_idx }">기존 관리자 계정 수정</a></div>
        </div>
    </div>





<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
</html>