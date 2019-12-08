package l38;

public class Solution {
	
	public static void main(String[] args) {
		
		countAndSay(5);
		
	}
    public static String countAndSay(int n) {
        int first = 1;
        String s = "1 ";
        
        
        while(first != n ) {
//        	System.out.println(s);
        	
        	String temp = "";
        	
        	int cnt = 1;
        	for(int i=0; i<s.length()-1; i++) {
        		if(s.charAt(i) == s.charAt(i+1)) {
        			cnt++;
        		} else {
        			temp +=cnt;
        			temp +=s.charAt(i);
        			cnt = 1;
        		}
        	}
        	
        	
        	s = temp + " ";
        	first++;
        }
        
        
        
        
        
        return s;
        
        
        

    }
}