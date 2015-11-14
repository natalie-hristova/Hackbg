package Natiii;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2 {
	static char[][] array;
	static String name;
	static int br = 0;
	static ArrayList<String> found = new ArrayList<String>();
	static int X, Y;
	static String word = new String();

	public static void main(String[] args) {
		System.out.println("Enter X and Y");
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		array = new char[X][Y];
		System.out.println("Enter the name:");
		if ((name = sc.nextLine()).length() <= X && (name = sc.nextLine()).length() <= Y) {

			for (int i = 0; i < X; i++) {
				for (int j = 0; j < Y; j++) {
					System.out.println("Enter the next letter:");
					array[i][j] = sc.next().charAt(0);
				}
			}
			leftAndRight(array);
			upAndDown(array);
			primaryDiagonal(array);
			secondaryDiagonal(array);
			addReversal();
			findMatches();
		} else {
			System.out.println("The name is too long.");
		}

	}

	public static void findMatches() {
		for (int i = 0; i < found.size(); i++) {
			if (found.get(i).contains(name)) {
				br++;
			}
		}
		System.out.println("Result:" + br);
	}

	public static void leftAndRight(char array[][]) {

		for (int i = 0; i < X; i++) {
			word = "";
			for (int j = 0; j < Y; j++) {
				word += array[i][j];
			}
			found.add(word);

		}
	}

	public static void upAndDown(char array[][]) {

		for (int i = 0; i < Y; i++) {
			word = "";
			for (int j = 0; j < X; j++) {
				word += array[j][i];
			}
			found.add(word);
		}
	}

	public static void primaryDiagonal(char array[][]) {
		for (int slice = 0; slice < X + Y - 1; ++slice) {
			word = "";
			int z1 = slice < Y ? 0 : slice - Y + 1;
			int z2 = slice < X ? 0 : slice - X + 1;
			for (int j = slice - z2; j >= z1; --j) {
				word += array[j][slice - j];
			}
			found.add(word);
		}
	}

	public static void secondaryDiagonal(char array[][]) {
		for (int slice = 0; slice < X + Y - 1; ++slice) {
			word = "";
			int z1 = slice < Y ? 0 : slice - Y + 1;
			int z2 = slice < X ? 0 : slice - X + 1;
			for (int j = slice - z2; j >= z1; --j) {
				word += array[X - j - 1][slice - j];
			}
			found.add(word);
		}
	}

	public static void addReversal() {
		StringBuilder wordReversal = new StringBuilder("");
		int listSize = found.size();
		for (int i = 0; i < listSize; i++) {
			wordReversal.append(found.get(i));
			found.add(wordReversal.reverse().toString());
			wordReversal.setLength(0);
		}

	}
}
