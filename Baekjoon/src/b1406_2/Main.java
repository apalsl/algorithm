package b1406_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		String str = sc.next();
		int n = sc.nextInt();
		
		for(int i=0; i<str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		for(int i=0; i<n; i++) {
			char c = sc.next().charAt(0);
			switch (c) {
			case 'L':
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
				break;
			case 'D':
				if(!right.isEmpty()) {
					left.push(right.pop());
				}
				break;
			case 'B':
				if(!left.isEmpty()) {
					left.pop();
				}
				break;
			case 'P':
				left.push(sc.next().charAt(0));
			default:
				break;
			}
			
		}
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		while(!right.isEmpty()) {
			System.out.print(right.pop());
		}
		
	}

}
