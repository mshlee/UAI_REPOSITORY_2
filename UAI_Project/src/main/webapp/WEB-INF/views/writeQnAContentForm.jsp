<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div id="wrapper">
      <form action="./writeContentAction" method="post" enctype="multipart/form-data">
      <input type = "checkbox" name = "b_qCategory" 
         id = "b_qCategory1"   value = "0">상품문의<br>
        <input type = "checkbox" name = "b_qCategory" 
         id = "b_qCategory1"  value = "1">결제문의
         제목 : <input type="text" name="b_title"> <br><br>
         닉네임 : ${sessionData.m_nick } <br><br>
         내용 : <textarea rows="20" cols="50" name="b_content"></textarea> <br><br>
         <input type="hidden" value="${sessionData.m_idx }" name="m_idx">
         <br>
         
         <input type = "checkbox" name = "b_isHidden" 
         id = "b_isHidden" value = "0">비밀 글<br>
         PW: <input type="password" name="b_pw">
         <input type = "checkbox" name = "b_isHidden" 
         id = "b_isHidden" value = "1">공개 글
         <input type="file" name="files" multiple> <br>
         <input type="submit" value="글쓰기">
      </form>
   </div>
</body>


</html>