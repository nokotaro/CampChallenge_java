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

@WebServlet(name = "UserProfileSearch", urlPatterns = {"/UserProfileSearch"})
public class UserProfileSearch extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  ArrayList<String> userProfile(String id){
    ArrayList<ArrayList> userlist = new ArrayList<ArrayList>();
    ArrayList<String> data1 = new ArrayList<String>();
    data1.add("0018001");
    data1.add("1991年");
    data1.add("1月");
    data1.add("1日");
    data1.add("1020073");
    data1.add("東京都");
    data1.add("千代田区");
    data1.add("九段北1-12-6");
    userlist.add(data1);

    ArrayList<String> data2 = new ArrayList<String>();
    data2.add("0018002");
    data2.add("1992年");
    data2.add("2月");
    data2.add("2日");
    data2.add("1020073");
    data2.add("東京都");
    data2.add("千代田区");
    data2.add("九段北2-12-6");
    userlist.add(data2);

    ArrayList<String> data3 = new ArrayList<String>();
    data3.add("0018003");
    data3.add("1993年");
    data3.add("3月");
    data3.add("3日");
    data3.add("1020073");
    data3.add("東京都");
    data3.add("千代田区");
    data3.add("九段北3-12-6");
    userlist.add(data3);

    int i = 0;
    for (; i < userlist.size(); i++) {
        if (userlist.get(i).get(0) == id) {
          break;
      }
    }
   return userlist.get(i);
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      String id = "0018003";
      if (userProfile(id) == null) {
        out.println("該当するIDのユーザーが見つかりません");
      } else {
        for (int i = 1; i < userProfile(id).size(); i++) {
          out.println(userProfile(id).get(i) + "<br>");
        }
      }
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
