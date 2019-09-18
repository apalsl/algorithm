package l8;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		myAtoi(sc.next());
	}
	
	
	 public static int myAtoi(String str) {
	        
	        char[] c = new char[str.length()];
	        for(int i=0; i<str.length(); i++){
	        	System.out.println(str.charAt(i));
	        	c[i] = str.charAt(i);
	        }
	        
	        if(c[0] != ' ' && (c[0] < 0 || c[0] > 9) && c[0] != '-') return 0;
	        
	        String result = "";
	        int cnt = 0;
	        int space = 0;
	        
	        for(int i=0; i<str.length(); i++){
	        	if(cnt == 1) {
	        		if(c[i] < 0 || c[i] > 9) break;
	        		result += c[i];
	        	}
	        	if(c[i] == ' ') {
	        		space++;
	        	}
	        	if(space != 0 && c[i-1] != ' ') {
	        		return 0;
	        	}
	        	if(c[i] == '-') {
	        		cnt++;
	        	} else if(c[i] >= 0 && c[i] <= 9) {
	        		result += c[i];
	        	}
	        }

	        
	        
	        
	        return Integer.valueOf(result);
	        
	   }
}
