<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String seq = request.getParameter("seq");
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq)); //순번입력
	BoardDAO dao = new BoardDAO();
	vo = dao.getBoard(vo.getSeq()); //객체저장
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<a href="logout_proc.jsp">로그아웃</a>
	<hr>
	<form action="updateBoard_proc.jsp" method="post">
	<input type="hidden" name="seq" value="<%=vo.getSeq() %>">
		<table border="1">
			<tr><td>제목</td><td><input type="text" name="title" value="<%=vo.getTitle() %>"></td></tr>
			<tr><td>작성자</td><td><%=vo.getWriter() %></td></tr>
			<tr><td>내용</td><td><textarea name="content" cols="40" rows="10"><%=vo.getContent() %></textarea></td></tr>
			<tr><td>등록일</td><td><%=vo.getRegDate() %></td></tr>
			<tr><td>조회수</td><td><%=vo.getCnt() %></td></tr>
			<tr><td colspan="2" align="center"><input type="submit" value="수정"></td></tr>
		</table>
	</form>
	<hr>
	<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard_proc.jsp?seq=<%=vo.getSeq()%>">글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.jsp">글 목록</a>
</body>
</html>