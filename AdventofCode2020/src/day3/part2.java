package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class part2 {

	public static void main(String[] args) {
		
		try {
			int treeCount = 0;
			int indexCounter = 0;
			int lineLen;
			int[] rightMove = {1,3,5,7};
			int[] downMove = {1,2};
			long multipleTreeCount = 1;
			
			FileReader reader;
			BufferedReader br;
			
			for (int i = 0; i < downMove.length; i++) {
				for (int j = 0; j < rightMove.length; j++) {
					reader = new FileReader(new File("day3Input.txt"));
					br = new BufferedReader(reader); 
					
					String currentLine = br.readLine();
					
					lineLen = currentLine.length();
					
					while(currentLine != null){
						
						
						//System.out.println(indexCounter%lineLen);
						
						char[] temp = currentLine.toCharArray();
						
						if(currentLine.charAt(indexCounter%lineLen) == '#') {
							temp[indexCounter%lineLen] = 'X';
							treeCount++;
						} else {
							temp[indexCounter%lineLen] = 'O';
						}
							
						currentLine = new String(temp);
						
						
						//System.out.println(currentLine);
						
						indexCounter += rightMove[j];
						
						
						for(int k = 0; k < downMove[i]; k++)
							currentLine = br.readLine();
					}
					System.out.println("For right move: " + rightMove[j] + " down move: " + downMove[i] + " Tree count = "+ treeCount);
					multipleTreeCount = multipleTreeCount * treeCount;
					System.out.println("So far all trees multiplied together = " + multipleTreeCount);
					treeCount = 0;
					indexCounter = 0;
				}
				
			}
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
