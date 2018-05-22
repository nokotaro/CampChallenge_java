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

public class PrefecturesData{

  public String name = null;
  public int population = 0;

  public void setData(String n, int p){
    this.name = n;
    this.population = p;
  }

  public void printData(){
    System.out.println(this.name);
    System.out.println(this.population);
  }
}
