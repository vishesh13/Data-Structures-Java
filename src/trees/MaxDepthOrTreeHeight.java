package trees;

class MaxDepthOrTreeHeightNode {
	MaxDepthOrTreeHeightNode left, right;
	int key;

	MaxDepthOrTreeHeightNode(int data) {
		key = data;
		left = right = null;
	}
}

public class MaxDepthOrTreeHeight {
	MaxDepthOrTreeHeightNode root;

	public int getHeight(MaxDepthOrTreeHeightNode node) {
		if (node == null)
			return 0;
		else {
			int leftHeight = getHeight(node.left);
			int rightHeight = getHeight(node.right);

			if (leftHeight > rightHeight)
				return (leftHeight + 1);
			else
				return (rightHeight + 1);
		}
	}

	public static void main(String[] args) {

		MaxDepthOrTreeHeight tree = new MaxDepthOrTreeHeight();
		tree.root = new MaxDepthOrTreeHeightNode(10);
		tree.root.left = new MaxDepthOrTreeHeightNode(9);
		tree.root.right = new MaxDepthOrTreeHeightNode(6);
		tree.root.right.left = new MaxDepthOrTreeHeightNode(8);
		tree.root.right.right = new MaxDepthOrTreeHeightNode(7);
		tree.root.right.right.right = new MaxDepthOrTreeHeightNode(7);

		System.out.println("Height: " + tree.getHeight(tree.root));

	}

}
