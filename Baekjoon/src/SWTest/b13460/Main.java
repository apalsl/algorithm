package SWTest.b13460;

import java.util.Scanner;

public class Main {
	
	static short[] xplace = {-1,0,1,0};
	static short[] yplace = { 0,1,0,-1};
	static int R,R2;
	static int B,B2;
	static int zero, zeor2;
	static boolean[][] bool;
	static char[][] array;

	
	private static void dfs() {
		for(int i=0; i<xplace.length; i++) {
			int dx = R+xplace[i];
			int dy = R+yplace[i];
			
			if(array[dx][dy] == '.' && bool[dx][dy] == false) {
				switch (xplace[i]) {
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					break;
				}
			
			
			
				
				
			}
			
			
			
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int n2 = sc.nextInt();
		bool = new boolean[n][n2];
		array = new char[n][n2];
		for(int i =0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<n; j++) {
				bool[i][j] = false;
				array[i][j] = str.charAt(j);
				if(str.charAt(j) == 'R') {
					R = i;
					R2 = j;
				} else if (str.charAt(j) == 'B') {
					B = i;
					B2 = j;
				} else if (str.charAt(j) == 'O') {
					zero = i;
					zero = j;
				}
			}
		}
		
		dfs();
		
		
		for(int i =0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

}
