package binarytree;
import java.util.*;

public class RootToNodePath {
	public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data ){
		if(root==null) {
			return null;
		}
		if(root.data==data) {
			ArrayList<Integer> output= new ArrayList<>();
			output.add(data);
			return output;
		}
		ArrayList<Integer> leftOutput= getRootToNodePath(root.left, data);
		if(leftOutput!=null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		ArrayList<Integer> rightOutput= getRootToNodePath(root.right, data);
		
		if(rightOutput!=null) {
			rightOutput.add(root.data);
			return rightOutput;
		}else {
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
