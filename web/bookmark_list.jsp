<%@ page import="bookmarkgroup.BookMarkGroupDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bookmark.BookMarkDTO" %>
<%@ page import="bookmark.BookMarkDAO" %><%--
  Created by IntelliJ IDEA.
  User: wlals
  Date: 2023-02-21
  Time: 오후 6:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<h1>북마크</h1>
<%@include file="menu.jsp" %>
<% ArrayList<BookMarkDTO> list = new BookMarkDAO().getAllData();%>
<table>
    <tr>
        <th>ID</th>
        <th>북마크 이름</th>
        <th>와이파이명</th>
        <th>등록일자</th>
        <th>비고</th>
    </tr>
    <%
        if(list!=null) {
            for (BookMarkDTO dto : list) {
                out.println("<td>" + dto.getBOOKMARK_GROUP_ID() + "</td>");
                out.println("<td>" + dto.getBOOKMARK_GROUP_NM() + "</td>");
                out.println("<td>" + dto.getBOOKMARK_WIFI_NM() + "</td>");
                out.println("<td>" + dto.getBOOKMARK_CD() + "</td>");
                out.println("<td><button type='button' onclick=\"location.href='bookmark_delete.jsp?ID=" + dto.getBOOKMARK_ID() + "'\">삭제</button></td>");
                out.println("</tr>");
            }
        }else{

        }
    %>

</table>
</body>
</html>
