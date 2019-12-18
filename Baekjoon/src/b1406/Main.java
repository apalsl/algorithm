package b1406;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int n = sc.nextInt();
		
		LinkedList<Character> list = new LinkedList<Character>();
		
//		for(int i=0; i<str.length(); i++) {
//			list.add(str.charAt(i));
//		}
//		
		for(char c :str.toCharArray()) {
			list.add(c);
		}
		
		int pointer = str.length();
		for(int i=0; i<n; i++) {
			switch (sc.next().charAt(0)) {
			case 'P':
				if(pointer > list.size()) {
					list.add(sc.next().charAt(i));
				} else {
					list.add(pointer, sc.next().charAt(0));	
				}
				pointer++;
				break;
			case 'L':
				if(pointer > 0) {
					pointer--;	
				}
				break;
			case 'D':
				if(pointer != list.size()) {
					pointer++;	
				}
				break;
			case 'B':
				if(pointer > 0) {
					list.remove(--pointer);
				}
				break;
			default:
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(char c : list) {
			sb.append(c);
		}
		
		System.out.print(sb);
		
	}
}
