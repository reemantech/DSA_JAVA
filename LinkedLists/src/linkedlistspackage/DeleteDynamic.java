package linkedlistspackage;

import java.util.Scanner;

public class DeleteDynamic {
	
	public static Node<Integer> deleteDynamic(Node<Integer> head, int pos){
		
		// if the position entered is greater than the no. of elements in the list
		if( (head==null || head.next==null ) && pos>0)  {
			return head;
		}		
		// ------- // 
		
		if(pos==0) {
			head=head.next;
			return head;
		}
		head.next=deleteDynamic(head.next, pos-1);
		return head;
		
	}
	
	public static void main(String[] args) {
		
		Node<Integer> head=LinkedListUse.takeInput();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the position from where you want to delete: ");
		int pos=sc.nextInt();
		head=deleteDynamic(head, pos);
		
		LinkedListUse.outputList(head);
		
		sc.close();
	}

}
