package D3.s6730;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int max = sc.nextInt();
			int up = 0;
			int down = 0;
			for(int i=0; i<n-1; i++) {
				int value = sc.nextInt();
				
				if (max < value && value-max > up) {
						up = value - max;	
				} else if (max > value && max - value > down){
						down = max - value;
				}
				max = value;
			}
			
			System.out.println("#"+t+" "+up+" " +down);
		}
	}
}
