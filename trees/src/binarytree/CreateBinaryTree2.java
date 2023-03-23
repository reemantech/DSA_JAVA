package binarytree;

// using postOrder and InOrder array of nodes

public class CreateBinaryTree2 {

	public static BinaryTreeNode<Integer> buildTreeHelper(int in[], int post[], int inS,int inE,int postS,int postE){
		if(inS>inE) {
			return null;
		}
		int rootData= post[postE];
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
		
		int rootIndex = -1;
		for(int i=inS ; i<=inE ;i++) {
			if(in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}
		if(rootIndex == -1) {
			return null;
		}
		
		int leftInS = inS;
		int leftInE = rootIndex -1;
		int leftPostS = postS;
		int leftPostE = leftInE - leftInS + leftPostS;
		
		int rightInS = rootIndex+1;
		int rightInE = inE;
		int rightPostS = leftPostE+1;
		int rightPostE = postE-1;
		
		root.left=buildTreeHelper(in, post, leftInS, leftInE, leftPostS, leftPostE);
		root.right= buildTreeHelper(in, post, rightInS, rightInE, rightPostS, rightPostE);
		return root;
	}
	
	public static void main(String[] args) {
		int in[]  = {4,2,5,1,6,3,7};
		int post[]= {4,5,2,6,7,3,1};
		BinaryTreeNode<Integer> root = buildTreeHelper(in, post, 0, in.length-1,0, post.length-1);
		BinaryTreeUse.printLevel(root);
	}

}
