package b1158;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++)
			que.add(i);
		
		sb.append("<");
		while(!que.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				que.add(que.poll());
			}
			if(que.size() == 1) {
				sb.append(que.poll()+">");
			} else {
				sb.append(que.poll() + ", ");	
			}
		}
		System.out.print(sb);		
	}
}
