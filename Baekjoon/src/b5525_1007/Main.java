package b5525_1007;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  
  // http://mygumi.tistory.com/

  static int n;
  static int m;
  static String s;
  static StringBuilder pattern;
  
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		n = Integer.parseInt(br.readLine().trim());
//      m = Integer.parseInt(br.readLine().trim());
//      s = br.readLine();
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
        s = sc.next();
        
        setting();
		
		ArrayList<Integer> list = kmp(s, pattern.toString());
		System.out.println(list.size());
	}

	public static void setting() {
		pattern = new StringBuilder("IOI");
        for(int i=1;i<n;i++) {
        	pattern.append("OI");
        }
	}
	
	public static int[] getPi(String pattern) {
		int m = pattern.length();
		int j = 0;
		char[] p = new char[m];
		int[] pi = new int[m];

		p = pattern.toCharArray();

		for (int i = 1; i < m; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}

	public static ArrayList<Integer> kmp(String str, String pattern) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] pi = getPi(pattern);
		int n = str.length(), m = pattern.length(), j = 0;
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		//j - ã�� ���ڿ��� �� �ε���.

		for (int i = 0; i < n; i++) {
			while (j > 0 && s[i] != p[j]) {
				//�߰� �ܰ� �پ�ѱ�.
				//pi�迭�� �̿��Ͽ� j�ε����� �����Ŵ���ν� while�� �ߴ�.
				j = pi[j - 1];
			}
			if (s[i] == p[j]) {
				if (j == m - 1) {
					//j�� �� �ε����ν�, �ε����� ã�� ���ڿ��� ũ�⿡ �����ϸ� ���ڿ� ã��.
					list.add(i - m + 1);
					//���� ���� ã�� ���ڿ��� ���� �� �ֱ� ����.
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		return list;
	}

}