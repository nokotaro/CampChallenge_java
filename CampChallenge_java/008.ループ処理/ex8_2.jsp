<%--
    Document   : ex8_2
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
      String a = "A";
      for (int i = 0; i < 29; i++) {
        a = a + "A";
        }
      out.print(a);
    %>
  </body>
</html>
