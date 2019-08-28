package b17141;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N,M,count;
	static int MAX = 2500;
	static int MIN = -2500;
	static int map[][] = new int[50][50];
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static List<Bug> bugList = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if  (map[i][j] == 2) {
					bugList.add(new Bug(i,j));
				} else if (map[i][j] ==  0) {
					count++;
				} else if (map[i][j] == 1) {
					map[i][j] = -5;
				}
			}
		}
		
		System.out.println(solve());
	}
	
	
	
	static List<int[]> combiList = new ArrayList<int[]>();
	static int[][] backup = new int[50][50];
	static boolean[][] chk = new boolean[50][50];
	static Queue<Bug> que = new LinkedList<Main.Bug>();
	
	private static int solve() {
		int result = 2500;
		
		int[] array = new int[M];
		
		combination(array,0,bugList.size(),M,0);
		
		for(int[] combi : combiList) {
			
			que.clear();
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					backup[i][j] = map[i][j];
					chk[i][j] = false;
				}
			}
			
			for(int i=0; i<combi.length; i++) {
				Bug bug = bugList.get((combi[i]));
				backup[bug.x][bug.y] = 0;
				chk[bug.x][bug.y] = true;
				que.add(bug);
			}
			
			int value = bfs(); //  4  5  6   7  , -1  -1, -1,  -1
			
			if(value  < result) {
				result = value;
			}
		}
		
		
		if(MAX == result) {
			return -1;
		}
		
		
		return result;
	}

	private static int bfs() {
		int cnt = count;
		
		while(!que.isEmpty())  {
			Bug b = que.poll();
			int x = b.x;
			int y = b.y;
			
			for(int i=0; i<4; i++) {
				int qx = x + dx[i];
				int qy = y + dy[i];
				
				if(qx < 0 || qx >=N || qy < 0 || qy >=N) continue;
				if(chk[qx][qy] == true || backup[qx][qy] == -5) continue;

				
				chk[qx][qy] = true;
				backup[qx][qy] = backup[x][y]+1;
				que.add(new Bug(qx,qy));
//				for(int z=0; z<N; z++) {
//					for (int c=0; c<N; c++) {
//						System.out.print(backup[z][c] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("------------------------");
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(backup[i][j] == 0 && chk[i][j] == false) {
					return 2500;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(backup[i][j]  > max) {
					max = backup[i][j];
				}
			}
		}
		
		
		return max;
	}

	private static void combination(int[] arr, int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			combiList.add(arr.clone());
			return;
		}
		
		if(index == n) {
			return;
		}
		
		arr[arrSize] = index;
		combination(arr, arrSize+1, n, r, index+1);
		combination(arr, arrSize, n, r, index+1);
		
	}

	static class Bug {
		int x, y;
		
		public Bug(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
