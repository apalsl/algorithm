package b17406;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//연구소3 작성중
public class Main {
	static int N, M, K;
	static int[][] map   = new int[50][50];
	static int[][] backup   = new int[50][50];
	static List<Turn> list = new ArrayList<Turn>();
	static int[] Dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] Dy = {0, -1, -1, -1, 0, 1, 1, 1}; 
	
	
	static class Turn{
		int r,c,s;
		public Turn(int r,  int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		for(int  i=0; i<N; i++) {
			for(int j=0; j<M; j++)  {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<K; i++) {
			list.add(new Turn(sc.nextInt()-1, sc.nextInt()-1,  sc.nextInt()));
		}
		
		System.out.println(solve());
		
	}
	
	static void TurnArray()  {
		
		

		for(int i=0;  i<list.size(); i++) {
			for(int j=1; j<=list.get(i).s; j++) {
				int r = list.get(i).r;
				int c = list.get(i).c;
				int s = list.get(i).s;
				System.out.print("r = "  + r  + "  c = " + c);
				System.out.println("   S  = "  + j);
				
				
				
				
				
				int temp = map[r-s][c-s];
				System.out.println("temp == " + temp);
				for(int x=0; x<s*2; x++) {
					map[r -s + x][c-s] = map[r -s + x+1][c-s];
				}
				for(int x=0; x<s*2; x++) {
					map[r+s][c-s+x] = map[r+s][c-s+x+1];
				}
				for(int x=0; x<s*2; x++) {
					map[r+s-x][c+s] = map[r+s-x-1][c+s];
				}
				for(int x=0; x<s*2; x++) {
					map[r-s][c+s-x] = map[r-s][c+s-x-1];
				}
				map[r-s][c-s+1] = temp;
				
				
				
				
				for(int w=0; w<N; w++) {
					for(int v=0; v<M; v++)  {
						System.out.print(map[w][v] + "  ");
					}
					System.out.println();
				}
				System.out.println("-----------------------------");
				
				
				
				
				
				
				
			}
		}
	}

	private static int solve() {
		int MIN = 0;
		backup = map;
		
		
		
		
		for(int  i=0; i<N; i++) {
			for(int j=0; j<M; j++)  {
				System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("==================================");
		
		TurnArray();
		
		for(int  i=0; i<N; i++) {
			for(int j=0; j<M; j++)  {
				System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}
		
		
		
//		for(int i=0;  i<N; i++) {
//			//init  Turn,  
//			
//			
//			int sum = 0;
//			for(int j=0; j<M; j++)  {
//				sum +=  map[i][j];
//			}
//			if(MIN  < sum) {
//				MIN = sum;
//			}
//		}
		
		
		return MIN;
	}
}
