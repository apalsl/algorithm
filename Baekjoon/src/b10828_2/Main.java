package b10828_2;

import java.util.Scanner;

public class Main {

	static int stack[] = new int[10001];
	static int point = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		while(n-->0) {
			switch (sc.next()) {
			case "push":
				stack[point] = sc.nextInt();
				point++;
				break;
			case "pop":
				if(point == 0) {
					System.out.println("-1");
				} else {
					System.out.println(stack[point-1]);
					point--;
				}
				break;
			case "top":
				if(point == 0) {
					System.out.println("-1");
				} else {
					System.out.println(stack[point-1]);
				}
				break;
			case "size":
				System.out.println(point);
				break;
			case "empty":
				if(point ==0) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
				break;
			default:
				break;
			}
		}
	}
	
}
