package linkedlistspackage;

public class MergeSortLL {
	
	public static Node<Integer> mergeSortLL(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> mid =LinkedListUse.midpoint(head);
		Node<Integer> midNext =mid.next;
		mid.next=null;
		
		
		// remember that the head is going to be changed every time so don't forget to store the head of two parts of linked list;
		// we never had to do this in arrays as arrays are contiguous whereas linked lists are not.
		Node<Integer> newhead=mergeSortLL(head);
		midNext=mergeSortLL(midNext);
		
		return LinkedListUse.merge(newhead,midNext);	
	}
	
	public static void main(String[] args) {
		
		Node<Integer> head=LinkedListUse.takeInput();
		
		head=mergeSortLL(head);
		
		LinkedListUse.outputList(head);
	}

}
