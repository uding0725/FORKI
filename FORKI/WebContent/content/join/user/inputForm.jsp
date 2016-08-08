<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="color.jspf"%>
<html>
<head>
<title>회원가입</title>
<link href="style.css" rel="stylesheet" type="text/css">



<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script>

$(document).ready(function(){
    // 옵션추가 버튼 클릭시
    var num = 1;
    $(".addItemBtn").click(function(){
        // item 의 최대번호 구하기
    num =  num + 1;
    var insert_tr_td = "<tr class ='item"+num+"'>  <td><input type='text' name='child' size='6' maxlength='15'/></td><td><input type='text' name='child' size='10' readonly/></td><td><input type='button' value='어린이집/유치원 찾기' onClick='childCheck()''></td><td><button class='delBtn'>삭제</button></td></tr>";
    $('#example tr:last').after(insert_tr_td);
        
        
        /* var lastItemNo = $("#example tr:last").attr("class").replace("item", "");
		var newitem = $("#example tr:eq(1)").clone();
        newitem.removeClass();
        newitem.find("td:eq(0)").attr("rowspan", "1");
        newitem.addClass("item"+(parseInt(lastItemNo)+1));

        $("#example").append(newitem); */
    });


    // 삭제버튼 클릭시
    $(".delBtn").live("click", function(){
        var clickedRow = $(this).parent().parent();
        var cls = clickedRow.attr("class");
         
        // 각 항목의 첫번째 row를 삭제한 경우 다음 row에 td 하나를 추가해 준다.
        if( clickedRow.find("td:eq(0)").attr("rowspan") ){
            if( clickedRow.next().hasClass(cls) ){
                clickedRow.next().prepend(clickedRow.find("td:eq(0)"));
            }
        }

        clickedRow.remove();

        // rowspan 조정
        resizeRowspan(cls);
    });

    // cls : rowspan 을 조정할 class ex) item1, item2, ...
    function resizeRowspan(cls){
        var rowspan = $("."+cls).length;
        $("."+cls+":first td:eq(0)").attr("rowspan", rowspan);
    }
});
   
    function checkIt() {
        var userinput = eval("document.userinput");
        
        if(!userinput.id.value) {
            alert("ID를 입력하세요");
            return false;
        }
       
        if(!userinput.passwd.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(userinput.passwd.value != userinput.passwd2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
      
        if(!userinput.name.value) {
            alert("사용자 이름을 입력하세요");
            return false;
        }
        
        if(!userinput.jumin1.value  || !userinput.jumin2.value )
        {
            alert("주민등록번호를 입력하세요");
            return false;
        }
        return true;
    }

    // 아이디 중복 여부를 판단
    function openConfirmid(userinput) {
        // 아이디를 입력했는지 검사
        if (userinput.id.value == "") {
            alert("아이디를 입력하세요");
            return;
        }
        // url과 사용자 입력 id를 조합합니다.
        url = "confirmId.jsp?id=" + userinput.id.value ;
       
        // 새로운 윈도우를 엽니다.
        open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
    }
    
    function zipCheck(){
    	
    	url="ZipCheck.jsp?check=y";
    	
    	window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
    }
    
	function childCheck(){
    	
    	url="ZipCheck2.jsp?check=y";
    	
    	window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
    }	
</script>


<body bgcolor="${bodyback_c}">

<form method="post" action="inputPro.jsp" name="userinput"  onSubmit="return checkIt()">
  <table id="example" width="400" border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr>
    <td height="39" align="center" bgcolor="${value_c}" colspan="4">
       <font size="+1" ><b>회원가입</b></font></td>
    </tr>
    
    <tr>
        <td width="400" colspan="4">
        <input type="text" name="id" size="20" maxlength="12" onfocus="this.value='';" value="아이디">
        <input type="button" name="confirm_id" value="ID중복확인" OnClick="openConfirmid(this.form)">
      </td>
    </tr>
    
    <tr>
    <td bgcolor="${value_c}" colspan="4">
       <font size="1" color="red">
       <b>아이디는 5자 이상 ~ 13자 영문, 소문자, 숫자만 사용가능합니다.<br>
       /필수 정보입니다.</b>
       </font>
    </td>
    </tr>
    
    <tr>
      <td colspan="4">
        <input type="password" name="passwd" size="20" maxlength="12" onfocus="this.value='';" value="1111">
      </td>
    </tr>
    
    <tr>
    <td bgcolor="${value_c}"  colspan="4">
       <font size="1" color="red">
       <b>5 ~ 16자 영문, 숫자, 특수문자를 사용하세요. /필수 정보입니다.</b>
       </font>
    </td>
    </tr>
    
    <tr> 
       <td colspan="4">
        <input type="password" name="passwd2" size="20" maxlength="12" onfocus="this.value='';" value="1111">
      </td>
    </tr>
   
   <tr>
    <td bgcolor="${value_c}"  colspan="4">
       <font size="1" color="red">
       <b>비밀번호를 동일하게 입력하세요. /필수 정보입니다.</b>
       </font>
    </td>
    </tr>
   
    <tr>
        <td colspan="4">
        <input type="text" name="name" size="19" maxlength="10" onfocus="this.value='';" value="이름">
      </td>
    </tr>
    
    <tr>
        <td colspan="4">
        <input type="text" name="n_name" size="19" maxlength="10" onfocus="this.value='';" value="닉네임">
        <input type="button" name="confirm_n_name" value="닉네임 중복확인" OnClick="openConfirmid(this.form)">
      </td>
    </tr>
    
    <tr>
    <td bgcolor="${value_c}" colspan="4">
       <font size="1" color="red">
       <b>/필수 정보입니다.</b>
       </font>
    </td>
    </tr>
    
    <tr>
    <td colspan="4">
    <input type="radio" value="남자" name="gender" id="man" class="validate required">
	<lable for="man">남자</lable>
	<input type="radio" value="여자" name="gender" id="woman">
	<lable for="woman">여자</lable>
    </td>
    </tr>
    
    <tr>
        <td colspan="4">
        <input type="text" name="email" size="30" maxlength="30" onfocus="this.value='';" value="이메일">
      </td>
    </tr>
   
    <tr>
    <td bgcolor="${value_c}" colspan="4" >
       <font size="1" color="red">
       <b>/필수 정보입니다.</b>
       </font>
    </td>
    </tr>
    
    <tr>
    <td bgcolor="${value_c}" colspan="4" >
	<b>생년월일</b>
    </td>
    </tr>
    
    <tr>
      <td colspan="4">
        <input type="text" name="year" size="10" maxlength="4" onfocus="this.value='';" value="생년(4자리)">
        <select name="MM" id="month">
        <%for(int i=1; i<13; i++){ %>
		<option value="<%=i%>"><%=i %>월</option>
		<%} %>
        </select>
        <select name="dd" id="date">
        <%for(int i=1; i<31; i++){ %>
		<option value="<%=i%>"><%=i %>일</option>
		<%} %>
        </select>
      </td>
    </tr>
    
    <tr>
        <td colspan="4">  
        <input type="text" name="cp" size="50" maxlength="50" onfocus="this.value='';" value="핸드폰번호">
      </td>
    </tr>
    
    <tr> 
       <td colspan="4">
        <input type="text" name="zipcode" size="10" readonly>
        <input type="button" value="우편번호찾기" onClick="zipCheck()">
	</td>
</tr>

<tr>
<td colspan="4">
<input type="text" name="address" size="50" onfocus="this.value='';" value="상세주소">
</td>
</tr>
<tr><td colspan="4"><input type = "button" class = "addItemBtn" value= "자녀추가"  /></td></tr>
<tr>
            <td><font size="1">자녀이름</font></td>
            <td><font size="1">유치원 / 어린이집</font></td>
            <td><font size="1">찾기</font></td>
            <td><font size="1">비고</font></td>
        </tr>
        <tr class="item1"> 
        
            <td><input type="text" name="child" size="6" maxlength="15"/></td>
            <td><input type="text" name="child_home" size="10" readonly/></td>
            <td><input type="button" value="어린이집/유치원 찾기" onClick="childCheck()"></td>
            <td><button class="delBtn">삭제</button></td>
           
</tr>



</table> 
<div align="center">
<input type="submit" name="confirm" value="등   록" >
<input type="reset" name="reset" value="다시입력">
<input type="button" value="가입안함" onclick="javascript:window.location='main.jsp'">
</div>
</form>
</body>
</html>