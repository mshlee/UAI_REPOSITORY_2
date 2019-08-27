<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.allCheck {
	float: left;
	width: 200px;
}

.allCheck input {
	width: 16px;
	height: 16px;
}

.allCheck label {
	margin-left: 10px;
}

.delBtn {
	float: right;
	width: 300px;
	text-align: right;
}

.delBtn button {
	font-size: 18px;
	padding: 5px 10px;
	border: 1px solid #eee;
	background: #eee;
}

.checkBox {
	float: left;
	width: 30px;
}

.checkBox input {
	width: 16px;
	height: 16px;
}
</style>
</head>
<body>
	<ul>
		<li>
			<div class="allCheck">
				<input type="checkbox" name="allCheck" id="allCheck" /><label
					for="allCheck">모두 선택</label>
				<script>
					$("#allCheck").click(function() {
						var chk = $("#allCheck").prop("checked");
						if (chk) {
							$(".chBox").prop("checked", true);
						} else {
							$(".chBox").prop("checked", false);
						}
					});
				</script>
			</div>

			<div class="delBtn">
				<button type="button" class="selectDelete_btn">선택 삭제</button>
				<script>
					$(".selectDelete_btn").click(function() {
						var confirm_val = confirm("정말 삭제하시겠습니까?");

						if (confirm_val) {
							var checkArr = new Array();

							$("input[class='chBox']:checked").each(function() {
								checkArr.push($(this).attr("data-cartNum"));
							});

							$.ajax({
								url : "/deleteFileForm",
								type : "post",
								data : {
									chbox : checkArr
								},
								success : function(result) {
									if (result == 1) {
										location.href = "/listFilePage";
									} else {
										alert("삭제 실패");
									}
								}
							});

						}
					});
				</script>
			</div>

		</li>

		<c:forEach items="${boardDataVO.fileList}" var="file">
			<li>
				<div class="checkBox">
					<input type="checkbox" name="chBox" class="chBox"
						data-cartNum="${file.f_idx}" />
					<script>
						$(".chBox").click(function() {
							$("#allCheck").prop("checked", false);
						});
					</script>
				</div>

				<div class="thumb">
					<img src="${file.f_path}" style="width: 200px; height: 150px" />
				</div>

				<div class="delete">
					<button type="button" class="delete_btn"
						data-cartNum="${file.f_idx}">삭제</button>
				</div>

			</li>
		</c:forEach>
	</ul>
</body>
</html>