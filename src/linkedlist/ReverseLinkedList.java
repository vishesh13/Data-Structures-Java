package linkedlist;

/**
 * LinkedList class containing utility methods to manipulate the list
 * 
 * @author Bishesh
 *
 */
public class ReverseLinkedList {

	ReverseLinkedListNode head;

	class ReverseLinkedListNode {
		ReverseLinkedListNode next;
		int data;

		ReverseLinkedListNode(int key) {
			data = key;
			next = null;
		}
	}

	/**
	 * method to insert node into the linked list
	 * 
	 * @param key
	 */
	public void insertNode(int key) {
		ReverseLinkedListNode current = head;
		ReverseLinkedListNode newNode = new ReverseLinkedListNode(key);

		if (head == null) {
			newNode.next = head;
			head = newNode;
		} else {
			while (current.next != null) {
				current = current.next;
			}

			newNode.next = current.next;
			current.next = newNode;
		}

	}

	/**
	 * method to print the values of linked list nodes
	 */
	public void printList() {
		ReverseLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * method to reverse the nodes of linked list
	 */
	public void reverseListIterative() {
		ReverseLinkedListNode next = head;
		ReverseLinkedListNode current = head;
		ReverseLinkedListNode prev = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
	}

	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		list.insertNode(8);
		list.insertNode(7);
		list.insertNode(6);
		list.insertNode(5);
		list.insertNode(4);
		list.insertNode(3);
		list.insertNode(2);
		list.insertNode(1);

		list.printList();
		list.reverseListIterative();
		list.printList();
	}
}
