package D3.s5948;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int test_case =1; test_case<=t; test_case++) {
			int[] arr = new int[7];
			
			for(int i=0; i<7; i++) {
				arr[i] = sc.nextInt();
			}
			
			combination(arr, 0, 7, 3, 0);
			
		}
		
		
		
	
	}

	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			print(arr, index);
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}// end combination()

	public static void print(int[] arr, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println("");
	}

}
