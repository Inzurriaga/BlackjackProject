package com.skilldistillery.blackjack;

public class Player extends Character {
	private int wallet;
	private int bet;
	
	public Player(String name, int wallet) {
		super(name);
		this.wallet = wallet;
	}
	
	public boolean compareBetToWallet(int bet) {
		if(bet <= wallet) {
			this.setBet(bet);
			return true;
		} 
		return false;
	}

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
	
	
	
}
