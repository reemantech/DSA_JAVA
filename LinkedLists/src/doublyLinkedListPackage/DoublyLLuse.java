package doublyLinkedListPackage;

import java.util.Scanner;

public class DoublyLLuse {
	
	static Scanner sc= new Scanner(System.in);
	
	public static DoublyLLNode<Integer> takeInput(){
		
		int data=sc.nextInt();
		DoublyLLNode<Integer> head=null,tail=null; 
		while(data!=-1) {
			DoublyLLNode<Integer> node=new DoublyLLNode<>(data);
			if(head==null) {
				head=node;
				tail=node;				
			}
			else {
				tail.next=node;
				node.prev=tail;
				tail=node;
			}
			data=sc.nextInt();
		}
		return head;
		
	}
	
	public static <T> void output(DoublyLLNode<T> head) {
		
		if(head==null) {
			System.out.println("DLL is empty");
			return;
		}
		else {
			
			System.out.print("From where you want to start printing\n"
					+ "head=1\ntail=2\nYour Choice: ");
			
			int choice = sc.nextInt();
			
			if(choice==1) {
				while(head!=null) {
					System.out.print(head.data+ " ");
					head=head.next;
				}
				System.out.println();
				return;
			}
			
			else if(choice ==2) {
				DoublyLLNode<T> tail=null;
				// getting the tail
				while(head!=null) {
					tail=head;
					head=head.next;
				}
				// start printing from the tail
				while(tail!=null) {
					System.out.print(tail.data+ " ");
					tail=tail.prev;
				}
				System.out.println();
				return;
			}
			else {
				System.out.println("Wrong input\n");
				return;
			}
		}
	}
	
	public static <T> int size(DoublyLLNode<T> dllNode) {
		if(dllNode==null) {
			return 0;
		}
		int count=0;
		while(dllNode!=null) {
			count++;
			dllNode=dllNode.next;
		}
		return count;
	}
	
	// recursive approach to insert an element 
	public static <T> DoublyLLNode<T> insert(DoublyLLNode<T> dllNode, T ele , int pos){
		
		// inserting the first node if dll is empty
		if(dllNode==null && pos==0) {
			DoublyLLNode<T> firstNode=new DoublyLLNode<T>(ele);
			dllNode=firstNode;
			return dllNode;
		}
		
		 
		//	the position entered by the user is 
		//	greater than the last position of the dll i.e invalid
			
		if(dllNode.next==null && pos>1) {
			System.out.println("Re-Enter the position");
			return dllNode;
		}

		
		// inserting in the end;
		if(dllNode.next==null && pos==1) {
			DoublyLLNode<T> lastNode=new DoublyLLNode<T>(ele);
			dllNode.next=lastNode;
			lastNode.prev=dllNode;
			
			return dllNode;
		}
		
		// in case of non empty dll, inserting the node at any position other than end 
		if(pos==0) {
			DoublyLLNode<T> newNode=new DoublyLLNode<T>(ele);
			newNode.next=dllNode;
			dllNode.prev=newNode;
			return newNode;
		}
		DoublyLLNode<T> smallAns=insert(dllNode.next,ele,pos-1);
		dllNode.next=smallAns;
		smallAns.prev=dllNode;
		
		return dllNode;
		
	}
	
	public static  DoublyLLNode<Integer> insert(DoublyLLNode<Integer> dllNode){
		System.out.print("Enter the element: ");
		int ele=sc.nextInt();
		
		System.out.print("\nEnter the choice: "
				+ "\nstart:1\nend:2\nAny Other Position:3\nYour Choice: ");
		int choice=sc.nextInt();
		if(choice ==1) {
			dllNode=insert(dllNode,ele,0);
		}
		else if(choice ==2) {
			if(size(dllNode)==0) {
				dllNode=insert(dllNode, ele, 0);
			}
			else {
				dllNode=insert(dllNode, ele, size(dllNode));
			}
		}
		else {
			System.out.print("Enter the position: ");
			int pos=sc.nextInt();
			dllNode=insert(dllNode,ele,pos);
		}
		return dllNode;
		
	}
	
	public static void main(String[] args) {
		DoublyLLNode<Integer> dllNode=takeInput();
		
		output(dllNode);
		dllNode=insert(dllNode);
		
		output(dllNode);
		
	}
}
