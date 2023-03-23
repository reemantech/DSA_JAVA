package arrays;

import java.util.Scanner;


public class Test {

//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		String input = s.nextLine();
//		String output[] = Test.permutationOfString(input);
//		for(int i = 0; i < output.length; i++) {
//			System.out.println(output[i]);
//		}
//	}
//
//	private static String[] permutationOfString(String input) {
//		// TODO Auto-generated method stub
//		return helper(input, 0);
//	}
//
//	private static String[] helper(String input, int start) {
//		// TODO Auto-generated method stub
//		if(start==input.length()-1) {
//			String myans[] = new String[1];
//			myans[0]= ""+input.charAt(start);
//			return myans;
//		}
//		
//		char currentChar= input.charAt(start);
//		
//		String nextPermutation[] = helper(input, start+1);
//		String ans[] = new String[(input.length()-start)*(nextPermutation.length)];
//		
//		int l=0;
//		
//		for(int i=0;i<nextPermutation.length;i++) {  //     i
//			String ithString = nextPermutation[i];  // bc cb
//			
//			for(int j=0;j<=ithString.length();j++) {
//				ans[l] = ithString.substring(0,j) + currentChar + ithString.substring(j);
//				l++;
//			}
//			
//			/*
//			//b 
////			c
//			
//			
//				// abc
//				
//			
////			"" + a + bc , j=0
////			b + a + c , j=1
////			bc + a +""      , j=2
//			
//				// a b c
//				// b a c
//				// b c a
//			*/
//		}
//		
//		return ans;
//	}
	
	public static int[][] subsetsSumK(int input[], int k) {
        // Write your code here
        return subsetsSumK(input, k, 0);

    }

    public static int[][] subsetsSumK(int[] input, int p, int start) {
        if (start == input.length) {
            if (p == 0) {
                return new int[1][0];
            }
            else {
                return new int[0][0];
            }
        }
        int cn=input[start]; // current number
        int[][] smallans1=subsetsSumK(input, p,start+1);  // not included
        int[][] smallans2=subsetsSumK(input, p-cn, start+1);  // included
        
        int[][] myans=new int[smallans1.length+smallans2.length][];
        int k=0;  // for traversal
        
     // copying the not included one subset matrix
        for(int i=0;i<smallans1.length;i++){
            myans[k]=smallans1[i];
            k++;
            
        }
        
        // now updating the included subset matrix by including the current number
        for(int i=0;i<smallans2.length;i++){
            myans[k]=new int[smallans2[i].length+1];  // increasing the length of ith row by 1
            // so we can include the current number cn
            myans[k][0]=cn;  // inserting the current number first
            
            // copying the rest of the included subset matrix
            for(int j=0;j<smallans2[i].length;j++){
                myans[k][j+1]=smallans2[i][j];
            }
            k++;
        }
        return myans;
        
    }
}