package mapsPack;

import java.util.HashMap;
import java.util.Set;

public class MapUse {

	public static void main(String[] args) {
		HashMap<String, Integer> map= new HashMap<>();
		
		// insert
		map.put("abc", 1);
		map.put("pqr", 2);
		map.put("abc", 100);
		map.put("pqr", 20); // remember , we just updated the values of abc and pqr,
							// this does not mean that we added one more abc and pqr,
							// we just updated the values of abc and pqr
		// size will be 2
		
		System.out.println("size:"+map.size());
		
		// check Presence
		if(map.containsKey("abc")) {
			System.out.println("Has abc");
		}
		
		if(map.containsValue(2)) {
			System.out.println("yes it has 2");
			// ye operation mehnga pad sakta hai, kyunki keys are
			// unique but ho sakta hai har key ke liye same values hon.
			// i.e why map.containsValue(value) is of order O(n);
		}
		
		// get value
		int v= map.get("abc");
		System.out.println(v);
		
		//int k= map.get("abc1");
//		above statement will give error as "abc1" 
//		does not exist
//		since abc1 has int value of class Integer,
//		when a key does not exist it has null value
//			:	Integer n=null;
//			:	int k= n ; is same as int k= map.get("abc1); 
		// thus it will give error;
		
		int k= (map.containsKey("abc1"))? map.get("abc1"):0;
		
		// remove
		int p= map.remove("abc"); // removes the key from the map and returns the value of the key
		System.out.println(p);
		
		// iterate
		Set<String> set=map.keySet(); // returns all the keys in a set
		
		for(String str: set) {
			System.out.println(str);
		}// order maintained nhi hota hai.
		// zaroori nhi ki jis order m insert kiya usi order m print ho.
	}

}
