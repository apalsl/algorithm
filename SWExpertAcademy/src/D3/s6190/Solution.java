package D3.s6190;

import java.util.Scanner;

public class Solution {
	static int arr[] = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			
			for(int i=0; i<n; i++) {
				arr[i] = 0;
			}
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = -1;
			for(int i=0; i<n-1; i++) {
				test : for(int j=i+1; j<n; j++) {
					int b = arr[i] * arr[j]%10;
					int a = arr[i] * arr[j]/10;
					while(a > 0) {
						int c = a%10;
						if (c > b) {
							continue test;
						}
						b = c;
						a = a/10;
					}
					if (max < arr[i] * arr[j]) {
						max = arr[i] * arr[j];
					}
				}
			}
			System.out.println("#" + test_case + " "+ max);
		}
	}
}
