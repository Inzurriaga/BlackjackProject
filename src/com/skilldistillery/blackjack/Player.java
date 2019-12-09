package com.skilldistillery.blackjack;

public class Player extends Character {
	private int wallet;
	private int bet;

	public Player(String name, int wallet) {
		super(name);
		this.wallet = wallet;
	}

	public boolean compareBetToWallet(int bet) {
		if (bet <= wallet) {
			this.setBet(bet);
			return true;
		}
		return false;
	}

	public void playerOutcome(int num) {
		switch (num) {
			case 1:
				this.wallet += this.bet;
				break;
			case 2:
				this.wallet -= this.bet;
				break;
			default:
		}
		this.bet = 0;
	}
	
	public void addWinnings() {
		this.wallet += this.bet;
	}
	
	public void addlost() {
		this.wallet -= this.bet;
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
