package b2941;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int count = 0;
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			
			if (cnt >= s.length())
				break;
			if(cnt + 1 >= s.length()) {
				count++;
				cnt++;
				continue;
			}
			
			char c = s.charAt(cnt);
			switch (c) {
			case 'c':
				if (s.charAt(cnt + 1) == '=' || s.charAt(cnt + 1) == '-') {
					cnt++;
				}
				break;
			case 'd':
				if (s.charAt(cnt + 1) == '-') {
					cnt++;
				} else if (cnt + 2 < s.length()) {
					if(s.charAt(cnt + 1) == 'z' && s.charAt(cnt + 2) == '=') {
						cnt += 2;
					}
				}
				break;
			case 'l':
				if (s.charAt(cnt + 1) == 'j') {
					cnt++;
				}
				break;
			case 'n':
				if (s.charAt(cnt + 1) == 'j') {
					cnt++;
				}
				break;
			case 's':
			case 'z':
				if (s.charAt(cnt + 1) == '=') {
					cnt++;
				}
				break;
			}
			count++;
			cnt++;
		}

	System.out.println(count);

}

}
