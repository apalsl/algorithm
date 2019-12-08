package b1152;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		if(s.equals(" ")) {
			System.out.println(0);
			return;
		}

		int count = 0;
		for(int i=0; i<s.length(); i++) {
			char a = s.charAt(i);
			if(a == ' ' && i != 0 &&  i != s.length()-1) {
				count++;
			}
		}
		System.out.println(count+1);
	}
}
