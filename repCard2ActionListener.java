package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Replace Card Two Action Listener.
 * 
 * Listener for replacing card two's button. This button replaces the second card and
 * shuffles the remaining cards in the deck. It is disabled after one use. 
 * 
 * @author Janvi Sharma
 *
 */
public class repCard2ActionListener extends FrameWork implements ActionListener{
	public void actionPerformed(ActionEvent event) {
	if(replaceCtr<2) {
		Cards temp = new Cards();
		temp = userC[1];
		userC[1] = totalCards[6];
		totalCards[6] = temp;
		
		repCard2.setEnabled(false);
		
		ShuffleDeck(totalCards);
		displayUC2.setIcon(new ImageIcon(userC[1].getImageName()));
		frame.repaint();
		repCard2.setEnabled(false);
		replaceCtr++;
	}
	}
}