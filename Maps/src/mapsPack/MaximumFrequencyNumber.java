package mapsPack;

import java.util.HashMap;

public class MaximumFrequencyNumber {

	public static int maxFrequencyNumber(int[] a) {
		// a function to return first maximum occurring number in the array. 
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i : a ) {
			if(map.containsKey(i)) {
				map.put(i,map.get(i)+1);
			}
			else {
				map.put(i, 1);
			}
		}
		int max=Integer.MIN_VALUE;
		int maxfreq=0;
		for(int i : a) {
			if(maxfreq<map.get(i)) {
				maxfreq=map.get(i);
				max=i;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
