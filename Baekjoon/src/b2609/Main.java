package b2609;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int nm = n * m;
		int temp = 0;
		//true
		while(n != 0) {
			//n < m,   n = m 
			if ( n < m ) {
				temp = n;
				n = m;
				m = temp;
			}
			// else n = n-m
			n = n - m;
		}
		
		//GCD
		System.out.print(m + " ");
		
		//LCM
		System.out.println(nm/m);
	
	}

}
