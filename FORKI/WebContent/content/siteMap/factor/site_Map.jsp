<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div id="mdS-wrap">
	<div style="width: 940px; height: 40px; margin:auto; position:relative; top:10px; font-family: 'Jeju Gothic', serif;">
		<font size="+2">사이트맵</font> <span style='position: absolute; right: 0px'> <a href="/FORKI/content/main/main.do"><img
				src="../img/home.png" width="20" height="20"></a> <a href="">>사이트맵</a>
		</span>
	</div>
	<div id="mdS-container">
	<div id="mdSTL-content" >
	
	<c:if test="${sessionScope.grade == null}">
				<div style="width:100%; height:45px; border-bottom:1px solid;"><img src="../img/chick3.png" style="position:relative; top:10px;" width="35" height="35"> <b><font size="+1">회원정보</font></b></div>
				<br>
					&nbsp; <a class="siteMap" style="text-decoration:none; color:#000000;" href="/FORKI/content/join/factor/user/loginForm.do"> 로그인</a><br><br>
					&nbsp;	<a class="siteMap" style="text-decoration:none; color:#000000;" href="/FORKI/content/join/UserInputForm.do"> 회원가입</a><br><br>
						&nbsp;<a class="siteMap" style="text-decoration:none; color:#000000;" href="/FORKI/content/join/factor/user/findID.do"> 아이디찾기</a><br><br>
						&nbsp;<a class="siteMap" style="text-decoration:none; color:#000000;" href="/FORKI/content/join/UserFindPW.do"> 비밀번호찾기</a><br><br>
					
				</c:if>
				

				<c:if test="${sessionScope.grade == 0}">
						<div style="width:100%; height:45px; border-bottom:1px solid;"><img src="../img/chick3.png" style="position:relative; top:10px;" width="35" height="35"><b><font size="+1">회원정보</font></b></div>
				<br>
		
					&nbsp;<a class="siteMap" href="/FORKI/content/adminPage/SysMemberCare.do">회원관리</a><br><br>
					&nbsp;<a class="siteMap" href="/FORKI/content/adminPage/SysBlack_list.do">블랙리스트</a><br><br>
					&nbsp;<a class="siteMap" href="/FORKI/content/adminPage/SysApprobation.do">기업가입신청</a><br><br>
					&nbsp;<a class="siteMap" href="/FORKI/content/adminPage/signUp.do">유치원등록신청</a><br><br>
					&nbsp;<a class="siteMap" href="/FORKI/content/MyPage/ReportList.do">신고함</a><br><br>
				</c:if>
				<c:if test="${sessionScope.grade == 1}">
						<div style="width:100%; height:45px; border-bottom:1px solid;"><img src="../img/chick3.png"  style="position:relative; top:10px;" width="35" height="35"><b><font size="+1">회원정보</font></b></div>
					<br>&nbsp;<a class="siteMap" href="/FORKI/content/join/UserModify.jsp">개인정보수정</a><br><br>
					&nbsp;<a class="siteMap" href="/FORKI/content/MyPage/MessengerList.do">쪽지함</a><br><br>
					&nbsp;<a class="siteMap" href="/FORKI/content/MyPage/FavoriteKinder.do">관심유치원</a><br><br>
					&nbsp;<a class="siteMap" href="/FORKI/content/MyPage/HealthCheck.do">예방접종문진표</a><br><br>
				</c:if>
				<c:if test="${sessionScope.grade == 2}">
				<div style="width:100%; height:40px; border-bottom:1px solid;"><img src="../img/chick3.png"style="position:relative; top:10px;"  width="30" height="30"> <b><font size="+1">회원정보</font></b></div>
					<br>&nbsp;<a class="siteMap" href="/FORKI/content/myPage_Buss/kinderUpdate.do">유치원수정</a><br><br>
					&nbsp;<a class="siteMap" href="/FORKI/content/MyPage/MessengerList.do">쪽지함</a><br><br>
					&nbsp;<a class="siteMap" href="/FORKI/content/myPage_Buss/kinderInput.do">유치원등록하기</a><br><br>
				</c:if>
	</div>
	<div id="mdSTR-content" >
	<div style="width:100%; height:45px; border-bottom:1px solid;"><img src="../img/chick2.png"style="position:relative; top:10px;" width="35" height="35"> 
	<b><font size="+1">유치원 찾기</font></b></div>
		<br>&nbsp; <a class="siteMap" href="/FORKI/content/findKinder/findkinder.do">유치원찾기</a><br><br>
	</div>
	<div id="mdSBL-content" >
		<div style="width:100%; height:45px; border-bottom:1px solid;"><img src="../img/chick1.png"style="position:relative; top:10px;" width="35" height="35"> 
	<b><font size="+1">주변시설 찾기</font></b></div>
<br>&nbsp; <a class="siteMap" href="/content/MedicalSystem/searchMedi.do">의료시설 찾기</a><br><br>
<br>&nbsp; <a class="siteMap" href="/FORKI/content/LibrarySystem/searchLib.do">공원/도서관 찾기</a><br><br>
	</div>
	<div id="mdSBR-content" >
		<div style="width:100%; height:45px; border-bottom:1px solid;"><img src="../img/chick4.png"style="position:relative; top:10px;" width="35" height="35"> 
	<b><font size="+1">게시판</font></b></div>
<br>&nbsp;	<a class="siteMap" href="/FORKI/content/board/notifyList.do">공지사항</a><br><br>
<br>&nbsp; <a class="siteMap" href="/FORKI/content/board/recommendList.do">건의사항</a><br><br>
<br>&nbsp; <a class="siteMap" href="/FORKI/content/board/freeBoardList.do">맘을 전해요</a><br><br>
	</div>	
	</div>
</div> 
