<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

 <script>
  function showPopup() { 
     window.open("checkPW", "비밀번호 확인", "width=400, height=300, left=100, top=50"); }
  </script>
</head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div id="wrapper">
      <c:choose>
         <c:when test="${!empty sessionData.m_idx }">
            ${sessionData.m_nick }님 환영합니다.
            <a href="./logoutAction">로그아웃</a>
            <a href="./mainPage">메인페이지로</a>
            <br>

         </c:when>
         <c:when test="${!empty sessionData.ad_idx }">
            ${sessionData.ad_nick }님 환영합니다.
            <a href="./logoutAction">로그아웃</a>
            <a href="./mainPage">메인페이지로</a>
               <br>
            </c:when>
         <c:otherwise>
            비회원님 환영합니다.
            <a href="./loginForm">로그인 페이지로</a><br>
            <a href="./mainPage">메인페이지로</a>
         </c:otherwise>
      </c:choose>
      <table border="1">
         <tr>
            <td>문의</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>비밀글</td>
         </tr>
            <c:forEach var="boardDataVO" items="${boardDataList }">
            <tr>
               <td><c:choose>
               <c:when test="${boardDataVO.contentDataVO.b_qCategory eq'0'} ">
               상품문의</c:when>
               <c:otherwise>
               결제문의
               </c:otherwise>
               </c:choose>
                <td><c:choose>
               <c:when test="${boardDataVO.contentDataVO.b_isHidden eq'0' }">
               <a href="./readQnAContentPage?b_idx=${boardDataVO.contentDataVO.b_idx }">
                  ${boardDataVO.contentDataVO.b_title}</a>
                  </c:when>
                  <c:otherwise>
                 
                  <form action="./readQnAContentPage" method="post">
                        <input type="hidden" name="b_idx" value="${boardDataVO.contentDataVO.b_idx }">
                        <input type="password" placeholder="비밀번호를 입력해주세요" name="b_pw">
                        <input type="submit"  value="확인">
                  </form>
                  <!-- <input type="button" value="비밀글입니다" onclick="showPopup();" /> -->
                  
                  </c:otherwise>
                </c:choose>
               <td>${boardDataVO.memberDataVO.m_nick }</td>
               <td>${boardDataVO.contentDataVO.b_postdate}</td>
               <td><c:choose> 
                        <c:when test="${boardDataVO.contentDataVO.b_isHidden eq'0' }">
                     공개글
                  </c:when>
               <c:otherwise>비밀글</c:otherwise></c:choose></td>
            </tr>
               </c:forEach>
            
      </table>
      <br>
      <c:if test="${!empty sessionData }">
         <a href="./writeQnAContentForm">질문 작성</a>
      </c:if>

      <br>
      </div>
         <div id="search">
      <form action="./qnaBoardPage" method="get">
      <input type="hidden" name="b_type" value="2" >
      검색대상 : <select name="searchTarget">
         <option value="b_title" selected>제목</option>
         <option value="b_content">내용</option>
         <option value="m_nick">작성자</option>
         
      </select>
         검색어 : <input type="text" name="searchWord">
         <input type="submit" value="serach">
         
      </form>
      </div>
<script>
/*
var goodURL  = "#"  //이곳에 인증이 되었을때 이동할 페이지  입력
    alert("패스워드를 입력하셔야 합니다.")

var password =  prompt("PASSWD 입력","")

   function checkPW(){

    if (password == null)  {
        alert("출입금지")
        location  = history.back();        // 실패시 이동 주소       history.back();를 넣어도 됨
    }
    else  {
        var  combo =  password
        var  total =  combo.toLowerCase()

    if  (total == "1234")  {                // 비밀번호
        location  =  goodURL
    }
    else  {
        alert("출입금지")
        location  = history.back();    // 실패시 이동 주소      history.back();를 넣어도 됨
    }
   }
}
*/
</script>

</body>
</html>