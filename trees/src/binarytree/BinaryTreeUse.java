package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import trees.QueueUsingLL;

public class BinaryTreeUse {
	
	public static BinaryTreeNode<Integer> takeInputLevel(Scanner s){
		System.out.println("Enter root data: ");
		int rootData=s.nextInt();
		Queue<BinaryTreeNode<Integer>> que= new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
		que.add(root);
		while(!que.isEmpty()) {
			BinaryTreeNode<Integer>temp= que.poll();
			
			System.out.println("Left child exists for "+temp.data+": y/n");
			String str= s.next();
			if(str.charAt(0)=='y') {
				System.out.println("Enter left child data of "+ temp.data);
				
				int leftData= s.nextInt();
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftData);
				temp.left= left;
				que.add(temp.left);
			}
			else {
				temp.left=null;
			}
			
			System.out.println("Right child exists for "+temp.data+": y/n");
			String str2= s.next();
			if(str2.charAt(0)=='y') {
				System.out.println("Enter right child data of "+ temp.data);
				int rightData= s.nextInt();
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightData);
				temp.right= right;
				que.add(temp.right);
			}
			else {
				temp.right=null;
			}
		}
		return root;
	}
	
	public static <T> void printLevel(BinaryTreeNode<T> root) {
		
		if(root==null) {
			return;
		}
		
		QueueUsingLL<BinaryTreeNode<T>> pendingNodes= new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		pendingNodes.enqueue(null);
		
		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<T> frontNode= pendingNodes.dequeue();
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
				if(frontNode.left!=null) {
					pendingNodes.enqueue(frontNode.left);
				}
				if(frontNode.right!=null) {
					pendingNodes.enqueue(frontNode.right);
				}
				
			}
		}		
	}
	
	public static BinaryTreeNode<Integer> takeInput(Scanner s){
		System.out.println("Enter root Data");
		int rootData= s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
		root.left=takeInput(s);
		root.right= takeInput(s);
		return root;
	}
	
	public static <T> void print(BinaryTreeNode<T> root) {
		if(root==null) {
			return;
		}
		String toBePrinted=root.data+"";
		if(root.left!=null) {
			toBePrinted+=":"+ "L" + root.left.data+",";
		}
		if(root.right!=null) {
			toBePrinted+= "R" + root.right.data;
		}
		System.out.println(toBePrinted);
		print(root.left);
		print(root.right);
	}

	
	public static <T> int countNodes(BinaryTreeNode<T> root) {
		if(root==null) {
			return 0;
		}
		int ans=1;
		ans+= countNodes(root.left);
		ans+=countNodes(root.right);
		
		return ans;
	}
	
	public static <T> int diameter(BinaryTreeNode<T> root) {
		
		if(root==null) {
			return 0;
		}
		int option1= height(root.left)+height(root.right);
		int option2= diameter(root.left);
		int option3= diameter(root.right);
		
		return  Math.max(option1, Math.max(option2, option3));
	}
	
	public static Pair<Integer , Integer> heightDiameter(BinaryTreeNode<Integer> root){
		// pair.first = height
		// pair.second = diameter
		
		if(root==null) {
			Pair<Integer, Integer> output= new Pair<>();
			output.first=0;
			output.second=0;
			return output;
		}
		Pair<Integer, Integer> lout= heightDiameter(root.left);
		Pair<Integer, Integer> rout= heightDiameter(root.right);
		
		int height =  Math.max(lout.first,rout.first);
		
		int option1= lout.first+rout.first;
		int option2= lout.second;
		int option3= rout.second;
		
		int diameter= Math.max(option1,Math.max(option2, option3));
		
		Pair<Integer, Integer> output= new Pair<>();
		output.first=height;
		output.second=diameter;
		return output;
		// time complexity of this approach is O(n) 
	}
	
	public static <T> int height(BinaryTreeNode<T> root) {
		if(root==null) {
			return 0;
		}
		int lh= height(root.left);
		int rh=height(root.right);
		return 1+ Math.max(lh, rh);
	}

	public static int countLeafNodes(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		
		return countLeafNodes(root.left) + countLeafNodes(root.right);
	}
	//___________ traversals in Binary tree___________//
	
	public static <T> void inOrder(BinaryTreeNode<T> root) {
		
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	public static <T> void preOrder(BinaryTreeNode<T> root) {
		
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static <T> void postOrder(BinaryTreeNode<T> root) {
	
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	//________________________________________________//
	
	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		BinaryTreeNode<Integer> root=takeInputLevel(s);
		Pair<Integer, Integer> obj= heightDiameter(root);
		System.out.println(obj.second);
		printLevel(root);
		s.close();
	}

}
