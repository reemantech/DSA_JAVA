package mapsPack;
import java.util.*;
public class RemoveDuplicates {

	public static ArrayList<Integer> removeDuplicates(int a[]){
		ArrayList<Integer> output= new ArrayList<>();
		HashMap<Integer, Boolean> seen = new HashMap<Integer, Boolean>();
		// it will store only those numbers which we've seen
		for(int i=0;i<a.length;i++) {
			if(seen.containsKey(a[i])) {
				continue;
			}
			output.add(a[i]);
			seen.put(a[i], true);
		}
		return output;
	}
	
	public static void main(String[] args) {
		int a[]= {1,2,5,8,2,3,6,5,1,5,5,8,7,9,9,9,5};
		ArrayList<Integer> ans= removeDuplicates(a);
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i)+" ");
		}
		System.out.println();

	}

}
