package com.skilldistillery.blackjack;

import java.util.List;
import java.util.ArrayList;

public abstract class Hand {
	private List<Card> cards;

	public Hand() {
		this.cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public void clear() {
		this.cards = new ArrayList<>();
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		return cards.toString();
	}
}
