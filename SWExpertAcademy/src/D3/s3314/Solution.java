package D3.s3314;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int  T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int count =0;
			for(int i=0; i<5; i++) {
				int score = sc.nextInt();
				
				if (score>40) {
					count +=score;
				} else {
					count +=40;
				}
			}
			System.out.println("#"+t+ " " + count/5);
		}
	}
}
