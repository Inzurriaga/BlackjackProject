package com.skilldistillery.blackjack;

import java.util.List;
import java.util.ArrayList;

public abstract class Hand {
	protected List<Card> cards;

	public Hand() {
		this.cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public void clear() {
		this.cards.clear();
	}

	public abstract int getHandValue();

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return cards.toString();
	}
}
