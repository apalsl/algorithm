package D3.s6900;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String[] str = new String[N+M];
			int[] arr = new int[N];
			int[] arr2 = new int[N];
			
			for(int i=0; i<N; i++) {
				int chk = 0;
				str[i] = sc.next();
				arr[i] = sc.nextInt();
				
				for(int j=0; j<8; j++) {
					if( str[i].charAt(j) != '*') {
						chk +=1;
					}
				}
				arr2[i] = chk;
			}
			
			for(int i=N; i<M+N; i++) {
				str[i] = sc.next();
			}
			
			
			int money = 0;
			for(int i=0; i<N; i++) {
				
				for(int j=0; j<M; j++) {
					int cnt =0;
					for(int k=0; k<8; k++) {
						if (str[i].charAt(k) == str[N+j].charAt(k)) {
							cnt +=1;
						}
					}
					
					if (arr2[i] == cnt) {
						money += arr[i];
					}
					
				}
			}
			
			System.out.println("#"+t+" "+money);
			
			
		}
	}
}
