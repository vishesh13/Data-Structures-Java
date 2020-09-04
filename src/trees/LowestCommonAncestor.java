package trees;

class LcaNode {
	LcaNode left, right;
	int key;

	public LcaNode(int data) {
		key = data;
		left = right = null;
	}
}

public class LowestCommonAncestor {
	LcaNode root;

	public LcaNode getLcaNode(LcaNode node, int one, int two) {
		if (node == null)
			return null;

		if (node.key == one || node.key == two)
			return node;

		LcaNode left = getLcaNode(node.left, one, two);
		LcaNode right = getLcaNode(node.right, one, two);

		if (left != null && right != null)
			return node;

		return left != null ? left : right;
	}

	public void inorder(LcaNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.key + " ");
			inorder(node.right);
		}
	}

	public static void main(String[] args) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new LcaNode(3);
		tree.root.left = new LcaNode(6);
		tree.root.right = new LcaNode(8);
		tree.root.left.left = new LcaNode(2);
		tree.root.left.right = new LcaNode(11);
		tree.root.left.right.left = new LcaNode(9);
		tree.root.left.right.right = new LcaNode(5);
		tree.root.right.right = new LcaNode(13);
		tree.root.right.right.left = new LcaNode(7);

		tree.inorder(tree.root);

		System.out.println();
		System.out.println(tree.getLcaNode(tree.root, 9, 3).key);
	}
}
