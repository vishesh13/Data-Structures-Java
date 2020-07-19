package trees;

//4.5 Validate if a binary tree is a Binary Serach Tree

/*
 * Tree Node
 */
class ValidateBinaryTreeAsBSTNode {
	ValidateBinaryTreeAsBSTNode left, right;
	int key;

	public ValidateBinaryTreeAsBSTNode(int data) {
		key = data;
		left = right = null;
	}
}

/**
 * Class containing method validate Binary Tree as Binary Search Tree
 * 
 * @author bishesh
 *
 */
public class ValidateBinaryTreeAsBST {
	ValidateBinaryTreeAsBSTNode root;
	boolean isBST = true;
	boolean isLeftTreeBalanced = true;
	boolean isRightTreeBalanced = true;

	public void validateForBST(ValidateBinaryTreeAsBSTNode node) {
		if (node == null)
			return;

		if (node.left != null) {
			if (isBST && isLeftTreeBalanced && isRightTreeBalanced && node.left != null && node.left.key < node.key) {
				isBST = true;
				isLeftTreeBalanced = true;
				validateForBST(node.left);
			} else {
				isBST = false;
				isLeftTreeBalanced = false;
			}
		}

		if (node.right != null) {
			if (isBST && isLeftTreeBalanced && isRightTreeBalanced && node.right.key > node.key) {
				isBST = true;
				isRightTreeBalanced = true;
				validateForBST(node.right);
			} else {
				isBST = false;
				isLeftTreeBalanced = false;
			}
		}
	}

	void preOrderRec(ValidateBinaryTreeAsBSTNode root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}

	public static void main(String[] args) {
		ValidateBinaryTreeAsBST tree = new ValidateBinaryTreeAsBST();
		tree.root = new ValidateBinaryTreeAsBSTNode(50);
		tree.root.left = new ValidateBinaryTreeAsBSTNode(30);
		tree.root.right = new ValidateBinaryTreeAsBSTNode(70);
		tree.root.left.left = new ValidateBinaryTreeAsBSTNode(20);
		tree.root.left.right = new ValidateBinaryTreeAsBSTNode(40);
		tree.root.right.left = new ValidateBinaryTreeAsBSTNode(90);
		tree.root.right.right = new ValidateBinaryTreeAsBSTNode(80);

		tree.validateForBST(tree.root);
		System.out.println(tree.isBST);
		tree.preOrderRec(tree.root);
		// 50 30 20 40 70 60 80
	}
}
