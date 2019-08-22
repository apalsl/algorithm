package D3.s3408;

import java.util.Scanner;

public class Solution {
	static long s1 = 0, s2=0, s3=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long  t=  sc.nextInt();
	
		for(int T =1; T<=t; T++) {
			long n = sc.nextLong();
			s1 = (n*(n+1))/2;
			s2 = n*n;
			s3 = n*(n+1);
			System.out.println("#"+ T+ " " + s1+" "+ s2 +" "+ s3);
			
		}
		
		sc.close();
	}
}
