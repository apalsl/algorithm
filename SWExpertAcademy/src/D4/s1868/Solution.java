package D4.s1868;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =  sc.nextInt();
		
		for(int test_case =1; test_case<=t; test_case++) {
			int n =sc.nextInt();
			int arr[][] = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String str = sc.next();
				for(int j=0; j<n; j++) {
					char c = str.charAt(j);
					switch (c) {
					case '.':
						arr[i][j] = 10;
						continue;
					case '*':
						arr[i][j] = -1;
						continue;
					}
				}
			}
			
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
			
		}
	}

}
