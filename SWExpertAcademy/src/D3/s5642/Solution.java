package D3.s5642;

import java.util.Scanner;

public class Solution {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			int n = sc.nextInt();
			int arr[] = new int[n+1];
			arr[0] = 0;
			for(int i=1; i<=n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = -999;
			 for(int i=2;i<=n;i++) {


				    if (arr[i-1] > 0 && arr[i] + arr[i-1] > 0) {
				        arr[i] += arr[i-1];
				    } 

				    if (max < arr[i]) {
				        max = arr[i];
				    }

				}


			
			System.out.println("#" + t + " " + max);
		}
	}
	
	
	
}
