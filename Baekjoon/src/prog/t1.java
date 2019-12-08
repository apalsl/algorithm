package prog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class t1 {
	public static void main(String[] args) {
		solution(124124);
	}
	
	static Integer[] arr = new Integer[11];
	static public long solution(long n) {
		List<Integer> list = new ArrayList<Integer>();
		while(n > 0) {
			list.add((int) (n%10));
			n = n/10;
		}
		
		list.sort(new Sort());
		
		String s = "";
		for(int i=0; i<list.size(); i++) {
			s += list.get(i).toString();
		}
		
		System.out.println(s);
		
		return Long.valueOf(s);
	}
	
	static class Sort implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 > o2) {
				return -1;
			} else if (o1 == o2){
				return 0;
			} else {
				return 1;
			}
		}
		
	}
}

