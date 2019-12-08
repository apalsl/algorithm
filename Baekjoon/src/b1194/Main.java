package b1194;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int map[][];
	static boolean chk[][] = new boolean[51][51];
	static int A,Z,a,z;
	
	static int[] dn = {1,0,-1,0};
	static int[] dm = {0,1,0,-1};
	
	static int SN, SM;
	
	public static void main(String[] args) {
		
		
		char Ac = 'A';
		char Zc = 'Z';
		char ac = 'a';
		char zc = 'z';
	
		A = Ac;
		Z = Zc;
		a = ac;
		z = zc;
		
	
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				char c = str.charAt(j);
				if(c == '.') {
					map[i][j] = 0;
				} else if (c =='#') {
					map[i][j] = -1;
				} else if (c == '0') {
					SN = i;
					SM = j;
					map[i][j] = 0;
				} else if (c == '1') {
					map[i][j] = 1;
				} else {
					map[i][j] = c;
				}
			}
		}
		
		System.out.println(solve());
	}


	static Queue<Point> que = new LinkedList<Point>();
	private static int solve() {

		chk[SN][SM] = true;
		que.add(new Point(SN,SM,0));
		
		return bfs();
	}
	
	
	static List<Integer> list = new ArrayList<Integer>();
	private static int bfs() {
		while(!que.isEmpty()) {
			
			Point p = que.poll();
			int n = p.x;
			int m = p.y;
			int t = p.t;
			
			
			for(int i=0; i<4; i++) {
				boolean b = false;
				int sn = n + dn[i];
				int sm = m + dm[i];
				
				
				if(sn < 0 || sn >= N || sm < 0 || sm >= M) continue;
				if(map[sn][sm] == -1 || chk[sn][sm] == true) continue;
				
				
				if(map[sn][sm] == 1) {
					return t;
				}
				
				
				if(map[sn][sm] >= a && map[sn][sm] <=z) {
					list.add(map[sn][sm]);
					b = true;
				} else if(map[sn][sm] >=A && map[sn][sm] <=Z) {
					for(Integer in : list) {
						if(in == map[sn][sm]+32) 
						b = true;
					}
				} else {
					b = true;
				}
				

				if(!b) continue;
				
				que.add(new Point(sn,sm,t+1));
				chk[sn][sm] = true;
				
			}
		}
		
		return -1;
		
	}


	static class Point {
		int x;
		int y;
		int t;
		public Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
		
	}

}
