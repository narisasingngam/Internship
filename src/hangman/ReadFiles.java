package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Model.HangmanWord;
/**
 * Read text file on the hangman game.
 * @author narisa singngam
 */
public class ReadFiles {
	
	private HangmanWord model;
	
	public ReadFiles(){
		model = HangmanWord.getInstance();
	}
	
	/**
	 * Read file on text.
	 * @param fileText
	 * @throws IOException
	 */
	public void readFile(String fileText) throws IOException {
		File file = new File(fileText);
		BufferedReader bufer = new BufferedReader(new FileReader(fileText));
		String st;
		int count = 1;
		while ((st = bufer.readLine()) != null) {
			if(count%2 != 0) model.getWords().add(st.toUpperCase());
			else model.getHint().add(st);
			count++;
		}
	}
	

}
