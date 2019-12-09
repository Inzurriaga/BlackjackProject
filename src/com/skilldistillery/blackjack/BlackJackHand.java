package com.skilldistillery.blackjack;

public class BlackJackHand extends Hand {

	public BlackJackHand() {
	}

	@Override
	public int getHandValue() {
		int sum = 0;
		for(Card card : this.cards) {
			sum += card.getValue();
		}
		return sum;
	}

	public boolean isBlackJack() {
		int sum = getHandValue();
		if(sum == 21) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		int sum = getHandValue();
		if(sum < 22) {
			return false;
		}
		return true;
	}

	public boolean isHard() {
		return true;
	}

	public boolean isSoft() {
		return true;
	}
}
