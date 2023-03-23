package trees;

public class QueueUsingLL<T> {
	
	private int size;
	private Node<T> front;
	private Node<T> rear;
	
	public QueueUsingLL() {
		this.front=null;
		this.rear=null;
		size=0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public T front(){
		if(size==0) {
		//	System.out.println("front Queue is Empty");
			return null;
		}
		return front.data;
	}
	public void enqueue(T ele) {
		Node<T> newNode=new Node<>(ele);
		if(size==0) {
			front=newNode;
			rear=newNode;
		}
		rear.next=newNode;
		rear=newNode;
		size++;
	}
	public T dequeue() {
		if(size==0) {
			System.out.println("Queue is Empty");
			return null;
		}
		T temp= front.data;
		front=front.next;
		size--;
		return temp;
	}
	

}
