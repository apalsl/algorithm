package b2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] map;
	static boolean[][] chk;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int N,M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		 N = sc.nextInt();
		 M = sc.nextInt();

		map = new int[N][M];
		chk = new boolean[N][M];


		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				chk[i][j] = false;
			}
		}
		
		chk[0][0] = true;
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
		
	}

	private static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		qx.add(x);
		qy.add(y);
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			chk[x][y] = true;
			
			for(int i=0; i<4; i++) {
				int a = x+dx[i];
				int b = y+dy[i];
				
				if(a>=0 && a<N && b>0 && b<M) {
					if(map[a][b] == 1 && chk[a][b] == false) {
						qx.add(a);
						qx.add(b);
						chk[a][b] = true;
						map[a][b] = map[a][b]+1;
					}
					
				}
				
			}
			
			
			
		}
		
		
	}
}

