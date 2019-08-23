package D3.s3456;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(a == c) {
				a = b;
			} else if(a==b) {
				a = c;
			}
			System.out.println("#"+t+" "+a);
		}
		
		
	}
}
