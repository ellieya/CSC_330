package edu.cuny.csi.csc330.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyActionListener implements ActionListener {
		
		public MyActionListener(JLabel label) {
			super(); 
			this.label = label;
		}
		
		private boolean visible = false; 
		private JLabel label; 
		
		public void actionPerformed(ActionEvent ae) {
			
				if (visible) visible = false; 
				else visible = true;
				label.setVisible(visible);
		}
	
}
	
