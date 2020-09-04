package trees;

/**
 * Mirror Tree Node
 * 
 * @author Bishesh
 *
 */
class MirrorTreeNode {
	MirrorTreeNode left, right;
	int key;

	public MirrorTreeNode(int data) {
		key = data;
		left = right = null;
	}
}

/**
 * Java class containing method to get the mirror of a binary tree
 * 
 * @author bishesh
 *
 */
public class MirrorTree {

	MirrorTreeNode root;

	/**
	 * method to get the mirror of a binary tree
	 * @param node
	 * @return tree node
	 */
	public MirrorTreeNode getMirror(MirrorTreeNode node) {
		if (node == null)
			return null;

		MirrorTreeNode left = getMirror(node.left);
		MirrorTreeNode right = getMirror(node.right);

		node.left = right;
		node.right = left;

		return node;
	}

	public void inorder(MirrorTreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.key + " ");
			inorder(node.right);
		}
	}

	public static void main(String[] args) {
		MirrorTree tree = new MirrorTree();
		tree.root = new MirrorTreeNode(1);
		tree.root.left = new MirrorTreeNode(2);
		tree.root.right = new MirrorTreeNode(3);
		tree.root.left.left = new MirrorTreeNode(4);
		tree.root.left.right = new MirrorTreeNode(5);

		System.out.println("Inorder: ");
		tree.inorder(tree.root);
		System.out.println();

		tree.getMirror(tree.root);
		System.out.println("Inorder: ");
		tree.inorder(tree.root);

	}

}
