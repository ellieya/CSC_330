package edu.cuny.csi.csc330.extra;

/* TODO
 * Turn the game lose output into exception.
 * 
 * Game lose:
 * 		Incorrect guesses information
 * 		Total guesses information
 * 
 * Game win:
 * 		Win after how many guesses?
 * 		How many guesses left?
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
	List<String> wordList;
	String word;
	int wordLen;
	int lettersFound;
	boolean[] letterKnown;
	
	// TODO address this
	Vector<Character> lettersGuessed;
	
	HangMan(String fileName) {
		penalty = 0;
		populateListFromFile(fileName);
		//word = pickWordFromWordList();
		word = "TEST";
		wordLen = word.length();
		letterKnown = new boolean[wordLen];
		lettersGuessed = new Vector<Character>();
		playGame();
		
	}
	
	private void playGame() {
		boolean endGame = false;
		Scanner scanObj = new Scanner(System.in);
		
		while (!endGame) {
			printHangman();
			printKnownLetters();
			printLettersGuessed();
			//Ask for input
			if (!getInputAndCheckLetterExist(scanObj)) {
				incrPenalty();
				System.out.println("Letter not found!");
			}
			
			System.out.println();
			
			//If penalty met or all letters have been found, end the game
			if (penalty == 6 || lettersFound == wordLen)
				endGame = true;
			
		}
		scanObj.close();

		
		//Throw exception if penalty = 6
		// TODO put this into the exception class instead
		if (penalty == 6) {
			printHangman();
			System.err.println("GAME OVER! The word was " + word);
		} else {
			System.out.print("The word was ");
			printKnownLetters();
			System.out.println("You won! Congratulations!");
		}
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


	private void printLettersGuessed() {
		System.out.print("Letters Guessed: ");
		for (int i = 0; i < lettersGuessed.size(); i++) {
			System.out.print(lettersGuessed.get(i));
		}
		System.out.println();
	}

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
	
	private boolean checkLetterExist(char userInput) {
		boolean atLeastOneFound = false;

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == userInput) {
				letterKnown[i] = true;
				atLeastOneFound = true;
				lettersFound++;
			}
		}

		return atLeastOneFound;
	}

	private void printKnownLetters() {
		for (int i = 0; i < word.length(); i++) {
			if (letterKnown[i]) {
				System.out.print(word.charAt(i));
			} else {
				System.out.print('_');
			}
			
			System.out.print(' ');
		}
		System.out.println();
		
	}

	private String pickWordFromWordList() {
		return wordList.get(Randomizer.generateInt(0, wordList.size()-1));
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
	
	public void incrPenalty() {
		penalty++;
	}

	public List<String> getWordList() {
		return wordList;
	}

	public static void main(String args[]) {
		HangMan game = new HangMan(args[0]);

	}
}
