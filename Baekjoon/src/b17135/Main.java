package b17135;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, D;
	static int[][] map = new int[16][16];
	static int[][] backup = new int[16][16];
	static boolean[][] chk = new boolean[17][17];

	static int[] Dx = { 0, 1, 0, -1 };
	static int[] Dy = { 1, 0, -1, 0 };

	static class Point {
		int n, m;

		public Point(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		System.out.println(solve());
	}

	static Queue<Point> que = new LinkedList<Main.Point>();
	static Queue<Point> tempque = new LinkedList<Main.Point>();

	static void print() {
		for (int vv = 0; vv < N; vv++) {
			for (int cc = 0; cc < M; cc++) {
				System.out.print(backup[vv][cc] + " "); 
			}
			System.out.println();
		}
	}
	
	private static int solve() {
		int result = -1000;

		int[] array = new int[3];
		combination(array, 0, M, 3, 0);

		for (int[] combi : combiList) {

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					backup[i][j] = map[i][j];
					chk[i][j] = false;
				}
			}

			for (int i = 0; i < N; i++) {
					
				
				for (int b = 0; b < M; b++) {
						check[N][b] = false;
				}
				
					print();
					System.out.println("==========================================");

				for (int j = 1; j <= D; j++) {
					for (int c = 0; c < combi.length; c++) {
						
						for (int si = 0; si < N; si++) {
							for (int bal = 0; bal < M; bal++) {
								chk[si][bal] = false;
							}
						}
						
						que.add(new Point(N, combi[c]));
						Point p = null;
						if(!check[N][combi[c]]) {
							p = bfs(j);
						}
						que.clear();
						tempque.clear();
						pointList.clear();
						
						if (p == null) {
							continue;
						} else {
							check[N][combi[c]] = true;
							if(!check[p.n][p.m]) {
								backup[p.n][p.m] = 1;
								count++;
								check[p.n][p.m] = true;
							}
								
						}
						
						
					}
				}
				
				print();
				System.out.println("---------------------------------");
				move();

			}

			if (count > result) {
				result = count;
			}

		}

		return result;
	}
	
	static void move() {
		for (int a = N - 1; a >= 0; a--) {
			for (int b = 0; b < M; b++) {
				if (backup[a][b] == 0)
					continue;
				if (a + 1 == N) {
					backup[a][b] = 0;
				} else {
					backup[a + 1][b] = 1;
					backup[a][b] = 0;
				}
			}
		}
	}
	

	static List<Point> pointList = new ArrayList<Main.Point>();
	static int n, m;
	static boolean check[][] = new boolean[18][18];

	private static Point bfs(int j) {
		int count = 0;
		while (!que.isEmpty()) {
			Point p = que.poll();
			n = p.n;
			m = p.m;
			for (int i = 0; i < 4; i++) {
				int qn = n + Dx[i];
				int qm = m + Dy[i];
				if (qn < 0 || qn >= N || qm < 0 || qm >= M)
					continue;
				if (chk[qn][qm] == true)
					continue;
				if (backup[qn][qm] == 1 && ((Math.abs(n - qn) + Math.abs(m - qm)) <= D)) {
					pointList.add(new Point(qn, qm));
				}

				chk[qn][qm] = true;
				tempque.add(new Point(qn, qm));
			}

			if (que.isEmpty()) {
				count++;
				if (!pointList.isEmpty()) {
					break;
				}
				if (count == j) {
					return null;
				}
				que.addAll(tempque);
				tempque.clear();
			}
		}

		if (pointList.isEmpty()) {
			return null;
		} else {
			if (pointList.size() > 1) {
				pointList.sort(new SortList());
			}
			return pointList.get(0);
		}

	}

	static class SortList implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			return o1.m < o2.m ? 1 : -1;
		}

	}

	static List<int[]> combiList = new ArrayList<int[]>();

	private static void combination(int[] arr, int arrSize, int n, int r, int index) {
		if (arrSize == r) {
			combiList.add(arr.clone());
			return;
		}
		if (index == n) {
			return;
		}

		arr[arrSize] = index;
		combination(arr, arrSize + 1, n, r, index + 1);
		combination(arr, arrSize, n, r, index + 1);
	}
}
