<%@ page contentType="text/html; charset=utf-8"%>
<style>
table {
	font-size: 11;
}
</style>
<img src="../img/chick/icon6.png" width="30" height="30"  style="position:relative; top:5px;"><font size="+2">예방접종 문진표</font>
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td rowspan="17">국<br>가<br>필<br>수<br>예<br>방<br>접<br>종
		</td>
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
		<td class="off" id="cell1"><input type="checkbox" onclick="toggle(this,'cell1')">1회</td>
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
		<td class="off" id="cell2"><input type="checkbox" onclick="toggle(this,'cell2')">1차</td>
		<td class="off" id="cell3"><input type="checkbox" onclick="toggle(this,'cell3')">2차</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td class="off" id="cell4"><input type="checkbox" onclick="toggle(this,'cell4')">3차</td>
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
		<td rowspan="2">디프테리아 <br>파상풍<br> 백일해
		</td>
		<td>DTaP③</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td class="off" id="cell5"><input type="checkbox" onclick="toggle(this,'cell5')">1차</td>
		<td class="off" id="cell6"><input type="checkbox" onclick="toggle(this,'cell6')">2차</td>
		<td class="off" id="cell7"><input type="checkbox" onclick="toggle(this,'cell7')">3차</td>
		<td>&nbsp;</td>
		<td colspan="2" class="off" id="cell8"><input type="checkbox" onclick="toggle(this,'cell8')">추 4차</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td colspan="2" class="off" id="cell9"><input type="checkbox" onclick="toggle(this,'cell9')">추 5차</td>
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
		<td colspan="2" class="off" id="cell10"><input type="checkbox" onclick="toggle(this,'cell10')">추 6차</td>
	</tr>

	<tr>
		<td>폴리오⑤</td>
		<td>IPV(사백신)</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td class="off" id="cell11"><input type="checkbox" onclick="toggle(this,'cell11')">1차</td>
		<td class="off" id="cell12"><input type="checkbox" onclick="toggle(this,'cell12')">2차</td>
		<td class="off" id="cell13"><input type="checkbox" onclick="toggle(this,'cell13')">3차</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td colspan="2" class="off" id="cell14"><input type="checkbox" onclick="toggle(this,'cell14')">추 4차</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

	<tr>
		<td>B형헤모필<br>루스<br>인풀루엔자⑥
		</td>
		<td>PRP-T/HBOC</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td class="off" id="cell15"><input type="checkbox" onclick="toggle(this,'cell15')">1차</td>
		<td class="off" id="cell16"><input type="checkbox" onclick="toggle(this,'cell16')">2차</td>
		<td class="off" id="cell17"><input type="checkbox" onclick="toggle(this,'cell17')">3차</td>
		<td colspan="2" class="off" id="cell18"><input type="checkbox" onclick="toggle(this,'cell18')">추 4차</td>
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
		<td class="off" id="cell19"><input type="checkbox" onclick="toggle(this,'cell19')">1차</td>
		<td class="off" id="cell20"><input type="checkbox" onclick="toggle(this,'cell20')">2차</td>
		<td class="off" id="cell21"><input type="checkbox" onclick="toggle(this,'cell21')">3차</td>
		<td colspan="2" class="off" id="cell22"><input type="checkbox" onclick="toggle(this,'cell22')">추 4차</td>
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
		<td>홍역<br>유행성<br>이하선염<br>풍진⑨
		</td>
		<td>MMR</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td colspan="2" class="off" id="cell23"><input type="checkbox" onclick="toggle(this,'cell23')">1차</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td colspan="2" class="off" id="cell24"><input type="checkbox" onclick="toggle(this,'cell24')">2차</td>
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
		<td colspan="2" class="off" id="cell25"><input type="checkbox" onclick="toggle(this,'cell25')">1차</td>
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
		<td colspan="5" class="off" id="cell26"><input type="checkbox" onclick="toggle(this,'cell26')">1차~2차</td>
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
		<td colspan="5" class="off" id="cell27"><input type="checkbox" onclick="toggle(this,'cell27')">1차~3차</td>
		<td>&nbsp;</td>
		<td class="off" id="cell28"><input type="checkbox" onclick="toggle(this,'cell28')">추 4차</td>
		<td>&nbsp;</td>
		<td class="off" id="cell29"><input type="checkbox" onclick="toggle(this,'cell29')">추 5차</td>
	</tr>

	<tr>
		<td>JE(생백신)⑫</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td colspan="5" class="off" id="cell30"><input type="checkbox" onclick="toggle(this,'cell30')">1차~2차</td>
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
		<td class="line" rowspan="6">기<br>타<br>예<br>방<br>접<br>종
		</td>
	</tr>

	<tr>
		<td class="line">결핵</td>
		<td class="line">BCG(경피용)</td>
		<td class="line" class="off" id="cell31"><input type="checkbox" onclick="toggle(this,'cell31')">1회</td>
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
		<td class="off" id="cell32"><input type="checkbox" onclick="toggle(this,'cell32')">1차</td>
		<td class="off" id="cell33"><input type="checkbox" onclick="toggle(this,'cell33')">2차</td>
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
		<td class="off" id="cell34"><input type="checkbox" onclick="toggle(this,'cell34')">1차</td>
		<td class="off" id="cell35"><input type="checkbox" onclick="toggle(this,'cell35')">2차</td>
		<td class="off" id="cell36"><input type="checkbox" onclick="toggle(this,'cell36')">3차</td>
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
		<td rowspan="2">인유두종<br>바이러스
		</td>
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
		<td colspan="2" class="off" id="cell37"><input type="checkbox" onclick="toggle(this,'cell37')">1~3차</td>
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
		<td colspan="2" class="off" id="cell38"><input type="checkbox" onclick="toggle(this,'cell38')">1~3차</td>
	</tr>

	<tr>
		<td colspan="17"><input type="submit" value="저장"></td>
</table>