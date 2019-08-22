package D3.s3376;

import java.util.Scanner;

public class Solution {

	static long[] arr = new long[102];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		
		for(int i=6; i<102; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		
		
		int t = sc.nextInt();
		for(int T=1; T<=t; T++) {
			int n = sc.nextInt();
			System.out.println("#"+T + " " + arr[n]);
			
			
		}
	}
	
}
