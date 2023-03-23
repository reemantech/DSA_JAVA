package dp1;

public class KnapSack01 {
	
	public static int knapsackR(int [] wt, int[] value,int max ,int i) {
		if(i>=wt.length || max ==0) {
			return 0;
		}
		if(wt[i]>max) {
			return knapsackR(wt,value,max,i+1);
		}
		else {
			// including the ith object
			int op1 = value[i] + knapsackR(wt,value,max-wt[i],i+1);

			//excluding the ith object
			int op2= knapsackR(wt,value,max,i+1);
			return Math.max(op1, op2);
		}
	}
	
	
	
	public static void main(String[] args) {
		int wt[]= {6,1,2,4,5};
		int val[]= {8,5,4,8,7};
		int max=5;
		System.out.println(knapsackR(wt, val, max, 0));
	}
}
