package b7569;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,H;
	static int[][][] map = new int[101][101][101];
	static boolean[][][] chk = new boolean[101][101][101];
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		H = Integer.valueOf(st.nextToken());
		
		
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();
//		H = sc.nextInt();
		
		int T = 0, F = 0;
			
		for(int i=0; i<H; i++) {
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					int value = Integer.valueOf(st.nextToken());
					map[i][j][k] = value;
					if(value == 1) {
						T++;
						que.add(new Point(i,k,j));
					} else if(value == -1){
						F++;
					}
				}
			}
		}
		
		if(T+F == H*M*N) {
//			System.out.println("0");
			bw.write("0\n");
//			return;
		} else {
//			System.out.println(bfs());
			bw.write(bfs()+"\n");
		}
		
		br.close();
		bw.close();
		
	}
	
	static int count = 0;
	
	private static int bfs() {
		while(!que.isEmpty()) {
			Point p = que.poll();
			int h = p.h;
			int x = p.x;
			int y = p.y;
			
			//check high down
			if(h-1 >= 0) {
				if (map[h-1][y][x] == 0) {
					map[h-1][y][x] = 1;
					chk[h-1][y][x] = true;
					tempQue.add(new Point(h-1,x,y));
				}
			}
			if(h+1 < H) {
				if (map[h+1][y][x] == 0) {
					map[h+1][y][x] = 1;
					chk[h+1][y][x] = true;
					tempQue.add(new Point(h+1,x,y));
				}
			}
			
			for(int d = 0; d<4; d++) {
				int qx = x + dx[d];
				int qy = y + dy[d];
				
				if(qx < 0 || qx >= N || qy < 0 || qy >= M) continue;
				if(chk[h][qy][qx] == true) continue;
				if(map[h][qy][qx] == 1 || map[h][qy][qx] == -1) continue;
				
				map[h][qy][qx] = 1;
				chk[h][qy][qx] = true;
				
				tempQue.add(new Point(h,qx,qy));
			}
			
			if(que.isEmpty()) {
				if(!tempQue.isEmpty()) {
					count++;
					que.addAll(tempQue);
					tempQue.clear();
					
//					for(int i=0; i<H; i++) {
//						for(int j=0; j<M; j++) {
//							for(int k=0; k<N; k++) {
//								chk[i][j][k] = false;
//							}
//						}
//					}
					
//					print();
				} else {
					break;
				}
			}
		}

		
		int chkZero = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					if (map[i][j][k] == 0) {
						chkZero++;
					}
				}
			}
		}
		
		if(chkZero != 0) {
			return -1;
		} else {
			return count;
		}
		
		
	}

	private static void print() {
		System.out.println("--------------------");
		for(int i=0; i<H; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					System.out.print(map[i][j][k] + " ");
				}
				System.out.println();
			}
		}
	}

	static Queue<Point> que = new LinkedList<Point>();
	static Queue<Point> tempQue = new LinkedList<Point>();
	static class Point {
		int x,y,h;
		public Point(int h, int x, int y) {
			this.h = h;
			this.x = x;
			this.y = y;
		}
	}
}
