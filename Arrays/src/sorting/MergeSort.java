package sorting;

import java.util.Scanner;

public class MergeSort {
	
	public static void mergesort(int[] arr, int start, int end) {
		
		if(start>=end) {
			return;
		}
		int mid= (start+end)/2;
		mergesort(arr, start,mid );
		mergesort(arr, mid+1,end);
		merge(arr,start,end);
	}
	
	public static void merge(int[] arr,int start, int end) {
		
		int[] extra= new int[end-start+1];
		int mid=(start+end)/2;
		int i=start,j=mid+1,k=0;
		
		while(i<=mid && j<=end) {
			if(arr[i]<arr[j]) {
				extra[k]=arr[i];
				i++;
			}
			else {
				extra[k]=arr[j];
				j++;
			}
			k++;
		}
		while(i<=mid) {
			extra[k]=arr[i];
			i++;
			k++;
		}
		while(j<=end) {
			extra[k]=arr[j];
			j++;
			k++;
		}
		
		i=0;
		while(i<extra.length) {
			arr[start+i]=extra[i];
			i++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int[] arr= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
		}
		
		mergesort(arr,0,n-1);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
		sc.close();
	}

}
