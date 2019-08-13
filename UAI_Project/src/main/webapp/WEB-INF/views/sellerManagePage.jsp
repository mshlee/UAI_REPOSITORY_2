<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UAI-판매자 메인</title>
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
			<a href="">쇼핑몰메인</a><a href="">로그아웃</a>
		</div>
		<br> <img src="" type="button">
		<div id="header">
			<a href="">메인</a> <a href="">상품관리</a> <a href="">주문관리</a> <a href="">회원관리</a>
			<a href="">리뷰관리</a> <a href="">QnA관리</a> <a href="">지급관리</a>
		</div>
		<div id="left_box">
			<div id="admin_menu">

				환영합니다.<br>
				<button onclick="">로그아웃</button>
				<br>
				<button onclick="">관리자계정설정</button>

			</div>

		</div>
		<div id="search_box">
            <form action="" method="post">
            <table>
            <tr class="table-primary">
                <th>카테고리</th>
                <th><select name="p_type">
                    <option value="0">언어</option>
                    <option value="1">IT/컴퓨터</option>
                    <option value="2">미술</option>
                    <option value="3">음악</option>
                    <option value="4">스포츠</option>
                    <option value="5">기타</option>
                </select></th>
            </tr>
            <tr class="table-secondary">
                <th>등록기간</th>
                    <th><input type="date">~<input type="date"></th></tr>
            
            <tr class="table-primary">
                <th>수강료</th>
                <th><input type="text" name="minPrice">~<input type="text" name="maxPrice"></th>
            </tr>
            <tr class="table-secondary">
                <th>키워드</th>
                <th><select name="keyword">
                    <option value="p_name">강의명</option>
                    <option value="p_idx">강의번호</option>
                    <option value="pc_teacher">강의번호</option>
                </select><input type="text" name="value"></th>
            </tr>
            <tr class="table-primary">
                <th>
                <button type="submit" id="btn-primary" style="float: right">검색</button></th>
            </tr>
            </table>
                </form>
        </div><br>
		<div id="content_box">
			<table class="table-responsive table-hover">
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">강의번호</th>
						<th scope="col">카테고리</th>
						<th scope="col">강의명</th>
						<th scope="col">할인율</th>
						<th scope="col">원 가격</th>
						<th scope="col">판매 가격</th>
						<th scope="col">할인율</th>
						<th scope="col">수수료</th>
						<th scope="col">강사명</th>
						<th scope="col">지역</th>
						<th scope="col">현재수강인원</th>
						<th scope="col">최대수강인원</th>
						<th scope="col">강의시작일</th>
						<th scope="col">강의종료일</th>
						<th scope="col">강의시간</th>
						<th scope="col">강의일자</th>
						<th scope="col">등록일</th>
					</tr>
				</thead>

				<tbody>
					<form action="" method="post">

						<!--forEach문으로 반복해서 리스트 가져오기-->
						<tr>
							<th scope="row"><input type="checkbox" name="b_idx"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
							<th scope="row"></th>
						</tr>
					</form>
				</tbody>
			</table>
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