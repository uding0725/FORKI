<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page session="true"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	Date time = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<p>SESSION 정보</p>
	세션 memId : ${sessionScope.memId} <br> <!-- 세션에 저장된 아이디 값을 확인 -->
	세션ID : <%=session.getId()%><br>
	<%
		time.setTime(session.getCreationTime()); 
	%>
	세션생성시간 : <%=formatter.format(time)%><br>
	<%
		time.setTime(session.getLastAccessedTime());
	%>
	최근접근시간 : <%=formatter.format(time)%>

	<hr />
	MEMBERS 테이블의 내용 
	<table width="100%" border="1">
		<tr>
			<td>ID</td>
			<td>PWD</td>
			<td>NAME</td>
			<td>Email</td>
		</tr>
		<%
			Class.forName("oracle.jdbc.driver.OracleDriver"); /* 독립적으로 돌리기위해 커넥션풀을 사용하지 않음 */

			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:XE";
				String dbUser = "you";
				String dbPass = "0258";

				String query = "select * from MEMBER order by ID";

				conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

				stmt = conn.createStatement();

				rs = stmt.executeQuery(query);

				while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("ID")%></td>
			<td><%=rs.getString("PASSWD")%></td>
			<td><%=rs.getString("NAME")%></td>
			<td><%=rs.getString("EMAIL")%></td>
		</tr>
		<%
			}
			} catch (SQLException ex) {
				out.println(ex.getMessage());
				ex.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException ex) {
					}
				if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException ex) {
					}
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException ex) {
					}
			}
		%>
	</table>

</body>
</html>