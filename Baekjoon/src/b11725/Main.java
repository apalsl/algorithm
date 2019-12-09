package b11725;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer>[] a = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] chk = new boolean[n+1];
		
		int[] node = new int[n+1];
		
		q.add(1);
		chk[1] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i : a[x]) {
				if(chk[i] == false) { 
					chk[i] = true;
					node[i] = x;
					q.add(i);
				}
			}
		}
		
		for(int i=2; i<=n; i++) {
			System.out.println(node[i]);
		}
		
	}
	
}
