<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table width=700>
	<tr rowspan=6>
	<td>
	</td>
		<td width=320 >
			<div name="myPage" >
				<c:if test="${sessionScope.grade == null}">
				<b>회원정보</b> <br>
					<a class="siteMap" href="/FORKI/content/join/factor/user/loginForm.do">로그인</a><br>
					<a class="siteMap" href="/FORKI/content/join/UserInputForm.do">회원가입</a><br>
					<a class="siteMap" href="/FORKI/content/join/factor/user/findID.do">아이디찾기</a><br>
					<a class="siteMap" href="/FORKI/content/join/UserFindPW.do">비밀번호찾기</a><br>
					
				</c:if>
				

				<c:if test="${sessionScope.grade == 0}">
				<b>회원정보</b> <br>
					<a class="siteMap" href="#">회원관리</a></li>
					<a class="siteMap" href="/FORKI/content/adminPage/SysBlack_list.do">블랙리스트</a></li>
					<a class="siteMap" href="#">기업가입신청</a></li>
					<a class="siteMap" href="/FORKI/content/adminPage/signUp.do">유치원등록신청</a></li>
					<a class="siteMap" href="/FORKI/content/MyPage/ReportList.do">신고함</a></li>
				</c:if>
				<c:if test="${sessionScope.grade == 1}">
				<b>회원정보</b> <br>
					<a class="siteMap" href="/FORKI/content/join/UserModify.jsp">개인정보수정</a></li>
					<a class="siteMap" href="/FORKI/content/MyPage/MessengerList.do">쪽지함</a></li>
					<a class="siteMap" href="/FORKI/content/MyPage/FavoriteKinder.do">관심유치원</a></li>
					<a class="siteMap" href="/FORKI/content/MyPage/HealthCheck.do">예방접종문진표</a></li>
				</c:if>
				<c:if test="${sessionScope.grade == 2}">
				<b>회원정보</b><br>
					<a class="siteMap" href="/FORKI/content/myPage_Buss/kinderUpdate.do">유치원수정</a></li>
					<a class="siteMap" href="/FORKI/content/MyPage/MessengerList.do">쪽지함</a></li>
					<a class="siteMap" href="/FORKI/content/myPage_Buss/kinderInput.do">유치원등록하기</a></li>
				</c:if>
				</div>
</td>
<td > </td>
<td width=320 >
<div name="searchKinder">
<b>유치원찾기</b><br>
					<a class="siteMap" href="/FORKI/content/findKinder/findkinder.do">유치원찾기</a><br>
</div>		
				
</td>
</tr>
<tr>
<td>
	</td>
<td width=320>
<div name="searchSide">
<b>주변 시설 찾기</b><br>
<a class="siteMap" href="/content/MedicalSystem/searchMedi.do">의료시설 찾기</a><br>
<a class="siteMap" href="/FORKI/content/LibrarySystem/searchLib.do">공원/도서관 찾기</a><br>
</div>
</td>
<td>
</td>
<td width=320>
<div name="board">
<b>게시판</b><br>
<a class="siteMap" href="/FORKI/content/board/notifyList.do">공지사항</a><br>
<a class="siteMap" href="/FORKI/content/board/recommendList.do">건의사항</a><br>
<a class="siteMap" href="/FORKI/content/board/freeBoardList.do">맘을 전해요</a><br>
</div>
</td>				
				
				</table>