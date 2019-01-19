package hangman;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
	
	private static GameModel instance;
	private List<String> words;
	private List<String> hint;
	private int score;
	private int sizetime;
	private int countWrongAns;
	
	private GameModel(){
		words = new ArrayList<>();
		hint = new ArrayList<>();
		score = 0;
		sizetime = 0;
		countWrongAns = 5;
	}
	
	/** Get instance of GameModel. */
	public static GameModel getInstance(){
		if (instance == null) {
			instance = new GameModel();
		}
		return instance;
	}
	
	public List<String> getWords(){
		return words;
	}
	
	public List<String> getHint(){
		return hint;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getSizeTime(){
		return sizetime;
	}
	
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
