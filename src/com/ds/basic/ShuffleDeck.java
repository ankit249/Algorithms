package com.ds.basic;

import java.util.ArrayList;
import java.util.Random;

public class ShuffleDeck {
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		myDeck.showCards();
		System.out.println("shuffle cards");
		// myDeck.shuffle();

		System.out.println("reservoir sample shuffle cards");
		myDeck.reservoirSampleShuffle();
	}
}

class Card {
	private String rank;
	private String suit;

	public Card(String r, String s) {
		rank = r;
		suit = s;
	}

	public String getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}

	public String toString() {
		return rank + " of " + suit;
	}
}

class Deck {
	private ArrayList<Card> list;
	private String[] ranks = { "ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING" };
	private String[] suits = { "SPADE", "HEART", "CLUB", "DIAMOND" };

	public Deck() {
		list = new ArrayList<Card>();
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				list.add(new Card(ranks[j], suits[i]));
			}
		}
	}

	public void showCards() {
		System.out.println("\n\n Showing Cards !!!");
		printDeck(list);
	}

	// no need for extra DS, inplace random shuffle
	public void reservoirSampleShuffle() {
		Random r = new Random();

		if (list == null || list.size() == 0) {
			return;
		}

		int n = list.size();
		for (int i = 0; i < n; i++) {
			int random = r.nextInt(n - i) + i;
			Card tmp = list.get(random);
			list.set(random, list.get(i));
			list.set(i, tmp);
		}

		printDeck(list);
	}

	public void shuffle() {
		ArrayList<Card> temp = new ArrayList<Card>();
		Random random = new Random();
		// random.nextInt(max - min) + min
		while (!list.isEmpty()) {
			int loc = random.nextInt(list.size());
			temp.add(list.get(loc));
			list.remove(loc);
		}
		// deck = temp;
		printDeck(temp);
	}

	private void printDeck(ArrayList<Card> cards) {
		int i = 0;
		for (Card c : cards) {
			System.out.println("card " + (++i) + " " + c);
		}
	}

}
