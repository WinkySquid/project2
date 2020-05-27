package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import models.Card;
import models.StopWatch;

@SuppressWarnings("serial")
public class ButtonMap extends JFrame{
	
	//INSTANCE VARIABLES
	private List<Card> cards;
	private StopWatch _s;
    private Card Card1;
    private Card Card2;
    private Timer t;
    
    //CONSTRUCTOR
	public ButtonMap() {
        List<Card> cardsList = new ArrayList<Card>();
        List<String> cardVals = new ArrayList<String>();
        _s = new StopWatch();
        for(int i = 0; i < 2; i++) {
            cardVals.add("chorusKids.png");
            cardVals.add("girl.png");
            cardVals.add("karateJoe.png");
            cardVals.add("monkey.png");
            cardVals.add("marshall.png");
            cardVals.add("munchyMonk.png");
            cardVals.add("reporter.png");
            cardVals.add("widgets.png");
            cardVals.add("screwbots.png");
            cardVals.add("samurai.png");
        }
        Collections.shuffle(cardVals);
        for (String val : cardVals){
            Card c = new Card(val);
            c.setUrl(val);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    doTurn(c);
                }
            });
            cardsList.add(c);
        }
        this.cards = cardsList;
        t = new Timer(700, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        t.setRepeats(false);
    	setBackground(new Color(50, 50, 50));

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5, 4));
        for (Card c : cards){
            pane.add(c);
        }
        setTitle("Memory Game: Rhythm Heaven Edition");
        _s.startThread();
    }

	/*
	 * This method changes the board (ButtonMap) when the player flips 
	 * over a card (clicks on a button). If the first card has not been 
	 * displayed and if the second card has not been displayed, then the 
	 * method reveals the first card the player picked. If the first 
	 * card has already been shown on the board and the second card 
	 * has not been displayed, then the method reveals the second card
	 * and starts the timer. 
	 */
    public void doTurn(Card c){
        if (Card1 == null && Card2 == null){
            Card1 = c;
            Card1.setIcon(c.getPic());
        }

        if (Card1 != null && Card1 != c && Card2 == null){
            Card2 = c;
            Card2.setIcon(c.getPic());
            t.start();

        }
    }

    /*
     * This method checks to see if the pair of cards the player
     * picks are a match. If the pair of cards are a match, the
     * method changes the buttons of the 2 cards and disables the
     * player from picking the 2 cards again; otherwise, the method 
     * "hides" the cards by having the buttons for the 2 cards
     * display nothing. However, if the last pair of cards has been
     * chosen and the player wins the game, the method shows a 
     * message dialog saying that the player won the game and displaying
     * the time that was spent on the game. The method then terminates
     * the program.
     */
    public void checkCards(){
        if (Card1.getSource().equals(Card2.getSource())){
            Card1.setEnabled(false); 
            Card2.setEnabled(false);
            Card1.setBackground(new Color(190, 190, 255));
            Card2.setBackground(new Color(190, 190, 255));
            Card1.setFace(true); 
            Card2.setFace(true);
            if (this.isGameWon()){
            	_s.stopThread();
            	int[] x = _s.getTime();
            	String s = "" + x[0] + ":" + x[1] + ":" + x[2] + ":" + x[3];
            	UIManager.put("OptionPane.background",new ColorUIResource(0,255,0));
                UIManager.put("Panel.background",new ColorUIResource(250,0,150));
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
                        "Times New Roman", Font.BOLD, 18)));
                JOptionPane.showMessageDialog(this, "You win!\n"
                		+ "Your time is: " + s +"\n"
                				+ "You're (probably) getting better...", "", -1, null);
                JOptionPane.showMessageDialog(this, "Thanks for playing!\n"
                		+ "(Rhythm Heaven is a property of Nintendo and Tsunku.)", "", -1, null);
                System.exit(0);
            }
        }

        else{
            Card1.setIcon(null); 
            Card2.setIcon(null);
        }
        Card1 = null; 
        Card2 = null;
    }
    
    /*
     * This method checks if the player has won the game. It checks if
     * each card on the board is face-up. If any card is face-down, then
     * the method returns false; otherwise, it will return true.
     */
    public boolean isGameWon(){
        for(Card c: this.cards){
            if (c.getFace() == false){
                return false;
            }
        }
        return true;
    }
}
