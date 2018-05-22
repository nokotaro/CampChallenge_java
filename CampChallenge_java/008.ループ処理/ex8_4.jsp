<%--
    Document   : ex8_4
    Created on : 2018/04/26, 10:00:00
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
      float num = 1000;
      while (num >= 100) {
        num = num / 2;
        }
      out.print(num);
    %>
  </body>
</html>
