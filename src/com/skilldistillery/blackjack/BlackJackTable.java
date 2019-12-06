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
		placeBet();
		dealCards();
		playerPlay();
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
			int playersChoice;
			while (true) {
				System.out.println(character.getName() + " pick an option");
				playerBetOption();
				try {
					playersChoice = input.nextInt();
					if (playersChoice == 3) {
						System.out.println("You have " + ((Player) character).getWallet() + " in your wallet");
						continue;
					}
					break;
				} catch (InputMismatchException e) {
					System.err.println("enter a valid response");
				}
			}
			if (playersChoice == 1) {
				playersInGame.add(character);
				updatePlayersBet(character);
			}

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
		for (Character player : playersInGame) {
			if (player instanceof Player) {
				System.out.println(player.getName() + " pick an option");
				int playerChoice = 1;
				do {
					playerPlayOption();
					try {
						playerChoice = input.nextInt();
						switch (playerChoice) {
							case 1:
								player.addCardToHand(deck.dealCard());
								break;
							case 2:
								System.out.print("next player turn");
								break;
							default:
								System.out.println("Enter a valid response");
						}
					} catch (InputMismatchException e) {
						System.err.println("Enter a valid response");
					}
				} while (playerChoice == 1);
			} else {
				System.out.println("im the dealer");
			}
		}
	}

	public void playerBetOption() {
		System.out.println("1. Bet\n2. Play next Deal\n3. check Wallet");
	}

	public void playerPlayOption() {
		System.out.println("1. Hit\n2. Stay");
	}

	public void updatePlayersBet(Character character) {
		int playersbet;
		boolean compareBetToWallet = false;
		do {
			try {
				System.out.println(character.getName() + " how much do you want to bet: ");
				playersbet = input.nextInt();
				compareBetToWallet = ((Player) character).compareBetToWallet(playersbet);
				break;
			} catch (InputMismatchException e) {
				System.err.println("enter a valid response");
			}
		} while (compareBetToWallet);
	}

}
