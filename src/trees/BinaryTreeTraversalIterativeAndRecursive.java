package trees;

import java.util.Stack;

class Node {
	Node left, right;
	int data;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTreeTraversalIterativeAndRecursive {
	Node root;

	/**
	 * PreOrder tree traversal iteratively using stack
	 */
	public void preOrderIterative() {
		System.out.println("PreOrder: ");
		if (root == null)
			return;

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.print(current.data + " ");
			if (current.right != null)
				stack.push(current.right);
			if (current.left != null)
				stack.push(current.left);

		}
	}

	/**
	 * PreOrder tree traversal recursively
	 * 
	 * @param node
	 */
	public void preOrderRecursive(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrderRecursive(node.left);
		preOrderRecursive(node.right);
	}

	/**
	 * PostOrder tree traversal iteratively using stack
	 */
	public void postOrderIterative() {
		System.out.println("PostOrder: ");
		if (root == null)
			return;

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		Stack<Node> postTraversal = new Stack<>();
		Node current;
		while (!stack.isEmpty()) {
			current = stack.pop();
			postTraversal.push(current);
			if (current.left != null)
				stack.push(current.left);
			if (current.right != null)
				stack.push(current.right);
		}

		while (!postTraversal.isEmpty()) {
			current = postTraversal.pop();
			System.out.print(current.data + " ");
		}
	}

	/**
	 * PostOrder tree traversal recursively
	 * 
	 * @param node
	 */
	public void postOrderRecursive(Node node) {
		if (node == null)
			return;

		postOrderRecursive(node.left);
		postOrderRecursive(node.right);
		System.out.print(node.data + " ");
	}

	/**
	 * InOrder tree traversal iteratively using stack
	 */
	public void inOrderIterative() {
		System.out.println("Inorder: ");
		if (root == null)
			return;

		Stack<Node> stack = new Stack<>();

		Node current = root;
		while (stack.size() > 0 || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				System.out.print(current.data + " ");
				current = current.right;
			}
		}
	}

	/**
	 * InOrder tree traversal recursively
	 * 
	 * @param node
	 */
	public void inOrderRecursive(Node node) {
		if (node != null) {
			inOrderRecursive(node.left);
			System.out.print(node.data + " ");
			inOrderRecursive(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreeTraversalIterativeAndRecursive tree = new BinaryTreeTraversalIterativeAndRecursive();
		tree.root = new Node(12);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);

		tree.preOrderIterative();
		System.out.println();
		tree.preOrderRecursive(tree.root);
		System.out.println();
		tree.postOrderIterative();
		System.out.println();
		tree.postOrderRecursive(tree.root);
		System.out.println();
		tree.inOrderIterative();
		System.out.println();
		tree.inOrderRecursive(tree.root);

	}
}
