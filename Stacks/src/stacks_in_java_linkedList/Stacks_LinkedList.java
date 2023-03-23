package stacks_in_java_linkedList;
import java.util.*;
public class Stacks_LinkedList<T> {
	private Node<T> Top;
	private int size;
	
	public Stacks_LinkedList(){
		this.Top=null;
		this.size=0;
	}
	
	public void push(T ele) {
		if(Top==null) {
			Node<T> newNode=new Node<>(ele);
			Top=newNode;
			size++;
			return;
		}
		Node<T> newNode=new Node<>(ele);
		newNode.next=Top;
		Top=newNode;
		size++;
	}
	
	public T pop() {
		if(size==0) {
			System.out.println("Stack is empty\n");
			return null;
		}
		T data=Top.data;
		Top=Top.next;
		size--;
		return data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return(size==0);
	}
	
	public T top() {
		return Top.data;
	}
	
	public static void main(String[] args) {
		Stacks_LinkedList<Integer> node=new Stacks_LinkedList<>();
		System.out.println(node.size +" "+ node.isEmpty());
		node.push(100);
		System.out.println(node.size +" "+ node.isEmpty());
		node.push(200);
		while(!node.isEmpty()) {
			System.out.println(node.pop());
		}
		
		Stack<Integer> stk= new Stack<>();
		stk.push(1);
		stk.push(2);
		System.out.println(stk.pop());
		
		
	}

}
