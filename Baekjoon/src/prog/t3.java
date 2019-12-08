package prog;

import java.util.Arrays;

public class t3 {

	
	static int[] arr = {1,4,2};
	static int[] arr2 = {5,4,4};
	public static void main(String[] args) {
		
		int n = 15;
		
		solution(arr, arr2);
	}

	private static void solution(int n) {
		String a = Integer.toBinaryString(n);
		
		System.out.println(a);
		int cnt = 0;
		for(int i=0; i<a.length(); i++) {
			char c = a.charAt(i);
			if(c == '0') {
				cnt++;
			}
		}
		
		while(true) {
			n++;
			String s = Integer.toBinaryString(n);
			int chk = 0;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c == '0') {
					chk++;
				}
			}
			
			if(chk == cnt) {
				System.out.println(s);
				System.out.println(n);
				break;
			}
		}
		
		
		
		
	}
	
	
	private static void solution(int[] a, int[] b) {
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int result = 0;
		for(int i=0; i<a.length; i++) {
			result += (a[i] * b[a.length-1-i]);
		}
		
		System.out.println(result);
		
		
		
	}
}
