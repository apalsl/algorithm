package b17413;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();

		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '<') {
				for(int j=stack.size(); j>0; j--) {
					System.out.print(stack.pop());
				}
				System.out.print(c);
				i++;
				while(true) {
					c = s.charAt(i);
					System.out.print(c);
					
					if(c == '>') {
						break;
					} 
					i++;
				}
			} else if(c ==' ') {
				while(!stack.isEmpty()) {
					char  ch = stack.pop();
					System.out.print(ch);
				}
				System.out.print(" ");
			} else {
				stack.add(c);
			}
		}
		
		while(!stack.isEmpty()) {
			char  ch = stack.pop();
			System.out.print(ch);
		}
		
		
	}
	
	

}
