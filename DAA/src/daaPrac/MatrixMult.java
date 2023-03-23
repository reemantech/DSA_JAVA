package daaPrac;

import java.util.Scanner;

public class MatrixMult {


    public static int MAX = 100;
     
    // Note that below variables are static
    // i and j are used to know current cell of
    // result matrix C[][]. k is used to know
    // current column number of A[][] and row
    // number of B[][] to be multiplied
    public static int i = 0, j = 0, k = 0;
     
    public static void multiplyMatrixRec(int row1, int col1, int A[][],
                       int row2, int col2, int B[][],int C[][])
    {
        if (i >= row1)
            return;
 
        if (j < col2)
        {
            if (k < col1)
            {
                C[i][j] += A[i][k] * B[k][j];
                k++;
                multiplyMatrixRec(row1, col1, A, row2, col2, B, C);
            }
  
            k = 0;
            j++;
            multiplyMatrixRec(row1, col1, A, row2, col2, B, C);
        }
        j = 0;
        i++;
        multiplyMatrixRec(row1, col1, A, row2, col2, B, C);
    }

    static void multiplyMatrix(int row1, int col1, int A[][],
                    int row2, int col2, int B[][])
    {
        if (row2 != col1)
        {
            System.out.println("Not Possible\n");
            return;
        }
  
        int[][] C = new int[MAX][MAX];
  
        multiplyMatrixRec(row1, col1, A, row2, col2, B, C);

        for (int i = 0; i < row1; i++)
        {
            for (int j = 0; j < col2; j++)
                System.out.print(C[i][j]+" ");
  
            System.out.println();
        }
    }
	public static void main(String[] args) {
//		Scanner s= new Scanner(System.in);
		int row1 = 3, col1 = 3, row2 = 3, col2 = 3;
//		System.out.print("Enter the dimensions of 1st 2D matrix\nrows: ");
//		int row1=s.nextInt();
//		System.out.print("columns: ");
//		int col1= s.nextInt();
//		
//		System.out.print("Enter the dimensions of 2nd 2D matrix\nrows: ");
//		int row2=s.nextInt();
//		System.out.print("columns: ");
//		int col2= s.nextInt();
//		
//		System.out.println("Enter the elements of matrix A");
        int A[][] = { {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9}};
  
        int B[][] = { {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9} };
		
        multiplyMatrix(row1, col1, A, row2, col2, B);

	}

}
