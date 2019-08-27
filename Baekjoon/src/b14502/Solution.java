package b14502;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int N,M, COUNT;
	static int[][] map = new int[51][51];
	static List<Bug> bugList = new ArrayList<Bug>();
	static List<Go> goList = new ArrayList<Go>();
	static boolean[][] chk = new boolean[51][51];
	static int[][] backup = new int[51][51];
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	 public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		COUNT = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]  = sc.nextInt();
				if(map[i][j] == 2) {
					bugList.add(new Bug(i, j));
				} else if (map[i][j] == 0)  {
					goList.add(new Go(i,j));
					COUNT++;
				} else  if (map[i][j] == 1)   {
					map[i][j]  = -1;
				}
			}
		}
		
		System.out.println(solve());
	}
	 
	static Queue<Bug> que = new LinkedList<Bug>();
	private static int solve() {
		int result = -100;
		int[] arr = new int[3];
		
		combination(arr, 0, COUNT, 3, 0);
		
		for(int[] combi : arrList) {
			for(int i=0; i<N; i++)  {
				for(int j=0; j<M; j++)  {
					backup[i][j] =  map[i][j];
					chk[i][j] =  false;
				}
			}
			
			que.clear();
			for(int i=0; i<3;  i++) {
				Go go = goList.get(combi[i]);
				chk[go.x][go.y] = true;
				backup[go.x][go.y] = -1;
			}
			for(int i=0; i<bugList.size(); i++)   {
				que.add(bugList.get(i));
			}
			
			int max = bfs();
			if(max > result)  {
				result = max;
			}
		}
		
		return result;
	}

	private static int bfs() {
		int sum = 0;
		
		while(!que.isEmpty())  {
			Bug bug = que.poll();
			int x = bug.x;
			int y = bug.y;
			
			for(int i=0; i<4; i++) {
				int qx = x + dx[i];
				int qy = y + dy[i];
				if(qx >= N || qx < 0 || qy < 0 || qy >= M) continue;
				if(backup[qx][qy] == -1 || chk[qx][qy] == true) continue;
				
				chk[qx][qy] = true;
				backup[qx][qy] = backup[x][y] +1 ;
				que.add(new Bug(qx,qy));
			}
		}
		
		for(int i=0; i<N; i++)  {
			for(int j=0; j<M; j++)  {
				if(backup[i][j] == 0) {
					sum++;
				}
			}
		}
		
		return sum;
	}

	static List<int[]> arrList = new ArrayList<>();
	
	private static void combination(int[] arr, int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			arrList.add(arr.clone());
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
	
	static class Go {
		int x, y;
		public Go(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
