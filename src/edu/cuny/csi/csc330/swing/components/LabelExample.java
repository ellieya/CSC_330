package edu.cuny.csi.csc330.swing.components; 



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabelExample extends JFrame {
	
   private JLabel label1, label2;

   public LabelExample()
   {
      super( "Testing JLabel Examples" );

      Container c = getContentPane();
      c.setLayout( new FlowLayout() );

      // JLabel constructor with a string argument
      label1 = new JLabel( "Label with text" );
      label1.setToolTipText( "This is label1" );
      c.add( label1 );

      // JLabel constructor with string, Icon and
      // alignment arguments
      Icon bug = new ImageIcon( "C:\\tmp\\poke.gif" );
      label2 = new JLabel( "Label with text and icon",
                           bug, SwingConstants.LEFT );
      label2.setToolTipText( "This is label2" );
      
      //label2.setSize(400,400);
      c.add( label2 );


      setSize( 300, 175 );
      this.setLocation(250, 250);
      show();
   }

   public static void main( String args[] )
   { 
      LabelExample app = new LabelExample();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.out.println("Closing App");
               System.exit( 0 );
            }
         }
      );
   }
}

