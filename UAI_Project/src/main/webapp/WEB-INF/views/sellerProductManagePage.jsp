<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UAI-강의 관리</title>
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
	overflow: auto;
	width: 1100px;
	height: 550px;
	margin: 5px auto;
	border: solid black 0.3px;
	float: right;
}
</style>

<script type="text/javascript">

function delchk(){
    return confirm("정말 삭제하시겠습니까?");
}

</script>

</head>
<body>
	<div id="wrapper">
		<div id="upper_bar">
			<a href="">쇼핑몰 메인</a><a href="">로그아웃</a>
		</div>
		<br> <img src="" type="button">
		<div id="header">
			<a href="./sellerIndex">메인</a> | <a href="./sellerManageProduct">강의 관리</a> | <a href="./sellerManageOrder">주문 관리</a> | <a href="./sellerManageMember">회원 관리</a> | 
			<a href="./sellerManageReview">리뷰 관리</a> | <a href="./sellerManageQnA">QnA 관리</a> | <a href="./sellerManagePaycheck">지급 관리</a> | <a href="./sellerDashboard">통계 관리</a>
		</div>
		<div id="left_box">
		
			<div id="admin_menu">
			<c:choose>
			<c:when test="${!empty sessionData }">
				환영합니다.<br>${sessionData.ad_nick }<br>
				<a href="./logoutAction"><button>로그아웃</button></a>
				<br>
				<a href="./sellerManageAdmin"><button>관리자계정설정</button></a>
					</c:when>
			<c:otherwise>
			<a href="./loginForm">관리자 로그인</a>
			</c:otherwise>
			</c:choose>
			</div>
			<br>
			<a href="./sellerNewProduct">강의 등록</a>
	
		</div>
		<div id="search_box">
            <form action="./sellerManageProduct" method="get">
            <table>
            <tr class="table-primary">
                <th>카테고리</th>
                <th><select name="p_type">
                	<option></option>
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
                    <th><input type="date" name="startDate">~<input type="date" name="endDate"></th></tr>
            
            <tr class="table-primary">
                <th>수강료</th>
                <th><input type="text" name="minPrice">~<input type="text" name="maxPrice"></th>
            </tr>
            <tr class="table-secondary">
                <th>키워드</th>
                <th><select name="keyword">
              		<option></option>
                    <option value="p_name">강의명</option>
                    <option value="p_idx">강의번호</option>
                    <option value="p_teacher">강사명</option>
                    <option value="p_location">장소</option>
                </select><input type="text" name="value"></th>
            </tr>
            <tr class="table-primary">
                <th>
                <button type="submit" style="float: right">검색</button></th>
            </tr>
            </table>
                </form>
        </div><br>
		<div id="content_box">
		<form action="./sellerDeleteProductsByIdx" name="list" method="post" onsubmit="return confirm('정말 삭제하시겠습니까?')">
			<table class="table-responsive table-hover">
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">강의번호</th>
						<th scope="col">카테고리</th>
						<th scope="col">강의명</th>
						<th scope="col">원 가격</th>
						<th scope="col">판매 가격</th>
						<th scope="col">강사명</th>
						<th scope="col">지역</th>
						<th scope="col">현재수강인원</th>
						<th scope="col">최대수강인원</th>
						<th scope="col">강의시작일</th>
						<th scope="col">강의종료일</th>
						<th scope="col">강의시간</th>
						<th scope="col">강의일자</th>
						<th scope="col">등록일</th>
						<th scope="col">강의수정</th>
						<th scope="col">강의삭제</th>
					</tr>
				</thead>

				<tbody>
				

						<!--lhe: forEach문으로 반복해서 리스트 가져오기-->
						<c:forEach var="productDataList" items="${productDataList }">
						<tr>
							<th scope="row"><input type="checkbox" name="idx[]" value="${productDataList.p_idx }"></th>
							<th scope="row">${productDataList.p_idx }</th>
							
							
							<!-- lhe: 상품 타입 번호를 키워드로 치환 -->
							<c:choose>
							<c:when test="${productDataList.p_type == '0'}">
							<th scope="row">언어</th>
							</c:when>
							<c:when test="${productDataList.p_type == '1'}">
							<th scope="row">IT/컴퓨터</th>
							</c:when>
							<c:when test="${productDataList.p_type == '2'}">
							<th scope="row">미술</th>
							</c:when>
							<c:when test="${productDataList.p_type == '3'}">
							<th scope="row">음악</th>
							</c:when>
							<c:when test="${productDataList.p_type == '4'}">
							<th scope="row">스포츠</th>
							</c:when>
							<c:when test="${productDataList.p_type == '5'}">
							<th scope="row">기타</th>					
							</c:when>
							</c:choose>

							<th scope="row">${productDataList.p_name }</th>
							<th scope="row">${productDataList.p_originalPrice }</th>	
							<th scope="row">${productDataList.p_nowPrice }</th>
							<th scope="row">${productDataList.p_teacher }</th>
							<th scope="row">${productDataList.p_location }</th>
							<th scope="row">0</th>
							<th scope="row">${productDataList.p_maxStudent }</th>
							<th scope="row">${productDataList.p_startDate }</th>
							<th scope="row">${productDataList.p_lastDate }</th>
							<th scope="row">${productDataList.p_lectureTime }</th>
							<th scope="row">${productDataList.p_lectureDay }</th>
							<th scope="row">${productDataList.p_postDate }</th>
							<th scope="row"><a href="./sellerUpdateProductByIdx?p_idx=${productDataList.p_idx }">수정</a></th>
							<th scope="row"><a href="./sellerDeleteProductByIdx?p_idx=${productDataList.p_idx }" onclick="return delchk()">삭제</a></th>
						</tr>
						</c:forEach>
						
					
				</tbody>
			</table>
			
			<button type="submit" style="float: right">선택삭제</button>
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