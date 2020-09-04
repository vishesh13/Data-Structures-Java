package trees;

/**
 * Binary Tree Node
 * 
 * @author bishesh
 *
 */
class SumNode {
	int key;
	SumNode left, right;

	public SumNode(int data) {
		left = right = null;
		key = data;
	}
}

/**
 * Java class containing method to check binary if tree has a certain sum
 * 
 * @author bu061787
 *
 */
public class HasPathSum {
	SumNode root;
	boolean hasSum = false;

	/**
	 * method to check binary tree has a certain sum
	 * 
	 * @param node
	 * @param sum
	 * @return boolean
	 */
	public boolean checkSum(SumNode node, int sum) {
		if (node == null)
			return (sum == 0);

		return checkSum(node.left, sum - node.key) || checkSum(node.right, sum - node.key);
	}

	public static void main(String[] args) {
		HasPathSum tree = new HasPathSum();
		System.out.println(tree.hasSum);
		tree.root = new SumNode(10);
		tree.root.left = new SumNode(8);
		tree.root.right = new SumNode(2);
		tree.root.left.left = new SumNode(3);
		tree.root.left.right = new SumNode(5);
		tree.root.right.left = new SumNode(2);
		tree.hasSum = tree.checkSum(tree.root, 23);

		System.out.println(tree.hasSum);
	}
}
