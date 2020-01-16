package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Control Action Listener.
 * 
 * Listener for the "exit" menu item to enable the user to close the program.
 * 
 * @author Janvi Sharma
 *
 */
public class ControlActionListener extends FrameWork implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		System.exit(0);
	}
}