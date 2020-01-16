package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Start Button Listener.
 * 
 * Listener for the start button. This makes sure that the bet input by the user is a
 * valid positive number and displays a warning message if it is not. If the bet input by the user is valid
 * this listener starts the game.
 * 
 * @author Janvi Sharma
 *
 */
public class startButtonListener extends FrameWork implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		
		try {
			betAmtInInt = Integer.parseInt(betAmount.getText());
			if(betAmtInInt<0) {
				betAmount.setText("");
				JOptionPane.showMessageDialog(null, "Warning: The bet you place must be a positive integer!", "Warning",JOptionPane.WARNING_MESSAGE);
			}
			if(betAmtInInt>0) {
			int val;
			val = betAmtUser - betAmtInInt;
			if(val<0) {
				betAmount.setText("");
				JOptionPane.showMessageDialog(null, "Warning: You only have $"+betAmtUser+"!", "Warning",JOptionPane.WARNING_MESSAGE);
			}
			if(val>=0) {
				displayUC1.setIcon(new ImageIcon(userC[0].getImageName()));
				displayUC2.setIcon(new ImageIcon(userC[1].getImageName()));
				displayUC3.setIcon(new ImageIcon(userC[2].getImageName()));
				repCard1.setEnabled(true);
				repCard2.setEnabled(true);
				repCard3.setEnabled(true);
				startButton.setEnabled(false);
				resultButton.setEnabled(true);
				frame.repaint();
			}
			}
		}
		catch (NumberFormatException nfe) {
			betAmount.setText("");
			JOptionPane.showMessageDialog(null, "The bet you place must be a positive integer!", "Warning",JOptionPane.WARNING_MESSAGE);
		}
	}
}
