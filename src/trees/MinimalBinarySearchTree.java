package trees;

//Cracking the coding interview chapter 4---> 4.2
class MinimalBinarySearchTreeNode {
	int key;
	MinimalBinarySearchTreeNode left, right;

	MinimalBinarySearchTreeNode(int item) {
		key = item;
		left = right = null;
	}

}

/**
 * Java class containing util method to convert given sorted array to binary search tree
 * @author Bishesh
 *
 */
public class MinimalBinarySearchTree {

	static MinimalBinarySearchTreeNode root;

	public MinimalBinarySearchTreeNode createMinimalTree(int arr[], int left, int right) {
		if (left > right)
			return null;

		int mid = (left + right) / 2;

		MinimalBinarySearchTreeNode node = new MinimalBinarySearchTreeNode(arr[mid]);
		node.left = createMinimalTree(arr, left, mid - 1);
		node.right = createMinimalTree(arr, mid + 1, right);

		return node;

	}

	public void inOrderRecursive(MinimalBinarySearchTreeNode node) {
		if (node != null) {
			inOrderRecursive(node.left);
			System.out.print(node.key + " ");
			inOrderRecursive(node.right);
		}

	}

	public void preOrderRecursive(MinimalBinarySearchTreeNode node) {
		if (node != null) {		
			System.out.print(node.key + " ");
			preOrderRecursive(node.left);
			preOrderRecursive(node.right);
		}
	}

	
	public static void main(String[] args) {
		MinimalBinarySearchTree tree = new MinimalBinarySearchTree();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int left = 0;
		int right = arr.length - 1;

		root = tree.createMinimalTree(arr, left, right);
		tree.inOrderRecursive(root);
		System.out.println();
		System.out.println("PreOrder: ");
		tree.preOrderRecursive(root);
	}
}
