<%-- 
    Document   : ex4_1
    Created on : 2018/04/20, 16:30:00
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
      String c1 = "groove";
      char hyphen = '-';
      String c2 = "gear";

      out.print(c1 + hyphen + c2);
    %>
  </body>
</html>
