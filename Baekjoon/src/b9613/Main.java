package b9613;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<int[]> arrList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int T=1; T<=t; ++T) {
			
			int n = sc.nextInt();
			long sum = 0;
			int[] arr = new int[n];
			int[] array = new int[2];

			for(int i=0; i<n; ++i) {
				arr[i] = sc.nextInt();
			}

			arrList = new ArrayList<int[]>();
			combination(array, 0, n, 2, 0);
			
			for(int[] combi : arrList) {
				sum += dcm(arr[combi[0]], arr[combi[1]]);
			}
			
			System.out.println(sum);
		}
	}

	private static int dcm(int i, int j) {
		int temp = 0;
		while(i != 0) {
			if( i < j) {
				temp = i;
				i = j;
				j = temp;
			}
			
			i = i - j;
		}
		return j;
	}

	private static void combination(int[] arr, int arrSize, int n, int r, int index) {
		if (arrSize == r) {
			arrList.add(arr.clone());
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
