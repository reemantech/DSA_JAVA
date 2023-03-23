package arrays;

import java.util.Scanner;

public class ShuffleArrayLC {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[2*n];
		
		for(int i=0;i<2*n;i++) {
			arr[i] = sc.nextInt();
		}
		arr = shuffleArray(arr, n);
		
		for(int i = 0;i<2*n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		sc.close();
	}
	
	static int[] shuffleArray(int arr[], int n) {
		if(n==1) {
			return arr;
		}
		int i = 0, j= n, k=0;
		
		int[] ans = new int[2*n];
		
		while(i<n && j<2*n) {
			ans[k++] = arr[i++];
			ans[k++] = arr[j++];
		}
		
		return ans;
	}

}
