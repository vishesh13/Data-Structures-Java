package trees;

class BalancedBinaryTreeNode {
	int key;
	BalancedBinaryTreeNode left;
	BalancedBinaryTreeNode right;

	BalancedBinaryTreeNode(int data) {
		key = data;
		left = right = null;
	}
}

public class BalancedBinaryTree {
	BalancedBinaryTreeNode root;

	public class Result {
		private boolean isBalanced;
		private int height;

		private Result(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}

	private Result isBalancedRecursive(BalancedBinaryTreeNode node, int depth) {
		if (node == null) {
			return new Result(true, -1);
		}

		Result leftSubtreeResult = isBalancedRecursive(node.left, depth + 1);
		Result rightSubtreeResult = isBalancedRecursive(node.right, depth + 1);

		boolean isBalanced = Math.abs(leftSubtreeResult.height - rightSubtreeResult.height) <= 1;
		boolean subtreesAreBalanced = leftSubtreeResult.isBalanced && rightSubtreeResult.isBalanced;
		int height = Math.max(leftSubtreeResult.height, rightSubtreeResult.height) + 1;

		return new Result(isBalanced && subtreesAreBalanced, height);
	}

	public static void main(String[] args) {
		BalancedBinaryTree tree = new BalancedBinaryTree();

		tree.root = new BalancedBinaryTreeNode(1);
		tree.root.left = new BalancedBinaryTreeNode(2);
		tree.root.right = new BalancedBinaryTreeNode(3);
		tree.root.left.left = new BalancedBinaryTreeNode(4);
		tree.root.left.right = new BalancedBinaryTreeNode(5);
		tree.root.right.left = new BalancedBinaryTreeNode(6);
		tree.root.right.right = new BalancedBinaryTreeNode(7);
		tree.root.right.right.right = new BalancedBinaryTreeNode(8);
		tree.root.right.right.right.right = new BalancedBinaryTreeNode(9);

		System.out.println(tree.isBalancedRecursive(tree.root, -1).isBalanced);

	}

}
