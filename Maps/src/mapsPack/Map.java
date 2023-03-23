package mapsPack;
import java.util.*;
public class Map<K,V> {

	// bucket Array storing LinkedList
	ArrayList<MapNode<K,V>> buckets;
	int size; // number of entries i.e how many linked list nodes we have in arrayList
	int numBuckets; // number of buckets in out bucket arrayList
	
	public Map() {
		numBuckets=20;
		buckets=new ArrayList<>();
		for(int i=0;i<20;i++) {
			buckets.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		return hashCode % numBuckets;
	}
	
	public void insert(K key , V value) {
		int bucketIndex= getBucketIndex(key);
		MapNode<K,V> head= buckets.get(bucketIndex);
		while(head!=null) {
			if( head.key.equals( key ) ) 
			{  // .equals() method checks the value equality
				head.value=value;
				return;
			}
			head=head.next;
		}
		// when we reach this line means that the key does not exist in the List
		// so we need to add new key value pair.
		// re initializing the head 'cuz ab wo null ho chuka hoga
		head=buckets.get(bucketIndex); 
		MapNode<K, V> newElementNode= new MapNode<>(key, value);
		
		newElementNode.next=head; // inserting new node at start
		buckets.set(bucketIndex,newElementNode); /* updating the head of the linkedList in the bucket arrayList */
		size++;
		double loadFactor= (1.0*size)/numBuckets;
		if(loadFactor>0.7) {
			rehash();
		}
	}
	
	public double loadFactor() {
		return (1.0*size)/numBuckets;
	}
	
	private void rehash() {
		System.out.println("Rehashing buckets "+numBuckets + " size "+ size);
		ArrayList<MapNode<K, V>> temp= buckets;
		buckets= new ArrayList<>();
		for(int i= 0 ; i<2*numBuckets;i++) {
			buckets.add(null);
		}
		size=0;
		numBuckets*=2;
		for(int i=0;i<temp.size();i++) {
			MapNode<K, V> head= temp.get(i);
			while(head!=null) {
				K key = head.key;
				V value= head.value;
				
				insert(key,value);
				head=head.next;
			}
		}
		
	}

	public int size() {
		return size;
	}
	
	public V removeKey(K key) {
		int bucketIndex= getBucketIndex(key);
		MapNode<K,V> head= buckets.get(bucketIndex);
		MapNode<K,V> prev=null;
		while(head!=null) {
			if( head.key.equals( key ) ) 
			{  // .equals() method checks the value equality
				if(prev==null){
					buckets.set(bucketIndex, head.next);
				}
				else{
					prev.next=head.next;
				}
				size--;
				return head.value;
			}
			
			prev = head;
			head = head.next;
		}
		return null;
	}
	
	public V getValue(K key) {
		int bucketIndex= getBucketIndex(key);
		MapNode<K,V> head= buckets.get(bucketIndex);
		while(head!=null) {
			if( head.key.equals( key ) ) 
			{  // .equals() method checks the value equality
				return head.value;
			}
			head=head.next;
		}
		
		return null;
	}

}
