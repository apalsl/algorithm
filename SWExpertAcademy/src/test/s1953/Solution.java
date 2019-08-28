package test.s1953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//11시 50분

public class Solution {
	static int map[][] = new int[51][51];
	static int map2[][] = new int[51][51];
	static boolean chk[][] = new boolean[51][51];
	static int N, M;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int R, C, L;
	static int timeCheck;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt(); // 세로
			M = sc.nextInt(); // 가로
			R = sc.nextInt(); // 시작 세로
			C = sc.nextInt(); // 시작 가로
			L = sc.nextInt(); // 탈출 소요시간
			timeCheck = 0;

			for (int i = 0; i < 51; i++) {
				for (int j = 0; j < 51; j++) {
					map[i][j] = -1;
					map2[i][j] = 0;
					chk[i][j] = false;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
//					map2[i][j] = map[i][j];
				}
			}
			int result = 0;
			// 1 상 하 좌 우
			// 2 상 하
			// 3 좌 우
			// 4 상 우
			// 5 하 우
			// 6 하 좌
			// 7 상 좌
			chk[R][C] = true;
			bfs(R, C);
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (chk[i][j] == true) {
						count++;
					}
				}
			}
			System.out.println("#" + test_case + " " + count);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map2[i][j]);
				}
				System.out.println();
			}
		}

	}

	private static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();

		qx.add(x);
		qy.add(y);
//		!qx.isEmpty() && !qy.isEmpty()
		// timeCheck <L
		while (timeCheck < L) {
			x = qx.poll();
			y = qy.poll();
			chk[x][y] = true;
			if(map2[x][y] == L-1) {
				timeCheck = L+1;
			}
			int a, b;
			switch (map[x][y]) {
			case 1:
				for(int i=0; i<4; i++) {
					a = x+dx[i];
					b = y+dy[i];
					if(a >=0 && a<N && b >=0 && b<M) {
						if(chk[a][b] == false && map[a][b] >= 1 && map[a][b] <=7) {
							System.out.println(map[x][y]);
							System.out.println("i = " + i + "  A = " + a + "  B = "+ b);
							chk[a][b] = true;
							qx.add(a);
							qy.add(b);
							map2[a][b] = map2[x][y] +1;
						}
					}
					
				}
				break;
			case 2:
				for(int i=0; i<4; i++) {
					if (i == 1 || i == 3) {
						a = x+dx[i];
						b = y+dy[i];
						if(a >=0 && a<N && b >=0 && b<M) {
							if(chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1 && map[a][b] != 3) {
								System.out.println(map[x][y]);
								System.out.println("i = " + i + "  A = " + a + "  B = "+ b);
								chk[a][b] = true;
								qx.add(a);
								qy.add(b);
								map2[a][b] = map2[x][y] +1;
							}
						}
					}
				}
				break;
			case 3:
				for(int i=0; i<4; i++) {
					if( i==0 || i==2) {
						
						a = x+dx[i];
						b = y+dy[i];
						if(a >=0 && a<N && b >=0 && b<M) {
							if(chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1 && map[a][b] != 2) {
								System.out.println(map[x][y]);
								System.out.println("i = " + i + "  A = " + a + "  B = "+ b);
								chk[a][b] = true;
								qx.add(a);
								qy.add(b);
								map2[a][b] = map2[x][y] +1;
							}
						}
					}
				}
				break;
			case 4:
				for(int i=0; i<4; i++) {
					if ( i==0 || i==3) {
						a = x+dx[i];
						b = y+dy[i];
						if(a >=0 && a<N && b >=0 && b<M) {
							if(chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
								System.out.println(map[x][y]);
								System.out.println("i = " + i + "  A = " + a + "  B = "+ b);
								chk[a][b] = true;
								qx.add(a);
								qy.add(b);
								map2[a][b] = map2[x][y] +1;
							}
						}
					}
				}
				break;
			case 5:
				for(int i=0; i<4; i++) {
					if (i == 0 || i == 1 ) {
						a = x+dx[i];
						b = y+dy[i];
						if(a >=0 && a<N && b >=0 && b<M) {
							if(chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
								System.out.println(map[x][y]);
								System.out.println("i = " + i + "  A = " + a + "  B = "+ b);
								chk[a][b] = true;
								qx.add(a);
								qy.add(b);
								map2[a][b] = map2[x][y] +1;
							}
						}
					}
				}
				break;
			case 6:
				for (int i=0; i<4; i++) {
					if (i == 1 || i == 2) {
						a = x+dx[i];
						b = y+dy[i];
						if(a >=0 && a<N && b >=0 && b<M) {
							if(chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
								System.out.println(map[x][y]);
								System.out.println("i = " + i + "  A = " + a + "  B = "+ b);
								chk[a][b] = true;
								qx.add(a);
								qy.add(b);
								map2[a][b] = map2[x][y] +1;
							}
						}
					}
				}
				break;
			case 7:
				for (int i=0; i<4; i++) {
					if (i == 2 || i ==3) {
						a = x+dx[i];
						b = y+dy[i];
						if(a >=0 && a<N && b >=0 && b<M) {
							if(chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
								System.out.println(map[x][y]);
								System.out.println("i = " + i + "  A = " + a + "  B = "+ b);
								chk[a][b] = true;
								qx.add(a);
								qy.add(b);
								map2[a][b] = map2[x][y] +1;
							}
						}
					}
				}
				break;
			default:
				break;
			}
			
		}
	}
}



















//for (int i = 0; i < 4; i++) {
//	if (map[x][y] == 1) {
//		a = x + dx[i];
//		b = y + dy[i];
//		if (a >= 0 && a < N && b >= 0 && b < M) {
//			if (chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
//				System.out.println(map[x][y]);
//				System.out.println("i = " + i + "  A = " + a + "  B = " + b);
//				chk[a][b] = true;
//				qx.add(a);
//				qy.add(b);
//			}
//		}
//	} else if (map[x][y] == 2) {
//		if (i == 1 || i == 3) {
//			a = x + dx[i];
//			b = y + dy[i];
//			if (a >= 0 && a < N && b >= 0 && b < M) {
//				if (chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
//					System.out.println(map[x][y]);
//					System.out.println("i = " + i + "  A = " + a + "  B = " + b);
//					chk[a][b] = true;
//					qx.add(a);
//					qy.add(b);
//				}
//			}
//		}
//	} else if (map[x][y] == 3) {
//		if (i == 0 || i == 2) {
//
//			a = x + dx[i];
//			b = y + dy[i];
//			if (a >= 0 && a < N && b >= 0 && b < M) {
//				if (chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
//					System.out.println(map[x][y]);
//					System.out.println("i = " + i + "  A = " + a + "  B = " + b);
//					chk[a][b] = true;
//					qx.add(a);
//					qy.add(b);
//				}
//			}
//		}
//	} else if (map[x][y] == 4) {
//		if (i == 0 || i == 3) {
//			a = x + dx[i];
//			b = y + dy[i];
//			if (a >= 0 && a < N && b >= 0 && b < M) {
//				if (chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
//					System.out.println(map[x][y]);
//					System.out.println("i = " + i + "  A = " + a + "  B = " + b);
//					chk[a][b] = true;
//					qx.add(a);
//					qy.add(b);
//				}
//			}
//		}
//	} else if (map[x][y] == 5) {
//		if (i == 0 || i == 1) {
//			a = x + dx[i];
//			b = y + dy[i];
//			if (a >= 0 && a < N && b >= 0 && b < M) {
//				if (chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
//					System.out.println(map[x][y]);
//					System.out.println("i = " + i + "  A = " + a + "  B = " + b);
//					chk[a][b] = true;
//					qx.add(a);
//					qy.add(b);
//				}
//			}
//		}
//	} else if (map[x][y] == 6) {
//		if (i == 1 || i == 2) {
//			a = x + dx[i];
//			b = y + dy[i];
//			if (a >= 0 && a < N && b >= 0 && b < M) {
//				if (chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
//					System.out.println(map[x][y]);
//					System.out.println("i = " + i + "  A = " + a + "  B = " + b);
//					chk[a][b] = true;
//					qx.add(a);
//					qy.add(b);
//				}
//			}
//		}
//	} else if (map[x][y] == 7) {
//		if (i == 2 || i == 3) {
//			a = x + dx[i];
//			b = y + dy[i];
//			if (a >= 0 && a < N && b >= 0 && b < M) {
//				if (chk[a][b] == false && map[a][b] != 0 && map[a][b] != -1) {
//					System.out.println(map[x][y]);
//					System.out.println("i = " + i + "  A = " + a + "  B = " + b);
//					chk[a][b] = true;
//					qx.add(a);
//					qy.add(b);
//				}
//			}
//		}
//	}
//}
