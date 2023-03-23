package doublyLinkedListPackage;

public class DoublyLLNode<T> {
	DoublyLLNode<T> prev;
	T data;
	DoublyLLNode<T> next;
	
	public DoublyLLNode(T data) {
		prev=null;
		this.data=data;
		next=null;
	}
}

