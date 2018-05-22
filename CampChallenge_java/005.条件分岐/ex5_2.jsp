<%--
    Document   : ex5_2
    Created on : 2018/04/24, 12:00:00
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
    //randomメソッドを用いて簡易的に乱数を生成する
    int num = (int)(Math.random()*3);

    //生成された値を出力する
    out.print(num + "<br>");

    switch(num){
      case 1:
        out.print("one");
        break;
      case 2:
        out.print("two");
        break;
      default:
        out.print("想定外");
        break;
    }
    %>
  </body>
</html>
