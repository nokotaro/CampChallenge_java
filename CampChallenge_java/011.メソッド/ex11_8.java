/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author takenoko
 */

@WebServlet(name = "UserProfileLimit", urlPatterns = {"/UserProfileLimit"})
public class UserProfileLimit extends HttpServlet {
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  //出力データ数のカウントと制限設定
  final int limit = 2;
  int count = 0;
  //userProfileメソッド
  ArrayList<String> userProfile(String id){

    //ユーザー管理配列の生成
    ArrayList<ArrayList> userlist = new ArrayList<ArrayList>();

    //該当無しの場合に返却するnull配列
    ArrayList<String> data0 = new ArrayList<String>();
    data0.add(null);
    userlist.add(data0);

    //各項目の説明
    ArrayList<String> example = new ArrayList<String>();
    example.add("ID");
    example.add("誕生年");
    example.add("誕生月");
    example.add("誕生日");
    example.add("都道府県");
    example.add("市区町村");
    example.add("番地");
    userlist.add(example);

    //以下ユーザーデータ配列
    ArrayList<String> data1 = new ArrayList<String>();
    data1.add("0018001");
    data1.add("1991年");
    data1.add("1月");
    data1.add("1日");
    data1.add(null);
    data1.add(null);
    data1.add(null);
    userlist.add(data1);

    ArrayList<String> data2 = new ArrayList<String>();
    data2.add("0018002");
    data2.add("1992年");
    data2.add("2月");
    data2.add("2日");
    data2.add("東京都");
    data2.add("千代田区");
    data2.add("九段北2-12-6");
    userlist.add(data2);

    ArrayList<String> data3 = new ArrayList<String>();
    data3.add("0018003");
    data3.add("1993年");
    data3.add("3月");
    data3.add("3日");
    data3.add("東京都");
    data3.add("千代田区");
    data3.add("九段北3-12-6");
    userlist.add(data3);

    //入力IDとマッチするユーザーデータ配列の検索
    int i = 1;

    for (; i < userlist.size(); i++) {
        if (userlist.get(i).get(0) == id) {
          break;
      }
    }
    //該当無しの場合にdata0を返却するための代入
    if (userlist.size() == i) {
      i = 0;
    }
   //該当ユーザーのデータが格納された配列を返却
   return userlist.get(i);
  }

  //outputDataメソッド
  void outputData(String id, PrintWriter out){
    //出力回数制限のチェック
    if (limit <= count) {
      return;
    }else{
      //先頭行にID表示
      out.println(id + "<br>");

      //存在しないIDが入力された場合の表示
      if (userProfile(id).get(0) == null) {
        out.println("該当するIDのユーザーが見つかりません<br>");
      }
      //ユーザーデータ配列から各要素を取り出す
      else {
        for (int i = 1; i < userProfile(id).size(); i++) {
          //nullの要素はcontinueする
          if (userProfile(id).get(i) == null) {
            continue;
          }
          //項目説明＋値を出力
          out.println(userProfile("ID").get(i) + "：" + userProfile(id).get(i) + "<br>");
        }
      }
      //ユーザーごとに挿入する改行コード
      out.println("<br>");
    }
    //出力回数をカウント
    count ++;
  }

  //processRequestメソッド
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      //検索するユーザーIDの入力
      outputData("0018001", out);
      outputData("0018002", out);
      outputData("0018003", out);
      outputData("0018004", out);
    }
  }


  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
