package stacks_in_java_linkedList;

import java.util.Scanner;
import java.util.Stack;

public class SymmetricBracketsCheck {
	
	public static boolean isBalanced(String str) {
		/*
		 * unbalanced stack
		 * )(
		 * (()
		 * ())(
		 */
		if(str.charAt(0)==')' || str.charAt(0)==']' || str.charAt(0)=='}'){
			return false;
		}
		Stacks_LinkedList<Character> node= new Stacks_LinkedList<>();
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{') {
				node.push(str.charAt(i));
			}
			
			else {
				// else it will be ')' or ']' or  '}'
				char c=node.pop();
				if(c=='(' || c=='[' || c=='{') {
					continue;
				}
			}
		}
		
		if(node.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
    }
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String str= sc.nextLine();
		boolean ans= isBalanced(str);
		System.out.println(ans);
		
		Stack<Integer> stk=new Stack<>();
		stk.push(10);
		stk.push(20);
		System.out.println(stk.peek());
		stk.pop();
		
		
	}

}
