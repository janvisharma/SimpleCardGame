package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
/**
 * Help Action Listener.
 * 
 * Listener for the "instruction" menu item to display the rules of the game.
 * 
 * @author Janvi Sharma
 *
 */
public class HelpActionListener extends FrameWork implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		String message = "Rules to determine who has better cards.\nJ,Q,K are regarded as special cards.\nRule 1: The one with more special cards wins.\nRule 2: If both have the same number of special cards, add the face values of the other card(s) and take the remainder after dividing the sum by 10. The one with a bigger remainder wins. (Note: Ace = 1).\nRule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.";
		JOptionPane.showMessageDialog(null, message);
	}
	public void menuDeselected(MenuEvent event) {}
	public void menuCanceled(MenuEvent event) {}
}