package trees;

/**
 * Tree Node
 * 
 * @author Bishesh
 *
 */
class SumTreeNode {
	SumTreeNode left, right;
	int key;

	SumTreeNode(int data) {
		left = right = null;
		key = data;
	}
}

/**
 * Binary Tree class containing method to transform it to sum tree
 * 
 * @author Bishesh
 *
 */
public class SumTree {
	SumTreeNode root;

	/**
	 * Method to transform Binary Tree to sum tree
	 * 
	 * @param node
	 * @return node key
	 */
	public int getSumTree(SumTreeNode node) {
		if (node == null)
			return 0;

		int prevVal = node.key;
		node.key = getSumTree(node.left) + getSumTree(node.right);
		return node.key + prevVal;
	}

	public void inorder(SumTreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.key + " ");
			inorder(node.right);
		}
	}

	public static void main(String[] args) {
		SumTree tree = new SumTree();
		tree.root = new SumTreeNode(10);
		tree.root.left = new SumTreeNode(-2);
		tree.root.right = new SumTreeNode(6);
		tree.root.left.left = new SumTreeNode(8);
		tree.root.left.right = new SumTreeNode(-4);
		tree.root.right.left = new SumTreeNode(7);
		tree.root.right.right = new SumTreeNode(5);

		tree.getSumTree(tree.root);
		System.out.println();
		tree.inorder(tree.root);
	}
}
