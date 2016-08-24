<%@ page contentType="text/html; charset=utf-8"%>

<style>
.button1 {
border:1x solid #ff0080;    /*---테두리 정의---*/
background-Color:#ffe6f2;   /*--백그라운드 정의---*/
font:50px 굴림;      /*--폰트 정의---*/
font-weight:bold;   /*--폰트 굵기---*/
color:#ff0080;    /*--폰트 색깔---*/
width:400;height:500;  /*--버튼 크기---*/
}

.button2 {
border:1x solid #02778B;    /*---테두리 정의---*/
background-Color:#B6FFFF;   /*--백그라운드 정의---*/
font:50px 굴림;      /*--폰트 정의---*/
font-weight:bold;   /*--폰트 굵기---*/
color:#02778B;    /*--폰트 색깔---*/
width:400;height:500;  /*--버튼 크기---*/
}
#content{
	padding:0px;
	}
#body{
	padding:0px;
}	
</style>

<body>
<div id="body">
<table>
<tr>
<td>
<div id="content">
<input type="button" value="기업" class="button1" onClick="document.location.href='/FORKI/content/join/ComInputForm.jsp'">
</div>
</td>
<td>
<div  id="content">
<input type="button" value="개인" class="button2" onClick="document.location.href='/FORKI/content/join/UserInputForm.jsp'">
</div>
</td>
</tr>
</table>

</div>
</body>