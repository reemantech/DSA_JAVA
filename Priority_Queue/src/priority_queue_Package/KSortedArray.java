package priority_queue_Package;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
public class KSortedArray {

	public static void sortKSorted(int [] arr, int k) {
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
		int i=0;
		for(;i<k;i++) {
			pq.add(arr[i]);
		}
		
		
		for(;i<arr.length;i++) {
			arr[i-k]=pq.remove();
			pq.add(arr[i]);
		}
		
		for(int j=arr.length-k;j<arr.length;j++) {
			arr[j]= pq.remove();
		}
	}
	
	public static ArrayList<Integer> KLargestElements(int arr[], int k) {
		
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();  // min heap declaration
		int i=0;
		for(;i<k;i++) {
			pq.add(arr[i]);
		}
		for(;i<arr.length;i++) {
			if(arr[i]>pq.peek()) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		ArrayList<Integer> ans= new ArrayList<Integer>();
		for(int j=0;j<k;j++) {
			ans.add(pq.remove());
		}
		return ans;
		
	}
	
	public static ArrayList<Integer> KSmallestElements(int arr[], int k) {
		
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap declaration
		int i=0;
		for(;i<k;i++) {
			pq.add(arr[i]);
		}
		for(;i<arr.length;i++) {
			if(arr[i]<pq.peek()) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		ArrayList<Integer> ans= new ArrayList<Integer>();
		for(int j=0;j<k;j++) {
			ans.add(pq.remove());
		}
		return ans;
		
	}
	
	public static void main(String[] args) {
		int arr[]={2,4,1,9,6,8};
		sortKSorted( arr, 3);
		
		for(int i : arr) {
			System.out.println(i);
		}
	}

}
