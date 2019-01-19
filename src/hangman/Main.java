package hangman;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		GameController game = new GameController();
		ReadFiles file = new ReadFiles();
		GameModel model = GameModel.getInstance();
		file.readFile("text.txt");

		// ควรใส่ใน view
		Random random = new Random();
		int n = random.nextInt(model.getWords().size());
		String word = model.getWords().get(n);

		System.out.println(word);
		game.addWord(word);
		game.clearLetter();
		
		game.countTime();
		
		while(model.getSizeTime() != 0) {
			System.out.print("Enter letter: ");
			Scanner scan = new Scanner(System.in);
			String s = scan.next();
			game.checkLetter(s);
			//ลองเอาไปใส่ใน while condition 
			if(model.getCountWrongAnswer() <= 0){
				System.out.println("Game Over");
				break;
			}
			System.out.println("Remaining wrong guess "+model.getCountWrongAnswer());
			game.showLetter();
			if(!game.getletChar().contains('_')) break;
		}

	}
}
