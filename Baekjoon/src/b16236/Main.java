package b16236;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// ù �Ʊ���ũ�� 2
// 1�ʿ� �����¿�
// ū����� �������� ����, ������ĭ ����
// �ڽź��� �����Ż� ����, ������ ������������ �������
// �����Ծ����� �������� ��û
// 1������ ��������
// 1�������� ������ �� ������ ����
// �Ÿ��� ĭ�� ������ �ּڰ�
// ������ ���� ���� �����, �״��� ����
//�̵��� ���ÿ� ����, ������ ũ�� +1
// ��û�ϱ� �������� ����� �Դ���


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
