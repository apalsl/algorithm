package D3.s6853;

import java.util.Scanner;

public class Solution {
<<<<<<< HEAD
	static int arr[] = new int[3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
=======
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int test_case = 1; test_case <=t; test_case++) {
>>>>>>> 14cbd98981cbb1e1068fe4736bc3388e15448d1b
			int x = sc.nextInt();
			int y = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
<<<<<<< HEAD
			
=======
			int n = sc.nextInt();
			int arr[] = new int[3];
>>>>>>> 14cbd98981cbb1e1068fe4736bc3388e15448d1b
			for(int i=0; i<3; i++) {
				arr[i] = 0;
			}
			
<<<<<<< HEAD
			int n = sc.nextInt();
=======
			
>>>>>>> 14cbd98981cbb1e1068fe4736bc3388e15448d1b
			while(n-->0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				
<<<<<<< HEAD
				if (x <i && x2>i && y<j && y2 >j){
					arr[0] +=1;
				} else if (x > i || x2 <i && y>j || y2<j) {
					arr[2] +=1;
				} else if ((i>x && i<x2 && y==j || y2==j) ||
						(j>y && j<y2 && x==i || x2==i)) {
					arr[1] +=1;
				}  
			}
			
			System.out.println("#" + t+ " "+arr[0]+" "+arr[1] + " " + arr[2]);
			
		}
=======
				if(((x <= i && i <= x2) && (y == j || j == y2)) || 
						((y <=j && j<=y2) && (x == i || x2 == i))) {
					arr[1] +=1;
				} else if (x<i && i<x2 && y<j && j<y2) {
					arr[0] +=1;
				} else {
					arr[2] +=1;
				}
			}
			
			
			System.out.println("#"+test_case+ " "+arr[0]+ " "+ arr[1]+ " "+ arr[2]);
				
		}
		
		
>>>>>>> 14cbd98981cbb1e1068fe4736bc3388e15448d1b
	}
}
