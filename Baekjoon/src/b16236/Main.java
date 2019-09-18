package b16236;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 첫 아기상어크기 2
// 1초에 상하좌우
// 큰물고기 지나가지 못함, 나머지칸 가능
// 자신보다 작은거산 먹음, 같은것 먹을수없으나 통과가능
// 먹을게없으면 엄마한테 요청
// 1마리면 먹으러감
// 1마리보다 많으면 젤 가까운애 먹음
// 거리는 칸의 개수가 최솟값
// 많으면 가장 위에 물고기, 그다음 왼쪽
//이동과 동시에 먹음, 먹으면 크기 +1
// 요청하기 전ㅋ까지 몇마리나 먹는지


public class Main {

	static List<Shark> sList = new ArrayList<Shark>();
	static int N;
	static int Fx,Fy;
	static int[] Dx = {0, -1 , 0 , 1};
	static int[] Dy = {-1, 0 , 1 , 0};
	static int[][] map = new int[21][21];
	static int[][] backup = new int[21][21];
	static boolean[][] chk = new boolean[21][21];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				backup[i][j] = 0;
				chk[i][j] = false;
				if(map[i][j] == 9) {
					sList.add(new Shark(i,j,map[i][j]));
				}
			}
		}
		
		System.out.println(solve());
	}
	
	static Queue<Shark> que = new LinkedList<Main.Shark>();
	
	private static int solve() {
		int result = 0;
		
		int count = 1;
		for(int i=0; i<sList.size(); i++) {
				que.add(sList.get(i));
				bfs();
		}
		int min = 0;
		int max = 20000000;
		
		for(int i=0; i<sList.size(); i++) {
			if (sList.get(i).size == count) {
				min = backup[sList.get(i).x][sList.get(i).y];
			}
			if(min < max) {
				max = min;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				backup[i][j] = 0;
			}
//			System.out.println();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(backup[i][j] + " ");
			}
			System.out.println();
		}
		
		
		return result;
	}

	private static void bfs() {
		while(!que.isEmpty()) {
			Shark s = que.poll();
			int x = s.x;
			int y = s.y;
			
			for(int i=0; i<4; i++) {
				int qx = x + Dx[i];
				int qy = y + Dy[i];
				
				if(qx < 0 || qx >= N || qy < 0 || qy >= N ) continue;
//				System.out.println("map = " + map[qx][qy] + "  szie = " + s.size);
				if(map[qx][qy] > s.size || chk[qx][qy] == true) continue;
//				System.out.println("aaaa");
				if(map[qx][qy] == 0) {
					backup[qx][qy] = backup[x][y]+1;
					chk[qx][qy] = true;
					que.add(new Shark(qx,qy, s.size));
				} else if (map[qx][qy] != 0 && map[qx][qy] < s.size) {
					backup[qx][qy] = backup[x][y]+1;
					chk[qx][qy] = true;
				}
			}
		}
		
	}

	static class Shark {
		int x,y,size;
		public Shark(int x, int y, int s) {
			this.x = x;
			this.y = y;
			this.size = s;
		}
	}
}
