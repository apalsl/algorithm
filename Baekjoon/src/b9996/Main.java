package b9996;

import java.util.Scanner;

public class Main {

	static String p;
	static int star = 0;
	static char[] arr1 = new char[100];
	static char[] arr2 = new char[100];
	static int front, back = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		p = sc.next();
		
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '*') {
				star = i;
			}
		}
		
		for(int i=0; i<star; i++) {
			arr1[i] = p.charAt(i);
			front++;
		}
		for(int i=star+1; i<p.length(); i++) {
			arr2[back] = p.charAt(i);
			back++;
		}
		
//		for(int i=0; i<p.length(); i++) {
//			if(arr1[i] != ' ') {
//				System.out.print(arr1[i] + " ");
//			}
//		}
//		System.out.println();
//		for(int i=0; i<p.length(); i++) {
//			if(arr2[i] != ' ') {
//				System.out.print(arr2[i] + " ");
//			}
//		}
		
		
		for(int t=0; t<n; t++) {
			String word = sc.next();
			
			int q = front+back;
			if(q > word.length()) {
				System.out.println("NE");
				continue;
			}
			
			if(isGood(word)) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
			
		}
		
		
	}

	private static boolean isGood(String s) {
		for(int i=0; i<front; i++) {
			char c = s.charAt(i);
			if(c != arr1[i]) {
				return false;
 			}
		}
		
		
		for(int i=0; i<back; i++) {
			char c =  s.charAt(s.length()-1-i);
			if(arr2[back-i -1 ] != c) {
				return false;
			}
		}
		
		
		return true;
	}
}
