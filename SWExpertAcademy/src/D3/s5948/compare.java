package D3.s5948;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class compare {

	public static void main(String[] args) {
		List<Map> list = new ArrayList<Map>();
		
		list.add(new Map(1,0));
		list.add(new Map(2,0));
		
		list.sort(new Sort());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).x);
			
		}
	}

	public static class Map {
		int x;
		int y;
		public Map(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Sort implements Comparator<Map> {
		@Override
		public int compare(Map o1, Map o2) {
			return o2.x - o1.x;
		}
	}
}