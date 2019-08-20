<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UAI-리뷰 관리</title>
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
			<a href="./index.do">메인</a> | <a href="./manageProduct.do">강의 관리</a> | <a href="./manageOrder.do">주문 관리</a> | <a href="./manageMember.do">회원 관리</a> | 
			<a href="./manageReview.do">리뷰 관리</a> | <a href="./manageQnA.do">QnA 관리</a> | <a href="./managePaycheck.do">지급 관리</a>
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
            <form action="./manageReview.do" method="get">
            <table>
            <tr class="table-primary">
            <th>작성일</th>
                <th><input type="date" name="startDate">~<input type="date" name="endDate"></th></tr>
               
            <tr class="table-secondary">
            <th>별점</th>
               <th><input type="text" name="minRate">~<input type="text" name="maxRate"></th>
                    </tr>
            
            <tr class="table-primary">
                <th>키워드</th>
                <th><select name="keyword">
              		<option></option>
              		<option value="b_referidx">글번호</option>
              		<option value="b_title">글제목</option>
              		<option value="p_idx">강의번호</option>
              		<option value="p_name">강의명</option>
                    <option value="m_idx">회원번호</option>
                    <option value="m_name">이름</option>
                    <option value="m_id">아이디</option>
                    <option value="m_nick">닉네임</option>
                </select><input type="text" name="value"></th>
            </tr>
            <tr class="table-secondary">
                <th>
                <button type="submit" style="float: right">검색</button></th>
            </tr>
            </table>
                </form>
        </div><br>
		<div id="content_box">
		<form action="./deleteReviewByIdx.do" method="post">
			<table class="table-responsive table-hover">
				<thead>
					<tr>
						<th scope="col">선택</th>
<<<<<<< HEAD
						<th scope="col">글번호</th>
=======
						<th scope="col">no.</th>
						<th scopㄷ="col">글번호</th>
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
						<th scope="col">강의번호</th>
						<th scope="col">강의명</th>
						<th scope="col">회원번호</th>
						<th scope="col">아이디</th>
						<th scope="col">닉네임</th>
						<th scope="col">회원명</th>
						<th scope="col">글제목</th>
<<<<<<< HEAD
						<th scope="col">조회수</th>
						<th scope="col">작성일</th>
=======
						<th scope="col">별점</th>
						<th scope="col">조회수</th>
						<th scope="col">작성일</th>
						<th scope="col">삭제</th>
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
					</tr>
				</thead>

				<tbody>
				
						<!--lhe: forEach문으로 반복해서 리스트 가져오기-->
<<<<<<< HEAD
						<c:forEach var="reviewDataList" items="${reviewDataList }" varStatus="status">
						<tr>
							<th scope="row"><input type="checkbox" name="b_referidx" value="${reviewDataList.contentDataVO.b_referidx}"></th>
							<th scope="row">${status.count}</th>
							<th scope="row">${reviewDataList.contentDataVO.b_referidx }</th>
							<th scope="row">${reviewDataList.contentDataVO.p_idx }</th>
							<th scope="row">${reviewDataList.productVO.p_name }</th>
=======
						<c:forEach var="reviewDataList" items="${reviewDataList }">
						<tr>
							<th scope="row"><input type="checkbox" name="b_referidx" value="${reviewDataList.contentDataVO.b_referidx}"></th>
							<th scopte="row">  </th>
							<th scope="row">${reviewDataList.contentDataVO.b_referidx }</th>
							<th scope="row">${reviewDataList.contentDataVO.p_idx }</th>
							<th scope="row">${reviewDataList.productDataVO.p_name }</th>
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
							<th scope="row">${reviewDataList.contentDataVO.m_idx }</th>
							<th scope="row">${reviewDataList.memberDataVO.m_id }</th>
							<th scope="row">${reviewDataList.memberDataVO.m_nick }</th>
							<th scope="row">${reviewDataList.memberDataVO.m_name}</th>
							<th scope="row">${reviewDataList.contentDataVO.b_title}</th>
<<<<<<< HEAD
							<th scope="row">${reviewDataList.memberDataVO.m_name}</th>
							<th scope="row">${reviewDataList.contentDataVO.b_count}</th>
							<th scope="row">${reviewDataList.contentDataVO.b_postdate}</th>
=======
							<th scope="row">${reviewDataList.contentDataVO.p_starRate}</th>
							<th scope="row">${reviewDataList.contentDataVO.b_count}</th>
							<th scope="row">${reviewDataList.contentDataVO.b_postdate}</th>
							<th scope="row"><a href="./deleteReviewByIdx?p_idx=${contentDataVO.b_idx}"><button>삭제</button></a></th>
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
						</tr>
						</c:forEach>
				</tbody>
			</table>
			<button type="submit" style="float: right">삭제</button>
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