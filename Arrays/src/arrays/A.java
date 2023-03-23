package arrays;

import java.util.*;

public class A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		String str[] = new String[n];

		for (int i = 0; i < n; i++) {
			str[i] = s.next();
		}
		int mat[][] = new int[str.length][str[0].length()];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < str[i].length(); j++) {

				if(str[i].charAt(j) == '.') {
					mat[i][j] = 5;
				} else {
					mat[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				System.out.print(mat[i][j]);

			}
			System.out.println();
		}
		
		dp(mat);

	}
	
	public static void dp(int[][] mat) {
		int ans = 0;
		
		int n = mat.length;
		int m= mat[0].length;
		
		int  i= 0,j=0;
		for(;i<n && j<m;) {
			
				if(i==0 && j==0) {
					continue;
				}
				if(mat[i][j] == 0) {
					break;
				}
				// on right
				
//				int right = (j+1<m && i-1>0)? Math.max(mat[i-1][j], mat[i][j-1]): 0;
				int left = (j-1>=0)?mat[i][j-1]:Integer.MIN_VALUE;
				if(left==Integer.MIN_VALUE) {
					i++;
				}
				int up = (i-1>=0) ? mat[i-1][j]:Integer.MIN_VALUE;
				if(up==Integer.MIN_VALUE) {
					j++;
				}
				ans+=Math.max(left, up);
				
			
		}
		
		System.out.println();
	}

}
