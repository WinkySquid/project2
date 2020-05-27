package controller;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import view.ButtonMap;


public class Overseer {
	
	//INSTANCE VARIABLES
	private static String[] O = {"PLAY", "QUIT", "HELP"};
    
    //CONSTRUCTOR
    public Overseer(){	
	        start();
	        setupGame();
    }
    
    /*
	 * This method displays the starting option dialog box. It sets the decoration 
	 * of the dialog box, and starts the game, displays the help message dialog, 
	 * or terminates the program depending on what option the user chooses.
	 */
    public void start(){
        
        boolean b = false;
        while(!b) {
        	try {
	        	UIManager.put("OptionPane.background",new ColorUIResource(0,0,255));
	            UIManager.put("Panel.background",new ColorUIResource(255,150,0));
	            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
	                    "Calibri", Font.BOLD, 32))); 
	            ImageIcon i = new ImageIcon(getClass().getResource("rh.png"));
	        	int x = JOptionPane.showOptionDialog(
	                    null,
	                    "Memory Game (but there are Rhythm Heaven images)\n"
	                    + "Press \"PLAY\" to play!",
	                    "Click a button", // dialog box title
	                    JOptionPane.DEFAULT_OPTION, 
	                    JOptionPane.INFORMATION_MESSAGE,
	                    i,
	                    O,
	                    O[0]);
	            if(x == 1) {
	            	JOptionPane.showMessageDialog(null,"Well, thanks for stopping by, anyway!");
	            	System.exit(0);
	            }
	            else if(x == 2) {
	            	UIManager.put("OptionPane.background",new ColorUIResource(0,255,0));
	                UIManager.put("Panel.background",new ColorUIResource(250,250,250));
	                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
	                        "Arial", Font.ITALIC, 14)));
	            	JOptionPane.showMessageDialog(null,"This is a simple game that tests your short-term memory!\n"
	            			+ "Click on a button to reveal what's inside the button,\n"
	            			+ "and if it matches, the icons will change color!\n"
	            			+ "If not, the images will be hidden and you will try again!\n"
	            			+ "Try to do this as fast as possible (since the timer starts\n"
	            			+ "as soon as when you click on \"PLAY\") \n "
	            			+ "And remember, you can press the X button at any time\n"
	            			+ "during the game to exit the game!\n"
	            			+ "Good luck!"
	            			);
	            }
	            else if(x == 0){
	            	b = true;
	            }
        	}
        	catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
        		JOptionPane.showMessageDialog(null,"Well, thanks for stopping by, anyway!");
        		System.exit(0);
        	}
        }
    }
    
    /*
     * This method sets up the board (a ButtonMap) that will be used for the game
     * and will display the hidden cards (as buttons). It makes the board not
     * resizable, sets up the dimensions and location of the board, and sets the
     * board to exit on close by default.
     */
    public void setupGame() {
    	ButtonMap b = new ButtonMap();
        b.setPreferredSize(new Dimension(500,600)); 
        b.setResizable(false);
        b.setLocation(725, 250);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
    }
    
    
}
