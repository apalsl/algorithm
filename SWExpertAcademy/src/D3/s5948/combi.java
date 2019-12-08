package D3.s5948;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class combi {
	
	static List<int[]> list = new ArrayList<int[]>();
	static List<int[]> list2 = new ArrayList<int[]>();
	public static void main(String[] args) {
		int[] arr = new int[3];
		int[] value = {1,2,1,2};
		
		
//		combination(arr, 0, 3, 3, 0);
		
//		for(int[] combi : list) {
//			for(int i=0; i<combi.length; i++) { 
//				System.out.print(value[combi[i]] + " ");
//			}
//			System.out.println();
//				
//		}
		
		System.out.println("-------------------------");
		
		perm(value,0,4,4);
		
		System.out.println(list2.size());
		System.out.println(list2.get(6));
		for(int[] per : list2) {
			for(int i=0; i<per.length; i++) {
				System.out.print(per[i] + " ");
			}
			System.out.println();
				
		}
		
		String str = "Abc";
		System.out.println(str.charAt(0));
		
	}
	
	static HashSet<int[]> set = new HashSet<int[]>();
	private static void perm(int[] arr, int arrSize, int n, int r) {
		if(arrSize == r) {
			if(list2.size() == 0) {
				list2.add(arr.clone());
			} else {
				for(int[] per : list2) {
					for(int i=0; i<per.length; i++) {
						if(per[i] != arr[i]) break;
						
						if(i == per.length-1) {
							return;
						}
					}
				}
				
				list2.add(arr.clone());
			}
			 
			
//			if(!list2.contains(arr)) {
				
//			}
			
			return;
		}
		
		for(int i=arrSize; i<n; i++) {
			swap(arr, i, arrSize);
			perm(arr,arrSize+1, n, r);
			swap(arr, i, arrSize);
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

	private static void combination(int[] arr, int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			list.add(arr.clone());
			return;
		}
		if(index == n) {
			return;
		}
		
		arr[arrSize] = index;
		combination(arr, arrSize+1, n, r, index+1);
		combination(arr, arrSize, n, r, index+1);
		
	}
}
