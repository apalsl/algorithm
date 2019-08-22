package D3.s3431;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		int t = sc.nextInt();
		
		for(int T=1; T<=t; T++) {
			
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			
			int result=-1;
			if (X < L) {
				result = -(X-L);
			} else if (U > X) {
				result = 0;
			}
			
			System.out.println("#" + T+ " " + result);
			
			
		}
		
	}
}
