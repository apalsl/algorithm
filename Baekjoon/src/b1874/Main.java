package b1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	static char c;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Stack<Integer> stack = new Stack<Integer>();
		int cnt = 0;
		for(int i=0; i<n; i++) {
			int t = sc.nextInt();
			
			if(t < cnt) {
				for(int j=0; j<t; j++) {
					stack.push(++cnt);
					c += '+';
				}
				stack.pop();
				c += '-';
			} else {
				boolean b = false;
				while (!stack.isEmpty() ) {
					int a = stack.pop();
					c += '-';
					if(a == cnt) {
						b = true;
					}
				}
				
				if(!b) {
					System.out.println("NO");
					return;
				}
			}
			
		}
		
		
		
		
		
	}
	
}
