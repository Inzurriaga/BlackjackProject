package com.skilldistillery.blackjack;

public class BlackJackHand extends Hand {

	public BlackJackHand() {

	}

	@Override
	public int getHandValue() {
		return 8;
	}

	public boolean isBlackJack() {
		return true;
	}

	public boolean isBust() {
		return true;
	}

	public boolean isHard() {
		return true;
	}

	public boolean isSoft() {
		return true;
	}
}
