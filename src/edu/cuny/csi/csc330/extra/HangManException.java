package edu.cuny.csi.csc330.extra;

import java.util.Vector;

public class HangManException extends Exception {
	
	private void printWrongLettersGuessed(Vector<Character> wrongLettersGuessed) {
		System.err.print("Wrong Guesses: ");
		for (int i = 0; i < wrongLettersGuessed.size(); i++) {
			System.err.print(wrongLettersGuessed.get(i));
			
			//If last character, then print nothing
			if (i != wrongLettersGuessed.size() - 1)
				System.err.print(", ");
		}
		System.err.println();
		
	}

	@Override
	public String toString() {
		
		HangMan.printHangman();
		System.err.println("GAME OVER! The word was " + HangMan.word);
		printWrongLettersGuessed();
		System.err.println("Guesses: " + guesses);
		System.err.println();
		
		return
		
	}
	

	
	
}
