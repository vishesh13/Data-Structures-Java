package trees;

class LeftViewTreeNode {
	LeftViewTreeNode left, right;
	int key;

	public LeftViewTreeNode(int data) {
		key = data;
		left = right = null;
	}
}

/**
 * Class containing method to traverse left view of a tree
 * 
 * @author Bishesh
 *
 */
public class LeftViewTree {
	LeftViewTreeNode root;

	int max_level = 0;

	/**
	 * method to print left view nodes
	 * 
	 * @param node
	 * @param level
	 */
	public void getLeftView(LeftViewTreeNode node, int level) {
		if (node == null)
			return;

		if (max_level < level) {
			System.out.print(node.key + " ");
			max_level = level;
		}

		getLeftView(node.left, level + 1);
		getLeftView(node.right, level + 1);
	}

	public void inorder(LeftViewTreeNode leftViewTreeNode) {
		if (leftViewTreeNode != null) {
			inorder(leftViewTreeNode.left);
			System.out.print(leftViewTreeNode.key + " ");
			inorder(leftViewTreeNode.right);
		}
	}

	public static void main(String[] args) {
		LeftViewTree tree = new LeftViewTree();
		tree.root = new LeftViewTreeNode(4);
		tree.root.left = new LeftViewTreeNode(5);
		tree.root.right = new LeftViewTreeNode(2);
		tree.root.right.left = new LeftViewTreeNode(3);
		tree.root.right.right = new LeftViewTreeNode(1);
		tree.root.right.left.left = new LeftViewTreeNode(6);
		tree.root.right.left.right = new LeftViewTreeNode(7);
		// tree.root = new LeftViewTreeNode(12);
		// tree.root.left = new LeftViewTreeNode(10);
		// tree.root.right = new LeftViewTreeNode(30);
		// tree.root.right.left = new LeftViewTreeNode(25);
		// tree.root.right.right = new LeftViewTreeNode(40);

		tree.inorder(tree.root);
		System.out.println();
		System.out.println("Left View");
		tree.getLeftView(tree.root, 1);

	}
}
