package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackApp {

	private Scanner input;
	private BlackJackTable table;

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	public BlackJackApp() {
		this.table = new BlackJackTable();
		this.input = new Scanner(System.in);
	}

	public void run() {
		intro();

	}

	public void intro() {
		System.out.println("Welcome to las vegas");
		int numberOfPlayer;
		while (true) {
			System.out.print("how many players are playing: ");
			try {
				numberOfPlayer = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.err.println("enter a whole number for player amount");
				input.nextLine();
			}
		}
		for (int i = 0; i < numberOfPlayer; i++) {
			playerCreationDialogue();
		}
		table.startGame();
	}

	public void playerCreationDialogue() {
		String name;
		int wallet;
		System.out.print("Enter your name: ");
		name = input.next();
		while (true) {
			System.out.print("Enter your wallet amount: ");
			try {
				wallet = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.err.println("enter a whole number for wallet amount");
				input.nextLine();
			}
		}
		table.addPlayer(new Player(name, wallet));
	}

}
