package priority_queue_Package;

import java.util.ArrayList;

public class Priority_Queue {

	private ArrayList<Integer> heap;
	
	
	public Priority_Queue() {
		heap= new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return heap.size() == 0;
	}
	public int size() {
		return heap.size();
	}
	
	public int getMin() throws PriorityQueueEmptyException {
		if(isEmpty()) {
			// throw an exception
			throw new PriorityQueueEmptyException();
		}
		return heap.get(0);
	}
	
	public void insert(int element) {
		heap.add(element);
		
		int childIndex= heap.size()-1;
		
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex >0) {
			if( heap.get(childIndex)<heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex=parentIndex;
				
				parentIndex = (childIndex-1)/2;
			}
			else {
				return;
			}
		}		
	}
	
	public int removeMin() throws PriorityQueueEmptyException {
		if(isEmpty()) {
			throw new PriorityQueueEmptyException();
		}
		int temp = heap.get(0);
		heap.set( 0, heap.get( heap.size() - 1) );
		heap.remove(heap.size()-1);
		
		int index=0;
		int minindex=index;
		int LCIndex= (2*index) +1;
		int RCIndex= (2*index) +2;
		while(LCIndex<heap.size()) {
			
			if(heap.get(LCIndex)< heap.get(minindex) ) {
				
				minindex= LCIndex;
			}
			
			if( RCIndex < heap.size() && heap.get(RCIndex)<heap.get(minindex)) {
				
				minindex= RCIndex;
			}
			if(minindex==index) {
				break;
			}
			else {
				int temp1= heap.get(index);
				heap.set(index, heap.get(minindex));
				heap.set(minindex, temp1);
				index=minindex;
				LCIndex= 2*index +1;
				RCIndex= 2*index +2;
			}
		}
		
		return temp;
	}
	
	
}
