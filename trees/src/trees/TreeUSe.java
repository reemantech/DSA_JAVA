package trees;

import java.util.Scanner;

public class TreeUSe {
	
	public static void preOrder(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		
		for(int i=0;i<root.children.size();i++) {
			preOrder(root.children.get(i));
		}
	}
	
	public static void postOrder(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		
		for(int i=0;i<root.children.size();i++) {
			postOrder(root.children.get(i));
		}
		System.out.print(root.data+" ");
	}
	
	public static void printAtK_Depth(TreeNode<Integer> root, int k) {
		if(k<0) {
			return;
		}
		if(k==0) {
			System.out.print(root.data);
			return;
		}
		for(int i=0;i<root.children.size();i++) {
			printAtK_Depth(root.children.get(i),k-1);
		}
	}
	
	public static int largest(TreeNode<Integer> root) {
		
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int ans=root.data;
		for(int i=0;i<root.children.size();i++) {
			int childLargest= largest(root.children.get(i));
			if(childLargest>ans) {
				ans=childLargest;
			}
		}
		return ans;
	}
	
	public static int nodeCount(TreeNode<Integer> root) {
		// ' if ' wali condition yahan pe base case nhi hai... it is an edge case
		// when user initially enters a null root value
		if(root==null) {
			return 0;
		}
		
		int count=1;
//		apna for loop is acting as a base case
		/*
		 * if there's no child for a node, for loop won't run, hence that node will return count of itself.
		 * */
		for(int i=0;i<root.children.size();i++) {
			count+=nodeCount(root.children.get(i)) ;
		}
		return count;
	}
	
	public static int sumOfAllNodes(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int sum=root.data; // storing the data of the node itself and getting the data of child nodes using recursion
		for(int i=0;i<root.children.size();i++) {
			sum+= sumOfAllNodes(root.children.get(i));
		}
		return sum;
	}
	
	public static TreeNode<Integer> takeInput(){
		int n;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the data of node ");
		n=sc.nextInt();
		TreeNode<Integer> root= new TreeNode<Integer>(n);
		System.out.println("Enter the number of children for "+n);
		int childCount=sc.nextInt();
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer> child= takeInput();
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String s= root.data+ ":";
		for(int i=0;i<root.children.size();i++) {
			s=s+root.children.get(i).data+",";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++) {
			print(root.children.get(i));
		}
		
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner s= new Scanner(System.in);
		
		System.out.println("Enter root data");
		int rootData=s.nextInt();
		
		QueueUsingLL<TreeNode<Integer>> pendingNodes=new QueueUsingLL<>();
		
		TreeNode<Integer> root = new TreeNode<>(rootData);
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			
			TreeNode<Integer> frontNode=pendingNodes.dequeue();
			
			System.out.println("Enter no. of children of "+ frontNode.data);
			int numChildren=s.nextInt();
			
			for(int i=0;i<numChildren;i++) {
				System.out.println("Enter "+(i+1)+"th child of "+ frontNode.data);
				int child= s.nextInt();
				TreeNode<Integer> childNode= new TreeNode<>(child);
				frontNode.children.add(childNode);
				pendingNodes.enqueue(childNode);
			}
		}
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {	
		
		QueueUsingLL<TreeNode<Integer>> pendingNodes=new QueueUsingLL<>();
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()) {
			
			TreeNode<Integer> frontNode=pendingNodes.dequeue();
			
			// printing the node data
			System.out.print(frontNode.data+": ");
			
			int numChildren=frontNode.children.size();
			
			// printing the child nodes of the node
			for(int i=0;i<numChildren;i++) {
				System.out.print(frontNode.children.get(i).data+",");
			}
			// enqueue the child nodes in the queue
			for(int i=0;i<numChildren;i++) {
				TreeNode<Integer> childNode=frontNode.children.get(i);
				pendingNodes.enqueue(childNode);
			}
			System.out.println();
		}
		
	}
	
	public static void printLevelWise2(TreeNode<Integer> root) {
		QueueUsingLL<TreeNode<Integer>> pendingNodes=new QueueUsingLL<>();
		if(root==null) {
			return;
		}
		pendingNodes.enqueue(root);
		pendingNodes.enqueue(null);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode=pendingNodes.dequeue();
			if(frontNode==null ) {
				if(pendingNodes.size()==0) {
					return;
				}
				System.out.println();
				pendingNodes.enqueue(frontNode);
				continue;
			}
			else {
				// printing the node data
				System.out.print(frontNode.data+" ");
				
				int numChildren=frontNode.children.size();
				for(int i=0;i<numChildren;i++) {
					TreeNode<Integer> childNode=frontNode.children.get(i);
					pendingNodes.enqueue(childNode);
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		// manual addition of nodes
//		TreeNode<Integer> root= new TreeNode<Integer>(4);
//		TreeNode<Integer> node1= new TreeNode<Integer>(2);
//		TreeNode<Integer> node2= new TreeNode<Integer>(3);
//		TreeNode<Integer> node3= new TreeNode<Integer>(5);
//		TreeNode<Integer> node4= new TreeNode<Integer>(6);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node2.children.add(node4);
		TreeNode<Integer> root = takeInputLevelWise();
		print(root);
		printLevelWise2(root);
		preOrder(root);
		
		
	}

}
