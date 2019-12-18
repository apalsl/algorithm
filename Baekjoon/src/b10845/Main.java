package b10845;

import java.util.Scanner;

public class Main {

	static void push(int n) {
		que[point++] = n;
	}
	
	static void pop() {
		if(point == start) {
			System.out.println(-1);
		} else {
			System.out.println(que[start++]);	
		}
	}
	
	static void size() {
		System.out.println(point-start);
	}
	
	static void empty() {
		if(point == start) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
	}
	
	static void front() {
		if(point == start) {
			System.out.println(-1);
		} else {
			System.out.println(que[start]);			
		}
	}
	
	static void back() {
		if(point == start) {
			System.out.println(-1);
		} else {
			System.out.println(que[point-1]);
		}
	}
	
	static int start = 0;
	static int[] que;
	static int point = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		que = new int[n];
		for(int i=0; i<n; i++) {
			switch (sc.next()) {
			case "push":
				push(sc.nextInt());
				break;
			case "front":
				front();
				break;
			case "back":
				back();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "pop":
				pop();
				break;
			default:
				break;
			}
		}
	}
	
}
