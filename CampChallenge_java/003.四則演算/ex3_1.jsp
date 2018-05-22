<%-- 
    Document   : ex3_1
    Created on : 2018/04/20, 14:00:00
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
      //あらかじめ定数で設定された消費税に対し、変数として所持金と果物の税抜価格を代入する。
      //それぞれの果物が最大で何個買えるかを、消費税計算を含め四則演算で算出し表示する。
      //また、剰余算を用いることでその時のおつりについても算出し表示する。

      //消費税をdouble型で定数として宣言
      final double SALES_TAX = 1.08;

      //所持金と果物の税抜価格を変数に代入
      double balance = 2000;
      int price_orange = 85;
      int price_apple = 130;

      //最初に所持金と果物の税抜価格を表示する
        out.print("みかん1個が税抜価格");
        out.print(price_orange);
        out.print("円、りんご1個が税抜価格");
        out.print(price_apple);
        out.print("円で売られている。<br>所持金が");
        out.print((int)balance);
        out.print("円のとき、消費税を");
        out.print((int)(100 * (SALES_TAX - 1))); //(int)の位置に注意
        out.print("％として計算すると、<br>");

      //小数点や剰余算を伴う計算は手計算の時の計算順序が通用しないので注意
      double max_qty_orange = balance / (price_orange * SALES_TAX);
        out.print("みかんなら最大");
        out.print((int)max_qty_orange);
        out.print("個買え、そのときのおつりは");
      double balance_orange = balance % (price_orange * SALES_TAX);
        out.print((int)balance_orange);
        out.print("円である。<br>");

      double max_qty_apple = balance / (price_apple * SALES_TAX);
        out.print("りんごなら最大");
        out.print((int)max_qty_apple);
        out.print("個買え、そのときのおつりは");
      double balance_apple = balance % (price_apple * SALES_TAX);
        out.print((int)balance_apple);
        out.print("円である。<br>また、みかんとりんごを同じ個数買わなければならないとき、<br>最大");

      //みかんとりんごが1個ずつ入っているセットを考え、あとは上記と同様に計算する。
      double max_qty_all = balance / ((price_orange + price_apple) * SALES_TAX);
        out.print((int)max_qty_all);
        out.print("個ずつ買うことができ、そのときのおつりは");
      double balance_all = balance % ((price_orange + price_apple) * SALES_TAX);
        out.print((int)balance_all);
        out.print("円である。");
%>
  </body>
</html>
