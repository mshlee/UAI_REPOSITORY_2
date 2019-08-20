<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UAI-판매자 메인</title>
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
#admin_menu{
    width: 180px;
    height: 100px;
    margin: 5px auto;
    border: solid black 0.3px;
}
#main_box{
    width: 1100px;
    margin: 5px auto;
    border: solid black 0.3px;
    float: right;
}
#left_column{
    width: 500px;
    height:300px;
    margin: 10px auto;
    border: solid black 0.3px;
    float: left;
}
#right_column{
    width: 500px;
    height:300px;
    margin: 10px auto;
    border: solid black 0.3px;
    float: right;
}
</style>


</head>
<body>
    <div id="wrapper">
        <div id="upper_bar"><a href="">쇼핑몰메인</a><a href="">로그아웃</a></div><br>
        <img src="" type="button">
        <div id="header"><a href="./index.do">메인</a> | <a href="./manageProduct.do">강의 관리</a> | <a href="./manageOrder.do">주문 관리</a> | <a href="./manageMember.do">회원관리</a> |  
            <a href="./manageReview.do">리뷰 관리</a> | <a href="./manageQnA.do">QnA 관리</a> | <a href="./managePaycheck.do">지급 관리</a>
        </div>
        <div id="left_box">
            <div id="admin_menu">
                
                환영합니다. <br>(닉네임아이디들어가야함)<br>
                <button onclick="">로그아웃</button><br>
                <button onclick="">관리자계정설정</button>

            </div>

        </div>
        <div id="main_box">
            <div id="left_column">
                <label>최신 주문</label><br>
                <div>
                    <!--forEach로 조건 설정하여 리스트 출력하기-->
                    <li>최신 주문 내역</li>

                </div>
                <button style="float: right;" onclick="">더보기</button></div>
           <div id="right_column"> 
                <label>최신 상품</label><br>
                <div>
                    <!--forEach로 조건 설정하여 리스트 출력하기-->
                    <li>최신 등록 상품</li>
                
                </div>
                <button style="float: right;" onclick="">더보기</button></div>
            <div id="left_column">     
                <label>최신 QnA</label><br>
                <div>
                    <!--forEach로 조건 설정하여 리스트 출력하기-->
                    <li>최신 등록 질문</li>
                
                </div>
                <button style="float: right;" onclick="">더보기</button>
            </div>
            <div id="right_column">                
                    <label>최신 리뷰</label><br>
                    <div>
                        <!--forEach로 조건 설정하여 리스트 출력하기-->
                        <li>최신 등록 리뷰</li>
                    
                    </div>
                    <button style="float: right;" onclick="">더보기</button>
                </div>
            </div>
            
        </div>
        </div>
        

    </div>





<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UAI-판매자 메인</title>
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
#admin_menu{
    width: 180px;
    height: 100px;
    margin: 5px auto;
    border: solid black 0.3px;
}
#main_box{
    width: 1100px;
    margin: 5px auto;
    border: solid black 0.3px;
    float: right;
}
#left_column{
    width: 500px;
    height:300px;
    margin: 10px auto;
    border: solid black 0.3px;
    float: left;
}
#right_column{
    width: 500px;
    height:300px;
    margin: 10px auto;
    border: solid black 0.3px;
    float: right;
}
</style>


</head>
<body>
    <div id="wrapper">
        <div id="upper_bar"><a href="">쇼핑몰메인</a><a href="">로그아웃</a></div><br>
        <img src="" type="button">
        <div id="header"><a href="./index.do">메인</a> | <a href="./manageProduct.do">강의 관리</a> | <a href="./manageOrder.do">주문 관리</a> | <a href="./manageMember.do">회원관리</a> |  
            <a href="./manageReview.do">리뷰 관리</a> | <a href="./manageQnA.do">QnA 관리</a> | <a href="./managePaycheck.do">지급 관리</a>
        </div>
        <div id="left_box">
            <div id="admin_menu">
                
                환영합니다. <br>(닉네임아이디들어가야함)<br>
                <button onclick="">로그아웃</button><br>
                <button onclick="">관리자계정설정</button>

            </div>

        </div>
        <div id="main_box">
            <div id="left_column">
                <label>최신 주문</label><br>
                <div>
                    <!--forEach로 조건 설정하여 리스트 출력하기-->
                    <li>최신 주문 내역</li>

                </div>
                <button style="float: right;" onclick="">더보기</button></div>
           <div id="right_column"> 
                <label>최신 상품</label><br>
                <div>
                    <!--forEach로 조건 설정하여 리스트 출력하기-->
                    <li>최신 등록 상품</li>
                
                </div>
                <button style="float: right;" onclick="">더보기</button></div>
            <div id="left_column">     
                <label>최신 QnA</label><br>
                <div>
                    <!--forEach로 조건 설정하여 리스트 출력하기-->
                    <li>최신 등록 질문</li>
                
                </div>
                <button style="float: right;" onclick="">더보기</button>
            </div>
            <div id="right_column">                
                    <label>최신 리뷰</label><br>
                    <div>
                        <!--forEach로 조건 설정하여 리스트 출력하기-->
                        <li>최신 등록 리뷰</li>
                    
                    </div>
                    <button style="float: right;" onclick="">더보기</button>
                </div>
            </div>
            
        </div>
        </div>
        

    </div>





<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
</html>