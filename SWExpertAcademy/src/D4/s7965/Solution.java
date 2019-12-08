//package D4.s7965;
//
//import java.math.BigInteger;
//import java.util.Scanner;
//
//public class Solution {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		
//		for(int test_case = 1; test_case<=T; test_case++) {
//			int n = sc.nextInt();
//			BigInteger result=0;
//			for(int i=1; i<=n; i++) {
//				int m = 1;
//				BigInteger count =1;
//				while(m<=i) {
//					count *= i;
//					m++;
//				}
//				result += count; count =0;
//				
//			}
//			
//			
//			System.out.println("#"+test_case+" " +result%100000000);
//			
//		}
//	}
//}
