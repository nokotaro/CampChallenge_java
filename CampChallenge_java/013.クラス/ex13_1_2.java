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

public class PrefecturesDataOut {

  public static void main(String[] args) {
    PrefecturesData hokkaido = new PrefecturesData();

    hokkaido.setData("北海道", 5316576);
    hokkaido.printData();

    PrefecturesData okinawa = new PrefecturesData();

    okinawa.setData("沖縄県", 1439997);
    okinawa.printData();
  }
}
