package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int n = sc.nextInt();

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			int spaces = 2 * (n - i);
//
//			for (int j = 1; j <= spaces; j++) {
//				System.out.print(" ");
//			}
//			for (int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
////			for(int j=)
//		}
//		for (int i = n; i >= 1; i--) {
//			for (int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			int spaces = 2 * (n - i);
//
//			for (int j = 1; j <= spaces; j++) {
//				System.out.print(" ");
//			}
//			for (int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//
//			System.out.println();
//		}
	}
}

class Solution3 {
	static Map<Integer, Boolean> map;
	static int last;

	// main function
	public static void main(String[] args) {
		map = new HashMap<>();

		map.put(1, false);
		map.put(0, false);
		map.put(2, true);
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		last = b;
		int count = 0;
		for (int i = a; i <= b; i++) {
			if (isPallin(i)) {
				count++;
			}
		}

		System.out.println(count);
	}

	// func 1
	static boolean isPallin(int n) {
		String s = "" + n;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return isPrime(n);
	}

	// func2
	static boolean isPrime(int n) {
		if (map.containsKey(n)) {
			return map.get(n);
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				map.put(n, false);
			}
		}
		for (int i = n + n; i <= last; i += n) {
			map.put(i, false);
		}
		return map.getOrDefault(n, true);
	}
}
