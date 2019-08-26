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

#content_box {
   overflow: auto;
   width: 1100px;
   height: 750px;
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
         <a href="./sellerIndex.do">메인</a> | <a href="./sellerManageProduct.do">강의 관리</a> | <a href="./sellerManageOrder.do">주문 관리</a> | <a href="sellerManageMember.do">회원 관리</a> | 
         <a href="./sellerManageReview.do">리뷰 관리</a> | <a href="./sellerManageQnA.do">QnA 관리</a> | <a href="./sellerManagePaycheck.do">지급 관리</a>
      </div>
      <div id="left_box">
  	<div id="admin_menu">
			<c:choose>
			<c:when test="${!empty sessionData }">
				환영합니다.<br>${sessionData.ad_nick }<br>
				<a href="./logoutAction"><button>로그아웃</button></a>
				<br>
				<a href="./sellerManageAdmin.do"><button>관리자계정설정</button></a>
					</c:when>
			<c:otherwise>
			<a href="./loginForm">관리자 로그인</a>
			</c:otherwise>
			</c:choose>
         </div>
         <br>
         <a href="">강의 등록</a>
   
      </div>
      
      <div id="content_box">
         <form action="./newProductAction" method = "post" enctype = "multipart/form-data">
            강의명: <input type = "text" name = "p_name"><br>
            강의 카테고리: 
            <select name = "p_type">
               <option value = 0>언어</option>
               <option value = 1>IT/컴퓨터</option>
               <option value = 2>미술</option>
               <option value = 3>음악</option>
               <option value = 4>스포츠</option>
               <option value = 5>기타</option>
            </select>
            <br>
            원가: <input type = "number" name = "p_originalPrice"><br>
            할인율: <input type = "number" name = "p_discountRate"><br>
            
            <!--  <input type = "hidden" name = "p_nowPrice" value = "null"/><br>-->
            
            강사명: <input type = "text" name = "p_teacher"><br>
            최대수강인원: <input type = "number" name = "p_maxStudent"><br>
            강의시작일: <input id = "startDate" type = "date" name = "p_startDate"><br>
            강의종료일: <input id = "lastDate" type = "date" name = "p_lastDate"><br>
            강의장소: <input type = "text" name = "p_location"><br>
            <!--  
              <select name="p_location" onChange="cat1_change(this.value,h_area2)" >

                  <option>-선택-</option>
         
               <option value='1'>서울</option>
               
               <option value='2'>부산</option>
               
               <option value='3'>대구</option>
               
               <option value='4'>인천</option>
               
               <option value='5'>광주</option>
               
               <option value='6'>대전</option>
               
               <option value='7'>울산</option>
               
               <option value='8'>강원</option>
               
               <option value='9'>경기</option>
               
               <option value='10'>경남</option>
               
               <option value='11'>경북</option>
               
               <option value='12'>전남</option>
               
               <option value='13'>전북</option>
               
               <option value='14'>제주</option>
               
               <option value='15'>충남</option>
               
               <option value='16'>충북</option>
               
                 </select>
               
                 <select name="h_area2">
               
                  <option>-선택-</option>
               
                 </select>
               
               <script language=javascript>
               
                var cat1_num = new Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
               
                var cat1_name = new Array('서울','부산','대구','인천','광주','대전','울산','강원','경기','경남','경북','전남','전북','제주','충남','충북');
               
                var cat2_num = new Array();
               
                var cat2_name = new Array();
               
                cat2_num[1] = new Array(17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41);
               
                cat2_name[1] = new Array('강남구','강동구','강북구','강서구','관악구','광진구','구로구','금천구','노원구','도봉구','동대문구','동작구','마포구','서대문구','서초구','성동구','성북구','송파구','양천구','영등포구','용산구','은평구','종로구','중구','중랑구');
               
                cat2_num[2] = new Array(42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57);
               
                cat2_name[2] = new Array('강서구','금정구','남구','동구','동래구','부산진구','북구','사상구','사하구','서구','수영구','연제구','영도구','중구','해운대구','기장군');
               
                cat2_num[3] = new Array(58,59,60,61,62,63,64,65);
               
                cat2_name[3] = new Array('남구','달서구','동구','북구','서구','수성구','중구','달성군');
               
                cat2_num[4] = new Array(66,67,68,69,70,71,72,73,74,75);
               
                cat2_name[4] = new Array('계양구','남구','남동구','동구','부평구','서구','연수구','중구','강화군','옹진군');
               
                cat2_num[5] = new Array(76,77,78,79,80);
               
                cat2_name[5] = new Array('광산구','남구','동구','북구','서구');
               
                cat2_num[6] = new Array(81,82,83,84,85);
               
                cat2_name[6] = new Array('대덕구','동구','서구','유성구','중구');
               
                cat2_num[7] = new Array(86,87,88,89,90);
               
                cat2_name[7] = new Array('남구','동구','북구','중구','울주군');
               
                cat2_num[8] = new Array(91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108);
               
                cat2_name[8] = new Array('강릉시','동해시','삼척시','속초시','원주시','춘천시','태백시','고성군','양구군','양양군','영월군','인제군','정선군','철원군','평창군','홍천군','화천군','횡성군');
               
                cat2_num[9] = new Array(109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148);
               
                cat2_name[9] = new Array('고양시 덕양구','고양시 일산구','과천시','광명시','광주시','구리시','군포시','김포시','남양주시','동두천시','부천시 소사구','부천시 오정구','부천시 원미구','성남시 분당구','성남시 수정구','성남시 중원구','수원시 권선구','수원시 장안구','수원시 팔달구','시흥시','안산시 단원구','안산시 상록구','안성시','안양시 동안구','안양시 만안구','오산시','용인시','의왕시','의정부시','이천시','파주시','평택시','하남시','화성시','가평군','양주군','양평군','여주군','연천군','포천군');
               
                cat2_num[10] = new Array(149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168);
               
                cat2_name[10] = new Array('거제시','김해시','마산시','밀양시','사천시','양산시','진주시','진해시','창원시','통영시','거창군','고성군','남해군','산청군','의령군','창녕군','하동군','함안군','함양군','합천군');
               
                cat2_num[11] = new Array(169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192);
               
                cat2_name[11] = new Array('경산시','경주시','구미시','김천시','문경시','상주시','안동시','영주시','영천시','포항시 남구','포항시 북구','고령군','군위군','봉화군','성주군','영덕군','영양군','예천군','울릉군','울진군','의성군','청도군','청송군','칠곡군');
               
                cat2_num[12] = new Array(193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214);
               
                cat2_name[12] = new Array('광양시','나주시','목포시','순천시','여수시','강진군','고흥군','곡성군','구례군','담양군','무안군','보성군','신안군','영광군','영암군','완도군','장성군','장흥군','진도군','함평군','해남군','화순군');
               
                cat2_num[13] = new Array(215,216,217,218,219,220,221,222,223,224,225,226,227,228,229);
               
                cat2_name[13] = new Array('군산시','김제시','남원시','익산시','전주시 덕진구','전주시 완산구','정읍시','고창군','무주군','부안군','순창군','완주군','임실군','장수군','진안군');
               
                cat2_num[14] = new Array(230,231,232,233);
               
                cat2_name[14] = new Array('서귀포시','제주시','남제주군','북제주군');

                cat2_num[15] = new Array(234,235,236,237,238,239,240,241,242,243,244,245,246,247,248);
               
                cat2_name[15] = new Array('공주시','논산시','보령시','서산시','아산시','천안시','금산군','당진군','부여군','서천군','연기군','예산군','청양군','태안군','홍성군');
               
                cat2_num[16] = new Array(249,250,251,252,253,254,255,256,257,258,259,260);
               
                cat2_name[16] = new Array('제천시','청주시 상당구','청주시 흥덕구','충주시','괴산군','단양군','보은군','영동군','옥천군','음성군','진천군','청원군');
               
               function cat1_change(key,sel){
               
                if(key == '') return;
               
                var name = cat2_name[key];
               
                var val = cat2_num[key];
               
               
                for(i=sel.length-1; i>=0; i--)
               
                 sel.options[i] = null;
               
                sel.options[0] = new Option('-선택-','', '', 'true');
               
                for(i=0; i<name.length; i++){
               
                 sel.options[i+1] = new Option(name[i],val[i]);
               
                }
               
               }
               
               
               
               
      
            </script>
            -->
            <br>
            
            강의요일: <input type = "text" name = "p_lectureDay"><br>
            강의시간: <input type = "text" name = "p_lectureTime"><br>
            <br>
            강의 상세정보<br>
            <textarea rows = "5" cols = "80" name = "p_lectureInfo">
            </textarea>
            <br>
            
            <br>
            강사 상세정보<br>
            <textarea rows = "5" cols = "80" name = "p_teacherInfo">
            </textarea>
            <br>
            
            <br>
            기타 상세정보<br>
            <textarea rows = "5" cols = "80" name = "p_otherInfo">
            </textarea>
            <br>
            
            수수료율: <input type = "number"  name = "p_commissionRate"><br>
            
            <br>
            <input type = "file" name = "files" multiple><br>
            
            <br>
            <input type = "submit" value = "등록">
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