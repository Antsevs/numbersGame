package numbersGame;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Game {
	
	private static Game obj = new Game();
	private static Random rand = new Random();
	private static Scanner scnr = new Scanner(System.in);
	public static void main(String [] args) {
		int menuOpt = obj.greeting();
		obj.menuChoice(menuOpt);
	}
	
	/* WINNING PAGE IDEA
	 * color code for each number, end page shows gradient of numbers in list
	 */
	public int greeting() {
		System.out.println("Welcome to the numbers game!\n"
				+ "1. New Game\n"
				+ "2. Continue Game\n"
				+ "3. Leaderboard\n"
				+ "4. Rules\n"
				+ "5. Exit\n");
		int menuOpt = scnr.nextInt();
		return menuOpt;
	}
	
	public void menuChoice(int menuOpt) {
		switch(menuOpt) {
			case 1:
				obj.game();
			case 2:
				obj.contGame();
				menuOpt = obj.greeting();
				obj.menuChoice(menuOpt);
			case 3:
				obj.ldrboard();
				menuOpt = obj.greeting();
				obj.menuChoice(menuOpt);
			case 4:
				obj.rules();
				menuOpt = obj.greeting();
				obj.menuChoice(menuOpt);
			case 5:
				System.out.println("Thanks for playing!");
				break;
			default:
				System.out.println("Funny. try again.");
				menuOpt = obj.greeting();
				obj.menuChoice(menuOpt);
		}
	}
	
	public void game() {
		int arr[] = new int[10];
		int index = 0;
		int errorCatch = 0;
		int repeatCount = 0;
		int randNum = 0;
		boolean winCheck = false;
		
		for(int count = 0; count < 10; count++) { //loop for building list
			if(repeatCount == 0) {
				randNum = rand.nextInt(1001);
			}
			System.out.println("Generated number: " + randNum);
			System.out.println("Index to place number: ");
			index = scnr.nextInt() - 1;
			while(index >= 10 || index < 0) { //ensure user index between 1-10
				System.out.println("Try again, your entry must be between 1 and 10.");
				index = scnr.nextInt() - 1;
			}
			if(arr[index] == 0) { //check if space is already taken
				repeatCount = 0;
				arr[index] = randNum;
				
				if(count != 0) { //as long as there is more than one number now in list
					/*for(int i = 0; i < index; i++) { //ensure numbers in front are smaller
						if(arr[i] > arr[index]) {
							errorCatch = 1;
							break;
						}
					} 
					
					for(int i = index + 1; i < 10; i++) { //ensure numbers behind are bigger
						if(arr[i] < arr[index] && arr[i] != 0) {
							errorCatch = 1;
							break;
						}
					}*/
				}
				if(errorCatch == 1) { //maybe include different color for the number or fail game for user if there is nowhere to place number
					System.out.println(Arrays.toString(arr));
					System.out.println("I'm sorry, you lose. Dork.");
					break;
				}
				System.out.println(Arrays.toString(arr));
				
			} else {
				System.out.println("That space is taken, try again.");
				repeatCount = 1;
				count--; //if repeated, dont add to counter
				System.out.println(Arrays.toString(arr));
			}
		}
		
		for(int m = 0; m <= 10; m++) { //check if list is completed successfully
			if(arr[m] != 0) {
				winCheck = true;
			} else {
				winCheck = false;
				break;
			}
		}
		
		if(winCheck = true) {
			System.out.println("Congratulations! You've Won!"
					+ "Your current streak is" + " games");
		}
	}
	
	public void contGame() {
		System.out.println("Continue Game");
	}
	
	public void ldrboard() {
		System.out.println("Leaderboard");
	}
	
	public void rules() {
		System.out.println("Rules");
	}
}
