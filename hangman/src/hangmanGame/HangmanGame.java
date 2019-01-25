package hangmanGame;

import java.io.IOException;
import java.util.Scanner;

import Model.HangmanWord;

/**
 * View of Hangman game.
 * @author narisa singngam
 */
public class HangmanGame {

	private GameController game;
	private HangmanWord model;
	private boolean gameStatus = true;

	public HangmanGame() {
		game = new GameController();
		model = HangmanWord.getInstance();
	}

	/**
	 * Start a new game.
	 * @throws IOException
	 */
	public void startGame() throws IOException {

		while(gameStatus){
		model.getWords().clear();
		model.getHint().clear();
		printQuestion();
		game.selectNumberFileGame();
		
		int countWord = model.getWords().size();
		
		while (!(countWord <= 0)) {
			String word = model.getWords().get(countWord - 1);
			String hint = model.getHint().get(countWord - 1);
			System.out.println(word);
			System.out.println(hint);
			System.out.println();

			game.addWord(word);
			game.clearLetter();
			game.showLetter();
			game.countTime();
			//Enter new letter.
			game.enterLetter();
			
			if (model.getCountWrongAnswer() <= 0) {
				System.out.println("Game Over");
				break;
			}
			game.clearChar();
			countWord -= 1;
		}
		//Start a new game part.
		newGame();
		
		}
		
	}
	
	/**
	 * Check for starting new game.
	 */
	public void newGame(){
		System.out.println("Do you want to quit the game?(y/n)");
		Scanner scan = new Scanner(System.in);
		
		while(true){
			String s = scan.next();
			if(s.equals("y")) {
				gameStatus = false;
				break;
			}
			else if(s.equals("n")){
				gameStatus = true;
				//Clear old score.
				model.setScore(0);
				game.clearChar();
				model.setCountWrongAnswer(5);
				break;
			}
			else System.out.println("Please enter 'y or n' ");
		}
	}
	
	public void printQuestion(){
		System.out.println("Select Category:");
		System.out.println("1.Country");
		System.out.println("2.Career");
		System.out.println("3.General knowledge in thailand");
	}

}
