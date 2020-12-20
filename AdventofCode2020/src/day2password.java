import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class day2password {

	public static void main(String[] args) {
try {
			
			FileReader reader = new FileReader(new File("day2Input.txt"));
			BufferedReader br = new BufferedReader(reader);
			
			String currentLine = br.readLine();
			int validPasswords = 0;
			
			while(currentLine != null) {
				
				int count = 0;
				 
				String[] temp = currentLine.split("-|\\s+");
				
				int lowerbound = Integer.parseInt(temp[0]);
				int upperbound = Integer.parseInt(temp[1]);
				
				char character = temp[2].charAt(0);
				
				char[] password = temp[3].toCharArray();

				for(int i = 0; i < password.length; i++) {
					if(password[i] == character)
						count++;
				}
				
				if(count >= lowerbound && count <= upperbound)
					validPasswords++;
				
				
				
				currentLine = br.readLine();
				
			}
			
			System.out.println("Valid Passwords = " + validPasswords);
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
