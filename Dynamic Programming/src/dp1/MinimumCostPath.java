package dp1;

import java.util.*;

public class MinimumCostPath {

	// recursive approach
	public static int minimumCostPath(int arr[][]) {
		return minimumCostPathREC(arr, 0, 0);
	}

	private static int minimumCostPathREC(int arr[][], int i, int j) {
		int m = arr.length;
		int n = arr[0].length;
		if (i == m - 1 && j == n - 1) {
			return arr[i][j];
		}

		if (i >= m || j >= n) {
			return Integer.MAX_VALUE;
		}

		int op1 = minimumCostPathREC(arr, i + 1, j);
		int op2 = minimumCostPathREC(arr, i + 1, j + 1);
		int op3 = minimumCostPathREC(arr, i, j + 1);

		return arr[i][j] + Math.min(op1, Math.min(op2, op3));
	}

	// -----------------------------------------------------------------------
	// memoization approach
	public static int minimumCostPathMem(int arr[][]) {
		int storage[][] = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
//			for(int j=0;j<arr[0].length;j++) {
//				storage[i][j] = -1;
//			}
			Arrays.fill(storage[i], -1);
		}
		return minimumCostPathMem(arr, 0, 0, storage);
	}

	public static int minimumCostPathMem(int arr[][], int i, int j, int[][] storage) {
		int m = arr.length;
		int n = arr[0].length;
		if (i == m - 1 && j == n - 1) {
			storage[m - 1][n - 1] = arr[i][j];
			return storage[i][j];
		}
		if (i >= m || j >= n) {
			return Integer.MAX_VALUE;
		}

		if (storage[i][j] != -1) {
			return storage[i][j];
		}

		int op1 = minimumCostPathMem(arr, i + 1, j, storage);
		int op2 = minimumCostPathMem(arr, i + 1, j + 1, storage);
		int op3 = minimumCostPathMem(arr, i, j + 1, storage);

		storage[i][j] = arr[i][j] + Math.min(op1, Math.min(op2, op3));
		return storage[i][j];
	}

	// -----------------------------------------------------------------------
	// dynamic programming approach
	public static int minimumCostPathDP1(int arr[][]) {

		int m = arr.length, n = arr[0].length;
		int storage[][] = new int[m][n];

		storage[m - 1][n - 1] = arr[m - 1][n - 1];

//		for (int i = m - 1; i >= 0; i--) {
//
//			for (int j = n - 1; j >= 0; j--) {
//
//				if (i == m - 1) {
//					if (j == n - 1) {
//						continue;
//					}
//					storage[i][j] = arr[i][j] + storage[i][j + 1];
//					continue;
//				}
//
//				else if (j == n - 1) {
//					storage[i][j] = arr[i][j] + storage[i + 1][j];
//					continue;
//				}
//
//				else {
//					int op1 = storage[i][j + 1];
//					int op2 = storage[i + 1][j + 1];
//					int op3 = storage[i + 1][j];
//					storage[i][j] = arr[i][j] + Math.min(op1, Math.min(op2, op3));
//				}
//
//			}
//		}
		
		// getting values for last row and column first, then iterating over rest of the matrix
		//last row
		for(int j=n-2;j>=0;j--) {
			storage[m-1][j] = arr[m-1][j] + storage[m-1][j+1] ;
		}
		//last column
		for(int i=m-2;i>=0;i--) {
			storage[i][n-1] = arr[i][n-1] + storage[i+1][n-1] ;
		}
		
		for(int i=m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				storage[i][j] = arr[i][j] + Math.min(storage[i][j+1], 
						Math.min(storage[i+1][j+1], storage[i+1][j]));
			}
		}

		return storage[0][0];
	}

	public static void main(String[] args) {

		int arr[][] = { { 1, 1, 1 }, { 4, 4, 2 }, { 7, 8, 9 } };
		System.out.println(minimumCostPathDP1(arr));
		System.out.println(minimumCostPathMem(arr));
		System.out.println(minimumCostPath(arr));

	}

}
