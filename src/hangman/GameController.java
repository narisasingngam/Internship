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


	public GameController() {
		letter = new ArrayList<>();
		letChar = new ArrayList<>();

	}

	public List<Character> getletChar() {
		return letChar;
	}
	
	public List<Character> getLetter() {
		return letter;
	}

	public void addWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			letter.add(word.charAt(i));
		}
	}
	
	public void clearLetter(){
		for (int i = 0; i < letter.size(); i++) {
			letChar.add('_');
		}
	}

	public void checkLetter(String let) {
		char letChars = let.charAt(0);
		for (int i = 0; i < letter.size(); i++) {
		if (letter.get(i).equals(letChars)) {
			letChar.set(i, letChars);
		}
	}	
}
	public void showLetter(){
		for (int i = 0; i < letChar.size(); i++) {
			System.out.print(letChar.get(i) + " ");
		}
		System.out.println();
	}


}
