<%--
    Document   : ex10_1
    Created on : 2018/04/27, 14:00:00
    Author     : takenoko
--%>

<%@page import="org.camp.servlet.ResultData" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <%
    ResultData data = (ResultData)request.getAttribute("DATA");
  %>
  <title>占い結果</title>
  </head>
  <body>
  <%
    if(data != null){
      out.println("<h1>あなたの" + data.getD() + "の運勢は、" + data.getLuck() + "です</h1>");
    }
  %>
  </body>
</html>
