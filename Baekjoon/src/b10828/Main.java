package b10828;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		while(n--> 0) {
			String str = sc.next();
			if("push".equals(str)) {
				stack.push(sc.nextInt());
			} else if ("top".equals(str)) {
				if(!stack.isEmpty()) {
					System.out.println(stack.peek());
				} else {
					System.out.println("-1");
				}
			} else if ("size".equals(str)) {
				System.out.println(stack.size());
			} else if ("empty".equals(str)) {
				if(stack.isEmpty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else if ("pop".equals(str)) {
				if(!stack.isEmpty()) {
				System.out.println(stack.pop());
				} else {
					System.out.println("-1");
				}
			}
		}
	}

}
