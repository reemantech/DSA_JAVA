package priority_queue_Package;

import java.util.PriorityQueue;

public class InPlaceHeapSort {

	public static void inplaceHeapSort(int arr[]) {
		if(arr.length==0){
            return;
        }
        for(int i=0;i<arr.length;i++){
            insertIntoVirtualHeap(arr,i);
        }
        
        for(int i=0;i<arr.length;i++){
           arr[arr.length -1 -i]= removeFromVirtualHeap(arr, arr.length-i);
        }
		
	}
	
	private static void insertIntoVirtualHeap(int[] arr, int i){
        
        int childIndex=i;
        
        int parentIndex =  (childIndex -1) /2;
        while(childIndex >0){
            
            if(arr[childIndex] < arr[parentIndex]){
                int temp =arr[childIndex];
                arr[childIndex]= arr[parentIndex];
                arr[parentIndex]=temp;
                childIndex= parentIndex;
                parentIndex = (childIndex -1) /2;
            }
            else{
                return;
            }
        }
    }
	
	private static int removeFromVirtualHeap(int [] arr, int heapSize){
        int temp = arr[0];
        arr[0]= arr[heapSize-1];
        heapSize--;
        int index=0;
        int l = 2*index +1;
        int r = 2*index +2;
        
        while(l<heapSize){
            int minIndex = index;
            if(arr[l] < arr[minIndex]){
                minIndex= l;
            }
            if(r<heapSize && arr[r]<arr[minIndex]){
                minIndex= r;
            }
            if(minIndex!=index){
                int temp1 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp1;
                
                index=minIndex;
                l = 2*index +1;
                r = 2*index +2;
            }
            else{
                break;
            }
        }
        return temp;
        
    }
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // this declaration creates a priority queue of minimum heap
		int arr[]= {9,1,0,4,7,3};
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]); // inserting the element in pq
			
			
		}

//		System.out.println(pq.element());
		
		while(!pq.isEmpty()) {
			System.out.print(pq.remove()+" ");
		}
	}

}
