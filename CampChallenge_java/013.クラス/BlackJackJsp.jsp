<%@page import="org.camp.blackjack.BlackJack" %>
<%@page import="java.util.*" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ブラックジャック</title>
    <style type="text/css">
    </style>
  </head>
  <body>
    <%= request.getAttribute("playing")%>
  </body>
</html>