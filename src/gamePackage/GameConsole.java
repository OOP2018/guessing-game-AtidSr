package gamePackage;

import java.util.Scanner;

/**
 * Play guessing game on the console.
 * 
 */
public class GameConsole {

	/** play the game.
	 * @param  game is number game that player play
	 * @return correct guessing result from player
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println(game.toString());

		boolean correct = false;
		int guess = 0;
		while (!correct) {
			System.out.println(game.getMessage());
			System.out.print("Your guess? ");
			guess = console.nextInt();
			correct = game.guess(guess);
	

			if (correct) {
				System.out.println(game.getMessage());
			}

		}

		return guess;
	}

}
