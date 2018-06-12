/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blackjack;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author takenoko
 */

@WebServlet(name = "BlackJackJsp", urlPatterns = {"/BlackJackJsp"})
public class BlackJack extends HttpServlet {
  public BlackJack() {
  }

  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    playData(request, response);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BlackJackJsp.jsp");
    dispatcher.forward(request, response);
  }
  
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    playData(request, response);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BlackJackJsp.jsp");
    dispatcher.forward(request, response);
  }

  
  private void playData(HttpServletRequest request, HttpServletResponse response){
    
    StringBuilder play = new StringBuilder(); //最終的に返却する文字列playをStringBuilderで生成

    Dealer dealer = new Dealer(); //dealerインスタンスの生成
    User user = new User(); //userインスタンスの生成

    //ゲームスタート時動作
    user.setCard(dealer.deal());
    dealer.setCard(dealer.deal());
    
    play.append("<br>BLACK JACK<br><br>");
    play.append("----------------------------------------<br><br>");
    play.append("GAME START<br><br>");
    play.append("Dealer ? ["+dealer.myCards.get(0)+", ?]<br>");
    play.append("Player "+user.open()+" "+user.myCards+"<br><br>");
    play.append("----------------------------------------<br><br>");
    
    
    
    //プレイヤーのターン
    play.append("PLAYER'S TURN<br><br>");
    if (!user.checkSum()){
      play.append("Dealer ? ["+dealer.myCards.get(0)+", ?]<br>");
      play.append("Player "+user.open()+" "+user.myCards+" STAY<br><br>");
      play.append("----------------------------------------<br><br>");
      
      } else {
      while (user.checkSum()) { //手札の合計値が14以上になるまでヒット

        user.setCard(dealer.hit());

        //バースト時処理
        if (user.open() > 21) { //ヒット後手札の合計値が22以上ならディーラーのターンを待たずにプレイヤーの負けが確定
        play.append("Dealer ? ["+dealer.myCards.get(0)+", ?]<br>");
        play.append("Player "+user.open()+" "+user.myCards+" HIT["+user.myCards.get(user.myCards.size()-1)+"] BUST<br><br>");
        play.append("----------------------------------------<br><br>");
        play.append("RESULT<br><br>");
        play.append("Dealer "+dealer.open()+" "+dealer.myCards+"<br>");
        play.append("Player BUST "+user.myCards+"<br><br>Dealer's WIN<br>");
        request.setAttribute("playing", play); //プレイ内容を送信
        return;
        }

        if (!user.checkSum()) {
        play.append("Dealer ? ["+dealer.myCards.get(0)+", ?]<br>");
        play.append("Player "+user.open()+" "+user.myCards+" HIT["+user.myCards.get(user.myCards.size()-1)+"] STAY<br><br>");
        play.append("----------------------------------------<br><br>");
        continue;
        }
        
        play.append("Dealer ? ["+dealer.myCards.get(0)+", ?]<br>");
        play.append("Player "+user.open()+" "+user.myCards+" HIT["+user.myCards.get(user.myCards.size()-1)+"]<br><br>");
      }
    }
    
    
    
    //ディーラーのターン
    play.append("DEALER'S TURN<br><br>");
    if (!dealer.checkSum()){
      play.append("Dealer "+dealer.open()+" "+dealer.myCards+" STAY<br>");
      play.append("Player "+user.open()+" "+user.myCards+"<br><br>");
      play.append("----------------------------------------<br><br>");
      
      } else {
      while (dealer.checkSum()) { //手札の合計値が17以上になるまでヒット
        
        dealer.setCard(dealer.hit());

        //バースト時処理
        if (dealer.open() > 21) { //ヒット後手札の合計値が22以上ならディーラーのターンを待たずにプレイヤーの負けが確定
        play.append("Dealer "+dealer.open()+" "+dealer.myCards+" HIT["+dealer.myCards.get(dealer.myCards.size()-1)+"] BUST<br>");
        play.append("Player "+user.open()+" "+user.myCards+"<br><br>");
        play.append("----------------------------------------<br><br>");
        play.append("RESULT<br><br>");
        play.append("Dealer BUST "+dealer.myCards+"<br>");
        play.append("Player "+user.open()+" "+user.myCards+"<br><br>Player's WIN<br>");
        request.setAttribute("playing", play); //プレイ内容を送信
        return;
        }

        if (!dealer.checkSum()) {
        play.append("Dealer "+dealer.open()+" "+dealer.myCards+" HIT["+dealer.myCards.get(dealer.myCards.size()-1)+"] STAY<br>");
        play.append("Player "+user.open()+" "+user.myCards+"<br><br>");
        play.append("----------------------------------------<br><br>");
        continue;
        }

        play.append("Dealer "+dealer.open()+" "+dealer.myCards+" HIT["+dealer.myCards.get(dealer.myCards.size()-1)+"]<br>");
        play.append("Player "+user.open()+" "+user.myCards+"<br><br>");
      }
    }
    


    
    
    //リザルト表示
    play.append("RESULT<br><br>");
    play.append("Dealer "+dealer.open()+" "+dealer.myCards+"<br>");
    play.append("Player "+user.open()+" "+user.myCards+"<br><br>");
    
    if (user.open() == dealer.open()) {
      play.append("DRAW"); //プレイヤーとディーラーが同得点の場合引き分け
    } else if (user.open() > dealer.open() || dealer.open() > 21) {
      play.append("Player's WIN"); //ディーラーがバーストするかプレイヤーの合計値の方が大きければ勝ち
    } else {
      play.append("Dealer's WIN");
    }
    play.append("<br>");
    request.setAttribute("playing", play); //プレイ内容を送信
  }
  
  
  @Override
  public String getServletInfo() {
    return "Short description";
  }
}