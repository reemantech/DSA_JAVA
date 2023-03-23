package binarytree;

// using preOrder and InOrder array of nodes

public class CreateBinaryTree1 {
	
	public static BinaryTreeNode<Integer> buildTree(int in[], int pre[]){
		return buildTreeHelper(in, pre,0,in.length-1, 0, pre.length-1);
	}
	
	public static BinaryTreeNode<Integer> buildTreeHelper(int[] in, int[] pre, int inS, int inE, int preS, int preE) {
		if(inS > inE) {
			return null;
		}
		int rootData= pre[preS];
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
		
		int rootIndex=-1;
		for(int i = inS ; i<= inE; i++) {
			if(in[i]==rootData) {
				rootIndex = i;
				break;
			}
		}
		if(rootIndex == -1) {
			return null;
		}
		
		int leftInS = inS;
		int leftInE = rootIndex - 1;
		int leftPreS = preS + 1 ;
		int leftPreE = leftInE - leftInS + leftPreS;
		
		int rightInS = rootIndex + 1;
		int rightInE = inE;
		int rightPreS = leftPreE + 1 ;
		int rightPreE = preE ;
		
		root.left  =buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
		root.right =buildTreeHelper(in, pre, rightInS, rightInE,rightPreS, rightPreE);
		return root;
		
	}

	public static void main(String[] args) {
		int[] In = {4,2,5,1,6,3,7};
		int[] Pre= {1,2,4,5,3,6,7};
		BinaryTreeNode<Integer> root= buildTree(In,Pre);
		BinaryTreeUse.printLevel(root);
	}

}
