package D3.s7087;

import java.util.Scanner;

public class Solution {

	static int MAX_VALUE = 26;
	static boolean chk[]= new boolean[MAX_VALUE];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int test_case =1; test_case<=t; test_case++) {
			for(int i=0; i<MAX_VALUE; i++) {
				chk[i] = false;
			}
			
			int n = sc.nextInt();
			sc.nextLine();
			while(n-- >0) {
				String str = sc.nextLine();
				str = str.trim();
				chk[str.charAt(0)-65] = true;	
				
			}
			
			int count =0;
			for(int i=0; i<MAX_VALUE; i++) {
				if(chk[i] == true) {
					count++;
				} else {
					break;
				}
			}
			
			System.out.println("#" + test_case + " "+ count);
		}
	}
}
