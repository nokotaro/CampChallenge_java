<%--
    Document   : ex8_1
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
      long num = 8;
      for (int i = 0; i < 19; i++) {
        num = num * 8;
        }
      out.print(num);
    %>
  </body>
</html>
