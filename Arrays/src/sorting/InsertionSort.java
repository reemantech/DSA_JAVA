package sorting;

import java.util.Scanner;

public class InsertionSort {
//	2| 1 4 1 8
//	1 2| 4 1 8 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;++i) {
			arr[i]=sc.nextInt();
		}
//		first element is always sorted
		for(int i=1;i<n;i++) {
			int j=i-1;
			int current = arr[i]; // stored the number for comparison
			while(j>=0 && current<arr[j]){
				arr[j+1]=arr[j];
				j--;
				
			}
			arr[j+1]=current;
		}
		
		for(int i=0;i<n;++i) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

}
  