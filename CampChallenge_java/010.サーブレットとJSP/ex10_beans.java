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

import java.io.Serializable;

public class ResultData implements Serializable{

	private String d;
	private String luck;

	public ResultData(){}

	public String getD(){
		return d;
	}

	public void setD(String d){
		this.d = d;
	}

	public String getLuck(){
		return luck;
	}

	public void setLuck(String luck){
		this.luck = luck;
	}
}
