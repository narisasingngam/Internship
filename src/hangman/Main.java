package hangman;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		GameController game = new GameController();
		ReadFiles file = new ReadFiles();
		GameModel model = new GameModel();
		file.readFile("text.txt");

		Random random = new Random();
		int n = random.nextInt(model.getWords().size());
		String word = model.getWords().get(n);

		System.out.println(word);
		game.addWord(word);
		game.clearLetter();

		while (game.getletChar().contains('_')) {
			Scanner scan = new Scanner(System.in);
			String s = scan.next();
			game.checkLetter(s);
			game.showLetter();
		}

	}
}
