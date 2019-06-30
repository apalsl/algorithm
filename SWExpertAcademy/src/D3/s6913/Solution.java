package D3.s6913;

import java.util.Scanner;

public class Solution {
	
	static int MAX_VALUE = 22;
	static int arr[] = new int[MAX_VALUE];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t =  sc.nextInt();
		
		for(int test_case = 1; test_case<=t; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			for(int i=0; i<MAX_VALUE; i++) {
				arr[i] = -1;
			}
			
			for(int i=1; i<=N; i++ ) {
				int count = 0;
				for(int j=0; j<M; j++) {
					int value = sc.nextInt();
					if(value == 1) {
						arr[i] = ++count;
					}
				}
			}
			
			int MAX = 0;
			int count = 0;
			for(int i=1; i<MAX_VALUE; i++) {
				if(arr[i] > MAX) {
					MAX = arr[i];
				} 
			}
			
			for(int i=1; i<MAX_VALUE; i++) {
				if (arr[i] == MAX) {
					count++;
				}	
			}
			
			if(count>0) {
				System.out.println("#"+test_case + " " + count + " " + MAX);	
			}  else {
				System.out.println("#"+test_case + " " + N + " " + MAX);
			}
			
		}
		
	}
}
