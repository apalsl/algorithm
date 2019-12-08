package b9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		String s = br.readLine();
		String bom = br.readLine();
		
		if(s.length() < bom.length()) {
			System.out.println(s);
			return;
		}
		
		char[] arrbom = new char[50];
		char[] arr = new char[1000002];
		
		int len = bom.length();
		
		for(int i=0; i<bom.length(); i++) {
			arrbom[i] = bom.charAt(i);
		}
		
		int v = 0;
		one : for(int i=0; i<s.length(); i++) {
			arr[v] = s.charAt(i);
			if(arr[v] == arrbom[len-1]) {
				for(int j=1; j<len; j++) {
					if(v-j < 0 || arr[v-j] != arrbom[len-1-j]) {
						v++;
						continue one; 
					}
				}
				v -= len-1;
				continue;
			} else {
				v++;	
				continue;
			}
		}
		StringBuffer sb = new StringBuffer();
	
		if(v == 0) {
			System.out.println("FRULA");
		} else {
			for(int i=0; i<v; i++) {
				sb.append(arr[i]);
			}	
			System.out.println(sb);
		}
	}
}
