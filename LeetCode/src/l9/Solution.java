package l9;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(int x) {
    	if(x == 0) {
        	return true;
        }
        
    	
    	List<Integer> list = new ArrayList<Integer>();
        
        int xx = x;
        while(xx>0){
            int n = xx%10;
            list.add(n);            
            xx = xx/10;
        }
        
        String str = "";
        for(int i=0; i<list.size(); i++) {
            str += list.get(i).toString();
        }
        
        
        
        if(x > 0 && str.equals(String.valueOf(x))){
            return true;
        }
        
        return false;
    }
}