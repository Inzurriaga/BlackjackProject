package com.skilldistillery.blackjack;

public enum Suit {
	CLUBS("Clubs", "\u2663"),
	DIAMONDS("Diamonds", "\u2666"),
	HEARTS("Hearts", "\u2665"),
	SPADES("Spades", "\u2660");
	
	private String suit;
	private String symbol;
	
	Suit(String suit, String symbol) {
		this.suit = suit;
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	@Override
	public String toString() {
		return this.suit;
	} 
}
