package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Character> letter;
	private List<Character> letChar;
	private List<Character> wrongLetter;
	
	public Player(){
		letter = new ArrayList<>();
		letChar = new ArrayList<>();
		wrongLetter = new ArrayList<>();
	}
	
	/**Get list of char letter.*/
	public List<Character> getletChar() {
		return letChar;
	}
	
	/**Get list of letter.*/
	public List<Character> getLetter() {
		return letter;
	}
	
	/**Get list of wrong letter.*/
	public List<Character> getWrongLetter() {
		return wrongLetter;
	}
	
}
