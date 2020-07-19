package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Cracking the coding interview chapter 4.
//Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 4.3

class ListOfDepthsTreeNode {

	int key;
	ListOfDepthsTreeNode left, right;

	public ListOfDepthsTreeNode(int data) {
		key = data;
		left = right = null;
	}
}

/**
 * Java class containing methods to create linked lists at each tree depth.
 * 
 * @author Bishesh
 *
 */
public class ListOfDepths {
	ListOfDepthsTreeNode root;

	static Queue<ListOfDepthsTreeNode> queue;
	ArrayList<LinkedList<ListOfDepthsTreeNode>> listNode = new ArrayList<>();

	public void treeDepthToLinkedList() {
		ListOfDepthsTreeNode current;
		LinkedList<ListOfDepthsTreeNode> nodeLinkedList = new LinkedList<ListOfDepthsTreeNode>();

		while (!queue.isEmpty()) {
			current = queue.poll();
			if (current != null) {
				nodeLinkedList.addLast(current);
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			} else {
				listNode.add(nodeLinkedList);
				nodeLinkedList = new LinkedList<ListOfDepthsTreeNode>();
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
	}

	/**
	 * method to display list of tree nodesc
	 */
	public void display() {
		Iterator it = listNode.iterator();
		while (it.hasNext()) {
			LinkedList<ListOfDepthsTreeNode> head = (LinkedList<ListOfDepthsTreeNode>) it.next();				
				for(ListOfDepthsTreeNode n: head ) {
					if(n == null)
						break;
					System.out.print(n.key + " ");
				}
			System.out.println("");
		}
	}

	/**
	 * InOrder tree traversal recursively
	 * 
	 * @param node
	 */
	public void inOrderRecursive(ListOfDepthsTreeNode node) {
		if (node != null) {
			inOrderRecursive(node.left);
			System.out.print(node.key + " ");
			inOrderRecursive(node.right);
		}
	}

	public static void main(String[] args) {
		ListOfDepths tree = new ListOfDepths();
		tree.root = new ListOfDepthsTreeNode(1);
		tree.root.left = new ListOfDepthsTreeNode(2);
		tree.root.right = new ListOfDepthsTreeNode(3);
		tree.root.left.left = new ListOfDepthsTreeNode(4);
		tree.root.left.right = new ListOfDepthsTreeNode(5);
		tree.root.right.left = new ListOfDepthsTreeNode(6);
		tree.root.right.right = new ListOfDepthsTreeNode(7);

		tree.inOrderRecursive(tree.root);
		System.out.println();
		queue = new LinkedList<ListOfDepthsTreeNode>();
		queue.add(tree.root);
		queue.add(null);

		tree.treeDepthToLinkedList();
		tree.display();
	}

}
