package day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class d4part1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileReader reader = new FileReader("day4Input.txt");
			BufferedReader br = new BufferedReader(reader);

			String buffer = br.readLine();
			Stack<String> passportInfo = new Stack<String>();
			
			int validPPCount = 0;

			while (buffer != null) {
				//System.out.println("check3");
				while (!buffer.isBlank()) {
					passportInfo.push(buffer);
					
					buffer = br.readLine();
					if(buffer == null) break;
					//System.out.println("check2");
				} 
				
				if(passportValidator(passportInfo)) validPPCount++;
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
		
		
		
		while(!passportStrings.empty()) {
			//System.out.println("check");
			String currLine = passportStrings.pop();
			//System.out.println(currLine);
			String[] kvPairs = currLine.split("\\s");
			
			mainLoop: for (int i = 0; i < kvPairs.length; i++) {
				
				String[] temp = kvPairs[i].split(":");
				String key = temp[0];
				String value = temp[1];
				
				switch(key.toLowerCase()) {
				case "byr":
					byr = value;
					break;
				case "iyr":
					iyr = value;
					break;
				case "eyr":
					eyr = value;
					break;
				case "hgt":
					hgt = value;
					break;
				case "hcl":
					hcl = value;
					break;
				case "ecl":
					ecl = value;
					break;
				case "pid":
					pid = value;
					break;
				case "cid":
					cid = value;
					break;
				}
			}
			
			
			
			
		}
		if(byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null) 
			isValid = true;
		return isValid;
	}

};
