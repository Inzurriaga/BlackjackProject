package com.skilldistillery.blackjack;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<>();
		createDeck();
	}
	
	public void createDeck() {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		for(Suit suit : suits) {
			for(Rank rank : ranks) {
				cards.add(new Card(suit, rank));
			}
		}
	}
	
	public int cardsLeftInDeck() {
		return cards.size();
	}
	
	public Card dealCard() {
		return cards.remove(0);
	}
	
	public void dealCard(Hand hand) {
		hand.addCard(cards.remove(0));
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public int size() {
		return cards.size();
	}
}
