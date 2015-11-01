package Natiii;

import java.util.Scanner;

public class Zad2 {

	static char[][] ivan;
	static int br = 0;

	public static void main(String[] args) {

		ivan = new char[][] { { 'i', 'v', 'a', 'n' }, { 'e', 'v', 'n', 'h' }, { 'i', 'n', 'a', 'v' },
				{ 'm', 'v', 'v', 'n' }, { 'q', 'r', 'i', 't' } };

		for (int i = 0; i < ivan.length; i++) {
			for (int j = 0; j < ivan[i].length; j++) {
				if (ivan[i][j] == 'i' || ivan[i][j] == 'n') {
					if (i == 0 || i == 1) {
						upDown(i, j);
					}
					if (j == 0 || j == 3) {
						leftRight(i, j);
					}
					if (j == 0 && (i == 0 || i == 1)) {
						diag1(i, j);
					}
					if (j == 0 && (i == 3 || i == 4)) {

						diag2(i, j);
					}
				}
			}
		}
		System.out.println(br);
	}

	public static void upDown(int x, int y) {
		if (ivan[x][y] == 'i') {
			if (ivan[x + 1][y] == 'v' && ivan[x + 2][y] == 'a' && ivan[x + 3][y] == 'n') {
				br++;
			}
		} else if (ivan[x + 1][y] == 'a' && ivan[x + 2][y] == 'v' && ivan[x + 3][y] == 'i') {
			br++;
		}
	}

	public static void leftRight(int x, int y) {
		if (ivan[x][y] == 'i') {
			if (ivan[x][y + 1] == 'v' && ivan[x][y + 2] == 'a' && ivan[x][y + 3] == 'n') {
				br++;
			} else if (ivan[x][y + 1] == 'a' && ivan[x][y + 2] == 'v' && ivan[x][y + 3] == 'i') {
				br++;
			}
		}
	}

	public static void diag1(int x, int y) {
		if (ivan[x][y] == 'i') {
			if (ivan[x + 1][y + 1] == 'v' && ivan[x + 2][y + 2] == 'a' && ivan[x + 3][y + 3] == 'n') {
				br++;

			} else if (ivan[x + 1][y + 1] == 'a' && ivan[x + 2][y + 2] == 'v' && ivan[x + 3][y + 3] == 'i') {
				br++;
			}
		}
	}

	public static void diag2(int x, int y) {
		if (ivan[x][y] == 'i') {
			if (ivan[x - 1][y + 1] == 'v' && ivan[x - 2][y + 2] == 'a' && ivan[x - 3][y + 3] == 'n') {
				br++;
			} else if (ivan[x - 1][y + 1] == 'a' && ivan[x - 2][y + 2] == 'v' && ivan[x - 3][y + 3] == 'i') {
				br++;
			}

		}
	}

}
