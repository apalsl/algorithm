package D3.s5948;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static List<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result[] = {1,2,3,4};
		perm(result, 0, 4, 4);

		for(int[] permi : list) {
			for(int i=0; i<permi.length; i++) {
				System.out.print(permi[i] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static void combination(int[] arr, int arrSize, int n, int r, int index) {
		if (arrSize == r) {
			list.add(arr.clone());
			return;
		}
		if (index == n) {
			return;
		}

		arr[arrSize] = index;
		combination(arr, arrSize + 1, n, r, index + 1);
		combination(arr, arrSize, n, r, index + 1);

	}
    // 값이 있는 배열, 0, n개 중에 k개 (동일한 갯수)
	public static void perm(int[] arr, int arrSize, int n, int k) {
		if (arrSize == k) {
			list.add(arr.clone());
			return;
		}
		for (int i = arrSize; i < n; i++) {
			swap(arr, i, arrSize);
			perm(arr, arrSize + 1, n, k);
			swap(arr, i, arrSize);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	
//	private static void combination(int[] arr, int arrSize, int n, int r, int index) {
//		if(arrSize == r) {
//			list.add(arr.clone());
//			return;
//		}
//		if(index == n) {
//			return;
//		}
//		arr[arrSize] = index;
//		combination(arr, arrSize+1, n, r, index+1);
//		combination(arr, arrSize, n, r, index+1);
//	}

}