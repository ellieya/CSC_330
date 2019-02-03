package edu.cuny.csi.csc330.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;


public class CalcController implements 
		ActionListener, WindowListener {
	
	// Calculator Model instance 
	private Calculator calc; 
	private CalcView view;
	
	private boolean operationCompletedState; 

	public CalcController() {
		init();
	}
	
	public void setView(CalcView calcView) {
		this.view = calcView;
	}
	
	
	// private instance methods 
	private void init() {
		calc = new Calculator();
		operationCompletedState = true; 
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		Object source = ae.getSource();
		System.out.println("Calc actionPerformed: "  + source.getClass().getSimpleName());
		
		
		if(source.getClass().equals(JButton.class) ) {
			JButton button = (JButton) source;
			
			calcActionPerformed(button);
		
		}
		
		
	}
	
	private boolean isInputValue(String value) {
		if(value.length() == 1 ) {
			for(int i = 0 ; i < CalcView.VALUE_CHARS.length ; ++i) {
				if(value.charAt(0) == CalcView.VALUE_CHARS[i] ) 
					return true;
			}
		}
		
		return false;
	}
	
	private void calcActionPerformed(JButton button) {
		// determine what board position has been selected.  
		System.out.println("Calc actionPerformed: "  + button.getName());
		String name = button.getName();

		
		// Clear [C] Key 
		if(name.equals(CalcView.BL_CLEAR)) {
			this.view.clear(); 
			calc.clear();
			view.setOperationsMode(false);
		} 
		
		else if(name.equals(CalcView.BL_ADD)) {
			Double value = Double.valueOf(this.view.getValue() ); 
			calc.add(value);
			operationCompletedState = true; 
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
			// call method that disables the op buttons ... 
			view.setOperationsMode(false); 
			
		} 
		else if(name.equals(CalcView.BL_SUBTRACT)) {
			Double value = Double.valueOf(this.view.getValue() ); 
			calc.subtract(value);
			operationCompletedState = true; 
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
			// call method that disables the op buttons ... 
			view.setOperationsMode(false); 
		} 
		else if(name.equals(CalcView.BL_MULTIPLY)) {
			Double value = Double.valueOf(this.view.getValue() ); 
			calc.multiply(value);
			operationCompletedState = true; 
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
			// call method that disables the op buttons ... 
			view.setOperationsMode(false); 
		} 
		
		else if(name.equals(CalcView.BL_DIVIDE)) {
			Double value = Double.valueOf(this.view.getValue() ); 
			calc.divide(value);
			operationCompletedState = true; 
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
			// call method that disables the op buttons ... 
			view.setOperationsMode(false); 
		} 
		
		else if(name.equals(CalcView.BL_PERCENT)) {
			Double value = Double.valueOf(this.view.getValue() ); 
			calc.percentage(value);
			operationCompletedState = true; 
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
			// call method that disables the op buttons ... 
			view.setOperationsMode(false); 
		} 
		
		else if(name.equals(CalcView.BL_POWER)) {
			Double value = Double.valueOf(this.view.getValue() ); 
			calc.pow(value);
			operationCompletedState = true; 
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
			// call method that disables the op buttons ... 
			view.setOperationsMode(false); 
		} 
		
		else if(name.equals(CalcView.BL_NEGATE)) {
			calc.negate();
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
		} 
		
		else if(name.equals(CalcView.BL_SIN)) {
			calc.sin();
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
		} 
		
		else if(name.equals(CalcView.BL_COS)) {
			calc.cos();
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
		} 
		
		else if(name.equals(CalcView.BL_TAN)) {
			calc.tan();
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
		} 
		
		else if(name.equals(CalcView.BL_INVERT)) {
			calc.invert();
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
			
		} 
		
		else if(name.equals(CalcView.BL_SQUARE_ROOT)) {
			calc.squareRoot();
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
		} 
		
		else if(name.equals(CalcView.BL_SQUARE)) {
			calc.square();
			view.setValue( String.valueOf(calc.getCurrentValue() ) );
		} 
		
		
		
		// Value Buttons 0-9, . 
		else if(isInputValue(name) ) {
			// view needs to account for state where operation has just been performed ... 
			this.view.appendInputValue(name, operationCompletedState); 
			if(operationCompletedState == true) {
					view.setOperationsMode(true); 
					operationCompletedState = false; 
			}
			
			
		}
		
		// display the state of "the model" in the console ...
		System.out.println(calc);
		
	}
	


	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened() Event");

	}

	@Override
	public void windowClosing(WindowEvent e) {
		String ObjButtons[] = {"YES","NO"};
		
	    int rc = JOptionPane.showOptionDialog(null, 
	        "Are you sure you want to exit?", "Online Examination System", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
	        ObjButtons,ObjButtons[1]);

	    if(rc == 0)   
	    	System.exit(0);  
	    
	}

	@Override
	public void windowClosed(WindowEvent e) {
        

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CalcView.present();

	}

}
