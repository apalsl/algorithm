package D3.s3499;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			String arr[] = new String[n+1];
			String arr2[] = new String[n+1];
			arr[0] = "";
			arr2[0] = "";
			
			if(n%2==1) {
				for(int i=1; i<=n/2+1; i++) {
					arr[i] = sc.next();
				}	
			} else {
				for(int i=1; i<=n/2; i++) {
					arr[i] = sc.next();
				}
			}
			for(int i=1; i<=n/2; i++) {
				arr2[i] = sc.next();
			}
			
			
			System.out.print("#"+t+" ");
			if(n%2==1) {
				for(int i=1; i<=n/2+1; i++) {
					System.out.print(arr[i] + " ");
					if (i==n/2+1) {
						System.out.println();
					} else {
						System.out.print(arr2[i] + " ");
					}
				}
			} else {
				for(int i=1; i<=n/2; i++) {
					if(i==n/2) {
						System.out.println(arr[i] + " "+ arr2[i]);
					} else {
						System.out.print(arr[i] + " ");
						System.out.print(arr2[i] + " ");	
					}
				}
			}
			
		}
		
	}
}
