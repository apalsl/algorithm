package D3.s3750;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			String str = br.readLine().trim();
			int arr[] = new int[str.length()];
			int count = 0;
			for(int i=0;i<str.length();i++) {
				arr[i] = str.charAt(i)-'0';
				count +=arr[i];
			}
			int result = 0;
			while(count >0) {
				result += count%10;
				count = count/10;
			}		
			System.out.println("#"+t+" "+result);
		}
		
	}
}
