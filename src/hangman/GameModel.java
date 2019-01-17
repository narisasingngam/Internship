package hangman;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
	
	private static List<String> words;
	
	public GameModel(){
		words = new ArrayList<>();
	}
	
	public List<String> getWords(){
		return words;
	}

}
