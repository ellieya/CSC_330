package edu.cuny.csi.csc330.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventsDemo {

   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public EventsDemo(){
      initGui();
   }

      
   private void initGui(){
      mainFrame = new JFrame("Events Demo");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        

      statusLabel.setSize(350,100);
      mainFrame.addWindowListener(new WindowCloseListener());

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
      
      
   }

   private void showEventDemo(){
      headerLabel.setText("Control in action: Button"); 

      JButton okButton = new JButton("OK");
      JButton submitButton = new JButton("Submit");
      JButton cancelButton = new JButton("Cancel");
      
      okButton.setName("OK");
      submitButton.setName("Submit");
      cancelButton.setName("Cancel");
      

      okButton.setActionCommand("OK");
      submitButton.setActionCommand("Submit");
      cancelButton.setActionCommand("Cancel");

      okButton.addActionListener(new ButtonClickListener()); 
      submitButton.addActionListener(new ButtonClickListener()); 
      cancelButton.addActionListener(new ButtonClickListener()); 
      
      okButton.addMouseMotionListener(new MouseListener()); 
      submitButton.addMouseMotionListener(new MouseListener()); 
      cancelButton.addMouseMotionListener(new MouseListener()); 

      controlPanel.add(okButton);
      controlPanel.add(submitButton);
      controlPanel.add(cancelButton);       

      mainFrame.setLocation(200, 200);
      mainFrame.setVisible(true);  
       
   }

   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         if( command.equals( "OK" ))  {
            statusLabel.setText("Ok Button clicked.");
         }
         else if( command.equals( "Submit" ) )  {
            statusLabel.setText("Submit Button clicked."); 
         }
         else  {
            statusLabel.setText("Cancel Button clicked.");
         }  	
      }		
   }
   
   private class MouseListener implements MouseMotionListener  {

	   private boolean caughtMotion = false;  
	   
	    public void mouseMoved(MouseEvent e) {
	    	
	    	if(caughtMotion == false) {
	    			System.out.println(e.getComponent().getName() + " TURNED WHITE");
	    			e.getComponent().setBackground(Color.WHITE);
	    	}
	    	caughtMotion = true; 
	    }

	    public void mouseDragged(MouseEvent e) {
	    	 // do nothing ...  
	    }
	   
	   
   }
   
   private class WindowCloseListener implements WindowListener{
	   public void windowClosing(WindowEvent e) {
		   
           int confirm = JOptionPane.showOptionDialog(e.getWindow(),
                   "Are You Sure to Close this Application?",
                   "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE, null, null, null);
           
           if (confirm == JOptionPane.YES_OPTION) {
        	   System.out.println(this.getClass().getName() + " is exiting!");
               System.exit(1);
           }
           
       }

       public void windowOpened(WindowEvent e) {}

       public void windowClosed(WindowEvent e) {}

       public void windowIconified(WindowEvent e) {}

       public void windowDeiconified(WindowEvent e) {}
 
       public void windowActivated(WindowEvent e) {}

       public void windowDeactivated(WindowEvent e) {}
   }
   
   public static void main(String[] args){
	   
	      EventsDemo eventDemo = new EventsDemo();  
	      eventDemo.showEventDemo();       
	      
    }
   
}
