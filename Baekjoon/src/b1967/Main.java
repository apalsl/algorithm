package b1967;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Node {
		int to, cost;
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	static ArrayList<Node>[] a;
	static boolean[] check = new boolean[10001];
	static int[] dist = new int[10001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Main.Node>();
		}
		for(int i=0; i<n-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			a[u].add(new Node(v,w)); // u노드에 v로 가중치는 w
			a[v].add(new Node(u,w));
		}
		bfs(1);
		int start = 1;
		for(int i=2; i<=n; i++) {
			if(dist[i] > dist[start]) {
				start = i;
			}
		}
		bfs(start);
		int ans = dist[1];
		for(int i=2; i<=n; i++) {
			if(ans < dist[i]) {
				ans = dist[i];
			}
		}
		System.out.println(ans);
	}
	
	private static void bfs(int start) {
		Arrays.fill(dist, 0);
		Arrays.fill(check, false);
		
		Queue<Integer> q = new LinkedList<>();
		check[start] = true;
		
		q.add(start);
		while(!q.isEmpty()) {
			int x = q.poll();
			for(Node e : a[x]) {
				if(check[e.to] == false) {
					dist[e.to] = dist[x] + e.cost;
					q.add(e.to);
					check[e.to] = true;
				}
				
			}
		}
		
		
		
		
	}
}
