package queueUsingLinkedLists;

public class QueueUsingLLuse {

	public static void main(String[] args) {

		QueueUsingLL<Integer> que=new QueueUsingLL<>();
		for(int i=1;i<=10;i++) {
			que.enqueue(i);
		}
		while(!que.isEmpty()) {
			System.out.println(que.dequeue()+" "+que.front());
			
		}
		

	}

}
