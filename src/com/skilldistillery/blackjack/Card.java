package com.skilldistillery.blackjack;

public class Card {
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getValue() {
		return this.rank.getValue();
	}
	
	public String cardSymbol() {
		return this.rank.getSymbol() + this.suit.getSymbol();
	}
	
	public String toString() {
		return this.rank + " of " + this.suit;
	}
}
