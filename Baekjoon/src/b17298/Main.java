package b17298;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		
		for(int i=0; i<n; i++) {
			stack.add(sc.nextInt());
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			temp.clear();
			temp.addAll(stack);
			list.clear();
			for(int j=0; j<n-1; j++) {
				list.add(temp.pop());
			}
			if(temp.peek() <Collections.max(list) ) {
				System.out.print(Collections.max(list));
			} else {
				System.out.print(-1);
			}
			
			if( i == n) {
				
			} else {
				System.out.print(" ");
			}
			

			
			
			
			
		}
//		
//		
		
		
		
		
		
	}
	
}
