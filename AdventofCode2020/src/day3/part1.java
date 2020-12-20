package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class part1 {

	public static void main(String[] args) {
		
		try {
			int treeCount = 0;
			int indexCounter = 0;
			int lineLen;
			
			FileReader reader = new FileReader(new File("day3Input.txt"));
			BufferedReader br = new BufferedReader(reader);
			
			String currentLine = br.readLine();
			currentLine = br.readLine();
			
			lineLen = currentLine.length();
			
			while(currentLine != null){
				indexCounter += 3;
				
				System.out.println(indexCounter%lineLen);
				
				char[] temp = currentLine.toCharArray();
				
				if(currentLine.charAt(indexCounter%lineLen) == '#') {
					temp[indexCounter%lineLen] = 'X';
					treeCount++;
				} else {
					temp[indexCounter%lineLen] = 'O';
				}
					
				currentLine = new String(temp);
				
				
				System.out.println(currentLine);
			
				currentLine = br.readLine();
			}
			
			System.out.println(treeCount);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
