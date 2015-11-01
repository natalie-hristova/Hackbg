package Natiii;

import java.util.Scanner;

public class Zad1 {
	public static void main(String[] args)  {
		int tmp = 0, br = 0;
		String symbol;
		System.out.println("Enter x and y:");
		Scanner Scanner = new Scanner(System.in);
		int x = Scanner.nextInt();
		int y = Scanner.nextInt();
		
		System.out.println("Enter the symbols:");
		Scanner Sc = new Scanner(System.in);
		String s = Sc.nextLine();
		// System.out.println(s+ s.length());

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '~')
				br++;
			tmp = br % 2;
			if((tmp==0 && c == '^')||(tmp==1 && c == 'v' )){
				y--;
		} else if ((tmp==0 && c == 'v')||(tmp==1 && c == '^' )){
			y++;
		} else if ((tmp==0 && c == '>')||(tmp==1 && c == '<' )){
			x++;
		} else if ((tmp==1 && c == '>')||(tmp==0 && c == '<' ))
			x--;
		
		}
		System.out.println("("+x +","+ y + ")");
	}
}
