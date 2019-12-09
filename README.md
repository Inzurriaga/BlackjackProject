## Black Jack App
### Week Five Homework for Skill Distillery

#### Overview

An java application that simulate the game of black jack.

Once users compiles and run the application they will be prompted with.

```
$ Welcome to las vegas
how many players are playing:
```

Once the user enter the amount of players they will then have to create each players account by entering their name and the amount of money they want to play.

```
$ Enter your name: bill
Enter your wallet amount: 200 
```

After all players info are enter in players then have three options before the cards are deal out. players can bet but not more than they have in their wallet, players can play next deal, or players can check wallet amount.

```
$ bill pick an option
1. Bet
2. Play next Deal
3. check Wallet
```

If players decide to bet then they will be deal two cards. All other players second card will be hidden from current player until its their turn to play. if player hit they will be given another card if they stay it will be next players turn.

```
$ bill : |2♠|  |6♦| 
Dealer : |6♣|  |  | 
1. Hit
2. Stay
```

If player beats the dealer or the dealer bust they will be prompted that they won and the amount they won, if they lost they will be prompted they lost and the amount they lost, or if they tie they will be prompted that they are tie. Once the players wallet hit 0 the player will be out the game.

```
$ bill lost 100
```

### Structure

Within the application  contains 11 classes, one to run the application, 2 Enum, 1 abstract, and the rest just normal classes of java.

The first class Card implements the Rank and Suit Enum.

Card implements --- Rank, Suit

The Deck class which creates a new List of Card when initialize.

Deck

The abstract class Hand holds an List of Card objects then gets extended to the  BlackjackHand class.

BlackjackHand extends --- Hand

Both Player and Dealer extends the Character class due to both having a hand and name.

Player --- Character <br />
Dealer --- Character

Then there's the BlackJackTable which in its field holds the Deck and a List of Character.

BlackJackTable

And Lastly the BlackJackApp which holds the BlackJackTable.

BlackJackApp

#### Concepts

* Enum
* Abstract
* Loop
* Methods
* if/else
* Classes
* OOP

#### Technologies Used

 * Java
 * Eclipse

#### Lessons Learned

Learn the basic structure of the java language using methods, loops, and variables.