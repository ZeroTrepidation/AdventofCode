package day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class d4part2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileReader reader = new FileReader("day4Input.txt");
			BufferedReader br = new BufferedReader(reader);

			String buffer = br.readLine();
			Stack<String> passportInfo = new Stack<String>();

			int validPPCount = 0;

			while (buffer != null) {
				// System.out.println("check3");
				while (!buffer.isBlank()) {
					passportInfo.push(buffer);

					buffer = br.readLine();
					if (buffer == null)
						break;
					// System.out.println("check2");
				}

				if (passportValidator(passportInfo))
					validPPCount++;
				buffer = br.readLine();

			}

			System.out.println("Valid Passports = " + validPPCount);

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("File not found");

		}

	}

	private static boolean passportValidator(Stack<String> passportStrings) {

		String byr = null, iyr = null, eyr = null, hgt = null, hcl = null, ecl = null, pid = null, cid = null;
		boolean isValid = false;

		while (!passportStrings.empty()) {
			// System.out.println("check");
			String currLine = passportStrings.pop();
			// System.out.println(currLine);
			String[] kvPairs = currLine.split("\\s");

			mainLoop: for (int i = 0; i < kvPairs.length; i++) {

				String[] temp = kvPairs[i].split(":");
				String key = temp[0];
				String value = temp[1];

				switch (key.toLowerCase()) {
				case "byr":
					if (byrCheck(value)) {
						byr = value;
					} else
						break mainLoop;
					break;
				case "iyr":
					if (iyrCheck(value)) {
						iyr = value;
					} else
						break mainLoop;
					break;
				case "eyr":
					if (eyrCheck(value)) {
						eyr = value;
					} else
						break mainLoop;
					break;
				case "hgt":
					if (hgtCheck(value)) {
						hgt = value;
					} else
						break mainLoop;
					break;
				case "hcl":
					if (hclCheck(value)) {
						hcl = value;
					} else
						break mainLoop;
					break;
				case "ecl":
					if (eclCheck(value)) {
						ecl = value;
					} else
						break mainLoop;
					break;
				case "pid":
					if (pidCheck(value)) {
						pid = value;
					} else
						break mainLoop;
					break;
				case "cid":
					cid = value;
					break;
				}
			}

		}
		if (byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null)
			isValid = true;
		return isValid;
	}

	private static boolean byrCheck(String value) {
		int year = Integer.parseInt(value);
		if (year >= 1920 && year <= 2002) {
			return true;
		}

		return false;
	}

	private static boolean iyrCheck(String value) {
		int year = Integer.parseInt(value);
		if (year >= 2010 && year <= 2020) {
			return true;
		}
		return false;
	}

	private static boolean eyrCheck(String value) {
		int year = Integer.parseInt(value);
		if (year >= 2020 && year <= 2030) {
			return true;
		}
		return false;
	}

	private static boolean hgtCheck(String value) {
		System.out.println(value);
		if (value.contains("cm")) {
			//System.out.println(value);
			int height = Integer.parseInt(value.replaceAll("\\D", ""));
			if (height >= 150 && height <= 193) {

				return true;
			}
		} else if (value.contains("in")) {
			//System.out.println(value);
			int height = Integer.parseInt(value.replaceAll("\\D", ""));
			if (height >= 59 && height <= 76) {

				return true;
			}

		} 
		//System.out.println(value + "isfalse");
		return false;
			


	}

	private static boolean hclCheck(String value) {
		if (value.length() == 7) {
			if (value.matches("^#{1}[a-fA-F0-9]+")) {
				return true;
			}
		}
		System.out.println(value + "isfalse");

		return false;
	}

	private static boolean eclCheck(String value) {
		if (value.matches("(amb|blu|brn|gry|grn|hzl|oth)")) {
			return true;
		}
		System.out.println(value + "isfalse");

		return false;
	}

	private static boolean pidCheck(String value) {
		if (value.length() == 9) {
			if (value.matches("^0*[1-9]+"))
				return true;
		}
		System.out.println(value + "isfalse");
		return false;
	}

};
