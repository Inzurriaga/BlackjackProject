package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BlackJackTable {
	private List<Character> characters;
	private List<Character> playersInGame;
	private Deck deck;
	private Scanner input;

	public BlackJackTable() {
		this.characters = new ArrayList<>();
		this.playersInGame = new ArrayList<>();
		this.deck = new Deck();
		this.input = new Scanner(System.in);
	}

	public void startGame() {
		deck.shuffle();
		addDealer();
		while (characters.size() > 1) {
			placeBet();
			dealCards();
			playerPlay();
			checkWinners();
		}
	}

	public void addPlayer(Character player) {
		this.characters.add(player);
	}

	public void addDealer() {
		this.characters.add(new Dealer("Dealer"));
	}

	public void placeBet() {
		playersInGame.clear();
		for (Character character : characters) {
			if (character instanceof Dealer) {
				playersInGame.add(character);
				break;
			}
			int playersChoice = 0;
			do {
				System.out.println(character.getName() + " pick an option");
				System.out.println("1. Bet\n2. Play next Deal\n3. check Wallet");
				try {
					playersChoice = input.nextInt();
					switch (playersChoice) {
						case 1:
							playersInGame.add(character);
							updatePlayersBet((Player) character);
							break;
						case 2:
							System.out.println(character.getName() + " decides to past game");
							break;
						case 3:
							System.out.println("You have " + ((Player) character).getWallet() + " in your wallet");
							break;
						default:
							System.out.println("Enter a valid response");
					}
				} catch (InputMismatchException e) {
					System.err.println("Enter a valid response");
				}
			} while (playersChoice == 3);
		}
	}

	public void dealCards() {
		System.out.println(this.playersInGame.get(this.playersInGame.size() - 1) + " is dealing out cards");
		for (int i = 0; i < 2; i++) {
			for (Character player : playersInGame) {
				player.addCardToHand(this.deck.dealCard());
			}
		}
	}

	public void playerPlay() {
		for (int i = 0; i < this.playersInGame.size(); i++) {
			if (this.playersInGame.get(i) instanceof Player) {
				int playerChoice = 0;
				do {
					System.out.println(this.playersInGame.get(i).getName() + " pick an option");
					displayCards(i);
					System.out.println("1. Hit\n2. Stay");
					try {
						playerChoice = input.nextInt();
						switch (playerChoice) {
							case 1:
								this.playersInGame.get(i).addCardToHand(deck.dealCard());
								if (this.playersInGame.get(i).getHand().isBust()) {
									System.out.println("you bust your hand value " + this.playersInGame.get(i).getHand().getHandValue());
									playerChoice = 2;
								}
								break;
							case 2:
								System.out.println("next player turn");
								break;
							default:
								System.out.println("Enter a valid response");
						}
					} catch (InputMismatchException e) {
						System.err.println("Enter a valid response");
					}
				} while (playerChoice == 1);
			} else {
				while(this.playersInGame.get(i).getHand().getHandValue() <= 17 && !this.playersInGame.get(i).getHand().isBust()) {
					this.playersInGame.get(i).addCardToHand(deck.dealCard());
				}
				if(this.playersInGame.get(i).getHand().isBust()) {
					System.out.println("Dealer bust");
				}
			}
		}
	}

	public void checkWinners() {
		int dealersCardValue = this.playersInGame.get(this.playersInGame.size() - 1).getHand().getHandValue();
		for (int i = 0; i < this.playersInGame.size() - 1; i++) {
			boolean bust = this.playersInGame.get(i).getHand().isBust();
			int player = this.playersInGame.get(i).getHand().getHandValue();
			if(this.playersInGame.get(this.playersInGame.size() - 1).getHand().isBust()) {
				((Player) this.playersInGame.get(i)).addWinnings();
			}else if (bust || player < dealersCardValue) {
				((Player) this.playersInGame.get(i)).addlost();
			} else if (player > dealersCardValue) {
				((Player) this.playersInGame.get(i)).addWinnings();
				System.out.println("congrats you won");
			} else {
				System.out.println("you are tie");
			}
			if(((Player) this.playersInGame.get(i)).getWallet() == 0) {
				this.characters.remove(i);
			}
		}
	}

	public void updatePlayersBet(Player player) {
		int playersbet;
		boolean compareBetToWallet = false;
		do {
			try {
				System.out.println(player.getName() + " how much do you want to bet: ");
				playersbet = input.nextInt();
				compareBetToWallet = (player.compareBetToWallet(playersbet));
				if (!compareBetToWallet) {
					System.out.println(
							"You have " + player.getWallet() + " in your wallet and trying to bet " + playersbet);
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("enter a valid response");
			}
		} while (!compareBetToWallet);
	}
	
	public void displayCards(int currentPlayerIndex) {
		for(int i = 0; i < this.playersInGame.size(); i++) {
			for(int x = 0; x < this.playersInGame.get(i).getHand().getCards().size(); x++) {
				if(x == 0) {
					System.out.print(this.playersInGame.get(i).getName() + " : ");
					System.out.print("|" + this.playersInGame.get(i).getHand().getCards().get(x).cardSymbol() + "| ");
				}
				if(currentPlayerIndex >= i && x > 0) {
					System.out.print("|" + this.playersInGame.get(i).getHand().getCards().get(x).cardSymbol() + "| ");
				} else if (x > 0) {
					System.out.print(" |  | ");
				}
			}
		}
		System.out.println();
	}

}
