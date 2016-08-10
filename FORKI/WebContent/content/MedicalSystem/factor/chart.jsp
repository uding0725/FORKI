<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>예방접종 문진표</title>
</head>
<style>

/* 문진표 css
 */
 table{
width : 1200px; 
cellpadding : 0;
cellspacing :0;
border : 1px solid;
text-align : center;
border-top : 2px solid;
border-collaps:collaps;
border-collaps:seperate;
}

.line{
border-top : 2px solid;
}

.off {
background-color: #fff;
}

.on {
background-color: #ccc;
}

/* 탭에 관한 css */
.tabWrap { width: 900px; height: 800px; }
    .tab_Menu { margin: 0px; padding: 0px; list-style: none; }
    .tabMenu { width: 150px; margin: 0px; text-align: center; 
               padding-top: 10px; padding-bottom: 10px; float: left; }
        .tabMenu a { color: #000000; font-weight: bold; text-decoration: none; }
    .current { background-color: #FFFFFF; 
               border: 1px solid blue; border-bottom:hidden; }
    .tabPage { width: 1200px; height: 710px; float: left; 
               border: 1px solid ; }


</style>

<!-- 탭에 관한 jquery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.0.min.js" ></script>
<script type="text/javascript">
    function tabSetting() {
        // 탭 컨텐츠 hide 후 현재 탭메뉴 페이지만 show
        $('.tabPage').hide();
        $($('.current').find('a').attr('href')).show();
        // Tab 메뉴 클릭 이벤트 생성
        $('li').click(function (event) {
            var tagName = event.target.tagName; // 현재 선택된 태그네임
            var selectedLiTag = (tagName.toString() == 'A') ? $(event.target).parent('li') : $(event.target); // A태그일 경우 상위 Li태그 선택, Li태그일 경우 그대로 태그 객체
            var currentLiTag = $('li[class~=current]'); // 현재 current 클래그를 가진 탭
            var isCurrent = false;  
             
            // 현재 클릭된 탭이 current를 가졌는지 확인
            isCurrent = $(selectedLiTag).hasClass('current');
             
            // current를 가지지 않았을 경우만 실행
            if (!isCurrent) {
                $($(currentLiTag).find('a').attr('href')).hide();
                $(currentLiTag).removeClass('current');
 
                $(selectedLiTag).addClass('current');
                $($(selectedLiTag).find('a').attr('href')).show();
            }
 
            return false;
        });
    }
 
    $(function () {
        // 탭 초기화 및 설정
        tabSetting();
    });

/* 선택하면 색깔 바뀌는 기능  */  
 function toggle(box,theId) {
    if(document.getElementById) {
        var cell = document.getElementById(theId);
        if(box.checked) {
            cell.className = "on";
        }
        else {
            cell.className = "off";
        }
    }
}

</script>

<body> 

 <!--  탭 안에 table 같이 뜨게 연결해줬음 -->
<div class="tabWrap">

<font size="+2"><p align="right">예방접종 문진표</p></font> 

  <br>

    <ul class="tab_Menu">
        <li class="tabMenu current">
            <a href="#tabContent01" >대한</a>
        </li>
        <li class="tabMenu">
            <a href="#tabContent02" >민국</a>
        </li>
        <li class="tabMenu">
            <a href="#tabContent03" >만세</a>
        </li>
        <li class="tabMenu">
        <a href="#">추가하기+</a>
        </li>
    </ul>
    
    
    
    <div class="tab_Content_Wrap"><!--  대한이 문진표 table -->
        <div id="tabContent01" class="tabPage">
<table border="1">
<tr>
<td rowspan="17">국<br>가<br>필<br>수<br>예<br>방<br>접<br>종</td>
</tr>
<tr>
<td>대상전염병</td>
<td>백신종류및방법</td>
<td>0개월</td>
<td>1개월</td>
<td>2개월</td>
<td>4개월</td>
<td>6개월</td>
<td>12개월</td>
<td>15개월</td>
<td>18개월</td>
<td>24개월</td>
<td>36개월</td>
<td>만4세</td>
<td>만6세</td>
<td>만11세</td>
<td>만12세</td>
</tr>
<tr>
<td>결핵①</td>
<td>BCG(피내용)</td>
<td class="off" id="cell1">
<input type="checkbox" onclick="toggle(this,'cell1')">1회</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>B형감염②</td>
<td>HepB</td>
<td class="off" id="cell2">
<input type="checkbox" onclick="toggle(this,'cell2')">1차</td>
<td class="off" id="cell3">
<input type="checkbox" onclick="toggle(this,'cell3')">2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell4">
<input type="checkbox" onclick="toggle(this,'cell4')">3차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td rowspan="2">디프테리아 <br>파상풍<br> 백일해</td>
<td>DTaP③</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell5">
<input type="checkbox" onclick="toggle(this,'cell5')">1차</td>
<td class="off" id="cell6">
<input type="checkbox" onclick="toggle(this,'cell6')">2차</td>
<td class="off" id="cell7">
<input type="checkbox" onclick="toggle(this,'cell7')">3차</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell8">
<input type="checkbox" onclick="toggle(this,'cell8')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell9">
<input type="checkbox" onclick="toggle(this,'cell9')">추 5차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>Td/Tdap④</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell10">
<input type="checkbox" onclick="toggle(this,'cell10')">추 6차</td>
</tr>

<tr>
<td>폴리오⑤</td>
<td>IPV(사백신)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell11">
<input type="checkbox" onclick="toggle(this,'cell11')">1차</td>
<td class="off" id="cell12">
<input type="checkbox" onclick="toggle(this,'cell12')">2차</td>
<td class="off" id="cell13">
<input type="checkbox" onclick="toggle(this,'cell13')">3차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell14">
<input type="checkbox" onclick="toggle(this,'cell14')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>B형헤모필<br>루스<br>인풀루엔자⑥</td>
<td>PRP-T/HBOC</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell15">
<input type="checkbox" onclick="toggle(this,'cell15')">1차</td>
<td class="off" id="cell16">
<input type="checkbox" onclick="toggle(this,'cell16')">2차</td>
<td class="off" id="cell17">
<input type="checkbox" onclick="toggle(this,'cell17')">3차</td>
<td colspan="2" class="off" id="cell18">
<input type="checkbox" onclick="toggle(this,'cell18')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">폐렴구균
<td>PCV(단백결합⑦</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell19">
<input type="checkbox" onclick="toggle(this,'cell19')">1차</td>
<td class="off" id="cell20">
<input type="checkbox" onclick="toggle(this,'cell20')">2차</td>
<td class="off" id="cell21">
<input type="checkbox" onclick="toggle(this,'cell21')">3차</td>
<td colspan="2" class="off" id="cell22">
<input type="checkbox" onclick="toggle(this,'cell22')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>PPSV(다당질)⑧</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="6">고위험군에 한하여 접종</td>
</tr>

<tr>
<td>홍역<br>유행성<br>이하선염<br>풍진⑨</td>
<td>MMR</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell23">
<input type="checkbox" onclick="toggle(this,'cell23')">1차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell24">
<input type="checkbox" onclick="toggle(this,'cell24')">2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>수두</td>
<td>Var</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell25">
<input type="checkbox" onclick="toggle(this,'cell25')">1차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>A형간염⑩</td>
<td>HepA</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="5" class="off" id="cell26">
<input type="checkbox" onclick="toggle(this,'cell26')">1차~2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">일본뇌염</td>
<td>JEV(사백신⑪</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="5" class="off" id="cell27">
<input type="checkbox" onclick="toggle(this,'cell27')">1차~3차</td>
<td>&nbsp;</td>
<td class="off" id="cell28">
<input type="checkbox" onclick="toggle(this,'cell28')">추 4차</td>
<td>&nbsp;</td>
<td class="off" id="cell29">
<input type="checkbox" onclick="toggle(this,'cell29')">추 5차</td>
</tr>

<tr>
<td>JE(생백신)⑫</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="5" class="off" id="cell30">
<input type="checkbox" onclick="toggle(this,'cell30')">1차~2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">인플루엔자</td>
<td>Flu(사백신)⑬</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="7">매년접종</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>Flu(생백신)⑭</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="3">매년접종</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td class="line" rowspan="6">기<br>타<br>예<br>방<br>접<br>종</td>
</tr>

<tr>
<td class="line">결핵</td>
<td class="line">BCG(경피용)</td>
<td class="line" class="off" id="cell31">
<input type="checkbox" onclick="toggle(this,'cell31')">1회</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
</tr>

<tr>
<td rowspan="2">로티바이러스</td>
<td>RV1(로타릭스)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell32">
<input type="checkbox" onclick="toggle(this,'cell32')">1차</td>
<td class="off" id="cell33">
<input type="checkbox" onclick="toggle(this,'cell33')">2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>RV5(로타텍)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell34">
<input type="checkbox" onclick="toggle(this,'cell34')">1차</td>
<td class="off" id="cell35">
<input type="checkbox" onclick="toggle(this,'cell35')">2차</td>
<td class="off" id="cell36">
<input type="checkbox" onclick="toggle(this,'cell36')">3차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">인유두종<br>바이러스</td>
<td>HPV(가다실)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell37">
<input type="checkbox" onclick="toggle(this,'cell37')">1~3차</td>
</tr>
<tr>
<td>HPV(서바릭스)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell38">
<input type="checkbox" onclick="toggle(this,'cell38')">1~3차</td>
</tr>

<tr>
<td colspan="17" ><input type="submit" value="저장"></td>
</table>
        </div>
        
        
        
        <div id="tabContent02" class="tabPage"> <!-- 민국이 문진표 table -->
<table border="1">
<tr>
<td rowspan="17">국<br>가<br>필<br>수<br>예<br>방<br>접<br>종</td>
</tr>
<tr>
<td>대상전염병</td>
<td>백신종류및방법</td>
<td>0개월</td>
<td>1개월</td>
<td>2개월</td>
<td>4개월</td>
<td>6개월</td>
<td>12개월</td>
<td>15개월</td>
<td>18개월</td>
<td>24개월</td>
<td>36개월</td>
<td>만4세</td>
<td>만6세</td>
<td>만11세</td>
<td>만12세</td>
</tr>
<tr>
<td>결핵①</td>
<td>BCG(피내용)</td>
<td class="off" id="cell39">
<input type="checkbox" onclick="toggle(this,'cell39')">1회</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>B형감염②</td>
<td>HepB</td>
<td class="off" id="cell40">
<input type="checkbox" onclick="toggle(this,'cell40')">1차</td>
<td class="off" id="cell41">
<input type="checkbox" onclick="toggle(this,'cell41')">2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell42">
<input type="checkbox" onclick="toggle(this,'cell42')">3차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td rowspan="2">디프테리아 <br>파상풍<br> 백일해</td>
<td>DTaP③</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell43">
<input type="checkbox" onclick="toggle(this,'cell43')">1차</td>
<td class="off" id="cell44">
<input type="checkbox" onclick="toggle(this,'cell44')">2차</td>
<td class="off" id="cell45">
<input type="checkbox" onclick="toggle(this,'cell45')">3차</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell46">
<input type="checkbox" onclick="toggle(this,'cell46')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell47">
<input type="checkbox" onclick="toggle(this,'cell47')">추 5차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>Td/Tdap④</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell48">
<input type="checkbox" onclick="toggle(this,'cell48')">추 6차</td>
</tr>

<tr>
<td>폴리오⑤</td>
<td>IPV(사백신)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell49">
<input type="checkbox" onclick="toggle(this,'cell49')">1차</td>
<td class="off" id="cell50">
<input type="checkbox" onclick="toggle(this,'cell50')">2차</td>
<td class="off" id="cell51">
<input type="checkbox" onclick="toggle(this,'cell51')">3차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell52">
<input type="checkbox" onclick="toggle(this,'cell52')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>B형헤모필<br>루스<br>인풀루엔자⑥</td>
<td>PRP-T/HBOC</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell53">
<input type="checkbox" onclick="toggle(this,'cell53')">1차</td>
<td class="off" id="cell54">
<input type="checkbox" onclick="toggle(this,'cell54')">2차</td>
<td class="off" id="cell55">
<input type="checkbox" onclick="toggle(this,'cell55')">3차</td>
<td colspan="2" class="off" id="cell56">
<input type="checkbox" onclick="toggle(this,'cell56')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">폐렴구균
<td>PCV(단백결합⑦</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell57">
<input type="checkbox" onclick="toggle(this,'cell57')">1차</td>
<td class="off" id="cell58">
<input type="checkbox" onclick="toggle(this,'cell58')">2차</td>
<td class="off" id="cell59">
<input type="checkbox" onclick="toggle(this,'cell59')">3차</td>
<td colspan="2" class="off" id="cell60">
<input type="checkbox" onclick="toggle(this,'cell60')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>PPSV(다당질)⑧</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="6">고위험군에 한하여 접종</td>
</tr>

<tr>
<td>홍역<br>유행성<br>이하선염<br>풍진⑨</td>
<td>MMR</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell61">
<input type="checkbox" onclick="toggle(this,'cell61')">1차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell62">
<input type="checkbox" onclick="toggle(this,'cell62')">2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>수두</td>
<td>Var</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell63">
<input type="checkbox" onclick="toggle(this,'cell63')">1차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>A형간염⑩</td>
<td>HepA</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="5" class="off" id="cell64">
<input type="checkbox" onclick="toggle(this,'cell64')">1차~2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">일본뇌염</td>
<td>JEV(사백신⑪</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="5" class="off" id="cell65">
<input type="checkbox" onclick="toggle(this,'cell65')">1차~3차</td>
<td>&nbsp;</td>
<td class="off" id="cell66">
<input type="checkbox" onclick="toggle(this,'cell66')">추 4차</td>
<td>&nbsp;</td>
<td class="off" id="cell67">
<input type="checkbox" onclick="toggle(this,'cell67')">추 5차</td>
</tr>

<tr>
<td>JE(생백신)⑫</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="5" class="off" id="cell68">
<input type="checkbox" onclick="toggle(this,'cell68')">1차~2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">인플루엔자</td>
<td>Flu(사백신)⑬</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="7">매년접종</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>Flu(생백신)⑭</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="3">매년접종</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td class="line" rowspan="6">기<br>타<br>예<br>방<br>접<br>종</td>
</tr>

<tr>
<td class="line">결핵</td>
<td class="line">BCG(경피용)</td>
<td class="line" class="off" id="cell69">
<input type="checkbox" onclick="toggle(this,'cell69')">1회</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
</tr>

<tr>
<td rowspan="2">로티바이러스</td>
<td>RV1(로타릭스)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell70">
<input type="checkbox" onclick="toggle(this,'cell70')">1차</td>
<td class="off" id="cell71">
<input type="checkbox" onclick="toggle(this,'cell71')">2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>RV5(로타텍)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell72">
<input type="checkbox" onclick="toggle(this,'cell72')">1차</td>
<td class="off" id="cell73">
<input type="checkbox" onclick="toggle(this,'cell73')">2차</td>
<td class="off" id="cell74">
<input type="checkbox" onclick="toggle(this,'cell74')">3차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">인유두종<br>바이러스</td>
<td>HPV(가다실)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell75">
<input type="checkbox" onclick="toggle(this,'cell75')">1~3차</td>
</tr>
<tr>
<td>HPV(서바릭스)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell76">
<input type="checkbox" onclick="toggle(this,'cell76')">1~3차</td>
</tr>

<tr>
<td colspan="17" ><input type="submit" value="저장"></td>
</table>        
        </div>
        
              
<div id="tabContent03" class="tabPage">  <!-- 만세 문진표 table       -->
<table border="1">
<tr>
<td rowspan="17">국<br>가<br>필<br>수<br>예<br>방<br>접<br>종</td>
</tr>
<tr>
<td>대상전염병</td>
<td>백신종류및방법</td>
<td>0개월</td>
<td>1개월</td>
<td>2개월</td>
<td>4개월</td>
<td>6개월</td>
<td>12개월</td>
<td>15개월</td>
<td>18개월</td>
<td>24개월</td>
<td>36개월</td>
<td>만4세</td>
<td>만6세</td>
<td>만11세</td>
<td>만12세</td>
</tr>
<tr>
<td>결핵①</td>
<td>BCG(피내용)</td>
<td class="off" id="cell77">
<input type="checkbox" onclick="toggle(this,'cell77')">1회</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>B형감염②</td>
<td>HepB</td>
<td class="off" id="cell78">
<input type="checkbox" onclick="toggle(this,'cell78')">1차</td>
<td class="off" id="cell79">
<input type="checkbox" onclick="toggle(this,'cell79')">2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell80">
<input type="checkbox" onclick="toggle(this,'cell80')">3차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td rowspan="2">디프테리아 <br>파상풍<br> 백일해</td>
<td>DTaP③</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell81">
<input type="checkbox" onclick="toggle(this,'cell81')">1차</td>
<td class="off" id="cell82">
<input type="checkbox" onclick="toggle(this,'cell82')">2차</td>
<td class="off" id="cell83">
<input type="checkbox" onclick="toggle(this,'cell83')">3차</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell84">
<input type="checkbox" onclick="toggle(this,'cell84')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell85">
<input type="checkbox" onclick="toggle(this,'cell85')">추 5차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>Td/Tdap④</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell86">
<input type="checkbox" onclick="toggle(this,'cell86')">추 6차</td>
</tr>

<tr>
<td>폴리오⑤</td>
<td>IPV(사백신)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell87">
<input type="checkbox" onclick="toggle(this,'cell87')">1차</td>
<td class="off" id="cell88">
<input type="checkbox" onclick="toggle(this,'cell88')">2차</td>
<td class="off" id="cell89">
<input type="checkbox" onclick="toggle(this,'cell89')">3차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell90">
<input type="checkbox" onclick="toggle(this,'cell90')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>B형헤모필<br>루스<br>인풀루엔자⑥</td>
<td>PRP-T/HBOC</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell91">
<input type="checkbox" onclick="toggle(this,'cell91')">1차</td>
<td class="off" id="cell92">
<input type="checkbox" onclick="toggle(this,'cell92')">2차</td>
<td class="off" id="cell93">
<input type="checkbox" onclick="toggle(this,'cell93')">3차</td>
<td colspan="2" class="off" id="cell94">
<input type="checkbox" onclick="toggle(this,'cell94')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">폐렴구균
<td>PCV(단백결합⑦</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell95">
<input type="checkbox" onclick="toggle(this,'cell95')">1차</td>
<td class="off" id="cell96">
<input type="checkbox" onclick="toggle(this,'cell96')">2차</td>
<td class="off" id="cell97">
<input type="checkbox" onclick="toggle(this,'cell97')">3차</td>
<td colspan="2" class="off" id="cell98">
<input type="checkbox" onclick="toggle(this,'cell98')">추 4차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>PPSV(다당질)⑧</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="6">고위험군에 한하여 접종</td>
</tr>

<tr>
<td>홍역<br>유행성<br>이하선염<br>풍진⑨</td>
<td>MMR</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell99">
<input type="checkbox" onclick="toggle(this,'cell99')">1차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell100">
<input type="checkbox" onclick="toggle(this,'cell100')">2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>수두</td>
<td>Var</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell101">
<input type="checkbox" onclick="toggle(this,'cell101')">1차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>A형간염⑩</td>
<td>HepA</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="5" class="off" id="cell102">
<input type="checkbox" onclick="toggle(this,'cell102')">1차~2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">일본뇌염</td>
<td>JEV(사백신⑪</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="5" class="off" id="cell103">
<input type="checkbox" onclick="toggle(this,'cell103')">1차~3차</td>
<td>&nbsp;</td>
<td class="off" id="cell104">
<input type="checkbox" onclick="toggle(this,'cell104')">추 4차</td>
<td>&nbsp;</td>
<td class="off" id="cell105">
<input type="checkbox" onclick="toggle(this,'cell105')">추 5차</td>
</tr>

<tr>
<td>JE(생백신)⑫</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="5" class="off" id="cell106">
<input type="checkbox" onclick="toggle(this,'cell106')">1차~2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">인플루엔자</td>
<td>Flu(사백신)⑬</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="7">매년접종</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>Flu(생백신)⑭</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="3">매년접종</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td class="line" rowspan="6">기<br>타<br>예<br>방<br>접<br>종</td>
</tr>

<tr>
<td class="line">결핵</td>
<td class="line">BCG(경피용)</td>
<td class="line" class="off" id="cell107">
<input type="checkbox" onclick="toggle(this,'cell107')">1회</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
<td class="line">&nbsp;</td>
</tr>

<tr>
<td rowspan="2">로티바이러스</td>
<td>RV1(로타릭스)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell108">
<input type="checkbox" onclick="toggle(this,'cell108')">1차</td>
<td class="off" id="cell109">
<input type="checkbox" onclick="toggle(this,'cell109')">2차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>RV5(로타텍)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td class="off" id="cell120">
<input type="checkbox" onclick="toggle(this,'cell120')">1차</td>
<td class="off" id="cell121">
<input type="checkbox" onclick="toggle(this,'cell121')">2차</td>
<td class="off" id="cell122">
<input type="checkbox" onclick="toggle(this,'cell122')">3차</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>

<tr>
<td rowspan="2">인유두종<br>바이러스</td>
<td>HPV(가다실)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell123">
<input type="checkbox" onclick="toggle(this,'cell123')">1~3차</td>
</tr>
<tr>
<td>HPV(서바릭스)</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td colspan="2" class="off" id="cell124">
<input type="checkbox" onclick="toggle(this,'cell124')">1~3차</td>
</tr>

<tr>
<td colspan="17" ><input type="submit" value="저장"></td>
</table>
        </div> <!-- 만세 문진표 table 끝 -->


</div>
</div>
</body>
</html>