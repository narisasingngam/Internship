package weather;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Main {
	public static void main(String[] args) throws JSONException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Input file xml :");
		String input = scan.next();
		String file = "weather/";
		BufferedReader bufer;
		try {
			// weather.xml
			bufer = new BufferedReader(new FileReader(file+input));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file+"weather.json"));
			StringBuilder build = new StringBuilder();
			String st;

			while ((st = bufer.readLine()) != null) {
				build.append(st);
			}

			JSONObject json = XML.toJSONObject(build.toString());
			String temp = json.toString(5);
			System.out.println(temp);
			writer.write(json.toString(5));
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Please Enter correct file");
		}

	}
}
