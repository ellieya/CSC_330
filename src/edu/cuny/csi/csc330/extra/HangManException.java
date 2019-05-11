package edu.cuny.csi.csc330.extra;

public class HangManException extends Exception {
	
	HangMan object;

	public HangManException(HangMan hangMan) {
		this.object = hangMan;
	}

	@Override
	public String toString() {
		StringBuilder holder = new StringBuilder();
		
		holder.append(HangMan.makeHangmanString(object.getPenalty()));
		holder.append("\nGAME OVER! The word was " + object.getWord() + "\n");
		holder.append(object.makeWrongLettersGuessedString());
		holder.append("\nTotal Guesses: " + object.getGuesses());
		holder.append("\n");
		
		return holder.toString();
		
	}
	

	
	
}
