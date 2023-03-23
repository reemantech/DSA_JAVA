package dp1;

public class EditDistance {

	public static int editDistanceRec(String s, String t) {
		if (s.length() == 0) {
			return t.length();
		}
		if (t.length() == 0) {
			return s.length();
		}

		if (s.charAt(0) == t.charAt(0)) {
			return editDistanceRec(s.substring(1), t.substring(1));
		} else {
			// insert
			int op1 = editDistanceRec(s, t.substring(1));
			// delete
			int op2 = editDistanceRec(s.substring(1), t);
			// substitute
			int op3 = editDistanceRec(s.substring(1), t.substring(1));

			return 1 + Math.min(op1, Math.min(op2, op3));
		}
	}

	public static int editDistanceM(String s, String t) {
		int m = s.length(), n = t.length();
		int storage[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				storage[i][j] = -1;
			}
		}

		return editDistanceM(s, t, storage);
	}

	private static int editDistanceM(String s, String t, int[][] storage) {
		int m = s.length();
		int n = t.length();

		if (m == 0) {
			storage[m][n] = n;
			return storage[m][n];
		}
		if (n == 0) {
			storage[m][n] = m;
			return storage[m][n];
		}
		if (storage[m][n] != -1) {
			return storage[m][n];
		}
		if (s.charAt(0) == t.charAt(0)) {
			storage[m][n] = editDistanceM(s.substring(1), t.substring(1), storage);
		} else {
			// insert
			int op1 = editDistanceM(s, t.substring(1), storage);
			// delete
			int op2 = editDistanceM(s.substring(1), t, storage);
			// substitute
			int op3 = editDistanceM(s.substring(1), t.substring(1), storage);

			storage[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
		}

		return storage[m][n];
	}

	public static int editDistanceDP(String s, String t) {
		int m = s.length();
		int n = t.length();

		int storage[][] = new int[m + 1][n + 1];

		for (int j = 0; j <= n; j++) {
			storage[0][j] = j;
		}
		for (int i = 0; i <= m; i++) {
			storage[i][0] = i;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					storage[i][j] = storage[i - 1][j - 1];
				} else {
					int op1 = storage[i][j - 1];
					int op2 = storage[i - 1][j];
					int op3 = storage[i - 1][j - 1];
					storage[i][j] = 1 + Math.min(op1, Math.min(op2, op3));
				}
			}
		}
		return storage[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "agei";
		String t = "abcd";
		System.out.println(editDistanceDP(s, t));
		System.out.println(editDistanceM(s, t));
		System.out.println(editDistanceRec(s, t));
	}

}
