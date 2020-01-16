package main;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
/**
 * Frame work of the game.
 * This class stores the graphical user interface components of the game that make it user friendly.
 * It also displays the initial setting of the game when the user first runs the program.
 * 
 * @author Janvi Sharma
 *
 */
public class FrameWork {
	static JFrame frame;
	static JPanel remainingAmtPanel, dealerCardsPanel, userCardsPanel,jOptionPanel;
	static JTextField betAmount;
	static int betAmtInInt, shuffleCtr=0, replaceCtr=0, gameCtr=2;
	static int betAmtUser = 100;
	static JLabel displayUC1,displayUC2,displayUC3,remainingAmt,displayDC1,displayDC2,displayDC3;
	static Cards[] userC, totalCards,dealerC; 
	static JButton repCard1, repCard2, repCard3,startButton,resultButton;
	
	public static void main(String args[]) {
	
	frame = new JFrame();
	JMenuBar menuBar = new JMenuBar();
	JMenu menu1 = new JMenu("Control");
	JMenuItem menuItem = new JMenuItem("Exit");
	JMenu menu2 = new JMenu("Help");
	JMenuItem instruction = new JMenuItem("Instruction");
	
	menu1.add(menuItem);
	menu2.add(instruction);
	menuBar.add(menu1);
	menuBar.add(menu2);
	
	menuItem.addActionListener(new ControlActionListener());
	instruction.addActionListener(new HelpActionListener());
	
	frame.setJMenuBar(menuBar);
	
	JPanel mainPanel = new JPanel();
	
	JPanel cardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 500, 500));
	cardsPanel.setBackground(Color.green);
	mainPanel.add(cardsPanel);
	
	dealerCardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,20)); // first panel for cardsPanel
	dealerCardsPanel.setBackground(Color.green);
	userCardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,20));
	userCardsPanel.setBackground(Color.green); // second panel for cardsPanel
	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,50));
	buttonPanel.setBackground(Color.green); // third panel for cardsPanel
	
	cardsPanel.add(dealerCardsPanel);
	cardsPanel.add(userCardsPanel);
	cardsPanel.add(buttonPanel);
	
	repCard1 = new JButton("Replace Card 1");
	repCard2 = new JButton("Replace Card 2");
	repCard3 = new JButton("Replace Card 3");
	
	repCard1.setBackground(Color.green);
	repCard2.setBackground(Color.green);
	repCard3.setBackground(Color.green);
	
	repCard1.addActionListener(new repCard1ActionListener());
	repCard2.addActionListener(new repCard2ActionListener());
	repCard3.addActionListener(new repCard3ActionListener());
	
	buttonPanel.add(repCard1);
	buttonPanel.add(repCard2);
	buttonPanel.add(repCard3);
	
	JPanel bottomPanel = new JPanel();
	
	JPanel betPanel = new JPanel();
	JLabel betLabel = new JLabel("Bet $:");
	betPanel.add(betLabel,BorderLayout.NORTH);
	
	betAmount = new JTextField(10);
	betPanel.add(betAmount);
	
	startButton = new JButton("Start");
	resultButton = new JButton("Result");

	betPanel.add(startButton);
	betPanel.add(resultButton);
	
	bottomPanel.add(betPanel);
	
	remainingAmtPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,80));
	
	remainingAmt = new JLabel("");
	remainingAmtPanel.add(remainingAmt);
	bottomPanel.add(remainingAmtPanel);
	mainPanel.add(bottomPanel);

	repCard1.setEnabled(false);
	repCard2.setEnabled(false);
	repCard3.setEnabled(false);
	resultButton.setEnabled(false);
	remainingAmt.setText("Please place your bet! Amount of money you have: $"+betAmtUser);
	
	totalCards = new Cards[52];
	int i,j;
	int start = 0;
	int ctr;
	for(i=1;i<5;i++) {
		ctr = 1;
		for(j=start;j<start+13;j++) {
			totalCards[j] = new Cards();
			totalCards[j].assignCardValue(ctr);
			String cardName = "";
			cardName = cardName + i;
			cardName = cardName + ctr;
			totalCards[j].assignImageName(cardName);
			ctr++;
		}
		start = start + 13;
	}
	
	ShuffleDeck(totalCards);
	shuffleCtr = 1;
	
	dealerC = new Cards[3];
	userC = new Cards[3];
	
	for(i=0;i<3;i++) {
		dealerC[i] = totalCards[i];
	}
	int k = 0;
	
	for(i=3;i<6;i++) {
		userC[k] = totalCards[i];
		k++;
	}
	
	ImageIcon displayDCard1 = new ImageIcon("card_back-0000.jpg"); // Display 3 back images of dealer's cards
	displayDC1 = new JLabel(displayDCard1);
	dealerCardsPanel.add(displayDC1);
	
	ImageIcon displayDCard2 = new ImageIcon("card_back-0000.jpg");
	displayDC2 = new JLabel(displayDCard2);
	dealerCardsPanel.add(displayDC2);
	
	ImageIcon displayDCard3 = new ImageIcon("card_back-0000.jpg");
	displayDC3 = new JLabel(displayDCard3);
	dealerCardsPanel.add(displayDC3);
	
	ImageIcon displayUCard1 = new ImageIcon("card_back-0000.jpg");
	displayUC1 = new JLabel(displayUCard1);
	userCardsPanel.add(displayUC1);
	
	ImageIcon displayUCard2 = new ImageIcon("card_back-0000.jpg");
	displayUC2 = new JLabel(displayUCard2);
	userCardsPanel.add(displayUC2);
	
	ImageIcon displayUCard3 = new ImageIcon("card_back-0000.jpg");
	displayUC3 = new JLabel(displayUCard3);
	userCardsPanel.add(displayUC3);
	
	startButton.addActionListener(new startButtonListener());
	resultButton.addActionListener(new resultButtonActionListener());

	
	cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.Y_AXIS));
	bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	frame.setTitle("A Simple Card Game");
	frame.add(mainPanel,BorderLayout.NORTH);
	frame.setSize(500,700);
	frame.setVisible(true);
	
	
	}
	/**
	 * Method to start the game's next round.
	 * This method stores the initial set up of the game
	 * that will allow the user to keep playing until the bet amount becomes zero.
	 * 
	 */
	
	public static void startGame() {
		replaceCtr = 0;
		shuffleCtr++;
		
		startButton.setEnabled(true);
		repCard1.setEnabled(false);
		repCard2.setEnabled(false);
		repCard3.setEnabled(false);
		resultButton.setEnabled(false);
		
		int i;
		shuffleCtr =0 ;
		Cards temp = new Cards();
		ShuffleDeck(totalCards);
		shuffleCtr=1;
		
		for(i=0;i<3;i++) {
			dealerC[i] = totalCards[i];
		}
		int k = 0;
		
		for(i=3;i<6;i++) {
			userC[k] = totalCards[i];
			k++;
		}
		
		ImageIcon displayDCard1 = new ImageIcon("card_back-0000.jpg"); // Display 3 back images of dealer's cards
		displayDC1.setIcon(displayDCard1);
		
		ImageIcon displayDCard2 = new ImageIcon("card_back-0000.jpg");
		displayDC2.setIcon(displayDCard2);
		
		ImageIcon displayDCard3 = new ImageIcon("card_back-0000.jpg");
		displayDC3.setIcon(displayDCard3);
		
		ImageIcon displayUCard1 = new ImageIcon("card_back-0000.jpg");
		displayUC1.setIcon(displayUCard1);
		
		ImageIcon displayUCard2 = new ImageIcon("card_back-0000.jpg");
		displayUC2.setIcon(displayUCard2);
		
		ImageIcon displayUCard3 = new ImageIcon("card_back-0000.jpg");
		displayUC3.setIcon(displayUCard3);
		
		frame.repaint();
		frame.setSize(500,700);
		frame.setVisible(true);

	}
	/**
	 * Method to Shuffle Deck of Cards.
	 * This method takes in a parameter of type Cards array and then shuffles the cards in it.
	 * The shuffle counter makes sure that the cards that have been given to the user and the dealer are not
	 * shuffled with the remaining cards in the deck.
	 * 
	 * @param totalCards Array that stores all 52 cards.
	 */
		
	public static void ShuffleDeck(Cards totalCards[]) {
		int i;
		Cards temp;
		Random rand = new Random(); 
		if(shuffleCtr==0) {
		for(i=0;i<52;i++) {
			 int r = i + rand.nextInt(52 - i); 
			 temp = totalCards[i];
			 totalCards[i] = totalCards[r];
			 totalCards[r] = temp;
		}
		}
		else
			for(i=6;i<52;i++) {
				 int r = i + rand.nextInt(52 - i); 
				 temp = totalCards[i];
				 totalCards[i] = totalCards[r];
				 totalCards[r] = temp;
			}
			
	}
}
