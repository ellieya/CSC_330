package edu.cuny.csi.csc330.examples;

import java.awt.event.*;
import javax.swing.*;

public class SimpleSwinger {   
    public static void main(String[] args) {

        final JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton button = new JButton();

        final JLabel label = new JLabel("Hello, Java Swing World!");

        label.setVisible(false);   
        
        frame.add(panel);
        panel.add(button);
        panel.add(label);
        frame.setVisible(true);
        frame.setSize(150, 150);
        frame.setTitle("My First Java Swing Example"); 
        frame.setLocation(500, 250);
        
        button.setText("Press ME!");
        

        button.addActionListener(
        		
        			new ActionListener() {
        				    private boolean visible = false; 
        					public void actionPerformed(ActionEvent ae) {
        						if (visible) visible = false; 
        						else visible = true;
        						
        						label.setVisible(visible);
        					
        					}
        			    }
        			
        			
        			
        			);
    }

}