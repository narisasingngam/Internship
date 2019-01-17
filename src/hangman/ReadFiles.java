package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {
	
	private GameModel model;
	
	public ReadFiles(){
		model = new GameModel();
	}
	
	public void readFile(String fileText) throws IOException {
		File file = new File(fileText);
		BufferedReader bufer = new BufferedReader(new FileReader(fileText));
		String st;
		while ((st = bufer.readLine()) != null) {
			model.getWords().add(st);
		}
	}

}
