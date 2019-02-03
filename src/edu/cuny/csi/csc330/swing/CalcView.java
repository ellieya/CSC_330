package edu.cuny.csi.csc330.swing;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
// 
public class CalcView extends JFrame {
	
	// Class/Static properties 
	
	private static String VERSION = "0.1";
	private static String DEFAULT_VALUE = "0";

	private static String DEFAULT_TITLE = "My Calculator (" + VERSION + ")";
	
	public static char[]  VALUE_CHARS = {'7', '8', '9', '4', '5', '6', '1', '2', '3', '0', '.' };
	
	// public static labels for OPs buttons 
	public static String BL_CLEAR = "C";
	
	public static String BL_SQUARE_ROOT = "sqrt";
	public static String BL_SQUARE = "x^2";
	public static String BL_PERCENT = "%";
	public static String BL_ADD = "+";
	public static String BL_SUBTRACT = "-";
	public static String BL_MULTIPLY = "*";
	public static String BL_DIVIDE = "/";
	public static String BL_NEGATE = "+/-";
	public static String BL_POWER = "x^y";
	public static String BL_INVERT = "1/x";
	public static String BL_COS = "cos";
	public static String BL_SIN = "sin";
	public static String BL_TAN = "tan";
	
	
	private static Integer VALUE_BUTTON_MAX = 11;
	
	private static Integer DEFAULT_X = 100; 
	private static Integer DEFAULT_Y = 100; 
	private static Integer DEFAULT_W = 750; 
	private static Integer DEFAULT_H = 750; 
	
	private static Dimension BUTTON_DIM = new Dimension(40,40);
	private static Dimension DISPLAY_DIM = new Dimension(200,40);
	private static Dimension CLEAR_DIM = new Dimension(60,40);
	
	
	/////////////////////////////////////////////////
	// GUI component instance data members 
	private JPanel mainPanel; 
	private JPanel controlPanel; 
	private JPanel displayPanel; 
	
	JTextField calcDisplay;
	
	private JButton [] valueButtons;  // 0 -9 and "."
	
	private JButton clearButton;
	private JButton sinButton;
	private JButton cosButton;
	private JButton tanButton;
	private JButton negateButton;
	private JButton squareButton;
	private JButton inverseButton;
	private JButton sqrtButton;
	private JButton powerButton;
	private JButton divideButton;
	private JButton multiplyButton;
	private JButton subtractButton;
	private JButton addButton;
	private JButton percentButton;

	// END OF GUI components
	

	public CalcView(CalcController listener) throws HeadlessException {
		actionListener = listener; 
		windowListener = listener; 
		
		guiInit();
	}
	
	public CalcView() throws HeadlessException {
		guiInit();
	}

	public CalcView(GraphicsConfiguration gc) {
		super(gc);
		guiInit();
	}

	public CalcView(String title) throws HeadlessException {
		super(title);
		guiInit();
	}

	public CalcView(String title, GraphicsConfiguration gc) {
		super(title, gc);
		guiInit();
	}
	

	

	/////////////////////////////////////////////////
	 
	private ActionListener actionListener;  
	private WindowListener windowListener;
	
	///////////////////////// 
	// GUI Component Getters
	
	

	// instance methods 
	private void init() {
	
		this.setSize(DEFAULT_W, DEFAULT_H);
		this.setLocation(DEFAULT_X, DEFAULT_X);
		this.setTitle(DEFAULT_TITLE);

	}
	

	
	public void reset(boolean winState)  {

		
	}
	
	public void undo()  {
		
	}
	
	/**
	 * perform all actions required when a board position is consumed 
	 * @param position
	 */
	public void takePosition(int position, boolean won, short code)  {
		
		
	}
	
	
	
	public String getValue() {
		return this.calcDisplay.getText();
	}
	
	
	
	
	private void guiInit() {
		init(); 
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// Panels 
		/*
		 * main panel - Flow 
		 * display panel Flow -> main
		 * control panel - GridLayout(6,4) -> main 
		 */
		mainPanel = new JPanel(); 
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		displayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT), true); 
		controlPanel = new JPanel(new GridLayout(6,4), true); 
		
		mainPanel.add(displayPanel);
		mainPanel.add(controlPanel);
		
		/////////////////////////////////////////
		// Calc visual components ... 
		calcDisplay = new JTextField(DEFAULT_VALUE);
		calcDisplay.setEditable(false);
		calcDisplay.setPreferredSize(DISPLAY_DIM);
		calcDisplay.setFont( new Font("Dialog", Font.PLAIN, 25) );
		calcDisplay.setBackground(Color.WHITE);
		calcDisplay.setHorizontalAlignment(JTextField.RIGHT);
		
		
		//////////////////////////////////////
		// Numbers and the "." 
		this.valueButtons = new JButton[VALUE_BUTTON_MAX]; // create array of number/value buttons 
		
		/**
		 * 7 8 9 
		 * 4 5 6 
		 * 1 2 4
		 * 0 .
		 */
		int i = 0; 
		for(char c : VALUE_CHARS) {
			valueButtons[i++] = this.createValueButton(c); 
		}
		
		this.clearButton = createClearButton(CalcView.BL_CLEAR);
		
		this.squareButton = createOperationButton(CalcView.BL_SQUARE);
		this.sqrtButton = createOperationButton(CalcView.BL_SQUARE_ROOT);
		this.sinButton = createOperationButton(CalcView.BL_SIN);
		
		this.cosButton = createOperationButton(CalcView.BL_COS);
		this.tanButton = createOperationButton(CalcView.BL_TAN);
		this.negateButton = createOperationButton(CalcView.BL_NEGATE);
		this.inverseButton = createOperationButton(CalcView.BL_INVERT);
		this.powerButton = createOperationButton(CalcView.BL_POWER);
		this.divideButton = createOperationButton(CalcView.BL_DIVIDE);
		this.multiplyButton = createOperationButton(CalcView.BL_MULTIPLY);
		this.subtractButton = createOperationButton(CalcView.BL_SUBTRACT);
		this.addButton = createOperationButton(CalcView.BL_ADD);
		this.percentButton = createOperationButton(CalcView.BL_PERCENT);
		
		
		displayPanel.add(this.calcDisplay);	
		displayPanel.add(this.clearButton);	
		
		// add all control buttons 
		controlPanel.add(this.sinButton);
		controlPanel.add(this.cosButton);
		controlPanel.add(this.tanButton);
		controlPanel.add(this.negateButton);
		
		controlPanel.add(this.squareButton);
		controlPanel.add(this.inverseButton);
		controlPanel.add(this.sqrtButton);
		controlPanel.add(this.powerButton);
		
		for( i = 0 ; i < 3 ; ++i) 
			controlPanel.add(this.valueButtons[i]);
		
		controlPanel.add(this.divideButton);
		
		for( i = 3 ; i < 6 ; ++i) 
			controlPanel.add(this.valueButtons[i]);
		
		controlPanel.add(this.multiplyButton);
		
		for( i = 6 ; i < 9 ; ++i) 
			controlPanel.add(this.valueButtons[i]);
		
		controlPanel.add(this.subtractButton);
		
		for( i = 9 ; i < 11 ; ++i) 
			controlPanel.add(this.valueButtons[i]);
		
		controlPanel.add(this.percentButton);
		controlPanel.add(this.addButton);
		

		///////////////////////////////////////////////////
		this.add(mainPanel);
		// this.setResizable(false);
		this.pack();
		
		// start assembling the "canvas" / the presentation 
		System.out.println("After all GUI components have been created!");
		
		addActionListeners();
		addOtherListeners();
		
		setOperationsMode(false);
	}
	
	/**
	 * Add Action Listener for each button 
	 */
	private void addActionListeners() {
		if(this.actionListener == null)
				return; 
		
		
		/**
			ADD ACTION LISTENERS FOR BUTTONS HERE  
		*/
		clearButton.addActionListener(this.actionListener);
		sinButton.addActionListener(this.actionListener);
		cosButton.addActionListener(this.actionListener);
		tanButton.addActionListener(this.actionListener);
		negateButton.addActionListener(this.actionListener);
		squareButton.addActionListener(this.actionListener);
		inverseButton.addActionListener(this.actionListener);
		sqrtButton.addActionListener(this.actionListener);
		powerButton.addActionListener(this.actionListener);
		divideButton.addActionListener(this.actionListener);
		multiplyButton.addActionListener(this.actionListener);
		subtractButton.addActionListener(this.actionListener);
		addButton.addActionListener(this.actionListener);
		percentButton.addActionListener(this.actionListener);
		
		
		for(int i = 0 ; i < valueButtons.length ; ++i) {
			valueButtons[i].addActionListener(this.actionListener);
		}
		
		
	}
	
	private void addOtherListeners() {
		addWindowListener(windowListener);
		
	}
	
	private JButton createOperationButton(String label)  {
		
		JButton button = new JButton(label);
		button.setName( label );
		button.setFont( new Font("Dialog", Font.PLAIN, 18) );
		button.setBackground(Color.LIGHT_GRAY);
		button.setPreferredSize(BUTTON_DIM);
		
		return button; 
	}
	
	private JButton createClearButton(String label)  {
		
		JButton button = new JButton(label);
		Border border = new LineBorder(Color.RED, 4);
		button.setName( label );
		button.setFont( new Font("Dialog", Font.PLAIN, 20) );
		button.setBackground(Color.LIGHT_GRAY);
		button.setPreferredSize(CLEAR_DIM);
		button.setBorder(border);
		
		return button; 
	}
	
	private JButton createValueButton(char label)  {
		
		JButton button = new JButton(Character.toString(label));
		
		// if(Character.isDigit(label))
			//button.setName( Integer.toString(label) );
		
		button.setName(Character.toString(label));
		
		button.setFont( new Font("Dialog", Font.PLAIN, 20) );
		button.setBackground(Color.WHITE);
		button.setPreferredSize(BUTTON_DIM);
		
		
		return button; 
	}
	

	public void clear() {
		calcDisplay.setText(DEFAULT_VALUE);
	}
	
	public void appendInputValue(String value) {
		appendInputValue(value, false); 
	}

	public void appendInputValue(String value, boolean opFlag) {
		//  need to account for state where operation has just been performed ... !!!!! 
		if( opFlag == true || calcDisplay.getText().equals(DEFAULT_VALUE) )  {
			calcDisplay.setText(value);
		}
		else {
			calcDisplay.setText( calcDisplay.getText() + value );
		}
	}
	
	public void setValue(String value) {
		calcDisplay.setText(  value );
	}
	
	public void setOperationsMode(boolean flag) {

		powerButton.setEnabled(flag);
		divideButton.setEnabled(flag);
		multiplyButton.setEnabled(flag);
		subtractButton.setEnabled(flag);
		addButton.setEnabled(flag);
		percentButton.setEnabled(flag);
		
	}
	
	

	
	public static void present() {
		
	      EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	
	            	CalcController listener = new CalcController(); 
	            	CalcView game = new CalcView(listener);
	            	listener.setView(game);
	            	
	                game.setVisible(true);
	                
	            }
	        }
	      );
	      
	      
	}
	
	
	///////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// create viewable instance 
		present();
  
	}

}
