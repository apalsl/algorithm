package D3.s6718;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		a : for(int i=1; i<=T; i++) {
			int n = sc.nextInt();
			int cnt = 0;
			int value = 100;
			while(cnt<5) {
				if(n < value) {
					System.out.println("#"+i + " "+cnt);
					continue a;
				} 
				value*=10;
				cnt++;
			}
			System.out.println("#"+i + " "+5);
		}
	}
}
