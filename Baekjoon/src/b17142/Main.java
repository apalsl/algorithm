package b17142;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N,M;
	static int[][] map = new int[51][51];
	static List<Bug> bug = new ArrayList<Bug>();
	static Queue<Bug> queue = new LinkedList<Bug>();	
	static int[] Dx = {0,1,0,-1};
	static int[] Dy = {1,0,-1,0};
	static int MAX_VALUE = 2_000_000_000;
	static class Bug {
		int x,y;
		Bug(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// X = N
	// Y = M
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					map[i][j] = 500;
					bug.add(new Bug(i,j));
				} else if (map[i][j] == 1) {
					map[i][j] = 100;
				}
			}
		}
		
		
		int[] array = new int[M];
		
		combination(array, 0, bug.size(), M, 0);
		boolean[][] chk = new boolean[51][51];
		for(int[] combi : list) {

			for(int i=0; i<combi.length; ++i) {
				System.out.println("X = " + bug.get(i).x + " Y = " + bug.get(i).y);
				queue.add(bug.get(i));
			}
			
			dfs(queue, chk);
		}
	}

	private static void dfs(Queue<Bug> queue, boolean[][] chk) {
		int[][] backup = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				backup[i][j] = map[i][j];
				chk[i][j] = false;
			}
		}
		
		roof : while(!queue.isEmpty()) {
			Bug b = queue.poll();
			int n = b.x;
			int m = b.y;
			
			for(int i=0; i<4; i++) {
				int dn = Dx[i] + n;
				int dm = Dy[i] + m;
				if(dn < 0 || dn >= N || dm < 0 || dm >= N) continue;
//				System.out.println(backup[dn][dm]);
				if(backup[dn][dm] == 100 || chk[dn][dm] == true) continue;
				if(backup[dn][dm] == 500) {
					if(!CheckArr(backup)) {
						break roof;
					}
				}
				
				backup[dn][dm] = backup[n][m]+1;
				chk[dn][dm] = true;
				queue.add(new Bug(dn,dm));
			}
		}
		
		
		int sum = 0;
		search : for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(backup[i][j] + " ");
				if(backup[i][j] == 0) {
					sum = -1; 
					break search;
				}
				if(backup[i][j] != 100 && backup[i][j] > sum) {
					sum = backup[i][j];
				} 
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------    " + sum );
	}
	
	private static boolean CheckArr(int[][] backup) {
		boolean search = true;
		search : for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(backup[i][j] != 0) {
					search = false;
				}
			}
		}
		return search;
	}

	static List<int[]> list = new ArrayList<int[]>();
	private static void combination(int[] array, int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			list.add(array.clone());
			return;
		}
		if(index == n) {
			return;
		}
		array[arrSize] = index;
		combination(array, arrSize+1, n, r, index+1);
		combination(array, arrSize, n, r, index+1);
	}

}
