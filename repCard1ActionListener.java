package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Replace Card One Action Listener.
 * 
 * Listener for replacing card one's button. This button replaces the first card and
 * shuffles the remaining cards in the deck. It is disabled after one use. 
 * 
 * @author Janvi Sharma
 *
 */

public class repCard1ActionListener extends FrameWork implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		if(replaceCtr<2) {
			Cards temp = new Cards();
			temp = userC[0];
			userC[0] = totalCards[6];
			totalCards[6] = temp;
			
			repCard1.setEnabled(false);
			
			ShuffleDeck(totalCards);
			displayUC1.setIcon(new ImageIcon(userC[0].getImageName()));
			frame.repaint();
			repCard1.setEnabled(false);
			replaceCtr++;
		}
	}
}