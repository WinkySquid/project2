package models;

import java.util.*;

public class CardList {
	
	//INSTANCE VARIABLE (an ArrayList of Card objects)
	private ArrayList<Card> c;
	
	//CONSTRUCTOR
	public CardList() {
		c = new ArrayList<Card>();
		addCards();
	}
	
	//GETTER
	public ArrayList<Card> getList(){
		return c;
	}
	
	/*
	 * This method adds the 20 cards (10 matching pairs of cards) that 
	 * will be on the board to c (the ArrayList). It also shuffles c 
	 * so that the Card objects in c will be in a random order.
	 */
	private void addCards() {
		Card c1 = new Card("chorusKids.png");
		Card c2 = new Card("girl.png");
		Card c3 = new Card("karateJoe.png");
		Card c4 = new Card("monkey.png");
		Card c5 = new Card("samurai.png");
		Card c6 = new Card("munchyMonk.png");
		Card c7 = new Card("widgets.png");
        Card c8 = new Card("marshall.png");
        Card c9 = new Card("screwbots.png");
        Card c0 = new Card("reporter.png");
        for(int i = 0; i < 2; i++){
        	c.add(c1);
        	c.add(c2);
    		c.add(c3);
    		c.add(c4);
    		c.add(c5);
    		c.add(c6);
    		c.add(c7);
    		c.add(c8);
    		c.add(c9);
    		c.add(c0);
        }
		Collections.shuffle(c);
	}
}
