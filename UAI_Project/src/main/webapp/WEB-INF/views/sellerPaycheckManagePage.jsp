<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UAI-지급 관리</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<style>
#wrapper {
	width: 1366px;
	height: 900px;
	border: solid black 0.3px;
	margin: 50px auto;
}

#upper_bar {
	float: right;
}

#header {
	width: 1166px;
	height: 100px;
	border: solid black 0.3px;
	float: right;
	padding: 10px;
}

#left_box {
	width: 200px;
	height: 500px;
	float: left;
	border: solid black 0.3px;
}

#admin_menu {
	width: 180px;
	height: 100px;
	margin: 5px auto;
	border: solid black 0.3px;
}

#search_box {
	width: 1100px;
	height: 200px;
	margin: 5px auto;
	border: solid black 0.3px;
	float: right;
}

#content_box {
	width: 1100px;
	height: 550px;
	margin: 5px auto;
	border: solid black 0.3px;
	float: right;
}
</style>


</head>
<body>
	<div id="wrapper">
		<div id="upper_bar">
			<a href="">쇼핑몰 메인</a><a href="">로그아웃</a>
		</div>
		
		<br> <img src="" type="button">
		<div id="header">
			<a href="./sellerIndex.do">메인</a> | <a href="./sellerManageProduct.do">강의 관리</a> | <a href="./sellerManageOrder.do">주문 관리</a> | <a href="./sellerManageMember.do">회원 관리</a> | 
			<a href="./sellerManageReview.do">리뷰 관리</a> | <a href="./sellerManageQnA.do">QnA 관리</a> | <a href="./sellerManagePaycheck.do">지급 관리</a>
		</div>
		<div id="left_box">
			<div id="admin_menu">
				환영합니다.<br>(닉네임아이디들어가야함)<br>
				<button onclick="">로그아웃</button>
				<br>
				<a href=""><button>관리자계정설정</button></a>

			</div>
			<br>
			
	
		</div>
		<div id="search_box">
            <form action="./sellerManagePaycheck.do" method="get">
            <table>
            <tr class="table-primary">
            <th>지급날짜</th>
                <th><input type="date" name="startDate">~<input type="date" name="endDate"></th></tr>
                        
                        
            <tr class="table-secondary">
            <th>지급완료금액</th>
                <th><input type="text" name="minPrice">~<input type="text" name="maxPrice"></th></tr>
               
            <tr class="table-primary">
                <th>지급여부</th>
                    <th>
                    <input type="radio" name="pd_isPaidToTeacher" value="0">미지급  |
                    <input type="radio" name="pd_isPaidToTeacher" value="1">지급완료</th>
                    </tr>
            
            <tr class="table-secondary">
           
                 <th>키워드</th>
                <th><select name="keyword">
              		<option></option>
                    <option value="o_idx">주문번호</option>
                    <option value="p_idx">강의번호</option>
                    <option value="p_name">강의명</option>
                    <option value="p_teacher">강사명</option>
                </select>
                <input type="text" name="value"></th>
                   
                    </tr>
            
            <tr class="table-primary">
                <th>
                <button type="submit" style="float: right">검색</button></th>
            </tr>
            </table>
                </form>
        </div><br>
		<div id="content_box">
		<form action="./updatePaycheckByIdx.do" method="post">
			<table class="table-responsive table-hover">
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">주문번호</th>
						<th scope="col">강의번호</th>
						<th scope="col">강의명</th>
						<th scope="col">강사명</th>
						<th scope="col">수수료율</th>
						<th scope="col">지급예정금액(주문금액*수수료율)</th>
						<th scope="col">지급완료금액</th>
						<th scope="col">지급여부</th>
						<th scope="col">지급날짜</th>
						<th scope="col">지급확인</th>
					</tr>
				</thead>
				
				<tbody>
				
				
						<!--lhe: forEach문으로 반복해서 리스트 가져오기-->
						<c:forEach var="paycheckDataList" items="${paycheckDataList }">
						<tr>
							<th scope="row">
							<input type="checkbox" name="o_idx" value="${paycheckDataList.paycheckDataVO.o_idx }">
							<input type="hidden" name="pd_isPaidToTeacher" value="1">
							</th>
							<th scope="row">${paycheckDataList.paycheckDataVO.o_idx }</th>
							<th scope="row">${paycheckDataList.orderDataVO.p_idx }</th>
							<th scope="row">${paycheckDataList.productDataVO.p_name }</th>
							<th scope="row">${paycheckDataList.paycheckDataVO.p_teacher }</th>
							<th scope="row">${paycheckDataList.productDataVO.p_commissionRate }</th>
							<th scope="row">tbd</th>
							
							<!-- lhe: 지급여부에 따라 지급 완료금액/미지급으로 분기 나눔.-->
							<c:choose>
							<c:when test="${paycheckDataList.paycheckDataVO.pd_isPaidToTeacher == 0}">
							<th scope="row">미지급</th>
							</c:when>
							<c:when test="${paycheckDataList.paycheckDataVO.pd_isPaidToTeacher == 1}">
							<th scope="row">tbd</th>
							</c:when>
							</c:choose>
							
				
								<!-- lhe: 지급여부 키워드로 치환.-->
							<c:choose>
							<c:when test="${paycheckDataList.paycheckDataVO.pd_isPaidToTeacher == 0}">
							<th scope="row">미지급</th>
							</c:when>
							<c:when test="${paycheckDataList.paycheckDataVO.pd_isPaidToTeacher == 1}">
							<th scope="row">지급완료</th>
							</c:when>
							</c:choose>
							<th scope="row">${paycheckDataList.paycheckDataVO.pd_paidDate }</th>
							
							<th scope="row"><a href=""><button>지급완료</button></a></th>
						</tr>
						</c:forEach>						
						
				</tbody>
				
			</table>
			<button type="submit" style="float: right">지급완료</button>
			</form>
		</div>

	</div>









	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
</body>
</html>