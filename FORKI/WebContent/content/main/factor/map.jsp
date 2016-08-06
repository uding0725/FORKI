<%@ page contentType="text/html; charset=utf-8" %>
<!-- Map Search Start -->
			<div id="factor">
				<h4 class="searchMapTitle">
					<span class="skip">지도로 찾기</span>
				</h4>
				<form>
					<fieldset>
						<!-- <legend>지도로 찾기</legend> -->
						<div class="seoulMap">

							<img id="searchGuMap" onmouseout="mouseOutMap();"
								src="../img/seoul_map.png" alt="서울특별시 자치구 선택" width="310"
								height="254" usemap="#seoulMap" class="mapImg">


							<map name="seoulMap">
								<area alt="종로구_0017" onmouseover="mouseOverMap('300');"
									shape="poly"
									coords="142,65,135,72,135,86,138,88,139,93,142,97,140,114,148,125,152,122,169,123,188,121,188,113,179,112,172,102,162,101,155,96,162,89,158,68,153,63,142,66"
									href="/bookstore/main?searchGuCode=300">
								<area alt="중구_0015" onmouseover="mouseOverMap('301');"
									shape="poly"
									coords="144,131,149,129,147,125,151,123,160,123,174,123,188,121,192,126,177,145,174,140,169,143,161,137,149,135,145,138,143,130"
									href="/bookstore/main?searchGuCode=301">
								<area alt="용산구_0012" onmouseover="mouseOverMap('302');"
									shape="poly"
									coords="136,153,145,139,151,135,161,137,169,143,174,141,185,153,158,177,139,170,136,153"
									href="/bookstore/main?searchGuCode=302">
								<area alt="성동구_0013" onmouseover="mouseOverMap('303');"
									shape="poly"
									coords="177,146,192,127,188,122,196,122,202,118,219,130,226,130,214,158,196,149,190,149,184,153,177,146"
									href="/bookstore/main?searchGuCode=303">
								<area alt="광진구_0024" onmouseover="mouseOverMap('304');"
									shape="poly"
									coords="214,158,229,122,241,122,247,118,249,122,247,126,248,132,252,132,249,147,234,161,222,162,214,158"
									href="/bookstore/main?searchGuCode=304">
								<area alt="동대문구_0018" onmouseover="mouseOverMap('305');"
									shape="poly"
									coords="188,121,188,113,210,93,217,93,224,88,223,79,226,94,224,101,229,117,226,130,219,130,201,117,196,122,187,120"
									href="/bookstore/main?searchGuCode=305">
								<area alt="중랑구_0020" onmouseover="mouseOverMap('306');"
									shape="poly"
									coords="224,87,224,79,231,77,250,75,258,76,259,91,256,95,259,100,252,109,246,118,241,122,228,122,229,117,224,102,226,94,224,87"
									href="/bookstore/main?searchGuCode=306">
								<area alt="성북구_0019" onmouseover="mouseOverMap('307');"
									shape="poly"
									coords="153,63,158,69,162,89,155,97,162,101,172,102,179,112,188,113,203,98,210,93,216,93,224,87,224,79,217,80,208,73,197,85,188,84,179,79,179,74,160,59,152,64"
									href="/bookstore/main?searchGuCode=307">
								<area alt="강북구_0021" onmouseover="mouseOverMap('308');"
									shape="poly"
									coords="177,17,184,28,181,45,187,49,208,73,197,85,188,84,180,79,178,72,160,58,161,50,157,42,161,35,167,33,168,19,177,17"
									href="/bookstore/main?searchGuCode=308">
								<area alt="도봉구_0023" onmouseover="mouseOverMap('309');"
									shape="poly"
									coords="177,16,181,1,194,3,197,10,201,6,208,9,210,16,209,32,212,39,212,57,207,54,202,65,189,50,181,46,184,33,184,26,177,16"
									href="/bookstore/main?searchGuCode=309">
								<area alt="노원구_0022" onmouseover="mouseOverMap('310');"
									shape="poly"
									coords="210,15,210,23,209,29,212,38,212,57,207,55,202,66,217,80,232,76,249,75,255,65,253,54,244,53,240,48,240,34,242,28,239,20,243,16,242,11,235,10,229,5,217,8,210,14"
									href="/bookstore/main?searchGuCode=310">
								<area alt="은평구_0016" onmouseover="mouseOverMap('311');"
									shape="poly"
									coords="100,114,84,102,96,103,98,87,110,53,132,38,141,45,143,64,135,71,135,85,129,91,129,96,124,98,112,109,108,106,100,114"
									href="/bookstore/main?searchGuCode=311">
								<area alt="서대문구_0014" onmouseover="mouseOverMap('312');"
									shape="poly"
									coords="101,114,109,106,112,109,119,105,129,96,129,92,135,86,138,88,139,94,143,99,140,114,149,128,140,133,125,134,101,114"
									href="/bookstore/main?searchGuCode=312">
								<area alt="마포구_0011" onmouseover="mouseOverMap('313');"
									shape="poly"
									coords="84,103,79,113,67,117,99,141,116,145,129,149,136,153,145,138,144,132,133,133,125,134,84,103"
									href="/bookstore/main?searchGuCode=313">
								<area alt="양천구_0002" onmouseover="mouseOverMap('314');"
									shape="poly"
									coords="45,141,42,150,45,159,41,177,47,177,52,183,65,176,73,181,79,181,84,162,91,156,85,141,72,140,71,156,55,160,45,143"
									href="/bookstore/main?searchGuCode=314">
								<area alt="강서구_0001" onmouseover="mouseOverMap('315');"
									shape="poly"
									coords="54,111,29,87,22,95,26,101,0,132,2,138,16,143,20,151,27,146,42,149,46,141,55,160,71,156,72,140,84,141,82,136,64,124,54,111"
									href="/bookstore/main?searchGuCode=315">
								<area alt="구로구_0025" onmouseover="mouseOverMap('316');"
									shape="poly"
									coords="41,177,38,187,34,188,41,196,39,203,36,208,38,210,42,207,57,209,59,202,63,202,76,191,80,197,90,203,98,204,99,201,92,180,83,168,80,181,73,182,69,177,64,177,52,183,47,177,40,177"
									href="/bookstore/main?searchGuCode=316">
								<area alt="금천구_0006" onmouseover="mouseOverMap('317');"
									shape="poly"
									coords="79,197,79,204,88,222,87,227,93,231,95,230,95,237,103,247,107,242,112,241,119,233,114,226,106,216,105,204,98,205,89,203,78,196"
									href="/bookstore/main?searchGuCode=317">
								<area alt="영등포구_0003" onmouseover="mouseOverMap('318');"
									shape="poly"
									coords="83,136,91,156,84,163,84,169,92,179,99,200,107,190,113,187,119,172,133,171,134,158,126,153,100,147,83,136"
									href="/bookstore/main?searchGuCode=318">
								<area alt="동작구_0004" onmouseover="mouseOverMap('319');"
									shape="poly"
									coords="99,201,107,190,113,187,120,172,134,171,159,183,159,209,146,205,144,194,128,193,119,192,98,201"
									href="/bookstore/main?searchGuCode=319">
								<area alt="관악구_0005" onmouseover="mouseOverMap('320');"
									shape="poly"
									coords="98,205,100,200,119,193,126,193,144,195,145,204,150,208,158,210,163,217,163,225,152,229,146,236,142,242,133,243,128,245,118,230,106,216,105,205,98,205"
									href="/bookstore/main?searchGuCode=320">
								<area alt="서초구_0007" onmouseover="mouseOverMap('321');"
									shape="poly"
									coords="159,209,159,183,173,169,179,165,185,164,197,200,202,201,209,216,219,215,228,208,234,209,243,225,238,229,234,239,224,240,225,244,222,249,209,250,199,241,198,231,198,225,194,219,191,222,183,227,177,224,176,218,169,217,168,221,162,225,163,217,159,209"
									href="/bookstore/main?searchGuCode=321">
								<area alt="강남구_0008" onmouseover="mouseOverMap('322');"
									shape="poly"
									coords="179,165,192,155,202,158,221,167,224,183,250,193,263,217,258,223,249,222,243,225,235,217,238,216,231,208,220,215,211,216,204,202,197,201,185,165,179,164"
									href="/bookstore/main?searchGuCode=322">
								<area alt="송파구_0009" onmouseover="mouseOverMap('323');"
									shape="poly"
									coords="221,168,226,183,250,194,263,217,269,215,269,210,275,210,282,201,290,193,289,184,277,182,274,177,277,171,260,160,263,152,259,149,253,149,249,156,242,162,230,166,221,168"
									href="/bookstore/main?searchGuCode=323">
								<area alt="강동구_0010" onmouseover="mouseOverMap('324');"
									shape="poly"
									coords="254,149,259,139,259,133,269,125,281,123,300,112,302,118,306,133,306,145,292,146,277,172,260,160,264,153,259,150,253,149"
									href="/bookstore/main?searchGuCode=324">
							</map>
						</div>
					</fieldset>
				</form>
			</div> <!-- Map Search End -->
