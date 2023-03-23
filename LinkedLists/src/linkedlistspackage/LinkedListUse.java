package linkedlistspackage;

import java.util.Scanner;

public class LinkedListUse {
	
	public static Node<Integer> takeInput() {
		Scanner sc= new Scanner(System.in);
		Node<Integer> head=null,tail=null;
		int data= sc.nextInt();
		while(data!=-1) {
			Node<Integer> newNode=new Node<>(data);
			if(head==null) {
				head=newNode;
				tail=newNode;
			}
			else {
				tail.next=newNode;
				tail=newNode;
			}
			
			data= sc.nextInt();
		}
		sc.close();
		return head;
	}
	
	public static <T> void outputList(Node<T> head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}
	
	public static <T> Node<T> midpoint(Node<T> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<T> slow=head,fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
		if(head1==null) {
			return head2;
		}
		if(head2==null) {
			return head1;
		}
		Node<Integer> t1=head1,t2=head2, head=null,tail=null;
		
		if(t1.data < t2.data) {
			head=t1;
			tail=t1;
			t1=t1.next;
		}
		else {
			head=t2;
			tail=t2;
			t2=t2.next;
		}
		while(t1!=null && t2!=null) {
			if(t1.data <=t2.data) {
				tail.next=t1;
				tail=tail.next;
				t1=t1.next;
			}
			else {
				tail.next=t2;
				tail=tail.next;
				t2=t2.next;
			}
		}
		
		if(t1!=null) {
			tail.next=t1;
		}
		if(t2!=null) {
			tail.next=t2;
		}
		
		return head;
	}
	 
	public static <T> Node<T> reverseLL(Node<T> head){
		
		if(head==null || head.next==null) {
			return head;
		}
		Node<T> prev=null,current=head;
		while(current!=null) {
			Node<T> nxt=current.next;
			current.next=prev;
			prev=current;
			current=nxt;
		}
		return prev;
		
	}
	
	public static <T> Node<T> reverseLL_Recursive(Node<T> head){
		
		if(head==null || head.next==null) {
			return head;
		}
		
		Node<T> nextNode= reverseLL_Recursive(head.next);
		head.next.next=head;
		head.next=null;
		
		return nextNode;
		
	}

	public static <T> DoubleNode<T> reversedLL_using_DoubleNode(Node<T> head){
		if(head==null || head.next==null) {
			DoubleNode<T> ans=new DoubleNode<T>();
			
			ans.head=head;
			ans.tail=head;
			
			return ans;
		}
		
		DoubleNode<T> smallAns= reversedLL_using_DoubleNode(head.next);
		smallAns.tail.next=head;
		head.next=null;
		
		smallAns.tail=head;
		
		return smallAns;
	}

}
