/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

/**
 *
 * @author takenoko
 */

public class PrefecturesExtendsOut {
  public static void main(String[] args) {
    PrefecturesExtends hokkaido = new PrefecturesExtends();

    hokkaido.setData("北海道", 5316576);
    hokkaido.printData();
    hokkaido.clearData();
    hokkaido.printData();

    PrefecturesExtends okinawa = new PrefecturesExtends();

    okinawa.setData("沖縄県", 1439997);
    okinawa.printData();
    okinawa.clearData();
    okinawa.printData();
  }
}
