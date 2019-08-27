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
														url : "/updateNoticeAction",
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
	
</head>
<body>
	<div id="wrapper">
		<h1>공지 수정</h1>
		<form action="./updateQnAAction" method="post"
			enctype="multipart/form-data">
			제목 : <input type="text" name="b_title"
				value="${boardDataVO.contentDataVO.b_title }" id="b_title">
			<br> Nick : ${sessionData.ad_nick } <br> 내용 : <br>
			<textarea rows="20" cols="50" name="b_content" id="b_content">${boardDataVO.contentDataVO.b_content }</textarea>
			<br> <br> <input type="hidden"
				value="${boardDataVO.contentDataVO.b_idx }" name="b_idx" id="b_idx">
			<input type="hidden" value="${sessionData.ad_idx}" name="ad_idx"
				id="ad_idx"> <input type="hidden" name="b_pw"
				value="noticePW" id="b_pw">

			 <input type="submit" value="수정완료">
		</form>
	</div>
</body>
</html>