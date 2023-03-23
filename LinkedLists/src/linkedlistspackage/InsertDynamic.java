package linkedlistspackage;

import java.util.Scanner;

public class InsertDynamic {
	
	public static Node<Integer> insertDynamic(Node<Integer> head, int pos , int elem){
		
		
		// if you don't want to add the element in the end if position number is greater than 
		// the position no. of the last element in the list
		
//		if(head==null || head.next==null) {
//			return head;
//		}
		
		// if you want to add the element in the end 
		if(head==null || head.next==null) {
			Node<Integer> newNode=new Node<>(elem);
			head.next=newNode;
			return head;
		}
		if(pos==0) {
			Node<Integer> newNode=new Node<>(elem);
			newNode.next=head;
			return newNode;
		}
		head.next=insertDynamic(head.next,pos-1,elem);
		return head;
		
	}
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		Node<Integer> head= LinkedListUse.takeInput();
		System.out.print("Enter the integer element to insert: ");
		int elem=sc.nextInt();
		System.out.print("\nEnter the position: ");
		int pos=sc.nextInt();
		
		head=insertDynamic(head, pos, elem);
		LinkedListUse.outputList(head);
		sc.close();
	}
	
}
