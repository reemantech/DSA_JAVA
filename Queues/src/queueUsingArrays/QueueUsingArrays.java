package queueUsingArrays;

public class QueueUsingArrays {
	
	private int data[];
	private int front;// index at which front element is stored
	private int rear; // index at which rear element is stored
	private int size; // size of the queue i.e index up to queue exists 
	
	public QueueUsingArrays() {
		data= new int[10];
		front=-1;
		rear=-1;
		size=0;
	}
	public QueueUsingArrays(int capacity) {
		data= new int[capacity];
		front=-1;
		rear=-1;
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int front() throws QueueEmptyException{
		if(size==0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
	public void enqueue(int ele) throws QueueFullException {
		if(size==data.length) {
//			throw new QueueFullException();
			doubleCapacity();
		}
		if(size==0) {
			front=0;
		}
		
		size++;
		rear=(rear+1)%data.length;
/*		rear++;
		if(rear==data.length) {
			rear=0;
		}
*/
		data[rear]=ele;
	}
	
	private void doubleCapacity() {
		int temp[]=data;
		data=new int[2*temp.length];
		int index=0;
		for(int i=front;i<temp.length;i++) {
			data[index]=temp[i];
			index++;
		}
		for(int i=0;i<=front-1;i++) {
			data[index]=temp[i];
			index++;
		}
		front=0;
		rear=temp.length-1;
	}
	
	public int dequeue() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		int temp=data[front];
		
		front = (front+1)%data.length;
		// below four lines can be rewritten in one single line, as above
/*		front++;
		if(front==data.length) {
			front=0;
		}
*/
		size--;
		// handling the case when we remove the only left element in the queue
		if(size==0) {
			front=-1;
			rear=-1;
		}
		return temp;
	}
	
	public static void main(String[] args) {

		

	}

}
