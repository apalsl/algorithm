package D3.s6853;

import java.util.Scanner;

public class Solution {
	static int arr[] = new int[3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			
			for(int i=0; i<3; i++) {
				arr[i] = 0;
			}
			
			int n = sc.nextInt();
			while(n-->0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				
				if (x <i && x2>i && y<j && y2 >j){
					arr[0] +=1;
				} else if (x > i || x2 <i && y>j || y2<j) {
					arr[2] +=1;
				} else if ((i>x && i<x2 && y==j || y2==j) ||
						(j>y && j<y2 && x==i || x2==i)) {
					arr[1] +=1;
				}  
			}
			
			System.out.println("#" + t+ " "+arr[0]+" "+arr[1] + " " + arr[2]);
			
		}
	}
}
