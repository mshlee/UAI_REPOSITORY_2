<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UAI-관리자 계정 정보 수정</title>
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
        #header{
            width: 1166px;
            height: 100px;
            border: solid black 0.3px;
            float: right;
            padding: 10px;
        }
        #left_box{
            width: 200px;
            height: 500px;
            float: left;
            border: solid black 0.3px;
        
        }
        #main_box{
            width: 1100px;
            margin: 5px auto;
            border: solid black 0.3px;
            float: right;
        }
        #content_box{
            width: 900px;
            height: 700px;
            border: solid black 0.3px;
            margin: 10px auto;
        }
        </style>


</head>
<body>
        <div id="wrapper">
                <div id="upper_bar"><a href="./mainPage">메인</a> <a href="./logoutAction">로그아웃</a></div><br>
                <img src="./img/logo.png" type="button">
                <div id="header">관리자 계정 수정</div>
                <div id="left_box">
                    <label><a href="">관리자 메인</a></label><br>
                    <label><a href="">관리자 계정 생성</a></label><br>
                    <label><a href="">쇼핑몰 메인</a></label><br>
                </div>
                <div id="main_box">
                    <div id="content_box">
        
                        <form action="./sellerAdminEditAction?ad_idx=${sessionData.ad_idx }" method="post">
                            <br><br><br>
                            <label>ID:</label>
                            <input type="text" name="ad_id" value="${adminData.ad_id}" disabled><br>
                            <label>NICK:</label>
                            <input type="text" name="ad_nick" value="${adminData.ad_nick }"><input type="checkbox" name="ad_nick" value="${adminData.ad_nick }">수정안함<br>
                           	<label>PW:</label>
                            <input type="password" name="ad_pw" value="${adminData.ad_pw }"><input type="checkbox" name="ad_nick" value="${adminData.ad_nick }">수정안함<br>
                            <input type="submit" value="수정"><br>
                        </form>
        
                    </div>
                </div>
        
        
            </div>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
</html>