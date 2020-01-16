package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Replace Card Three Action Listener
 * 
 * Listener for replacing card three's button. This button replaces the third card and
 * shuffles the remaining cards in the deck. It is disabled after one use. 
 * 
 * @author Janvi Sharma
 *
 */

public class repCard3ActionListener extends FrameWork implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		if(replaceCtr<2) {
		Cards temp = new Cards();
		temp = userC[2];
		userC[2] = totalCards[6];
		totalCards[6] = temp;
		
		repCard3.setEnabled(false);
		
		ShuffleDeck(totalCards);
		displayUC3.setIcon(new ImageIcon(userC[2].getImageName()));
		frame.repaint();
		repCard3.setEnabled(false);
		replaceCtr++;
		}
	}
}