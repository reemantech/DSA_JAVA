package binarytree;

public class BinarySearchTreeClass {

	private BinaryTreeNode<Integer> root;
	
	private BinaryTreeNode<Integer> insertDataHelper(BinaryTreeNode<Integer> root, int data){
		if(root==null) {
			BinaryTreeNode<Integer> node= new BinaryTreeNode<Integer>(data);
			return node;
		}
		if(root.data>=data) {
			root.left= insertDataHelper(root.left, data);
		}else {
			root.right= insertDataHelper(root.right, data);
		}
		return root;
	}
	public void insertData(int data) {
		root=insertDataHelper(root,data);
	}
	
	private BinaryTreeNode<Integer> deleteDataHelper(BinaryTreeNode<Integer> root, int data){
		if(root==null) {
			return null;
		}
		if(data<root.data) {
			root.left=deleteDataHelper(root.left, data);
			return root;
		}
		else if(data > root.data) {
			root.right=deleteDataHelper(root.right, data);
			return root;
		}else {
			if(root.left==null && root.right==null) {
				return null;
			}
			else if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			else {
				BinaryTreeNode<Integer> minNode= root.right;
				while(minNode.left!=null) {
					minNode=minNode.left;
				}
				root.data=minNode.data;
				root.right=deleteDataHelper(root.right, minNode.data);
				return root;
			}
			
		}		
	}
	public void deleteData(int data) {
		root=deleteDataHelper(root,data);
		
	}
	
	private void printTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		String toBePrinted= root.data+":";
		if(root.left!=null) {
			toBePrinted+= "L:"+root.left.data+",";
		}
		if(root.right!=null) {
			toBePrinted +="R:"+root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	public void printTree() {
		printTree(root);
	}
	
	private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root) {
		if(root==null) {
			return false;
		}
		if(root.data==data) {
			return true;
		}
		if(root.data<data) {
			return hasDataHelper(data,root.right);
		}
		else {
			return hasDataHelper(data, root.left);
		}
	}
	
	public boolean hasData(int data) {
		return hasDataHelper(data,root);
	}
}
