package b1934;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t<=T; ++t) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int nm = n*m;
			int temp = 0;
			while(n != 0) {
				if (n < m) {
					temp = n;
					n = m;
					m = temp;
				}
				n = n -m;
			}
			
			System.out.println(nm/m);
			
		}

	}
	
}
