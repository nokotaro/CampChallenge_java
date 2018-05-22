<%--
    Document   : ex8_3
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
      int sum = 0;
      for (int i = 0; i < 100; i++) {
        sum += i;
        }
      out.print(sum);
    %>
  </body>
</html>
