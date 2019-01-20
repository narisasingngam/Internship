package hangman;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller hangman game
 * @author narisa singngam
 */
public class GameController {

	private List<Character> letter;
	private List<Character> letChar;
	private List<Character> wrongLetter;
	private static GameModel model;

	public GameController() {
		letter = new ArrayList<>();
		letChar = new ArrayList<>();
		wrongLetter = new ArrayList<>();
		model = GameModel.getInstance();
	}
	
	/**Get list of char letter*/
	public List<Character> getletChar() {
		return letChar;
	}
	
	/**clear the list for start new game*/
	public void clearChar(){
		List<Character> temp = new ArrayList<>();
		List<Character> tempn = new ArrayList<>();
		List<Character> tempwrong = new ArrayList<>();
		letChar = temp;
		letter = tempn;
		wrongLetter = tempwrong;
	}
	
	/**Get list of letter*/
	public List<Character> getLetter() {
		return letter;
	}

	/**
	 * Add letter of word to List
	 * @param word in file
	 */
	public void addWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			letter.add(word.charAt(i));
		}
	}
	/**Show beginning game*/
	public void clearLetter() {
		for (int i = 0; i < letter.size(); i++) {
			letChar.add('_');
		}
	}

	/**
	 * Input letter to check on the word to prepare on output
	 * @param let input letter
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
			model.setScore(model.getScore()+5);
			model.setSize(model.getSizeTime() - 1);
		} else return;
		

		// Set collect letter in List
		for (int i = 0; i < letter.size(); i++) {
			if (letter.get(i).equals(selectChar)) {
				letChar.set(i, selectChar);
			}
		}
	}
	/**
	 * Check input letter is correct or not
	 * @param let input letter
	 * @return true if letter is not contain to the word
	 * @return false if letter is contain to the word
	 */
	public boolean checkCollectLetter(char let) {
		// Check duplicate letter
		if (wrongLetter.contains(let)) {
			System.out.println("This letter alredy used");
			return true;
		}
		if (!letter.contains(let)) {
			wrongLetter.add(let);
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
	
	/**
	 * Show the list of wrong letter that user input
	 */
	public void wrongGuess(){
		for (int i = 0; i < wrongLetter.size(); i++) {
			if(i == 0) System.out.print("Wrong guess: " + wrongLetter.get(0));
			else System.out.print("," + wrongLetter.get(i));
		}
		System.out.println();
	}

}
