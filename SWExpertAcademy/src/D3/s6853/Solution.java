package D3.s6853;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int test_case = 1; test_case <=t; test_case++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int n = sc.nextInt();
			int arr[] = new int[3];
			for(int i=0; i<3; i++) {
				arr[i] = 0;
			}
			
			
			while(n-->0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				
				if(((x <= i && i <= x2) && (y == j || j == y2)) || 
						((y <=j && j<=y2) && (x == i || x2 == i))) {
					arr[1] +=1;
				} else if (x<i && i<x2 && y<j && j<y2) {
					arr[0] +=1;
				} else {
					arr[2] +=1;
				}
			}
			
			
			System.out.println("#"+test_case+ " "+arr[0]+ " "+ arr[1]+ " "+ arr[2]);
				
		}
		
		
	}
}
