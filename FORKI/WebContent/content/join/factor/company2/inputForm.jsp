<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원가입</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script>
    function checkIt() {
        var userinput = eval("document.userinput");
        
        if(!userinput.id.value) {
            alert("ID를 입력하세요");
            return false;
        }else if(userinput.id.value){
        	if ((new RegExp(/[^a-z|^0-9]/gi)).test(userinput.id.value)){
        	    alert("ID는 영숫자 조합만 사용하세요");
                return false;
        	}
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
        }else if(userinput.name.value){
        	if ((new RegExp(/[^a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]/gi)).test(userinput.name.value)){
        	    alert("이름 형식이 틀립니다.");
        	    userinput.name.focus();
                return false;
        	}
        }
        
        if(!userinput.nickname.value) {
            alert("사용자 닉네임을 입력하세요");
            return false;
        }else if(userinput.nickname.value){
        	if ((new RegExp(/[^\w\Wㄱ-ㅎㅏ-ㅣ가-힣]/gi)).test(userinput.nickname.value)){
        	    alert("닉네임 형식이 틀립니다.");
        	    userinput.nickname.focus();
                return false;
        	}
        }
        
        if(!userinput.sex.value){
            alert("성별을 선택하세요");
            return false;
        }
        
        if(!userinput.email.value) {
            alert("이메일을 입력하세요");
            return false;
        }else if(userinput.email.value){
        	if (userinput.email.value.length < 6 || !(new RegExp(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i)).test(userinput.email.value)){
        	    alert("EMAIL 형식이 틀립니다.");
        	    userinput.email.focus();
                return false;
        	}
        }
        
        if(!userinput.b_day.value) {
            alert("생일을 입력하세요");
            return false;
        }else if(userinput.b_day.value){
        	if ((new RegExp( /[^0-9_]$/)).test(userinput.b_day.value)){
        	    alert("생일 형식이 틀립니다.");
        	    userinput.b_day.focus();
                return false;
        	}
        }
        
        /* if(!userinput.tell.value) {
            alert("핸드폰번호를 입력하세요");
            return false;
        }else */ if(userinput.tell.value){
        	if ((new RegExp( /[^0-9_]$/)).test(userinput.tell.value)){
        	    alert("핸드폰번호 형식이 틀립니다.");
        	    userinput.tell.focus();
                return false;
        	}
        }
        
        if(!userinput.schul_num.value) {
            alert("사업자번호를 입력하세요");
            return false;
        }else if(userinput.schul_num.value){
        	if ((new RegExp( /[^0-9_]$/)).test(userinput.schul_num.value)){
        	    alert("사업자번호 형식이 틀립니다.");
        	    userinput.schul_num.focus();
                return false;
        	}
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
        url = "/FORKI/content/join/factor/company2/confirmId.do?id=" + userinput.id.value ;
       
        // 새로운 윈도우를 엽니다.
        open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
    }
    
    //닉네임 중복 여부를 판단
    function openConfirmnick(userinput) {
        // 닉네임을 입력했는지 검사
        if (userinput.nickname.value == "") {
            alert("닉네임을 입력하세요");
            return;
        }
        // url과 사용자 입력 nickname를 조합합니다.
        url = "/FORKI/content/join/factor/company2/confirmNick.do?nickname=" + userinput.nickname.value ;
       
        // 새로운 윈도우를 엽니다.
        open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
    }
    
    function zipCheck(){
    	
    	url="/FORKI/content/join/factor/company2/ZipCheck.do?check=y";
    	
    	window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
    }
    
	function SchulCheck(){
    	
    	url="/FORKI/content/join/factor/company2/SchulCheck.do?check=y";
    	
    	window.open(url,"post","toolbar=no ,width=600 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
    }

</script>


<body>

<form method="post" action="/FORKI/content/join/ComInputPro.do" name="userinput"  onSubmit="return checkIt()">
  <table id="example" width="400" border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr>
    <td height="39" align="center" colspan="4">
       <font size="+1" ><b>회원가입</b></font></td>
    </tr>
    
    <tr>
        <td width="400" colspan="4">
        <input type="text" name="id" size="20" maxlength="12" placeholder="아이디">
        <input type="button" name="confirm_id" value="ID중복확인" OnClick="openConfirmid(this.form)">
      </td>
    </tr>
    
    <tr>
    <td colspan="4">
       <font size="1" color="red">
       <b>아이디는 5자 이상 ~ 13자 영문, 소문자, 숫자만 사용가능합니다.<br>
       /필수 정보입니다.</b>
       </font>
    </td>
    </tr>
    
    <tr>
      <td colspan="4">
        <input type="password" name="passwd" size="20" maxlength="12" placeholder="비밀번호">
      </td>
    </tr>
    
    <tr>
    <td colspan="4">
       <font size="1" color="red">
       <b>5 ~ 16자 영문, 숫자, 특수문자를 사용하세요. /필수 정보입니다.</b>
       </font>
    </td>
    </tr>
    
    <tr> 
       <td colspan="4">
        <input type="password" name="passwd2" size="20" maxlength="12" placeholder="비밀번호 확인">
      </td>
    </tr>
   
   <tr>
    <td colspan="4">
       <font size="1" color="red">
       <b>비밀번호를 동일하게 입력하세요. /필수 정보입니다.</b>
       </font>
    </td>
    </tr>
   
    <tr>
        <td colspan="4">
        <input type="text" name="name" size="19" maxlength="10" placeholder="이름">
      </td>
    </tr>
    
    <tr>
        <td colspan="4">
        <input type="text" name="nickname" size="19" maxlength="10" placeholder="닉네임">
        <input type="button" name="confirm_nickname" value="닉네임 중복확인" OnClick="openConfirmnick(this.form)">
      </td>
    </tr>
    
    <tr>
    <td colspan="4">
       <font size="1" color="red">
       <b>/필수 정보입니다.</b>
       </font>
    </td>
    </tr>
    
    <tr>
    <td colspan="4">
    <input type="radio" value="man" name="sex" id="man" class="validate required">
	<lable for="man">남자</lable>
	<input type="radio" value="woman" name="sex" id="woman">
	<lable for="woman">여자</lable>
    </td>
    </tr>
    
    <tr>
        <td colspan="4">
        <input type="text" name="email" size="30" maxlength="30" placeholder="이메일">
      </td>
    </tr>
   
    <tr>
    <td colspan="4" >
       <font size="1" color="red">
       <b>/필수 정보입니다.</b>
       </font>
    </td>
    </tr>
    
    <tr>
    <td colspan="4" >
	<b>생년월일</b>
    </td>
    </tr>
    
    <tr>
      <td colspan="4">
        <input type="text" name="b_day" size="10" maxlength="4" placeholder="생년(4자리)">
        <select name="MM" id="month">
        <%for(int i=1; i<13; i++){  %>
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
        <input type="text" name="tell" size="20" maxlength="20" placeholder="핸드폰번호는 -없이 입력하세요">
      </td>
    </tr>
    
    <tr> 
       <td colspan="4">
        <input type="text" name="zipcode" size="20" readonly placeholder="우편번호">
        <input type="button" value="우편번호찾기" onClick="zipCheck()">
	</td>
</tr>

<tr>
<td colspan="4">
<input type="text" name="address" size="50" placeholder="상세주소">
</td>
</tr>
<tr>
<td colspan="4">
<input type="text" name="schul_num" size="25" placeholder="사업자번호">
<!-- <input type="button" value="사업자번호 중복확인" onClick="openConfirmSchulNUM(this.form)"> -->
</td>
<tr>
<td colspan="4">
<input type="text" name="schul_nm" size="25" placeholder="어린이집/유치원 명">
<input type="button" value="어린이집/유치원 찾기" onClick="SchulCheck()">
</td>



</table> 
<div align="center">
<input type="submit" name="confirm" value="등   록" >
<input type="reset" name="reset" value="다시입력">
<input type="button" value="가입안함" onclick="javascript:window.location='/FORKI/content/main/main.do'">
</div>
</form>
</body>
</html>