<%--
    Document   : ex5_3
    Created on : 2018/04/24, 14:00:00
    Author     : takenoko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <%
    char a = 'A';

    switch(a){
      case 'A':
        out.print("英語");
        break;
      case 'あ':
        out.print("日本語");
        break;
      default:
        break;
    }
    %>
  </body>
</html>
