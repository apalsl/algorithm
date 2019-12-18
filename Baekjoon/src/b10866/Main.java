package b10866;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Deque<Integer> dque = new LinkedList<Integer>();
		
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			
			switch (sc.next()) {
			case "push_front":
				dque.addFirst(sc.nextInt());;
				break;
			case "push_back":
				dque.addLast(sc.nextInt());
				break;
			case "pop_front":
				if(dque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(dque.pollFirst());	
				}
				break;
			case "pop_back":
				if(dque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(dque.pollLast());
				}
				break;
			case "size":
				System.out.println(dque.size());
				break;
			case "empty":
				if(dque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				if(dque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(dque.peekFirst());	
				}
				break;
			case "back":
				if(dque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(dque.peekLast());	
				}
				break;
			default:
				break;
			}
		}
		
	}
}
