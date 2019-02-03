package edu.cuny.csi.csc330.swing.components;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SimpleFrame extends JFrame {

    public SimpleFrame() {

        initUI();
    }

    private void initUI() {
        
        setTitle("Simple example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
            	SimpleFrame ex = new SimpleFrame();
                ex.setVisible(true);
            }
        });
    }
}

