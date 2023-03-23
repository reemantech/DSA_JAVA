package advancedDataStructures;

import java.util.Scanner;

public class Disjoint_Union_Set {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// use striver video if you need explanation again
		System.out.println("No. of integers: ");
		
		int n = sc.nextInt();
		
		int parent[] = makeList(n);
		
		// here we don't need rank array, we are creating union on the basis of the value of the integer x and y
		// if value of parent of x is less than y, then x becomes the parent of y, else the reverse
		union(1,2, parent);
	}

	private static void union(int x, int y, int[] parent) {
		x = findParent(x, parent);
		y = findParent(y, parent);
		
		if(parent[x]<y) {
			parent[y] = x;
		}else {
			parent[x] = y;
		}
	}
	

	private static int findParent(int x, int[] parent) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = findParent(parent[x], parent);
	}

	private static int[] makeList(int n) {
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = i;
		}
		return arr;
	}

}
