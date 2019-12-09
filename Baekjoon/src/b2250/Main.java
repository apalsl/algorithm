package b2250;

import java.util.Scanner;

class Node {
	int left;
	int right;
	public int order, depth;
	Node(int left, int right) {
		this.left = left;
		this.right = right;
				
	}
}


public class Main {
	
	static void inorder(Node[] a, int x) {
		if(x == -1) {
			return;
		}
		inorder(a,a[x].left);
		System.out.print(x + " ");
		inorder(a,a[x].right);
	}
	
	static Node[] node = new Node[10001];
	static int[] left = new int[10001];
	static int[] right = new int[10001];
	static int[] cnt = new int[10001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			node[a] = new Node(x,y);
			if(x != -1) cnt[x] += 1; //�ڽ� ��� ī��Ʈ
			if(y != -1) cnt[y] += 1; //�ڽ� ��� ī��Ʈ
		}
		
		int root = 0;
		for(int i=1; i<=N; i++) { // �ڽ��� ������ ��Ʈ
			if(cnt[i] == 0) {
				root = i;
			}
		}
		
		inorder(root,1); // ��Ʈ���� , depth�� 1
		int maxdepth = 0;    // ���� ����
		
		for(int i=1; i<=N; i++) {
			int depth = node[i].depth; // ��
			int order = node[i].order; // ��
			if(left[depth] == 0) {
				left[depth] = order;
			} else {
				left[depth] = Math.min(left[depth], order);
			}
			
			right[depth] = Math.max(right[depth], order);
			maxdepth = Math.max(maxdepth, depth);
		}
		
		int ans = 0;
		int ans_level = 0;
		
	       for (int i=1; i<=maxdepth; i++) {
	            if (ans < right[i]-left[i]+1) {
	                ans = right[i]-left[i]+1;
	                ans_level = i;
	            }
	        }
		
		System.out.println(ans_level + " " + ans);
		
	}
	static int order = 0;
	private static void inorder(int value, int depth) {
		if(value == -1) return; // �ڽľ����� ����
		inorder(node[value].left, depth+1); // �������� ������ depth +1
		node[value].order = ++order; // ���� ���ʺ��� ī��Ʈ
		node[value].depth = depth; // depth ���
		inorder(node[value].right, depth+1);
	}
	
	
}
