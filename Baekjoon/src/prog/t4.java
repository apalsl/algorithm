package prog;

import java.util.ArrayList;
import java.util.List;

public class t4 {

	
	public static void main(String[] args) {
	  
		int n = 10;
		int[] arr = new int[n];
	      for(int i=0; i<n; i++) {
	          arr[i] = i+1;
	      }  
		
		perm(arr,0,n,n);
		
		int[] sibar = permList.get(2);
		
		for(int i=0; i<n; i++) {
			System.out.print(sibar[i] + " ");
		}
		
	}

	
	static List<int[]> permList = new ArrayList<int[]>();
	private static void perm(int[] arr, int arrSize, int n, int r) {
		if(arrSize == r) {
			permList.add(arr.clone());
			return;
		}
		
		for(int i=arrSize; i<n; i++) {
			swap(arr, i, arrSize);
			perm(arr, arrSize+1, n, r);
			swap(arr, i, arrSize);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	static List<int[]> combiList = new ArrayList<>();
	private static void combination(int[] arr, int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			combiList.add(arr.clone());
			return;
		}
		if(index  == n) {
			return;
		}
		arr[arrSize] = index;
		combination(arr, arrSize+1, n, r, index+1);
		combination(arr, arrSize, n, r, index+1);
	}
}
