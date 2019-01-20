package hangman;

import java.io.IOException;
import java.util.Scanner;

/**
 * View of Hangman game
 * @author narisa singngam
 */
public class HangmanGame {

	private GameController game;
	private ReadFiles file;
	private GameModel model;
	private boolean gameStatus = true;

	public HangmanGame() {
		game = new GameController();
		file = new ReadFiles();
		model = GameModel.getInstance();
	}

	/**
	 * Start a new game
	 * @throws IOException
	 */
	public void startGame() throws IOException {

		while(gameStatus){
			
		//เลือกตัวเลข
		file.readFile("text.txt");
		int countWord = model.getWords().size();
		
		while (!(countWord <= 0)) {
			String word = model.getWords().get(countWord - 1);
			String hint = model.getHint().get(countWord - 1);
			System.out.println(word);
			System.out.println(hint);
			System.out.println();

			game.addWord(word);
			game.clearLetter();
			game.countTime();
			// enter new letter
			enterLetter();
			
			if (model.getCountWrongAnswer() <= 0) {
				System.out.println("Game Over");
				gameStatus = false;
				break;
			}

			game.clearChar();
			countWord -= 1;
		}
		//Start a new game part
		newGame();
		
		}
		
	}

	/**
	 * Input new letter in to the game
	 */
	public void enterLetter() {

		while (model.getSizeTime() != 0) {
			System.out.print("Enter letter: ");
			Scanner scan = new Scanner(System.in);
			String s = scan.next();
			game.checkLetter(s);
			game.wrongGuess();

			if (model.getCountWrongAnswer() <= 0) {
				break;
			}
			System.out.println("Remaining wrong guess " + model.getCountWrongAnswer());
			game.showLetter();
			if (!game.getletChar().contains('_'))
				break;
		}
	}
	
	/**
	 * Check for starting new game
	 */
	public void newGame(){
		System.out.println("Do you want to quit the game?(y/n)");
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		
		while(true){
			if(s.equals("y")) {
				gameStatus = false;
				break;
			}
			else if(s.equals("n")){
				gameStatus = true;
				//clear old score
				model.setScore(0);
				game.clearChar();
				model.setCountWrongAnswer(5);
				break;
			}
			else System.out.println("Please enter 'y or n' ");
		}
	}

}
