<%--
    Document   : ex6_1
    Created on : 2018/04/25, 14:00:00
    Author     : takenoko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <%
      ArrayList<String> data = new ArrayList<String>();

      data.add("10");
      data.add("100");
      data.add("soeda");
      data.add("hayashi");
      data.add("-20");
      data.add("118");
      data.add("END");

      for (int i = 0; i < data.size(); i++) {
          out.print(data.get(i) + "<br>");
        }
    %>
  </body>
</html>
