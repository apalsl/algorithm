package b10799;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		
		int cnt = 0;
		int result = 0;
		
		for(int i=0; i<s.length(); i++) {
			
			char c = s.charAt(i);
			
			if(c == '(') {
				cnt++;
			} else if(c == ')') {
				cnt--;
				result += cnt;
			}
		}
		
		System.out.println(result);
		
	}
}
