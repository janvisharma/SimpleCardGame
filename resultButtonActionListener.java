package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;
/**
 * Result Button Action Listener
 * 
 * Listener for the result button. Implements the main working of the game
 * to find out the winner.
 * It is also responsible to keeping track of the betting amount the user has after each turn.
 * If the user loses all their money, the game is ended and all buttons are disabled.
 * 
 * @author Janvi Sharma
 *
 */

public class resultButtonActionListener extends FrameWork implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		
		jOptionPanel = new JPanel(new GridLayout(2,2));
		JLabel message = new JLabel();
		jOptionPanel.add(message);
		
		int option;
		
		int dealerSplCards = 0;
		int userSplCards = 0;
		
		int i;
		for(i=0;i<3;i++) {
			if(userC[i].getCardValue()>10) {
				userSplCards++;
			}
		}
		
		for(i=0;i<3;i++) {
			if(dealerC[i].getCardValue()>10) {
				dealerSplCards++;
			}
		}
		
		if(dealerSplCards>userSplCards) {
			
			betAmtUser = betAmtUser - betAmtInInt;
			
			displayDC1.setIcon(new ImageIcon(dealerC[0].getImageName()));
			displayDC2.setIcon(new ImageIcon(dealerC[1].getImageName()));
			displayDC3.setIcon(new ImageIcon(dealerC[2].getImageName()));
			
			frame.repaint();
			
			message.setText("Sorry! The Dealer wins this round!");
			
			option = JOptionPane.showConfirmDialog(null, jOptionPanel,"Message",JOptionPane.DEFAULT_OPTION);
			
			if(betAmtUser==0) {
				remainingAmt.setText("You have no more money! Please start a new game!");
				frame.repaint();
				JOptionPane.showMessageDialog(null, "Game over!\nYou have no more money!\nPlease start a new game!");
				
				repCard1.setEnabled(false);
				repCard2.setEnabled(false);
				repCard3.setEnabled(false);
				startButton.setEnabled(false);
				resultButton.setEnabled(false);
				betAmount.setText("");
				frame.repaint();
				
				gameCtr = 1;
			}
			else
			{
				remainingAmt.setText("Please place your bet! Amount of money you have: $"+betAmtUser);
				frame.repaint();
				if(option == JOptionPane.OK_OPTION) {
					betAmount.setText("");
					frame.repaint();
					startGame();
				}
			}
		}
		if(userSplCards>dealerSplCards)
		{
			displayDC1.setIcon(new ImageIcon(dealerC[0].getImageName()));
			displayDC2.setIcon(new ImageIcon(dealerC[1].getImageName()));
			displayDC3.setIcon(new ImageIcon(dealerC[2].getImageName()));
			betAmtUser = betAmtUser + betAmtInInt;
			remainingAmt.setText("Please place your bet! Amount of money you have: $"+betAmtUser);
			
			frame.repaint();
			message.setText("Congratulations! You win this round!");
			
			option = JOptionPane.showConfirmDialog(null, jOptionPanel,"Message",JOptionPane.DEFAULT_OPTION);
			if(option == JOptionPane.OK_OPTION) {
				betAmount.setText("");
				frame.repaint();
				startGame();
			}
			
		}
		
		if(dealerSplCards==userSplCards) {
			int faceValDealer=0, faceValUser =0;
			
			for(i=0;i<3;i++) {
				if(userC[i].getCardValue()<11) {
					faceValUser = faceValUser + userC[i].getCardValue();
				}
			}
			for(i=0;i<3;i++) {
				if(dealerC[i].getCardValue()<11) {
					faceValDealer = faceValDealer + dealerC[i].getCardValue();
				}
			}
			
			
			
			if(faceValDealer%10>faceValUser%10) {
				
				betAmtUser = betAmtUser - betAmtInInt;
				displayDC1.setIcon(new ImageIcon(dealerC[0].getImageName()));
				displayDC2.setIcon(new ImageIcon(dealerC[1].getImageName()));
				displayDC3.setIcon(new ImageIcon(dealerC[2].getImageName()));
				frame.repaint();
				message.setText("Sorry! The Dealer wins this round!");
				option = JOptionPane.showConfirmDialog(null, jOptionPanel,"Message",JOptionPane.DEFAULT_OPTION);
	
				if(betAmtUser==0) {
					remainingAmt.setText("You have no more money! Please start a new game!");
					frame.repaint();
					JOptionPane.showMessageDialog(null, "Game over!\nYou have no more money!\nPlease start a new game!");
					
					repCard1.setEnabled(false);
					repCard2.setEnabled(false);
					repCard3.setEnabled(false);
					startButton.setEnabled(false);
					resultButton.setEnabled(false);
					betAmount.setText("");
					frame.repaint();
					gameCtr = 1;
				}
				else
				{
					remainingAmt.setText("Please place your bet! Amount of money you have: $"+betAmtUser);
					frame.repaint();
					if(option == JOptionPane.OK_OPTION) {
						betAmount.setText("");
						frame.repaint();
						startGame();
					}
				}
			}
			
			if(faceValUser%10>faceValDealer%10) {
				displayDC1.setIcon(new ImageIcon(dealerC[0].getImageName()));
				displayDC2.setIcon(new ImageIcon(dealerC[1].getImageName()));
				displayDC3.setIcon(new ImageIcon(dealerC[2].getImageName()));
				betAmtUser = betAmtUser + betAmtInInt;
				remainingAmt.setText("Please place your bet! Amount of money you have: $"+betAmtUser);
				frame.repaint();
				
				message.setText("Congratulations! You win this round!");
			
				option = JOptionPane.showConfirmDialog(null, jOptionPanel,"Message",JOptionPane.DEFAULT_OPTION);
				if(option == JOptionPane.OK_OPTION) {
					betAmount.setText("");
					frame.repaint();
					startGame();
				}
				
			}
			
			if(faceValUser%10==faceValDealer%10) {
				
				betAmtUser = betAmtUser - betAmtInInt;
				
				displayDC1.setIcon(new ImageIcon(dealerC[0].getImageName()));
				displayDC2.setIcon(new ImageIcon(dealerC[1].getImageName()));
				displayDC3.setIcon(new ImageIcon(dealerC[2].getImageName()));
				frame.repaint();
				
				message.setText("Sorry! The Dealer wins this round!");
				option = JOptionPane.showConfirmDialog(null, jOptionPanel,"Message",JOptionPane.DEFAULT_OPTION);
				
				
				if(betAmtUser==0) {
					remainingAmt.setText("You have no more money! Please start a new game!");
					frame.repaint();
					JOptionPane.showMessageDialog(null, "Game over!\nYou have no more money!\nPlease start a new game!");
					
					repCard1.setEnabled(false);
					repCard2.setEnabled(false);
					repCard3.setEnabled(false);
					startButton.setEnabled(false);
					resultButton.setEnabled(false);
					betAmount.setText("");
					frame.repaint();
					gameCtr = 1;
				}
				else
				{	
					remainingAmt.setText("Please place your bet! Amount of money you have: $"+betAmtUser);
					frame.repaint();
					if(option == JOptionPane.OK_OPTION) {
						betAmount.setText("");
						frame.repaint();
						startGame();
					}
				}
			}		
		}		
	}
}