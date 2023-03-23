package binarytree;

public class BST {

	public int minimum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data,Math.min(minimum(root.left),minimum(root.left)));
	}
	public int maximum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data,Math.max(maximum(root.left),maximum(root.left)));
	}
	
	public boolean isBST(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int leftmax=maximum(root.left);
		int rightmin=minimum(root.right);
		
		if(root.data<=leftmax || root.data>rightmin) {
			return false;
		}
		
		boolean isLeftBST=isBST(root.left);
		boolean isRightBST=isBST(root.right);
		
		if(isLeftBST && isRightBST) {
			return true;
		}
		else {
			return false;
		}
	}

	
						//isBST,    <min    , max>
	public Pair<Boolean,Pair<Integer, Integer>> isBST2(BinaryTreeNode<Integer> root){
		if(root==null) {
			Pair<Boolean, Pair<Integer, Integer>> ans= new Pair<>();
			ans.first=true;
			ans.second= new Pair<Integer, Integer>();
			ans.second.first=Integer.MAX_VALUE;
			ans.second.second=Integer.MIN_VALUE;
			
			return ans;
		}
		Pair<Boolean, Pair<Integer, Integer>> leftout= isBST2(root.left);
		Pair<Boolean, Pair<Integer, Integer>> rightout= isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftout.second.first, rightout.second.first));
		int max = Math.max(root.data, Math.max(leftout.second.second, rightout.second.second));
		
		boolean isBST= (root.data >leftout.second.second)
				&& (root.data<=rightout.second.first)
				&& leftout.first && rightout.first;
		
		Pair<Boolean, Pair<Integer, Integer>> ans= new Pair<>();
		ans.first=isBST;
		ans.second= new Pair<Integer, Integer>();
		ans.second.first=min;
		ans.second.second=max;
		
		return ans;
		
	}

	// is BST 3
	public boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) {
		if(root==null) {
			return true;
		}
		// out of range
		if(root.data<min || root.data>max) {
			return false;
		}
		boolean isLeft= isBST3(root.left, min, root.data-1);
		boolean isRight= isBST3(root.right,root.data,max);
		
		return isLeft&& isRight;
	}
	

}
