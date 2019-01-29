package hangmanGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.HangmanWord;
import Model.Player;

/**
 * Controller hangman game.
 * 
 * @author narisa singngam
 */
public class GameController {
	private static HangmanWord model;
	private Player player;
	private ReadFiles file;

	public GameController() {
		model = HangmanWord.getInstance();
		player = new Player();
		file = new ReadFiles();
	}

	/** clear the list for start new game. */
	public void clearChar() {
		player.getletChar().clear();
		player.getLetter().clear();
		player.getWrongLetter().clear();
	}

	/**
	 * Add letter of word to List.
	 * 
	 * @param word
	 *            in file
	 */
	public void addWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			player.getLetter().add(word.charAt(i));
		}
	}

	/** Show beginning game. */
	public void clearLetter() {
		char[] specialChar = { ' ', '!', '?', '[', '-', '\\', '^', '$', '*', '+', '.', '(', ')', '|', ']', '{', '}' };
		for (int i = 0; i < player.getLetter().size(); i++) {
			player.getletChar().add('_');
		}
		// Automatic add special syntax.
		for (int i = 0; i < player.getLetter().size(); i++) {
			for (int j = 0; j < specialChar.length; j++) {
				int num = j;
				char c = Character.forDigit(num, 10);
				if (player.getLetter().get(i).equals(c)) {
					player.getletChar().set(i, c);
				} else if (player.getLetter().get(i).equals(specialChar[j])) {
					player.getletChar().set(i, specialChar[j]);
				}
			}
		}
	}

	/**
	 * Input letter to check on the word to prepare on output.
	 * 
	 * @param let
	 *            input letter
	 */
	public void checkLetter(String let) {
		char selectChar;
		// Check input only one letter
		if (let.length() > 1) {
			System.out.println("Please select only letter");
			return;
		}

		selectChar = let.charAt(0);
		// Check duplicate letter
		if (player.getletChar().contains(selectChar)) {
			System.out.println("This letter alredy used");
			return;
		}
		// Check wrong letter
		if (!checkCollectLetter(selectChar)) {
			model.setScore(model.getScore() + 5);
			model.setSize(model.getSizeTime() - 1);
		} else
			return;

		// Set collect letter in List
		for (int i = 0; i < player.getLetter().size(); i++) {
			if (player.getLetter().get(i).equals(selectChar)) {
				player.getletChar().set(i, selectChar);
			}
		}
	}

	/**
	 * Check input letter is correct or not.
	 * 
	 * @param let
	 *            input letter.
	 * @return true if letter is not contain to the word.
	 * @return false if letter is contain to the word.
	 */
	public boolean checkCollectLetter(char let) {
		// Check duplicate letter
		if (player.getWrongLetter().contains(let)) {
			System.out.println("This letter alredy used");
			return true;
		}
		if (!player.getLetter().contains(let)) {
			player.getWrongLetter().add(let);
			model.setSize(model.getSizeTime() - 1);
			model.setCountWrongAnswer(model.getCountWrongAnswer() - 1);
			return true;
		}
		return false;
	}

	/**
	 * Show output game.
	 */
	public void showLetter() {
		System.out.println("Score: " + model.getScore());
		for (int i = 0; i < player.getletChar().size(); i++) {
			System.out.print(player.getletChar().get(i) + " ");
		}
		System.out.println();
	}

	/**
	 * Limit time count.
	 */
	public void countTime() {
		int startTime = 5 + player.getLetter().size();
		model.setSize(startTime);
	}

	/**
	 * Show the list of wrong letter that user input.
	 */
	public void wrongGuess() {
		for (int i = 0; i < player.getWrongLetter().size(); i++) {
			if (i == 0)
				System.out.print("Wrong guess: " + player.getWrongLetter().get(0));
			else
				System.out.print("," + player.getWrongLetter().get(i));
		}
		System.out.println();
	}

	public boolean finishWord() {
		if (!player.getletChar().contains('_'))
			return true;
		return false;
	}

	/**
	 * Input new letter in to the game.
	 */
	public void enterLetter() {

		while (model.getSizeTime() != 0) {
			System.out.print("Enter letter: ");
			Scanner scan = new Scanner(System.in);
			String s = scan.next();
			checkLetter(s.toUpperCase());
			wrongGuess();

			if (model.getCountWrongAnswer() <= 0) {
				break;
			}
			System.out.println("Remaining wrong guess " + model.getCountWrongAnswer());
			showLetter();
			if (finishWord())
				break;
		}
	}

	/**
	 * Input number to select file game.
	 * 
	 * @return file string
	 * @throws IOException
	 */
	public void selectNumberFileGame() throws IOException {
		Scanner scan = new Scanner(System.in);
		boolean isTrue = true;
		while (isTrue) {
			String num = scan.next();
			if (num.equals("1")) {
				file.readFile("hangman/src/text1.txt");
				isTrue = false;
			} else if (num.equals("2")) {
				file.readFile("hangman/src/text2.txt");
				isTrue = false;
			} else if (num.equals("3")) {
				file.readFile("hangman/src/text3.txt");
				isTrue = false;
			} else
				System.out.println("Please enter number of category");
		}
	}

}
