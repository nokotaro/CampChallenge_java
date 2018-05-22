<%--
    Document   : ex7_1
    Created on : 2018/04/25, 16:00:00
    Author     : takenoko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <%
      HashMap<String,String> data = new HashMap<String, String>();

      data.put("1", "AAA");
      data.put("hello", "world");
      data.put("soeda", "33");
      data.put("20", "20");
    %>
  </body>
</html>