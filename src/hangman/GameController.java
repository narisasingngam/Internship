package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameController {

	private List<Character> letter;
	private List<Character> letChar;
	private List<Character> wrongLetter;
	private static GameModel model;
	private int score = 0;

	public GameController() {
		letter = new ArrayList<>();
		letChar = new ArrayList<>();
		wrongLetter = new ArrayList<>();
		model = GameModel.getInstance();
	}

	public List<Character> getletChar() {
		return letChar;
	}

	public List<Character> getLetter() {
		return letter;
	}

	/**
	 * Add letter of word to List
	 * 
	 * @param word
	 */
	public void addWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			letter.add(word.charAt(i));
		}
	}

	public void clearLetter() {
		for (int i = 0; i < letter.size(); i++) {
			letChar.add('_');
		}
	}

	/**
	 * Input letter to check on the word to prepare on output
	 * 
	 * @param let
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
		if (letChar.contains(selectChar)) {
			System.out.println("This letter alredy used");
			return;
		}
		// Check wrong letter
		if (!checkCollectLetter(selectChar)) {
			score += 5;
			model.setScore(score);
			model.setSize(model.getSizeTime() - 1);
		} else return;
		

		// Set collect letter in List
		for (int i = 0; i < letter.size(); i++) {
			if (letter.get(i).equals(selectChar)) {
				letChar.set(i, selectChar);
			}
		}
	}
	public boolean checkCollectLetter(char let) {
		// Check duplicate letter
		if (wrongLetter.contains(let)) {
			System.out.println("This letter alredy used");
			return true;
		}
		if (!letter.contains(let)) {
			wrongLetter.add(let);
			System.out.print("Wrong guess: " + wrongLetter.get(0));
			for (int i = 1; i < wrongLetter.size(); i++) {
				System.out.print("," + wrongLetter.get(i));
			}
			System.out.println();
			model.setSize(model.getSizeTime() - 1);
			model.setCountWrongAnswer(model.getCountWrongAnswer()-1);
			return true;
		}
		return false;
	}

	/**
	 * Show output game
	 */
	public void showLetter() {
		System.out.println("Score: " + model.getScore());
		for (int i = 0; i < letChar.size(); i++) {
			System.out.print(letChar.get(i) + " ");
		}
		System.out.println();
	}
	
	/**
	 * Limit time count
	 */
	public void countTime(){
		int startTime = 5 + letter.size();
		model.setSize(startTime);
	}

}
