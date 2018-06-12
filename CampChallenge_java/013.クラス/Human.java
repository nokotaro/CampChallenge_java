/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author takenoko
 */

//抽象クラス Human
abstract class Human {
  protected ArrayList<Integer> myCards = new ArrayList<Integer>(); //自分の手札
  public abstract void setCard(ArrayList<Integer> drawcard); //カードを手札に追加
  public abstract int open(); //手札の合計値を返却
  public abstract boolean checkSum(); //ヒットの判断
}

//子クラス User プレイヤー
class User extends Human{

  //引いたカードを手札に追加
  @Override
  public void setCard(ArrayList<Integer> drawcards) {
    this.myCards.addAll(drawcards); //入力配列の全要素を手札の配列の末端に追加
  }

  //自分の手札の合計値を返却
  @Override
  public int open() {
    int sum = 0; //合計値を一時的に格納する変数
      for (Integer myCard : myCards) { //手札の値を1枚ずつ加算する
        sum += myCard;
      }
    return sum; //合計値を返却
  }

  //ヒットの判断
  @Override
  public boolean checkSum() {
    int sum = open();
    return sum < 14; //手札の合計値が14未満ならヒット
  }
}

//子クラス Dealer ディーラー
class Dealer extends Human{

  //山札の配列を生成
  protected ArrayList<Integer> cards = new ArrayList<Integer>();
  
  //空の山札の配列にトランプを追加
  public Dealer() {
    for (int i = 1; i < 11; i++) {
      if (i != 10) {
        for (int j = 0; j < 4; j++) {
          cards.add(i); //1-9は4枚追加
        }
      } else {
        for (int j = 0; j < 16; j++) {
          cards.add(i); //10のみ16枚追加
        }
      }
    }
    //dealやhitのメソッド内でもRandom関数を用いて山札からランダムに引こうとしているが
    //よりランダム性を高めるためにshuffleメソッドを用いて山札をシャッフルする
    Collections.shuffle(cards);
  }
  
  //山札からランダムで2枚引く
  public ArrayList<Integer> deal() {
    ArrayList<Integer> dealcards = new ArrayList<Integer>(); //引いたカードを一時的に格納する配列
    
    for (int i = 0; i < 2; i++) { //2枚引く
      int num; //山札の配列から取得する要素の番号を格納する変数
      Random rnd = new Random();
      num = rnd.nextInt(this.cards.size()); //山札の残り枚数内の範囲でランダムな数字を得る
      int drawcard = this.cards.get(num);
      dealcards.add(drawcard); //引いたカードを一時格納の配列に追加
      this.cards.remove(num); //引いたカードを山札の配列から削除
    }
    return dealcards; //引いたカードを配列として返却
  }
  
  //山札からランダムで1枚引く
  //setCardの引数が配列型なので1枚だが配列で返却
  public ArrayList<Integer> hit() {
    ArrayList<Integer> hitcard = new ArrayList<Integer>();
    //基本動作はdealメソッドと同様
    int num;
    Random rnd = new Random();
    num = rnd.nextInt(this.cards.size());
    int drawcard = this.cards.get(num);
    hitcard.add(drawcard);
    this.cards.remove(num);
    return hitcard;
  }

  //引いたカードを手札に追加
  @Override
  public void setCard(ArrayList<Integer> drawcards) {
    this.myCards.addAll(drawcards);
  }

  //自分の手札の合計値を返却
  @Override
  public int open() {
    int sum = 0;
      for (Integer myCard : myCards) {
        sum += myCard;
      }
    return sum;
  }

  //ヒットの判断
  @Override
  public boolean checkSum() {
    int sum = open();
    return sum < 17; //手札の合計値が17未満ならヒット
  }
}