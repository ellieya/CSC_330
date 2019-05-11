package edu.cuny.csi.csc330.extra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import edu.cuny.csi.csc330.lib.Randomizer;

public class HangMan {
	
	private final int GAME_OVER_VALUE = 6; //Made into const in case want to change for the future.
	
	private int penalty;
	private int guesses;
	private int guessesLeft; // GAME_OVER_VALUE - penalty
	private List<String> wordList;
	private String word;
	private int wordLen;
	private int lettersFound;
	private boolean[] letterKnown;
	private Vector<Character> lettersGuessed;
	private Vector<Character> wrongLettersGuessed;
	
	public int getPenalty() {
		return penalty;
	}
	
	public int getGuesses() {
		return guesses;
	}

	public String getWord() {
		return word;
	}

	public HangMan(String fileName) {
		try {
			populateListFromFile(fileName);
			penalty = 0;
			guesses = 0;
			guessesLeft = GAME_OVER_VALUE;
			// TODO make sure you comment out word = "TEST" before submission
			word = pickWordFromWordList();
			//word = "TEST"; //for debugging purposes
			wordLen = word.length();

			// Initialize references
			letterKnown = new boolean[wordLen];
			lettersGuessed = new Vector<Character>();
			wrongLettersGuessed = new Vector<Character>();
		} catch (FileNotFoundException e) {
			System.err.println("FILE NOT FOUND! Did you place the file in the root folder?");
		}
		
	}
	
	public void playGame() {
		boolean endGame = false;
		Scanner scanObj = new Scanner(System.in);
		
		while (!endGame) {
			System.out.println(makeHangmanString(penalty));
			System.out.println(makeKnownLettersString());
			System.out.println(makeLettersGuessedString());
			System.out.println("Guesses left: " + guessesLeft);
			if (!getInputAndCheckLetterExist(scanObj)) {
				incrPenalty();
				System.out.println("Letter not found!");
			}
			incrGuesses();
			
			System.out.println();
			
			//If penalty met or all letters have been found, end the game
			if (penalty == GAME_OVER_VALUE || lettersFound == wordLen)
				endGame = true;
			
		}
		scanObj.close();
		
		try {
			gameEnd();
		} catch (HangManException e) {
			System.err.println(e);
		}
	}
	
	private void populateListFromFile(String fileName) throws FileNotFoundException {
		wordList = new LinkedList<String>();
		File wordFile = new File(fileName + ".txt");
		Scanner reader;
		
		try {
			reader = new Scanner(wordFile);
			while (reader.hasNextLine()) {
				wordList.add(reader.nextLine());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw e;
		}
	}
	
	private String pickWordFromWordList() {
		return wordList.get(Randomizer.generateInt(0, wordList.size()-1));
	}
	
	static protected String makeHangmanString(int penaltyValue) {
		
		StringBuilder holder = new StringBuilder();
		
			holder.append("__________\n");
			holder.append(" |    |\n");

		switch (penaltyValue) {
		case 1:
			holder.append(" |    o\n");
			holder.append(" |\n");
			holder.append(" |\n");
			break;
		case 2:
			holder.append(" |    o\n");
			holder.append(" |   /\n");
			holder.append(" |\n");
			break;
		case 3:
			holder.append(" |    o\n");
			holder.append(" |   /|\n");
			holder.append(" |\n");
			break;
		case 4:
			holder.append(" |    o\n");
			holder.append(" |   /|\\\n");
			holder.append(" |\n");
			break;
		case 5:
			holder.append(" |    o\n");
			holder.append(" |   /|\\\n");
			holder.append(" |   /\n");
			break;
		case 6:
			holder.append(" |    o\n");
			holder.append(" |   /|\\\n");
			holder.append(" |   / \\\n");
			break;
		default:
			holder.append(" |\n");
			holder.append(" |\n");
			holder.append(" |\n");
			break;
		}
			holder.append("__________");
			
			return holder.toString();
	}

	protected String makeKnownLettersString() {
		StringBuilder holder = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			if (letterKnown[i]) {
				holder.append(word.charAt(i));
			} else {
				holder.append('_');
			}
			
			//If last character, then append nothing
			if (i != word.length() - 1)
				holder.append(" ");
		}
		
		return holder.toString();
		
	}
	
	protected String makeWrongLettersGuessedString() {
		StringBuilder holder = new StringBuilder();
		holder.append("Wrong Guesses: ");
		for (int i = 0; i < wrongLettersGuessed.size(); i++) {
			holder.append(wrongLettersGuessed.get(i));
			
			//If last character, then print nothing
			if (i != wrongLettersGuessed.size() - 1)
				holder.append(", ");
		}
		
		return holder.toString();
		
	}
	
	protected String makeLettersGuessedString() {
		StringBuilder holder = new StringBuilder();
		
		holder.append("Letters guessed: ");
		for (int i = 0; i < lettersGuessed.size(); i++) {
			holder.append(lettersGuessed.get(i));
			
			//If last character, then print nothing
			if (i != lettersGuessed.size() - 1)
				holder.append(", ");
		}
		
		return holder.toString();
	}

	
	/**
	 * Grabs input and checks if input has already been guessed or not.
	 * If it has already been guessed, will continue asking for input until it is a letter that has not already been guessed. 
	 * 
	 * @return
	 * returns true if letter is found in 'word'
	 * false otherwise
	 */
	private boolean getInputAndCheckLetterExist(Scanner scanObj) {
		char userInput;
		boolean repeatLoopFlag; //Becomes true if input is invalid: not letter, already entered, nothing entered
		
		//Get input and validate input
		do {
			// Initialize/reset value of repeatLoopFlag to false
			repeatLoopFlag = false;
			System.out.print("Guess #" + (guesses + 1) + ": ");
			try {
				userInput = scanObj.nextLine().toUpperCase().charAt(0);
			} catch (Exception e) {
				// Makes userInput equal to space so that it will return "This is not a letter"
				// error.
				userInput = ' ';
			}

			// Check if userInput is character
			if (!Character.isLetter(userInput)) {
				System.out.println("This is not a letter! Try again.");
				repeatLoopFlag = true;
			} else {
				// Check for previously entered letter
				for (int i = 0; i < lettersGuessed.size(); i++) {
					if (userInput == lettersGuessed.get(i)) {
						System.out.println("You already guessed this letter! Try again.");
						repeatLoopFlag = true;
					}
				}
			}
		} while (repeatLoopFlag);
		
		//Update lettersGuessed list
		lettersGuessed.add(userInput);
		
		return checkLetterExist(userInput);
	}
	
	/**
	 * PRE: Check for duplicate guesses in getInputAndCheckLetterExist. Required b/c this method populates wrongLettersGuessed vector
	 * Helps getInputAndCheckLetterExist() check if letter is present in 'word'.
	 * If letter is not present, letter is added to wrongLettersGuessed
	 */
	private boolean checkLetterExist(char userInput) {
		boolean atLeastOneFound = false;

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == userInput) {
				letterKnown[i] = true;
				atLeastOneFound = true;
				lettersFound++;
			}
		}
		
		//Add to wrongLettersGuessed if not found
		if (!atLeastOneFound)
			wrongLettersGuessed.add(userInput);

		return atLeastOneFound;
	}

	/**
	 * Increments penalty and updates gussesLeft
	 */
	private void incrPenalty() {
		penalty++;
		guessesLeft--;
	}

	private void incrGuesses() {
		guesses++;
	}
	
	private void gameEnd() throws HangManException {
		if (penalty == GAME_OVER_VALUE) {
			throw new HangManException(this);
		} else {
			System.out.print("The word was ");
			System.out.println(makeKnownLettersString());
			System.out.println("Total Guesses: " + guesses);
			System.out.println("Guesses left: " + guessesLeft);
			System.out.println("You won! Congratulations!");
		}
	}

	public static void main(String args[]) {
		HangMan game = new HangMan(args[0]);
		game.playGame();
	}
}
