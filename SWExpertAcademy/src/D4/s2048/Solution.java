package D4.s2048;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		
		for(int test_case =1; test_case<=t; test_case++) {
			int n = sc.nextInt();
			String str = sc.next();
			
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			switch (str) {
			case "up":
				for(int i=0; i<n; i++) {
					for(int j=0; j<n-1; j++) {
						if (arr[j][i] == arr[j+1][i]) {
							arr[j][i] = arr[j][i]+arr[j+1][i];
							arr[j+1][i] = 0;
							j++;
						} else if (arr[j+1][i] ==0) {
							arr[j+1][i] = arr[j][i];
							arr[j][i] = 0;
						}
					}
				}
				for(int i=0; i<n; i++) {
					test : for(int j=0; j<n-1; j++) {
						if(arr[j][i] == 0) {
							for(int k=j; k<n; k++) {
								if(arr[k][i] != 0) {
									arr[j][i] = arr[k][i];
									arr[k][i] = 0;
									continue test;
								}
							}
						}
					}
				}
				break;
			case "down":
				for(int i=0; i<n; i++) {
					for(int j=n-1; j>0; j--) {
						if (arr[j][i] == arr[j-1][i]) {
							arr[j][i] = arr[j][i]+arr[j-1][i];
							arr[j-1][i] = 0;
							j--;
						} else if (arr[j-1][i] == 0) {
							arr[j-1][i] = arr[j][i];
							arr[j][i] = 0;
						}
					}
				}
				for(int i=0; i<n; i++) {
					test : for(int j=n-1; j>0; j--) {
						if(arr[j][i] == 0) {
							for(int k=j; k>=0; k--) {
								if(arr[k][i] != 0) {
									arr[j][i] = arr[k][i];
									arr[k][i] = 0;
									continue test;
								}
							}
						}
					}
				}
				break;
			case "left":
				for(int i=0; i<n; i++) {
					for(int j=0; j<n-1; j++) {
						if (arr[i][j] == arr[i][j+1]) {
							arr[i][j] = arr[i][j]+arr[i][j+1];
							arr[i][j+1] = 0;
							j++;
						} else if (arr[i][j+1] ==0) {
							arr[i][j+1] = arr[i][j];
							arr[i][j] = 0;
						}
					}
				}
				for(int i=0; i<n; i++) {
					test : for(int j=0; j<n-1; j++) {
						if(arr[i][j] == 0) {
							for(int k=j; k<n; k++) {
								if(arr[i][k] != 0) {
									arr[i][j] = arr[i][k];
									arr[i][k] = 0;
									continue test;
								}
							}
						}
					}
				}
				break;
			case "right":
				for(int i=0; i<n; i++) {
					for(int j=n-1; j>0; j--) {
						if (arr[i][j] == arr[i][j-1]) {
							arr[i][j] = arr[i][j]+arr[i][j-1];
							arr[i][j-1] = 0;
							j--;
						} else if (arr[i][j-1] ==0) {
							arr[i][j-1] = arr[i][j];
							arr[i][j] = 0;
						}
					}
				}
				for(int i=0; i<n; i++) {
				  test : for(int j=n-1; j>0; j--) {
						if(arr[i][j] == 0) {
							for(int k=j; k>=0; k--) {
								if(arr[i][k] != 0) {
									arr[i][j] = arr[i][k];
									arr[i][k] = 0;
									continue test;
								}
							}
						}
					}
				}
				break;
			default:
				break;
			}
			System.out.println("#"+test_case);
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(j == n-1) {
						System.out.print(arr[i][j]);
						continue;
					}
					System.out.print(arr[i][j]+ " ");
				}
				System.out.println();
			}
		}
	}
}
