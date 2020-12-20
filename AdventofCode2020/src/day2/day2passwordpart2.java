package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class day2passwordpart2 {

	public static void main(String[] args) {
		try {

			FileReader reader = new FileReader(new File("day2Input.txt"));
			BufferedReader br = new BufferedReader(reader);

			String currentLine = br.readLine();
			int validPasswords = 0;

			while (currentLine != null) {

				boolean valid = false;

				String[] temp = currentLine.split("-|\\s+");

				int pos1 = Integer.parseInt(temp[0]);
				int pos2 = Integer.parseInt(temp[1]);

				char character = temp[2].charAt(0);

				char[] password = temp[3].toCharArray();

				if (password[pos1 - 1] == character && password[pos2 - 1] != character)
					valid = true;
				else if (password[pos2 - 1] == character && password[pos1 - 1] != character)
					valid = true;

				if (valid == true)
					validPasswords++;

				currentLine = br.readLine();

			}

			System.out.println("Valid Passwords = " + validPasswords);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
