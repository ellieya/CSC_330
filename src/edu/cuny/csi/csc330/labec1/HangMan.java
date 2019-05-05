package edu.cuny.csi.csc330.labec1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class HangMan {
	private int penalty;
	LinkedList<String> wordList;
	
	HangMan(String fileName) {
		penalty = 0;
		populateListFromFile(fileName);
	}
	
	private void populateListFromFile(String fileName) {
		
		File wordFile = new File(fileName + ".txt");
		Scanner reader;
		
		try {
			reader = new Scanner(wordFile);
		//An exception here if file open fail
		//"Did you place file in root folder?"
		while (reader.hasNextLine()) {
			wordList.push(reader.nextLine());
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
	
	public void printHangman() {
		System.out.println("__________");
		System.out.println(" |    |");
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
			System.out.println(" |    o");
			System.out.println(" |   /|\\");
			System.out.println(" |   / \\");
			break;
		default:
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			break;
		}
		System.out.println("__________");
	}
	
	
	public static void main(String args[]) {
		HangMan game = new HangMan(args[0]);
	}
}
