//package SWTest.b16236;
//
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Main {
//
//	static int map[][] = new int[21][21];
//	static boolean chk[][]  = new boolean[21][21];
//	static int a;
//	static int b;
//	static int xgo[] = {0,-1,0,1};
//	static int ygo[] = {-1,0,1,0};
//	static Queue<Integer> que;
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		for(int i=0; i<21; i++) {
//			for(int j=0; j<21; j++) {
//				map[i][j] = -1;
//			}
//		}
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				map[i][j] = sc.nextInt();
//				
//				if(map[i][j] <=2) {
//					chk[i][j] = true;
//				} else if(map[i][j] == 9) {
//					a = i;
//					b = j;
//				}
//			}
//		}
//		
//		
//		bfs(a,b);
//	
//	
//		
//		
//		
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				if(chk[i][j] == true && map[i][j] == 1) {
//					searchOne(i,j);
//				}
//			}
//		}
//	}
//	static int check = 0;
//	static void bfs(int a, int b){
//		for(int i=0; i<4; i++) {
//			int dx = xgo[i]+a;
//			int dy = ygo[i]+b;
//			
//			if(chk[dx][dy] == true && map[dx][dy] <=2) {
//				
//				if(map[dx][dy] == 1) {
//					map[dx][dy] = 20;
//					break;
//				}
//				
//				
//			}
//			
//		}
//		
//		
//	}
//}
