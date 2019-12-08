package b9093;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String word = sc.nextLine();
			slove(word);
		}

	}

	private static void slove(String word) {
		word += " ";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
				continue;
			}

			if (c == ' ') {
				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(c);
			} else {
				stack.push(c);
			}
		}
		System.out.println();
	}

}
