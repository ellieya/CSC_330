package edu.cuny.csi.csc330.scratch;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionEvent;


import edu.cuny.csi.csc330.swing.TTTController;
import edu.cuny.csi.csc330.swing.TTTGameView;







public class SlotView extends JFrame{

	private static Integer DEFAULT_X = 200;
	private static Integer DEFAULT_Y = 200;
	private static Integer DEFAULT_W = 1000; 
	private static Integer DEFAULT_H = 500;
	
	
	private static String DEFAULT_TITLE = "Spinny Thing Game";
	
	
	private String[] Wheel= new String[3];
	
	private JButton spinButton;
	
	private ImageIcon imageArr;
	//private ImageIcon imageArr2;
	//private ImageIcon imageArr3;
	private ImageIcon image;
	private JLabel imageIcone;
	
	
	private JPanel mainPanel;
	private JLabel SlotPos_1;
	private JLabel SlotPos_2;
	private JLabel SlotPos_3;
	private JPanel Slot_1;
	private JPanel Slot_2;
	private JPanel Slot_3;
	private JPanel slotPanel; 
	private JPanel CreditPanel;
	private JPanel betPanel; 
	private JPanel mainOutPut;

	private JLabel  currentBet;
	private JLabel  currentPoints;
	private JLabel  pointsLabel;
	private JLabel  betLabel;
	
	
	private ActionListener actionListener;  
	private WindowListener windowListener;
	
	
	
	private int credit, bet=1;
	
	
	
	
	public SlotView() {
		guiInit();
	}
	
	public SlotView(SlotController listener) {
		actionListener = listener;
		windowListener = listener;
		guiInit();
	}

		public SlotView(GraphicsConfiguration gc) {
		super(gc);
		guiInit();
	}
	
	public void setCredit(int cred)
	{
		credit = cred;
	}
	
	public void spunWheelDec()
	{
		credit-=bet;
	//	this.pointsLabel.setText(Integer.toString(credit)) ;
	}
	
	public int getCreadit()
	{
		return credit;
	}
	public JLabel getCurentPoints() {
		return this.currentPoints;
	}
	
	public JLabel getCurrentBet() {
		return currentBet;
	}
	
	public JButton getSpinButton(){
		return spinButton;
	}
	
	private void init()
	{
		credit=50;
		this.setSize(DEFAULT_W, DEFAULT_H);
		this.getContentPane().setBackground(new Color(100, 149, 237));
		
		this.setLocation(DEFAULT_X, DEFAULT_X);
		//this.setBounds(100, 100, 1000, 500);
		this.setTitle(DEFAULT_TITLE);
		
		this.getContentPane().setLayout(null);
		
		
		
	}
	


	private JLabel createStatusLabel(String title)  {
		JLabel label = new JLabel();
		label.setText(title);
		label.setName( title );
		label.setFont( new Font("Dialog", Font.BOLD, 18) );
		label.setPreferredSize(new Dimension(100, 35));
		label.setBackground(Color.YELLOW);
		
		return label; 
	}
	public void importWheel(String[] W)
	{
		Wheel=W;
	}
	
	public void setWheels()
	{
		Slot_1.add(SlotPos_1);
		Slot_2.add(SlotPos_2);
		Slot_3.add(SlotPos_3);
	}

	public String[] wheelSet()
	{
		return Wheel;
	}
	
	
	private void guiInit() {
		
		init();
		//image();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
		currentBet = createStatusLabel("Bet: ");
		currentPoints = createStatusLabel("Credit: ");
		
		
		
		
		
		
for(int i = 0; i<3;i++) {
			
			if (Wheel[i]=="melon")
				imageArr = new ImageIcon("C:\\Users\\bn\\Pictures\\images\\Watermelon.png");
			if (Wheel[i]=="bell")
				imageArr= new ImageIcon("C:\\Users\\bn\\Pictures\\images\\Bell.png");
			if (Wheel[i]=="7")
				imageArr= new ImageIcon("C:\\Users\\bn\\Pictures\\images\\Seven.png");
			if (Wheel[i]=="lemon")
				imageArr= new ImageIcon("C:\\Users\\bn\\Pictures\\images\\Cherry.png");
			if (Wheel[i]=="bar")
				imageArr= new ImageIcon("C:\\Users\\bn\\Pictures\\images\\Bar.png");
		
		
		SlotPos_1= new JLabel(imageArr);	
		SlotPos_1.setBounds(0, 0, 181, 163);

		SlotPos_2= new JLabel(imageArr);
		SlotPos_2.setBounds(0, 0, 181, 163);
	

		SlotPos_3=new JLabel(imageArr);
		SlotPos_3.setBounds(0, 0, 181, 163);
}
			
		
		//set up a main panel for slot wheels
		slotPanel = new JPanel();
		slotPanel.setBackground(new Color(0, 0, 205));
		slotPanel.setBounds(40, 40, 914, 185);
		slotPanel.setLayout(null);
		
		//set up slot 1
		Slot_1 = new JPanel();
		Slot_1.add(SlotPos_1);
		Slot_1.setBackground(Color.BLACK);
		Slot_1.setBounds(10, 11, 181, 163);
		slotPanel.add(Slot_1);
		Slot_1.setLayout(null);
		Slot_1.setVisible(true);
		
		//set slot 2
		Slot_2 = new JPanel();
		Slot_2.add(SlotPos_2);
		Slot_2.setBackground(Color.BLACK);
		Slot_2.setBounds(360, 11, 181, 163);
		slotPanel.add(Slot_2);
		Slot_2.setLayout(null);
		Slot_2.setVisible(true);
		
		//set slot 3
		Slot_3 = new JPanel();
		Slot_3.add(SlotPos_3);
		Slot_3.setBackground(Color.BLACK);
		Slot_3.setBounds(723, 11, 181, 163);
		slotPanel.add(Slot_3);
		Slot_3.setLayout(null);
		Slot_3.setVisible(true);
		
		// set up for data output and buttons
		mainOutPut = new JPanel();
		mainOutPut.setBackground(new Color(112, 128, 144));
		mainOutPut.setBounds(40, 283, 914, 160);
		mainOutPut.setLayout(null);
		
		
		// outputs credit value
		CreditPanel = new JPanel(new GridLayout(1,2), true);
		CreditPanel.setBackground(new Color(112, 128, 144));
		CreditPanel.setBounds(10, 65, 222, 57);
		CreditPanel.add(currentPoints);
		pointsLabel=createStatusLabel(String.format("%d", credit) );
		CreditPanel.add(pointsLabel);
		mainOutPut.add(CreditPanel);

		//output for bets
		betPanel = new JPanel();
		betPanel.setBackground(new Color(112, 128, 144));
		betPanel.setBounds(682, 65, 222, 65);
		betPanel.add(currentBet);
		betLabel = createStatusLabel(Integer.toString(bet));
		betPanel.add(betLabel);
		mainOutPut.add(betPanel);
		
		//creates button for spinning the wheel
		spinButton = new JButton("SPIN WHEEL");
		spinButton.setForeground(Color.BLACK);
		spinButton.setBackground(new Color(34, 139, 34));
		spinButton.setBounds(381, 57, 139, 65);
		mainOutPut.add(spinButton);
		
				

		
		
		
				
		this.getContentPane().add(slotPanel);		
		this.getContentPane().add(mainOutPut);		
				
		//this.setVisible(true);
		addActionListeners();
		addOtherListeners();
	}
	
	private void addActionListeners() {
		if(this.actionListener == null)
				return; 
		
		this.spinButton.addActionListener(this.actionListener);	
	}
	
	
	
	
	
	private void addOtherListeners() {
		addWindowListener(windowListener);
		
	}
	
	public static void present() {
		
		 // The recommended way of startin a Swing / GUI Thread 
	      EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	
	            	SlotController listener = new SlotController(); 
	            	SlotView game = new SlotView(listener);
	            	listener.setGameView(game);
	            	
	                game.setVisible(true);
	                
	            }
	        }
	      );
	}
	
	public static void main(String[] args) {
		
		
		present();
	/*	JFrame frame = new JFrame();
		frame.setSize(new Dimension(1000,400));
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.setResizable(false);
		JPanel jpn = new JPanel();
		//frame.getContentPane().setLayout(null);
		frame.getContentPane().add(jpn);
		
		JButton spin= new JButton("spin");
		spin.setBounds(10,10,100,100);
		jpn.setBackground(new Color(100, 149, 237));
		jpn.add(spin);
		
		frame.setTitle("Test");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}
}
