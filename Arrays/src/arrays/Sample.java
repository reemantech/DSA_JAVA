
package arrays;

import java.util.*;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int i = 1;
		while (i <= n + 1) {
//			part 1
			System.out.print("*");
			int j = 1;
			
//			part2
			while (j <= i - 1) {
				System.out.print(j);
				j++;
			}
			j = 1;
//			part3
			while (j <= i - 2) {
				System.out.print(i - j - 1);
				j++;
			}
			// star at the end of the row
//			part4
			if (i != 1) {
				System.out.print("*");
			}
			System.out.println();
			i++;
		}

		i = 1;
		if (n == 0) {

			System.out.println("*");
		} else {

			while (i <= n) {
//				part 1
				System.out.print("*");
				
				int j = 1;
//				triangle 3 
//				part 2
				while (j <= n - i) {
					System.out.print(j);
					j++;
				}

				j = 1;
//				triangle 4
//				part 3
				while (j <= n - 2) {
					int k = n - i - j;
					if (k > 0) {
						System.out.print(k);
					}
					j++;
				}
				j = 1;
//				part 4
				while (j <= 1) {
					if (i <= n - 1) {
						System.out.print("*");
					}
					j++;
				}
				System.out.println();
				i++;
			}
		}
	}

}
