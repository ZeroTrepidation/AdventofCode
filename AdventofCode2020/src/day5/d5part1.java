package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class d5part1 {

	public static void main(String[] args) {

		try {

			FileReader file = new FileReader("day5Input.txt");
			BufferedReader br = new BufferedReader(file);

			int[] rows = new int[128];
			int[] seats = new int[8];
			int maxSeat = 0;

			for (int i = 0; i < rows.length; i++) {
				rows[i] = i;
			}

			for (int i = 0; i < seats.length; i++) {
				seats[i] = i;
			}

			String buffer = br.readLine();

			while (buffer != null) {
				char[] directions = buffer.toCharArray();

				int row = binaryPartition(directions, 0, rows.length, 127, 0);
				int column = binaryPartition(directions, 7, seats.length, 7, 0);
				int seat = row * 8 + column;

				if (seat > maxSeat) {
					maxSeat = seat;
				}

				System.out.println(buffer + ": row: " + row + ", column: " + column + ", seat ID " + seat);

				buffer = br.readLine();

			}

			System.out.println("Highest Seat ID is: " + maxSeat);

		} catch (IOException e) {
			System.out.println("File IO Exception");
		}

	}

	public static int binaryPartition(char[] array, int position, int size, int upper, int lower) {

		// System.out.println(array[position]+ " " + size + " " + position);

		if (size == 2) {
			if (array[position] == 'B' || array[position] == 'R')
				return upper;
			else if (array[position] == 'F' || array[position] == 'L')
				return lower;
		}

		size = size / 2;
		if (array[position] == 'B' || array[position] == 'R') {
			lower = lower + size;
			return binaryPartition(array, ++position, size, upper, lower);
		} else if (array[position] == 'F' || array[position] == 'L') {
			upper = upper - size;
			return binaryPartition(array, ++position, size, upper, lower);
		} else {
			return -1;
		}

	}

}
