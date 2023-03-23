package dp1;

public class CountBalancedBTs {

	// recursive approach
	public static int countBalancedBTs(int h) {
		int mod = (int)Math.pow(10, 9) + 7;
		return countBalancedBTs(h, mod);
	}
	
	private static int countBalancedBTs(int h, int mod) {
		if(h==0 || h==1) {
			return 1;
		}
		int x= countBalancedBTs(h-1,mod) % mod;
		int y= countBalancedBTs(h-2,mod) % mod;
		
		long res1=(long)x * x;
		long res2= (long)x * y * 2;
		int value1= (int)(res1 % mod);
		int value2= (int)(res2 % mod);
		
		return (value1 +value2)%mod;
		
	}
	
	// DP approach
	
	public static int countBalancedBTsDP(int h) {
		if(h==0 || h==1) {
			return 1;
		}
		int dp[]=new int[h+1];
		dp[0]=1;
		dp[1]=1;
		int mod = (int)Math.pow(10, 9) + 7;
		for(int i=2;i<=h;i++) {
			int x= dp[i-1];
			int y= dp[i-2];
			long res1=(long)x * x;
			long res2= (long)x * y * 2;
			int value1= (int)(res1 % mod);
			int value2= (int)(res2 % mod);
			dp[i] = (value1 + value2)%mod;
		}
		return dp[h];
	}
	
	public static void main(String[] args) {
		int x=7;
		System.out.println(countBalancedBTsDP(x));
		System.out.println(countBalancedBTs(x));

	}

}
