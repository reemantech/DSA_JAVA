package searching_Sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
 Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows. 
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Sample Input :
1
5 3
1
2
8
4
9
Sample Output:
3 
Output details:
FJ can put his 3 cows in the stalls at positions 1, 4 and 8, 
resulting in a minimum distance of 3.
 */
public class AngryCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t>0) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			
			long positions[] =  new long[n];
			for(int i=0;i<n;i++) {
				positions[i] = sc.nextInt();
			}
			
			long start =0;
			long end =  positions[n-1] - positions[0];
			
			long ans=-1;
			Arrays.sort(positions);
			
			
			while(start<=end) {
				
				long mid = start + (end-start)/2;
				
				if(check(c, positions, n, mid)) {
					ans = mid;
					start = mid+1;
				}else {
					end =mid-1;
				}
				
			}
			
			System.out.println(ans);
			
			t--;
		}

	}

	private static boolean check(int c, long[] positions, int n, long dist) {
		// TODO Auto-generated method stub
		
		int count =1;
		long last_position = positions[0];
		
		for(int i = 1;i<n;i++) {
			if(positions[i] -last_position>=dist) {
				last_position =positions[i];
				count++;
				
				if(count==c) {
					return true;
				}
			}
		}
		
		
		return false;
	}

}
