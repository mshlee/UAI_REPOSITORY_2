<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

   
</head>
<body>
<div class="container-fluid" id="wrapper">
      회원 가입 <br>
      <form action="./joinMemberAction" method="post">
         ID : <input id = "inputID" type="text" name="m_id" onblur = "confirmID()"><br>
         <div id = "result_box"></div>
         PW : <input type="text" name="m_pw"><br>
         NAME: <input type="text" name="m_name"><br>
         NICK : <input type="text" name="m_nick"><br>
         PHONE : <input type="text" name="m_phone"><br>
         ADDRESS : <input type="text" name="m_address"><br>
         GENDER: <label><input type = "radio" name = "m_gender" value = "남자" checked> 남자</label> 
            <input type = "radio" name = "m_gender" value = "여자"> 여자<br>
            BIRTH: <input id="birth" type="date" name="m_birth"><br>
           
         INTEREST1:
            <input type = "checkbox" name = "m_interest1" id = "m_interest1" onclick="CountChecked1(this);interestboxcheck();" value = "null"> 선택안함1
            <input type = "checkbox" name = "m_interest1" id = "m_interest1" onclick="CountChecked1(this);interestboxcheck();" value = "언어"> 언어
            <input type = "checkbox" name = "m_interest1" id = "m_interest1" onclick="CountChecked1(this);interestboxcheck();" value = "IT/컴퓨터"> IT/컴퓨터
            <input type = "checkbox" name = "m_interest1" id = "m_interest1" onclick="CountChecked1(this);interestboxcheck();" value = "미술"> 미술
            <input type = "checkbox" name = "m_interest1" id = "m_interest1" onclick="CountChecked1(this);interestboxcheck();" value = "음악"> 음악
            <input type = "checkbox" name = "m_interest1" id = "m_interest1" onclick="CountChecked1(this);interestboxcheck();" value = "스포츠"> 스포츠
            <br>
            
            INTEREST2:
            <input type = "checkbox" name = "m_interest2" id = "m_interest2" onclick="CountChecked2(this);interestboxcheck();" value = "null"> 선택안함2
            <input type = "checkbox" name = "m_interest2" id = "m_interest2" onclick="CountChecked2(this);interestboxcheck();" value = "언어"> 언어
            <input type = "checkbox" name = "m_interest2" id = "m_interest2" onclick="CountChecked2(this);interestboxcheck();" value = "IT/컴퓨터"> IT/컴퓨터
            <input type = "checkbox" name = "m_interest2" id = "m_interest2" onclick="CountChecked2(this);interestboxcheck();" value = "미술"> 미술
            <input type = "checkbox" name = "m_interest2" id = "m_interest2" onclick="CountChecked2(this);interestboxcheck();" value = "음악"> 음악
            <input type = "checkbox" name = "m_interest2" id = "m_interest2" onclick="CountChecked2(this);interestboxcheck();" value = "스포츠"> 스포츠
            <br>
            
            INTEREST3:
            <input type = "checkbox" name = "m_interest3" id = "m_interest3" onclick="CountChecked3(this);interestboxcheck();" value = "null"> 선택안함3
            <input type = "checkbox" name = "m_interest3" id = "m_interest3" onclick="CountChecked3(this);interestboxcheck();" value = "언어"> 언어
            <input type = "checkbox" name = "m_interest3" id = "m_interest3" onclick="CountChecked3(this);interestboxcheck();" value = "IT/컴퓨터"> IT/컴퓨터
            <input type = "checkbox" name = "m_interest3" id = "m_interest3" onclick="CountChecked3(this);interestboxcheck();" value = "미술"> 미술
            <input type = "checkbox" name = "m_interest3" id = "m_interest3" onclick="CountChecked3(this);interestboxcheck();" value = "음악"> 음악
            <input type = "checkbox" name = "m_interest3" id = "m_interest3" onclick="CountChecked3(this);interestboxcheck();" value = "스포츠"> 스포츠
            <br>
           
              <br>
            EDUCATION:  
            <select name ="m_education"> 
               <option value = "중졸이하">중졸이하</option>
                <option value = "고등학생">고등학생</option>
                <option value = "고졸">고졸</option> 
                <option value = "대학생">대학생</option>
                <option value = "대졸">대졸</option>
                <option value = "대졸이상">대졸이상</option>
            </select>
            <br>
            
            <br>
            MAJOR: <br>
              *본인의 전공을 입력해주세요. <br>
              *전공이 없을 시에는 빈칸으로 남겨두세요 :) <br>
              <input type="text" name="m_major"><br>
              
              <br>
              JOB: <br>
              *본인의 직업을 입력해주세요. <br>
              <input type="text" name="m_job"><br>
              
              <br>
              MARITALSTATUS:
              <label><input type = "radio" name = "m_maritalstatus" value = "미혼" checked>미혼</label> 
            <input type = "radio" name = "m_maritalstatus" value = "기혼">기혼<br>
              
              <br>
              <a href="./mainPage">메인 페이지로 돌아가기</a>
         <input type="submit" value="회원 가입">
         
         
      </form>
   </div>
</body>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/addressapi.js"></script>

<script language=Javascript>
   var maxChecked1 = 1;   //선택가능 갯수
   var totalChecked1 = 0; // 설정 끝

   function CountChecked1(m_interest1) {
       if (m_interest1.checked)
           totalChecked1 += 1;
       else
           totalChecked1 -= 1;

       if (totalChecked1 > maxChecked1) {
        
       m_interest1.checked = false;
       totalChecked1 -= 1;
       }
    
   }
   function ResetCount(){
       totalChecked1 = 0;
   }
</script>

<script language=Javascript>
   var maxChecked2 = 1;   //선택가능 갯수
   var totalChecked2 = 0; // 설정 끝
   function CountChecked2(m_interest2) {
       if (m_interest2.checked)
           totalChecked2 += 1;
       else
           totalChecked2 -= 1;

       if (totalChecked2 > maxChecked2) {
              alert ("최대 1개 까지만 가능합니다.");
       
          m_interest2.checked = false;
       totalChecked2 -= 1;
       }
    
   }
   function ResetCount(){
    totalChecked2 = 0;
   }
</script>

<script language=Javascript>
   var maxChecked3 = 1;   //선택가능 갯수
   var totalChecked3 = 0; // 설정 끝

   function CountChecked3(m_interest3) {
    if (m_interest3.checked)
        totalChecked3 += 1;
    else
        totalChecked3 -= 1;

    if (totalChecked3 > maxChecked3) {
        alert ("최대 1개 까지만 가능합니다.");
    m_interest3.checked = false;
    totalChecked3 -= 1;
    }
    
   }

   function ResetCount(){
    totalChecked3 = 0;
   }
</script>

<script>
   function confirmID(){
      console.log("confirmID 호출됨 ");
      
      //ID 입력 양식에 입력된 값 가져오기 
      var id = document.getElementById("inputID").value;
      
      //AJAX 호출
       var xmlhttp = new XMLHttpRequest();
      
      //호출 후 값을 받았을 때의 처리 로직
      xmlhttp.onreadystatechange = function (){
         //자바의 interface 문법과 비슷
         if(xmlhttp.readyState==4 && xmlhttp.status == 200){//5번 호출됨 (0~4)
            //if 조건절 외의 경우에는 전부 에러페이지가 뜨는 경우
            
            //alert(xmlhttp.responseText);
         
            var result = JSON.parse(xmlhttp.responseText);
            
            //***로직 처리 및 UI 처리***
            var result_box = document.getElementById("result_box");
            
            if(result.exist == true){
               //alert("이미 존재하는 ID 입니다");
               result_box.style.color = "red";
               result_box.innerText = "이미 존재하는 ID 입니다";
            }else{
               //alert("사용 가능한 ID 입니다");
               result_box.style.color = "green";
               result_box.innerText = "사용 가능한 ID 입니다";
            }
         
         
         }
      };
      
      xmlhttp.open("post", "./isExistID", true); //호출 0번
      //AJAX는 비동기식 처리 방식 (true로 세팅해주었을시 비동기식으로 처리, false로 세팅해주었을시 동기식으로 처리)
      //스레드와 비슷한 방식의 처리
      xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xmlhttp.send("m_id=" + id); //호출 1번
   }
   
   function check(){
      
       if($("#m_id").val() == ""){
              alert("아이디는 필수입력사항입니다");
              $("#m_id").focus();
              return false;
            }
   
   
       
       
   function interestboxcheck() {
       var interest1 = document.getElementsByName("m_interest1");
       var interest2 = document.getElementsByName("m_interest2");
       var interest3 = document.getElementsByName("m_interest3");
          
          if(interest1.checked==interest3.checked){
            alert("중복선택은 불가능합니다.");
            interest3.checked=false;
            }
          
          if(interest1.checked==interest2.checked){
            alert("중복선택은 불가능합니다.");
            interest2.checked=false;
            }
          
          if(interest2.checked==interest3.checked){
            alert("중복선택은 불가능합니다.");
            interest3.checked=false;
            }
         
      }
         
   }

</script>

</html>