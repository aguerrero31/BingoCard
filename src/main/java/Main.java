package main.java;
import java.util.ArrayList;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		
		// Variables and Objects
		Random random = new Random();
		ArrayList<Integer> currentRow = new ArrayList<Integer>();
		char[] bingoText = {'B', 'I', 'N', 'G', 'O'};
		int[][] bingoCard = new int[5][5];
		int randomNum;
		int upperBound;
		int lowerBound;
		
		// Card Generation
		for (int row = 0; row < bingoCard.length; row++) {
			upperBound = 15 + (15 * row);
			lowerBound = 1 + (15 * row);
			for (int column = 0; column < bingoCard[0].length; column++) {
				do {
					randomNum = random.nextInt(upperBound - lowerBound + 1) + (lowerBound);
					bingoCard[row][column] = randomNum;
				} while (currentRow.contains(bingoCard[row][column]));
				currentRow.add(randomNum);
			}
			currentRow.clear();
		}
		// Free space
		bingoCard[2][2] = 0;
		
		// Printing
		for (char letter : bingoText) {
			System.out.print(letter + "  ");
		}
		System.out.println("\n--------------");
		for (int column = 0; column < bingoCard.length; column++) {
			for (int row = 0; row < bingoCard[column].length; row++) {
				if (bingoCard[row][column] < 10) {
					System.out.print(bingoCard[row][column] + "  ");
				}
				else {
					System.out.print(bingoCard[row][column] + " ");
				}
			}
			System.out.print("\n");
		}
	}
	
}
