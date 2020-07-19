package trees;

import java.util.LinkedList;
import java.util.Deque;

class SpiralTraversalTreeNode {
	SpiralTraversalTreeNode left, right;
	int key;

	SpiralTraversalTreeNode(int data) {
		left = right = null;
		key = data;
	}
}

public class SpiralTraversalTree {

	SpiralTraversalTreeNode root;

	public void getSprialTraversal() {
		Deque<SpiralTraversalTreeNode> queue = new LinkedList<SpiralTraversalTreeNode>();
		queue.add(root);
		queue.add(null);

		SpiralTraversalTreeNode current;
		while (queue.size() > 1) {
			current = queue.peekFirst();
			while (current != null) {
				current = queue.poll();
				System.out.print(current.key + " ");

				if (current.right != null)
					queue.addLast(current.right);
				if (current.left != null)
					queue.addLast(current.left);

				current = queue.peekFirst();
			}

			current = queue.peekLast();
			while (current != null) {
				current = queue.pollLast();
				System.out.print(current.key + " ");

				if (current.left != null)
					queue.addFirst(current.left);
				if (current.right != null)
					queue.addFirst(current.right);

				current = queue.peekLast();
			}
		}

	}

	public static void main(String[] args) {
		SpiralTraversalTree tree = new SpiralTraversalTree();
		tree.root = new SpiralTraversalTreeNode(1);
		tree.root.left = new SpiralTraversalTreeNode(2);
		tree.root.right = new SpiralTraversalTreeNode(3);
		tree.root.left.left = new SpiralTraversalTreeNode(4);
		tree.root.left.right = new SpiralTraversalTreeNode(5);
		tree.root.right.left = new SpiralTraversalTreeNode(6);
		tree.root.right.right = new SpiralTraversalTreeNode(7);

		tree.getSprialTraversal();

	}

}
