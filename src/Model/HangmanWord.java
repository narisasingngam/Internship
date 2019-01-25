package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Hangman game model.
 * @author narisa singngam
 */
public class HangmanWord {
	
	private static HangmanWord instance;
	private List<String> words;
	private List<String> hint;
	private int score;
	private int sizetime;
	private int countWrongAns;
	
	private HangmanWord(){
		words = new ArrayList<>();
		hint = new ArrayList<>();
		score = 0;
		sizetime = 0;
		countWrongAns = 5;
	}
	
	/** Get instance of GameModel.*/
	public static HangmanWord getInstance(){
		if (instance == null) {
			instance = new HangmanWord();
		}
		return instance;
	}
	
	/** Get list of word from the file.*/
	public List<String> getWords(){
		return words;
	}
	
	/** Get list of hint  from the file.*/
	public List<String> getHint(){
		return hint;
	}
	/** Get number of score.*/
	public int getScore(){
		return score;
	}
	/**Get size for entering letter.*/
	public int getSizeTime(){
		return sizetime;
	}
	/**Get the number of wrong answer.*/
	public int getCountWrongAnswer(){
		return countWrongAns;
	}
	
	public void setScore(int newscore){
		score = newscore;
	}
	
	public void setSize(int updateSize){
		sizetime = updateSize;
	}
	
	public void setCountWrongAnswer(int updateAns){
		countWrongAns = updateAns;
	}

}
