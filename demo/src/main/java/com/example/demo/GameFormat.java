package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class GameFormat {
	@Id
	private int gamingLevel;
	private int noOfTimes;
	private int orderOfGame;
	public int getGamingLevel() {
		return gamingLevel;
	}
	public void setGamingLevel(int gamingLevel) {
		this.gamingLevel = gamingLevel;
	}
	public int getNoOfTimes() {
		return noOfTimes;
	}
	public void setNoOfTimes(int noOfTimes) {
		this.noOfTimes = noOfTimes;
	}
	public int getOrderOfGame() {
		return orderOfGame;
	}
	public void setOrderOfGame(int orderOfGame) {
		this.orderOfGame = orderOfGame;
	}
}
