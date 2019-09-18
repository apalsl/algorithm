package l22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		generateParenthesis(6);
	}

	public static List<String> generateParenthesis(int n) {
		List<String> str = new ArrayList<String>();
//         111222
//         112122
//         112212
//         121122
//         121212

		if (n == 2) {
			str.add("(())");
			str.add("()()");
			return str;
		}
		if (n == 1) {
			str.add("()");
			return str;
		}

		int[] arr = new int[n * 2];
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] = 1;
			} else {
				arr[i] = 2;
			}
		}

		perm(arr, 0, n * 2, n * 2);

		List<int[]> relist = new ArrayList<int[]>();

		t: for (int[] pe : per) {
			int result = 0;
			String s = "";
			for (int i = 0; i < pe.length; i++) {
				if (result < 0) {
					continue t;
				}
				if (pe[i] == 1) {
					s += "(";
					result++;
				} else {
					s += ")";
					result--;
				}
			}

			for (int i = 0; i < relist.size(); i++) {
				if (Arrays.equals(relist.get(i), pe)) {
					continue t;
				}
			}
			str.add(s);
		}
		

		int size = relist.size();
		for (int i = size - 1; i >= 0; i--) {
			String string = "";
			int[] q = relist.get(i);
			for (int j = 0; j < n * 2; j++) {
				if (q[j] % 2 == 1) {
					string += "(";
				} else {
					string += ")";
				}
			}
			str.add(string);
		}

		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}

		return str;
	}

	static List<int[]> per = new ArrayList<int[]>();
	public static void perm(int[] arr, int arrSize, int n, int r) {
		if (arrSize == r) {
			per.add(arr.clone());
			return;
		}

		for (int i = arrSize; i < n; i++) {
			swap(arr, i, arrSize);
			perm(arr, arrSize + 1, n, r);
			swap(arr, i, arrSize);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
