package edu.cuny.csi.csc330.scratch;

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
import java.util.Arrays;

import javax.swing.*;

import edu.cuny.csi.csc330.swing.TTTGameView;

public class SlotController implements ActionListener, WindowListener {

	private boolean ifWork = false;
	private SlotView gameView;
	private SlotGame gameModel;
	private int winAmount;
	private String wheel[];

	public SlotController() {
		init();
	}

	public void setGameView(SlotView gameView) {
		this.gameView = gameView;
	}

	private void init() {
		gameModel = new SlotGame();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		Object source = ae.getSource();
		ifWork = (source == this.gameView.getSpinButton());
		System.out.println(ifWork);
		System.out.println("Slot actionPerformed: "
				+ source.getClass().getSimpleName());
		// Spin button
		if (source == this.gameView.getSpinButton()) {
			winAmount = gameView.getCreadit();
			System.out.println(gameView.getCreadit());
			gameModel.getSlot();
			wheel = gameModel.returnWheel();
			winAmount += gameModel.getWinAmount();
			System.out.println(Arrays.toString(wheel));
			gameView.setCredit(winAmount);
			gameView.spunWheelDec();
			gameView.importWheel(wheel);
			System.out.println(Arrays.toString(gameView.wheelSet()));

		}

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		SlotView.present();

	}
}
