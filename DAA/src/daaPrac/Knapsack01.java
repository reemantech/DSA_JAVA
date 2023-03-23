package daaPrac;

import java.util.Scanner;

public class Knapsack01 {

	public static int knapSack(int W, int wt[], int val[], int n)
	  {
	    int []dp = new int[W + 1];
	    for (int i = 1; i < n + 1; i++) {
	      for (int w = W; w >= 0; w--) {
	  
	        if (wt[i - 1] <= w)
	            
	          dp[w] = Math.max(dp[w],dp[w - wt[i - 1]] + val[i - 1]);
	      }
	    }
	    return dp[W]; 
	  }
	public static void main(String[] args)
	  {
	    Scanner s= new Scanner(System.in);
		System.out.println("Enter the number of items");
		int n= s.nextInt();
		int wt[]= new int [n];
		System.out.println("Enter the weight of the items: ");
		for(int i=0;i<n;i++) {
			wt[i]=s.nextInt();
		}
		
		System.out.println("Enter the value of the items: ");
		int val[]= new int[n];
		for(int i=0;i<n;i++) {
			val[i]=s.nextInt();
		}
		System.out.println("Enter the capacity: ");
		int W= s.nextInt();
	    System.out.print(knapSack(W, wt, val, n));
	  }
}
