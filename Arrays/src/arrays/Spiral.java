package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spiral {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[][] take2DInput() throws IOException {
		String[] strRowsCols = br.readLine().trim().split("\\s");
		int n_rows = Integer.parseInt(strRowsCols[0]);
		int m_cols = Integer.parseInt(strRowsCols[1]);

		if (n_rows == 0) {
			return new int[0][0];
		}

		int[][] mat = new int[n_rows][m_cols];

		for (int row = 0; row < n_rows; row++) {
			String[] strNums;
			strNums = br.readLine().trim().split("\\s");

			for (int col = 0; col < m_cols; col++) {
				mat[row][col] = Integer.parseInt(strNums[col]);
			}
		}

		return mat;
	}

	public static void spiralPrint(int matrix[][]) {
		// Your code goes here

		int rowStart = 0;
		int rowLength = matrix.length - 1;

		if (matrix.length == 0) {
			return;
		}
		int colStart = 0;
		int colLength = matrix[0].length - 1;

		while (rowStart <= rowLength && colStart <= colLength) {

			for (int i = rowStart; i <= colLength; i++) {
				System.out.print(matrix[rowStart][i] + " ");
			}

			for (int j = rowStart + 1; j <= rowLength; j++) {
				System.out.print(matrix[j][colLength] + " ");
			}

			if (rowStart + 1 <= rowLength) {
				for (int k = colLength - 1; k >= colStart; k--) {
					System.out.print(matrix[rowLength][k] + " ");
				}
			}
			if (colStart + 1 <= colLength) {
				for (int k = rowLength - 1; k > rowStart; k--) {
					System.out.print(matrix[k][colStart] + " ");
				}
			}

			rowStart++;
			rowLength--;
			colStart++;
			colLength--;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[][] mat = take2DInput();

            spiralPrint(mat);
            System.out.println();

            t -= 1;
        }
	}

}
