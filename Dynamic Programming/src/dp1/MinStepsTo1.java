package dp1;

public class MinStepsTo1 {

	// recursive approach
	public static int countSteps(int n) {

		if (n == 1) {
			return 0;
		}
		int op1 = countSteps(n - 1); // option1 of counting steps by subtracting 1
		int minSteps = op1;

		if (n % 2 == 0) {
			int op2 = countSteps(n / 2);
			minSteps = Math.min(minSteps, op2);
		}
		if (n % 3 == 0) {
			int op3 = countSteps(n / 3);
			minSteps = Math.min(minSteps, op3);
		}
		return 1 + minSteps; // since we are subtracting 1 from n, the least step
	}

	// memoization approach
	public static int countStepsM(int n) {
		int storage[] = new int[n + 1];
		return countStepsM(n, storage);
	}

	private static int countStepsM(int n, int[] storage) {
		if (n == 1) {
			storage[n] = 0;
			return storage[n];
		}
		if (storage[n] != 0) {
			return storage[n]; // if the number is available then return it
		}
		int op1 = countStepsM(n - 1, storage);
		int minSteps = op1;

		if (n % 2 == 0) {
			int op2 = countStepsM(n / 2, storage);
			minSteps = Math.min(minSteps, op2);
		}
		if (n % 3 == 0) {
			int op3 = countStepsM(n / 3, storage);
			minSteps = Math.min(minSteps, op3);
		}

		storage[n] = 1 + minSteps; // storing the value we've got
		return storage[n];
	}

	// dynamic approach

	public static int countStepsDP(int n) {
		int storage[] = new int[n + 1];
		storage[1] = 0;

		for (int i = 2; i <= n; i++) {
			int minSteps = storage[i- 1];
			if (i % 2 == 0) {
				int op2 = storage[i / 2];
				minSteps = Math.min(minSteps, op2);
			}
			if (i % 3 == 0) {
				int op3 = storage[i / 3];
				minSteps = Math.min(minSteps, op3);
			}
			storage[i] = 1 + minSteps;
		}

		return storage[n];
	}

	public static void main(String[] args) {
		System.out.println(countStepsDP(5));
		System.out.println(countStepsM(5));
		System.out.println(countSteps(5));
	}

}
