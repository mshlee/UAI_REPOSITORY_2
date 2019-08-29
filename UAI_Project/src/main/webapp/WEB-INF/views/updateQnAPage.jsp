<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script src="//cdn.ckeditor.com/4.7.1/standard/ckeditor.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						CKEDITOR.replace('b_content');
						CKEDITOR.config.height = 500;

						//밑의 list 버튼 클릭 시 위치 설정
						$("#list").click(function() {
							location.href = "/boardNoticePage";
						});

						$("#save")
								.click(
										function() {

											//에디터 내용 가져옴
											var b_content = CKEDITOR.instances.content
													.getData();

											//널 검사
											if ($("#b_title").val().trim() == "") {
												alert("제목을 입력하세요.");
												$("#b_title").focus();
												return false;
											}

											if ($("#b_content").val().trim() == "") {
												alert("작성자를 입력하세요.");
												$("#b_content").focus();
												return false;
											}

											//값 셋팅
											//id= idx
											//subject = title
											//writer = nick
											//password = pw
											//content = content
											var objParams = {

												id : $("#b_idx").val(),
												subject : $("#b_title").val(),
												writer : $(
														"#sessionData.ad_nick")
														.val(),
												password : $("#b_pw").val(),
												content : content
											};

											//ajax 호출
											$
													.ajax({
														url : "/updateQnAAction",
														dataType : "json",
														contentType : "application/x-www-form-urlencoded; charset=UTF-8",
														type : "post",
														data : objParams,
														success : function(
																retVal) {
															//url = form action 위치와 동일. 이후 리다이렉트하여 돌아갈 위치는 밑의 location.href= 에 작성.
															if (retVal.code == "OK") {
																alert(retVal.message);
																location.href = "/boardNoticePage";
															} else {
																alert(retVal.message);
															}

														},
														error : function(
																request,
																status, error) {
															console
																	.log("AJAX_ERROR");
														}
													});

										});

					});
</script>
<script type="text/javascript">
	function getExtension(filename) {
		return filename.split('.').pop().toLowerCase();
	}
	function fileCheck() {
		var uploadFile = $("input[name=files]").val();
		if (uploadFile == "") {
			alert("파일을 첨부하지 않았습니다")
			return;
		} else {
			var extension = getExtension(uploadFile);
			alert(extension);
			switch (extension) {
			case 'jpg':
			case 'jpeg':
			case 'png':
			case 'bmp':
				$("#uploadForm").submit();
				break;
			default:
				alert("이미지 파일만 업로드 가능합니다.");
			}
		}
	}
</script>
      <script type="text/javascript">
      function fn_test2(value){
         if(value=="1"){
            document.getElementById("p_idx").style.display = "none";
         }else{
            document.getElementById("p_idx").style.display = "block";
            
         }
      }
      </script>
            <script type="text/javascript">
      function fn_test(value){
         if(value=="0"){
            document.getElementById("b_pw").style.display = "none";
         }else{
            document.getElementById("b_pw").style.display = "block";
            
         }
      }
      </script>

</head>
<body>

	<div id="question-box">
		<form onsubmit="return checkz()" action="./updateQnAAction"
			method="post" enctype="multipart/form-data">
			Title : <input type="text" name="b_title" id="b_title"
				value="${boardDataVO.contentDataVO.b_title }"
				placeholder="제목을 입력해주세요"> <br> Nick :
			${sessionData.m_nick } <br>
			<div id="is-hidden">
				<select name="b_isHidden" class="form-control" id="b_isHidden"
					onchange="fn_test(this.value);">
					<option value="0">공개글</option>
					<option value="1" selected>비밀글</option>
				</select>
			</div>
			<br> <br>
			<div id="is-hidden2">
				<select name="b_qCategory" class="form-control" onchange="fn_test2(this.value)">
					<option value="0" selected>상품문의</option>
					<option value="1">결제문의</option>
				</select>
			</div>
			<br>
			<textarea name="b_content" id="b_content">${boardDataVO.contentDataVO.b_content }</textarea>
			<br> <input type="hidden" value="${sessionData.m_idx}"
				name="m_idx"> <input type="hidden" value="0" name="ad_idx">
			<div id="b_pw" style="display: block" class="col-lg-12">
			
				게시물PW: <input type="password" name="b_pw"
					placeholder="비밀번호 미입력시 접근이 어려울 수 있습니다" maxlength="15"
					value="${boardDataVO.contentDataVO.b_pw }">
			</div>
			<input type="hidden" value="${product.p_name }" name="p_name">
			<input type="hidden" value="2" name="b_type"> <input
				type="hidden" value="${boardDataVO.contentDataVO.b_idx }"
				name="b_idx"> <br> 
				<select name="p_idx" id="p_idx">
					<c:forEach var="product" items="${productVO }">
					<option value="${product.p_idx }">강의명: ${product.p_name } 선생님 : ${product.p_teacher}</option>
					</c:forEach>
				</select>
			<div id="reivew-button">
				<input class="btn btn-info" type="submit" value="글쓰기">
			</div>
		</form>
		<c:forEach var="file" items="${boardDataVO.fileList }">
				미리보기:<img src="${file.f_path }" style="width: 200px; height: 150">${file.f_originalName } 
				<form action="./fileDeleteActionByUpdatePage" method="post">
				<input type="hidden" name="f_idx" value="${file.f_idx }"> <input
					type="hidden" name="b_idx" value="${file.b_idx }"> <input
					type="hidden" name="b_type" value="0"> <input type="submit"
					value="삭제">
			</form>

		</c:forEach>
		<form id="uploadForm" action="./fileUpdateAction" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="b_idx"
				value="${boardDataVO.contentDataVO.b_idx }"> <input
				type="hidden" name="b_type" value="0">
			<table>
				<tr>
					<th>파일선택</th>
					<td><input type="file" name="files" multiple="multiple" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="button" value="업로드" onclick="fileCheck()" /></td>
				</tr>
			</table>


		</form>
	</div>
	</div>
</body>
</html>