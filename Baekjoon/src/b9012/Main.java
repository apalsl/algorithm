package b9012;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			String s = sc.next().trim();
			
			if(isPass(s)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}

	private static boolean isPass(String ps) {
	
		int cnt = 0;
		for(int i=0; i<ps.length(); i++) {
			char c = ps.charAt(i);
			if(c == '(') {
				cnt++;
			} else {
				cnt--;
			}
			
			if(cnt < 0) {
				return false;
			}
		}
		return cnt == 0;
	}
	
}
