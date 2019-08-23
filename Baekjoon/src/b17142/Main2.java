package b17142;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {

	static int N, M;
	static int[][] map = new int[51][51];
	static boolean[][] chk = new boolean[51][51];
	static List<Bug> list = new ArrayList<Bug>();
	static Queue<Bug> queue = new LinkedList<Bug>();
	static int count = 0;
	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
	
	
	
	
	static class Bug {
		int x, y;
		public Bug(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					list.add(new Bug(i,j));
				} else if (map[i][j] == 0) {
					count++;
				} else if (map[i][j] == 1) {
					map[i][j] = -5;
				}
			}
		}
		
		
		System.out.println(solve());
	}

	private static int solve() {
		int max = 5000;

		int[] array = new int[M];
		combination(array,0,list.size(), M, 0);
		
		for(int[] combi : arrlist) {
			
			
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					back[i][j] = map[i][j];
					chk[i][j] = false;
				}
			}
			
			for(int i=0; i<M; i++) {
				chk[list.get(combi[i]).x][list.get(combi[i]).y] = true;
				back[list.get(combi[i]).x][list.get(combi[i]).y] = 0;
				queue.add(list.get(combi[i]));
//				System.out.println(list.get(combi[i]));
			}

			
			
			int result = bfs();
//			System.out.println("result = " + result);
			if (result < max) {
				max = result;
			}
			queue.clear();
			
		}
		
	
		if (max == 5000) {
			return -1;
		}
		
		return max;
	}

	static int[][] back = new int[51][51];
	
	private static int bfs() {
		int cnt = count;

		if (cnt == 0) {
			return 0;
		}
		
		while(!queue.isEmpty() && cnt > 0) {
			Bug b = queue.poll();
//			System.out.println("bug = " + b.x + "  " + b.y);
			int n = b.x;
			int m = b.y;
			
			for(int i=0; i<4; i++) {
				int qx = n + dx[i];
				int qy = m + dy[i];
				if(qx < 0 || qx >= N || qy < 0 || qy >= N) continue;
				if(chk[qx][qy] == true || back[qx][qy] == -5) continue;
				if(back[qx][qy] == 0) {
					cnt--;
				}
				chk[qx][qy] = true;
				back[qx][qy] = back[n][m] + 1;
				queue.add(new Bug(qx,qy));
//				System.out.println("----------------------------");
//				for(int j=0; j<N; j++) {
//					for (int k=0; k<N; k++) {
//						System.out.print(back[j][k]+ " ");
//					}
//					System.out.println();
//				}
			}
		}
		
		if(cnt > 0) {
			return 10000;
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (back[i][j] > sum) {
					sum = back[i][j];
				}
			}
		}
//		System.out.println("sum = " + sum);
		
		
		return sum;
		
		
	}

	static List<int[]> arrlist = new ArrayList<int[]>();
	private static void combination(int[] arr, int arrSize , int n, int r, int index) {
		if (arrSize == r) {
			arrlist.add(arr.clone());
			return;
		}
		
		if(index == n) {
			return;
		}
		
		arr[arrSize] = index;
		combination(arr, arrSize+1, n, r, index+1);
		combination(arr, arrSize, n, r, index+1);
	}
	
	
}
