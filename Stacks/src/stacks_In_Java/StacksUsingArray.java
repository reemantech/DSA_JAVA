package stacks_In_Java;

public class StacksUsingArray {
	private int data[];
	private int top;// index of topmost element of stack
	
	
	public StacksUsingArray(int capacity) {
		
		data=new int[capacity];
		top=-1;
	}
	
	public StacksUsingArray() {
		// in case no input provided by user
		data=new int[5];
		top=-1;
	}
	
	public boolean isEmpty() {
		return(top==-1);
		
//		or
		
//		if(top==-1) {
//			return true;
//		}
//		else {
//			return false;
//		}
	}
	
	public int size() {
		return top +1;
	}
	
	public int Top() throws StackEmptyException {
		if(size()==0) {
			// StackEmptyException
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
		else {
			return data[top];
		}
		
	}
	
	public void push(int elem) throws StackFullException {
		if(size()==data.length) {
			// Stack full
//			
//			StackFullException e=new StackFullException();
//			throw e;
			reconstruct();
			
		}
		top++;
		data[top]=elem;
		
	}
	
	private void reconstruct() {
		
		int[] temp= data;
		data=new int[2*temp.length];
		for(int i=0;i<temp.length;i++) {
			data[i]=temp[i];
		}
	}
	
	public int pop() throws StackEmptyException {
		if(size()==0) {
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
		int temp=data[top];
		top--;
		return temp;
	}
	
	
	public static void main(String[] args) throws StackFullException, StackEmptyException {
		StacksUsingArray stk=new StacksUsingArray(3);
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(45);
		
		while(!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
	}
}
