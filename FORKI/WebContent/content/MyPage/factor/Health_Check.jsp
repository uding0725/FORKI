<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="../CSS/chart.css?ver=1.1" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../js/chart.js"></script>
<style>
table {
	font-size: 12.5;
}
</style>
<div id="container">
	<c:if test="${listSize == 0}">
		등록된 아이가 없습니다.${listSize}
	</c:if>
	<ul class="tabs">
		<c:forEach var="article" items="${chartList}">
			<li class <c:if test="${article.num == 1}">="active"</c:if> rel="tab${article.num}">${article.name}</li>
		</c:forEach>
		<li>추가하기</li>
	</ul>
	<c:forEach var="article" items="${chartList}">
		<div class="tab_container">
			<div id="tab${article.num}" class="tab_content">
				<form method="post" action="/FORKI/content/MyPage/factor/HealthCheckUpdate.do" name="chart${article.num}">
					<input type="hidden" name="num" value="${article.num}">
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
							<td><input type="checkbox" name="bcg" value="1" <c:if test="${article.bcg >= 1}">checked</c:if>>1회</td>
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
							<td><input type="checkbox" name="hepb1" value="1" <c:if test="${article.hepb >= 1}">checked</c:if>>1차</td>
							<td><input type="checkbox" name="hepb2" value="2" <c:if test="${article.hepb >= 2}">checked</c:if>>2차</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><input type="checkbox" name="hepb3" value="3" <c:if test="${article.hepb >= 3}">checked</c:if>>3차</td>
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
							<td><input type="checkbox" name="dtap1" value="1" <c:if test="${article.dtap >= 1}">checked</c:if>>1차</td>
							<td><input type="checkbox" name="dtap2" value="2" <c:if test="${article.dtap >= 2}">checked</c:if>>2차</td>
							<td><input type="checkbox" name="dtap3" value="3" <c:if test="${article.dtap >= 3}">checked</c:if>>3차</td>
							<td>&nbsp;</td>
							<td colspan="2"><input type="checkbox" name="dtap4" value="4" <c:if test="${article.dtap >= 4}">checked</c:if>>추 4차</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td colspan="2"><input type="checkbox" name="dtap5" value="5" <c:if test="${article.dtap >= 5}">checked</c:if>>추 5차</td>
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
							<td colspan="2"><input type="checkbox" name="tdap" value="6" <c:if test="${article.tdap >= 6}">checked</c:if>>추 6차</td>
						</tr>

						<tr>
							<td>폴리오⑤</td>
							<td>IPV(사백신)</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><input type="checkbox" name="ipv1" value="1" <c:if test="${article.ipv >= 1}">checked</c:if>>1차</td>
							<td><input type="checkbox" name="ipv2" value="2" <c:if test="${article.ipv >= 2}">checked</c:if>>2차</td>
							<td><input type="checkbox" name="ipv3" value="3" <c:if test="${article.ipv >= 3}">checked</c:if>>3차</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td colspan="2"><input type="checkbox" name="ipv4" value="4" <c:if test="${article.ipv >= 4}">checked</c:if>>추 4차</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>

						<tr>
							<td>B형헤모필<br>루스<br>인풀루엔자⑥
							</td>
							<td>PRP-T/HBOC</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><input type="checkbox" name="prp_t1" value="1" <c:if test="${article.prp_t >= 1}">checked</c:if>>1차</td>
							<td><input type="checkbox" name="prp_t2" value="2" <c:if test="${article.prp_t >= 2}">checked</c:if>>2차</td>
							<td><input type="checkbox" name="prp_t3" value="3" <c:if test="${article.prp_t >= 3}">checked</c:if>>3차</td>
							<td colspan="2"><input type="checkbox" name="prp_t4" value="4" <c:if test="${article.prp_t >= 4}">checked</c:if>>추 4차</td>
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
							<td><input type="checkbox" name="pcv1" value="1" <c:if test="${article.pcv >= 1}">checked</c:if>>1차</td>
							<td><input type="checkbox" name="pcv2" value="2" <c:if test="${article.pcv >= 2}">checked</c:if>>2차</td>
							<td><input type="checkbox" name="pcv3" value="3" <c:if test="${article.pcv >= 3}">checked</c:if>>3차</td>
							<td colspan="2"><input type="checkbox" name="pcv4" value="4" <c:if test="${article.pcv >= 4}">checked</c:if>>추 4차</td>
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
							<td colspan="2"><input type="checkbox" name="mmr1" value="1" <c:if test="${article.mmr >= 1}">checked</c:if>>1차</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td colspan="2"><input type="checkbox" name="mmr2" value="2" <c:if test="${article.mmr >= 2}">checked</c:if>>2차</td>
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
							<td colspan="2"><input type="checkbox" name="var" value="1" <c:if test="${article.var >= 1}">checked</c:if>>1차</td>
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
							<td colspan="5"><input type="checkbox" name="hepa" value="1" <c:if test="${article.hepa >= 1}">checked</c:if>>1차~2차</td>
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
							<td colspan="5"><input type="checkbox" name="jev3" value="3" <c:if test="${article.jev >= 3}">checked</c:if>>1차~3차</td>
							<td>&nbsp;</td>
							<td><input type="checkbox" name="jev4" value="4" <c:if test="${article.jev >= 4}">checked</c:if>>추 4차</td>
							<td>&nbsp;</td>
							<td><input type="checkbox" name="jev5" value="5" <c:if test="${article.jev >= 5}">checked</c:if>>추 5차</td>
						</tr>

						<tr>
							<td>JE(생백신)⑫</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td colspan="5"><input type="checkbox" name="je2" value="2" <c:if test="${article.je >= 2}">checked</c:if>>1차~2차</td>
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
							<td>결핵</td>
							<td>BCG(경피용)</td>
							<td><input type="checkbox" name="bdg_m" value="1" <c:if test="${article.bdg_m >= 1}">checked</c:if>>1회</td>
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
							<td rowspan="2">로티바이러스</td>
							<td>RV1(로타릭스)</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><input type="checkbox" name="rv11" value="1" <c:if test="${article.rv1 >= 1}">checked</c:if>>1차</td>
							<td><input type="checkbox" name="rv12" value="2" <c:if test="${article.rv1 >= 2}">checked</c:if>>2차</td>
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
							<td><input type="checkbox" name="rv51" value="1" <c:if test="${article.rv5 >= 1}">checked</c:if>>1차</td>
							<td><input type="checkbox" name="rv52" value="2" <c:if test="${article.rv5 >= 2}">checked</c:if>>2차</td>
							<td><input type="checkbox" name="rv53" value="3" <c:if test="${article.rv5 >= 3}">checked</c:if>>3차</td>
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
							<td colspan="2"><input type="checkbox" name="hpv_g" value="3" <c:if test="${article.hpv_g >= 3}">checked</c:if>>1~3차</td>
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
							<td colspan="2"><input type="checkbox" name="hpv_c" value="3" <c:if test="${article.hpv_c >= 3}">checked</c:if>>1~3차</td>
						</tr>

						<tr>
							<td colspan="17"><input type="submit" value="저장"></td>
					</table>
				</form>
			</div>
		</div>
		<!-- .tab_container -->
	</c:forEach>
</div>
<!-- #container -->