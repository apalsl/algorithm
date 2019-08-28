package D3.s5948;

import java.util.ArrayList;
import java.util.List;

public class combi {
	
	static List<int[]> list = new ArrayList<int[]>();
	static List<int[]> list2 = new ArrayList<int[]>();
	public static void main(String[] args) {
		int[] arr = new int[3];
		int[] value = {1,2,3,4,5};
		
		
		combination(arr, 0, 3, 3, 0);
		
		for(int[] combi : list) {
			for(int i=0; i<combi.length; i++) {
				System.out.print(combi[i] + " ");
			}
			System.out.println();
				
		}
		
		System.out.println("-------------------------");
		
		perm(value,0,5,5);
		for(int[] per : list2) {
			for(int i=0; i<per.length; i++) {
				System.out.print(per[i] + " ");
			}
			System.out.println();
				
		}
		
	}
	private static void perm(int[] arr, int arrSize, int n, int r) {
		if(arrSize == r) {
			list2.add(arr.clone());
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
