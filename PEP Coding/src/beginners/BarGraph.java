package beginners;

import java.util.Scanner;
import java.util.concurrent.Delayed;

public class BarGraph {

	public static void main(String[] args) {
//		int[] arr= {3,1,0,7,5};
		Scanner sc= new Scanner(System.in);
		
		int n= sc.nextInt();
		
		int arr[] =new int[n];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			max=Math.max(max, arr[i]);
		}
		
//		int ans[][] = new int[n][max];
//		
//		for(int i=0;i<n;i++) {
//			int temp=arr[i];
//			for(int j=0;j<max;j++) {
//				if(temp>0) {
//					ans[i][j]=1;
//					temp--;
//				}
//			}
//		}
//		
//		for(int j=max-1;j>=0;j--) {
//			for(int i=0;i<n;i++) {
//				if(ans[i][j]==0) {
//					System.out.print(" ");
//				}else {
//					System.out.print("*");
//				}
//			}System.out.println();
//		}
		
		// eliminating 1 for loop
		
		for(int i=0;i<max;i++) {
			for(int j=0;j<n;j++) {
				if(arr[j]>=max-i) {
					
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}System.out.println();
		}
	}

}
