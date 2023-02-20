<%@ page import="wifiinfo.WifiInfoDTO" %>
<%@ page import="wifiinfo.WifiInfoDAO" %>
<%@ page import="bookmarkgroup.BookMarkGroupDAO" %><%--
  Created by IntelliJ IDEA.
  User: wlals
  Date: 2023-02-19
  Time: 오전 1:38
  To change this template use File | Settings | File Templates.

  parameter mgrNo
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        @import "css/common.css";
    </style>
    <%
        String mgrNo= request.getParameter("mgrNo");
        String distance= request.getParameter("distance");
    %>

</head>
<body>
<h1> 와이파이 정보 구하기</h1>
<%@ include file="menu.jsp"%>
<form action="" target="_blank">
    <select>
        <option value="">선택하세요</option>
        <%
            BookMarkGroupDAO dao=new BookMarkGroupDAO();
            for (String str :dao.getBookMarkGroupNames() ) {
                out.print("<option value=\""+str+"\"name=\""+str+"\">"   + str +"</option> ");
            }
        %>
    </select>
    <button>북마크 저장하기</button>
</form>


<table>
<%if(mgrNo!=null && distance!=null){

    WifiInfoDTO dto = new WifiInfoDAO().getDetail(mgrNo,distance);

    out.println("<tr><th>거리(Km)</th><td>"+distance +"</td>/<tr>");
    out.println("<tr><th>관리번호</th><td>"+dto.getX_SWIFI_MGR_NO() +"</td>/<tr>");
    out.println("<tr><th>자치구</th><td>"+dto.getX_SWIFI_WRDOFC()+"</td>/<tr>");
    out.println("<tr><th>도로명주소</th><td>"+dto.getX_SWIFI_ADRES1()+"</td>/<tr>");
    out.println("<tr><th>상세주소</th><td>"+dto.getX_SWIFI_ADRES2() +"</td>/<tr>");
    out.println("<tr><th>설치위치(층)</th><td>"+dto.getX_SWIFI_INSTL_FLOOR() +"</td>/<tr>");
    out.println("<tr><th>설치유형</th><td>"+dto.getX_SWIFI_INSTL_MBY() +"</td>/<tr>");
    out.println("<tr><th>설치기관</th><td>"+dto.getX_SWIFI_INSTL_TY() +"</td>/<tr>");
    out.println("<tr><th>서비스구분</th><td>"+dto.getX_SWIFI_SVC_SE() +"</td>/<tr>");
    out.println("<tr><th>망종류</th><td>"+dto.getX_SWIFI_CMCWR() +"</td>/<tr>");
    out.println("<tr><th>설치년도</th><td>"+dto.getX_SWIFI_CNSTC_YEAR() +"</td>/<tr>");
    out.println("<tr><th>실내외 구분</th><td>"+dto.getX_SWIFI_INOUT_DOOR() +"</td>/<tr>");
    out.println("<tr><th>WIFI접속환경</th><td>"+dto.getX_SWIFI_REMARS3() +"</td>/<tr>");
    out.println("<tr><th>X좌표</th><td>"+dto.getLAT() +"</td>/<tr>");
    out.println("<tr><th>Y좌표</th><td>"+dto.getLNT() +"</td>/<tr>");
    out.println("<tr><th>작업일자</th><td>"+dto.getWORK_DTTM() +"</td>/<tr>");
}else{

}%>
</table>



