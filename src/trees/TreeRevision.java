package trees;

/**
 * Tree Node
 * 
 * @author bishesh
 *
 */
class TreeNode {
	int key;
	TreeNode left, right;

	public TreeNode(int data) {
		left = right = null;
		key = data;
	}
}

/**
 * Java class containing binary tree's methods
 * 
 * @author bishesh
 *
 */
public class TreeRevision {
	TreeNode root;
	boolean hasSum = false;

	public boolean pathHasSum(TreeNode node, int sum) {
		if (node == null)
			return sum == 0;

		return (pathHasSum(node.left, sum - node.key) || pathHasSum(node.right, sum - node.key));
	}

	public static void main(String[] args) {
		TreeRevision tree = new TreeRevision();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(8);
		tree.root.right = new TreeNode(2);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(2);

		System.out.println("Has Path Sum: " + tree.pathHasSum(tree.root, 13));

	}
}
