<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="/servlettest/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#boardupdatelink").on('click', function(event){
        // 버튼의 value가 "수정"일 때만 암호 확인
        if ($(this).val() === "수정") {
            let inputString = prompt('글암호를 입력하세요', '암호 입력');
            if (inputString == '${board.writepw}') {
                // 암호가 맞으면 제목과 내용을 수정 가능한 입력 필드로 변경
                let title = $("#updatetitle").text();
                let contents = $("#updatecontents").text();

                $("#updatetitle").html('<input type="text" name="title" value="' + title + '" />');
                $("#updatecontents").html('<textarea name="contents">' + contents + '</textarea>');
                // 버튼 텍스트를 "수정 완료"로 변경
                $(this).val("수정 완료");

                // 폼의 action을 수정 페이지로 설정
                $("form").attr("action", "boardstart?menu=boardupdate");
            } else {
                alert('암호가 다릅니다. 올바른 암호를 입력하세요.');
                event.preventDefault(); // 수정되지 않도록 기본 이벤트 막기
            }
        } else if ($(this).val() === "수정 완료") {
            // 수정 완료 버튼 클릭 시 폼 제출
            $("form").submit();
        }
    });
	        
	$("#boarddeletelink").on('click', function(event){
		let inputString = prompt('글암호를 입력하세요', '암호 입력');
		if (inputString == ${board.writepw}){
			$("form").attr("action", "boardstart?menu=boarddelete");
			$("form").submit();
		} else {
			alert('암호가 다릅니다. 올바른 암호를 입력하세요.');
			event.preventDefault();
		}
	});
});
</script>
</head>
<body>
<h1><%=request.getParameter("seq") %> 번의 게시물 검색</h1>

<jsp:useBean id="board" class="mvc.BoardDTO" scope="request" />
<form method = "POST">
	<table border=1>
	<tr><td>번호</td><td>${board.seq }</td></tr>
	<tr><td>제목</td><td id="updatetitle">${board.title }</td></tr>
	<tr><td>내용</td><td id="updatecontents">${board.contents }</td></tr>
	<tr><td>작성자</td><td>${board.writer }</td></tr>
	<tr><td>조회수</td><td>${board.viewCount }</td></tr>
	<tr><td>작성시간</td><td>${board.writingTime }</td></tr>
	<tr>
	<td colspan="2" style="text-align:center">
	<input type="button" value="수정" id="boardupdatelink">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="삭제" id="boarddeletelink">
	<input type="hidden" name="seq" value="${board.seq }">
	</td>
	</tr>
	</table>
</form>
</body>
</html>