package daaPrac;

public class MatrixChainMultiplication {

	static int MatrixChainOrder(int p[], int n){
        int m[][] = new int[n][n];
 
        int i, j, k, L, q;
        for (i = 1; i < n; i++)
            m[i][i] = 0;
 
        for (L = 2; L < n; L++){
            for (i = 1; i < n - L + 1; i++){
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++){
                    q = m[i][k] + m[k + 1][j]
                        + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
 
        return m[1][n - 1];
    }
    public static void main(String args[])
    {
    	/*
    	 * Matrix 	order
    	 * A		10 x 20
    	 * B		20 x 30
    	 * C		30 x 40
    	*/
        int arr[] = new int[] { 10, 20, 30, 40 };
        int size = arr.length;
 
        System.out.println(
            "Minimum number of multiplications is "+ MatrixChainOrder(arr, size));
    }
}
