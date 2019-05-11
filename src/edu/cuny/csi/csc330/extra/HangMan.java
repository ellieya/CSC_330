package edu.cuny.csi.csc330.extra;

/* TODO
 * Turn the game lose output into exception.
 * 
 * 
 * Etc:
 * 		Make shit look nicer
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import edu.cuny.csi.csc330.lib.Randomizer;

public class HangMan {
	private int penalty;
	private int guesses;
	private int guessesLeft; // 6 - penalty
	private List<String> wordList;
	private String word;
	private int wordLen;
	private int lettersFound;
	private boolean[] letterKnown;
	private Vector<Character> lettersGuessed;
	private Vector<Character> wrongLettersGuessed;
	
	HangMan(String fileName) {
		penalty = 0;
		guesses = 0;
		guessesLeft = 6;
		populateListFromFile(fileName);
		//word = pickWordFromWordList();
		word = "TEST";
		wordLen = word.length();
		
		//Initialize references
		letterKnown = new boolean[wordLen];
		lettersGuessed = new Vector<Character>();
		wrongLettersGuessed = new Vector<Character>();
		playGame();
		
	}
	
	private void playGame() {
		boolean endGame = false;
		Scanner scanObj = new Scanner(System.in);
		
		while (!endGame) {
			printHangman();
			printKnownLetters();
			printLettersGuessed();
			if (!getInputAndCheckLetterExist(scanObj)) {
				incrPenalty();
				System.out.println("Letter not found!");
			}
			incrGuesses();
			System.out.println("Guesses is currently at " + guesses);
			
			System.out.println();
			
			//If penalty met or all letters have been found, end the game
			if (penalty == 6 || lettersFound == wordLen)
				endGame = true;
			
		}
		scanObj.close();
		
		gameEnd();
	}
	
	private void populateListFromFile(String fileName) {
		wordList = new LinkedList<String>();
		File wordFile = new File(fileName + ".txt");
		Scanner reader;
		
		try {
			reader = new Scanner(wordFile);
		//An exception here if file open fail
		//"Did you place file in root folder?"
		while (reader.hasNextLine()) {
			wordList.add(reader.nextLine());
		}	
		
		reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String pickWordFromWordList() {
		return wordList.get(Randomizer.generateInt(0, wordList.size()-1));
	}
	
	public void printHangman() {
		if (penalty != 6) {
			System.out.println("__________");
			System.out.println(" |    |");
		}
		else {
			System.err.println("__________");
			System.err.println(" |    |");
		}

		switch (penalty) {
		case 1:
			System.out.println(" |    o");
			System.out.println(" |");
			System.out.println(" |");
			break;
		case 2:
			System.out.println(" |    o");
			System.out.println(" |   /");
			System.out.println(" |");
			break;
		case 3:
			System.out.println(" |    o");
			System.out.println(" |   /|");
			System.out.println(" |");
			break;
		case 4:
			System.out.println(" |    o");
			System.out.println(" |   /|\\");
			System.out.println(" |");
			break;
		case 5:
			System.out.println(" |    o");
			System.out.println(" |   /|\\");
			System.out.println(" |   /");
			break;
		case 6:
			System.err.println(" |    o");
			System.err.println(" |   /|\\");
			System.err.println(" |   / \\");
			break;
		default:
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			break;
		}
		if (penalty != 6)
			System.out.println("__________");
		else
			System.err.println("__________");
	}

	private void printKnownLetters() {
		for (int i = 0; i < word.length(); i++) {
			if (letterKnown[i]) {
				System.out.print(word.charAt(i));
			} else {
				System.out.print('_');
			}
			
			//If last character, then print nothing
			if (i != word.length() - 1)
				System.out.print(" ");
		}
		System.out.println();
		
	}

	
	private void printLettersGuessed() {
		System.out.print("Letters Guessed: ");
		for (int i = 0; i < lettersGuessed.size(); i++) {
			System.out.print(lettersGuessed.get(i));
			
			//If last character, then print nothing
			if (i != lettersGuessed.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
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
		boolean alreadyGuessed;
		
		//Get input and validate input
		do {
			//Initialize/reset value of alreadyGussed to false
			alreadyGuessed = false;
			System.out.print("Input: ");
			userInput = scanObj.nextLine().toUpperCase().charAt(0);
			
			//Check for previously entered letter
			for (int i = 0; i < lettersGuessed.size(); i++) {
				if (userInput == lettersGuessed.get(i)) {
					System.out.println("You already guessed this letter! Try again.");
					alreadyGuessed = true;
				}
			} 
		} while (alreadyGuessed);
		
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
	public void incrPenalty() {
		penalty++;
		guessesLeft--;
	}

	private void incrGuesses() {
		guesses++;
	}
	
	private void gameEnd() throws HangManException{

		// Throw exception if penalty = 6
		// TODO put this into the exception class instead
		if (penalty == 6) {
			throw new HangManException();
		} else {
			System.out.print("The word was ");
			printKnownLetters();
			System.out.println("Guesses: " + guesses);
			System.out.println("Guesses left: " + guessesLeft);
			System.out.println("You won! Congratulations!");
		}
	}

	public static void main(String args[]) {
		HangMan game = new HangMan(args[0]);

	}
}
