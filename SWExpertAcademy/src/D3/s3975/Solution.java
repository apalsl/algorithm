package D3.s3975;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int T =1; T<=t; T++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			
			int alice = A*D;
			int bob = C*B;
			System.out.print("#"+T+" ");
			if(alice>bob) {
				System.out.println("ALICE");
			}else if(bob>alice) {
				System.out.println("BOB");
			}else {
				System.out.println("DRAW");
			}
			
		}
	}
}


