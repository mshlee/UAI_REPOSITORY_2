<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판 글쓰기</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
   
   
   function fn_test(value){
      if(value=="0"){
         document.getElementById("b_pw").style.display = "none";
      }else{
         document.getElementById("b_pw").style.display = "block";
         
      }
   }
</script>
<script>
/* if(secretpw==1){
	  password 입력창 나오게 설정
	  password 확인버튼 클릭function(
	      if(password==입력한pwd값){
	          게시글 상세화면 조회
	     }else{ alert(비밀번호 틀렸습니다).}

	)

	} */


   function checkz(){

      
      
      
         if(!document.b_title.value){
           alert("제목을 입력해주세요");
           document.b_title.focus();
           return false;
         }
         if(!document.b_content.value){
              alert("내용을 입력해주세요");
              document.b_content.focus();
              return false;
         }
         if(!document.b_pw.value){
              alert("글의 비밀번호를 입력해주세요");
              document.b_pw.focus();
              return false;
         }
         return true;
   }
</script>
</head>

<body>
<div id="wrapper">
      <form onsubmit="return checkz()" action="./writeQnAContentAction" method="post" enctype="multipart/form-data">
         제목 : <input type="text" name="b_title" id="b_title" placeholder="제목을 입력해주세요"> <br><br>
         닉네임 : ${sessionData.m_nick } <br>
         <select name ="b_isHidden" class="form-control" id="b_isHidden" onchange="fn_test(this.value);">
         <option value="0">공개글</option>
         <option value="1" selected>비밀글</option>
         </select><br>
         <select name="b_qCategory">
            <option value="0" selected>상품문의</option>
            <option value="1">결제문의</option>
         </select>
         <input type="hidden" name="p_idx" value="1">
         내용 : <textarea rows="20" cols="50" name="b_content" id="b_content" placeholder="내용을 입력해주세요"></textarea> <br><br>
         <input type="hidden" value="${sessionData.m_idx}"  name="m_idx">
         <div id="b_pw" style="display:block"  class="col-lg-12">
         게시물PW: <input type="password" name="b_pw"  placeholder="비밀번호를 입력해주세요" maxlength="15">
         </div>
         <br>
         <input type="file" name="files" multiple> <br>
         <input type="submit" value="글쓰기">
      </form>
   </div>
</body>
</html>