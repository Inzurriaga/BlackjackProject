package com.skilldistillery.blackjack;

public class Character {
	private String name;
	private BlackJackHand hand;

	public Character(String name) {
		this.name = name;
		this.hand = new BlackJackHand();
	}
	
	public void addCardToHand(Card card) {
		hand.addCard(card);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BlackJackHand getHand() {
		return hand;
	}

	public void setHands(BlackJackHand hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
