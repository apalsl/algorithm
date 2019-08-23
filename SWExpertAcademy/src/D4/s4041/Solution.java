package D4.s4041;

import java.util.Scanner;

//시작 10시 10분
public class Solution {
	
	static int map[][];
	static int x;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			x = sc.nextInt();
			
			map = new int[n][n];
//			boolean chk[][] = new boolean[n][n];
			int result = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
//					chk[i][j] = false;
				}
			}
			
			
			
			test : for(int i=0; i<n; i++) {
				int chk=0;
				int upcheck = 0;
				int downcheck = 0;
				for(int j=0;j<n-1;j++) {
					chk++;
					if(map[i][j] > map[i][j+1] && map[i][j] - map[i][j+1] != 1) {
						continue test;
					} else if (map[i][j] < map[i][j+1] && map[i][j+1] - map[i][j] != 1) {
						continue test;
					}
					
					if (j==0 && map[i][j] < map[i][j+1] && x>=1) {
						continue test;
					} else if (j == n-2 && map[i][j] > map[i][j+1] && x>=1) {
						continue test;
					} else if (j == n-2 && map[i][j] < map[i][j+1] && chk <x) {
						continue test;
					} else if (map[i][j] < map[i][j+1] && chk < x){
						continue test;
					}
				
					if (j == n-2 && chk >= x-1) {
						result++;
					}
					
					
					
					
				}
			}
			
			System.out.println(result);
			
		}
	}
	
	
	
}
